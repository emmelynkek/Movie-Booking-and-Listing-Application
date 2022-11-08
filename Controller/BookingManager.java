package Controller;

import Model.*;
import View.*;
import Model.TicketPrice.MovieGoerAge;
import Model.CinemaMovie.*;
import java.util.*;

public class BookingManager {
    // seat selection
    public static String seatSelector(SeatLayout layout) {
        Scanner sc = new Scanner(System.in);
        layout.getSeatlayout();
        int row;
        int col;
        do {
            System.out.println("Enter a row number: ");
            row = sc.nextInt();
            System.out.println("Enter column number: ");
            col = sc.nextInt();
            if (layout.getSeatavailability(row, col) == true) {
                layout.setSeatavailability(row, col, false);
                System.out.println("Seat successfully booked!");
                break;
            } else {
                System.out.println("The seat is not available. Please choose another seat.");
            }
        } while (true);
        return "R" + row + "C" + col;
    }

    public static void printBooking(Booking booking) {
        ShowTime showTime = booking.getShowTime();
        System.out.println("Transaction ID: " + booking.getTransactionID());
        System.out.println("Cineplex: " + showTime.getCineplexName() + " | Cinema Hall: " + showTime.getCinemaCode());
        System.out.println("Seats Booked: " + booking.getSeatID());
        System.out.println("Movie: " + booking.getMovieTitle());
        System.out.printf("Movie Date & Time: %s %s to %s\n", showTime.getDate(), showTime.getStartTime(),
                showTime.getEndTime());
        System.out.printf("Total Paid: $%.2f\n", booking.getTotalPrice());
        System.out.println("Booked By: " + booking.getUserID());
        System.out.printf("\n");
    }

    public static void printBookingHist(BookingList bookingList, User user) {
        if (bookingList.getList().isEmpty()) {
            System.out.println("Error! Booking List is empty.");
            return;
        }
        for (Booking booking : bookingList.getList()) {
            if (booking.getUserID().equals(user.getId()))
                printBooking(booking);
        }
    }

    // for an input showtime, user and public holiday list, a booking will be made
    // and the receipt will be printed.
    public static void makeBooking(CineplexList cList, MovieList mList, BookingList bList, PublicHolidayList phl,
            User user) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Movie Title to book ticket for: ");
        String input = sc.nextLine();

        CinemaMovie movie = mList.searchMovie(input);
        if (movie == null)
            return;

        else if (movie.getShowTimes().isEmpty()) {
            System.out.println("Error! Movie has no Show times.");
            return;
        } else if (movie.getStatus() == Status.END_OF_SHOWING || movie.getStatus() == Status.COMING_SOON) {
            System.out.println("Error! Cannot book tickets for " + movie.getStatus() + " movie.");
            return;
        } else {
            for (ShowTime st : movie.getShowTimes())
                st.displayShowTimes();
        }

        ShowTime st = movie.searchShowTime();
        if (st == null)
            return;

        Cineplex cineplex = cList.searchCineplex(st.getCineplexName());
        Cinema cinema = cineplex.searchCinema(st.getCinemaCode());

        GregorianCalendar cal = PublicHoliday.stringToDate(st.getDate());

        double price = priceCalculator(cinema, movie, cal, phl);

        // retrive seat layout from showtime object
        SeatLayout seatingPlan = st.getSeatLayout();

        // seat selection
        if (seatingPlan.isFull() == true) {
            System.out.println("This cinema is fully booked.");
        } else {
            String seatID = seatSelector(seatingPlan);
            Booking booking = new Booking();
            booking.setMovieTitle(movie.getMovie().getTitle());
            booking.setShowTime(st);
            booking.setTransactionID(st.getCinemaCode());
            booking.setTotalPrice(price);
            booking.setUserID(user.getId());
            booking.setSeatID(seatID);
            System.out.println("Booking success!");
            bList.addBooking(booking); // add the booking to Booking List
            printBooking(booking);
            movie.setTicketSales(movie.getTicketSales() + price);
        }
    }

    // the price of the ticket will be calculated based on the ages, movie show time
    // etc
    public static double priceCalculator(Cinema cinema, CinemaMovie movie, GregorianCalendar date,
            PublicHolidayList phl) {
        Scanner sc = new Scanner(System.in);
        TicketPrice price = new TicketPrice();
        MovieGoerAge age = null;
        MenuDisplay.printAgeMenu();
        int userAge = sc.nextInt();
        String buffer = sc.nextLine();
        while (age == null) {
            switch (userAge) {
                case 1:
                    age = MovieGoerAge.ADULT;
                    break;
                case 2:
                    age = MovieGoerAge.STUDENT;
                    break;
                case 3:
                    age = MovieGoerAge.SENIOR_CITIZEN;
                    break;
                default:
                    MenuDisplay.printAgeMenu();
                    userAge = sc.nextInt();
                    buffer = sc.nextLine();
                    break;
            }
        }
        double finalPrice = price.getAdjustedPrice(age, cinema, date, movie, phl);
        return finalPrice;
    }

    /*
     * public static void main(String[] args) throws Exception {
     * GregorianCalendar timing = new GregorianCalendar(2022, 12, 20, 13, 0);
     * Cineplex jurongPoint = new Cineplex("Jurong Point");
     * Cinema c = jurongPoint.getCinema().get(0);
     * PublicHolidayList publicHoliday = new PublicHolidayList();
     * Movie Minions = new Movie();
     * Minions.setTitle("Minions");
     * CinemaMovie cinemaM = new CinemaMovie();
     * cinemaM.setType(CinemaMovie.Type.BLOCKBUSTER);
     * ShowTime sTime = new ShowTime(timing, jurongPoint, c, Minions);
     * MovieGoer user = new MovieGoer("test", 999, "test@gmail.com");
     * BookingManager manager = new BookingManager();
     * manager.makeBooking(sTime, user, publicHoliday);
     * }
     */
}