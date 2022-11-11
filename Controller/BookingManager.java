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
        System.out.println("Booked By: " + booking.getUser().getId());
        System.out.println("Mobile Number: " + booking.getUser().getNum());
        System.out.println("Email Address: "+booking.getUser().getEmail()+"\n");
    }

    public static void printBookingHist(BookingList bookingList, Moviegoer user) {
        Boolean empty = true;
        Header.printBookingHistory();
        for (Booking booking : bookingList.getList()) {
            if (booking.getUser().getId().equals(user.getId())){
                printBooking(booking);
                empty = false;
            }
        }
        if (empty)
            System.out.println("Error! Booking history is empty.");
    }

    // for an input showtime, user and public holiday list, a booking will be made
    // and the receipt will be printed.
    public static void makeBooking(CineplexList cList, MovieList mList, BookingList bList, PublicHolidayList phl,
            Moviegoer user, TicketPrice tp) throws Exception {
        Scanner sc = new Scanner(System.in);
        String seatIDs;
        double totprice;
        Header.printBookTicket();
        CinemaMovie movie = mList.searchMovie();
        if (movie == null)
            return;

        else if (movie.getShowTimes().isEmpty()) {
            System.out.println("Error! Movie has no Show times.");
            return;
        } else if (movie.getStatus() == Status.END_OF_SHOWING || movie.getStatus() == Status.COMING_SOON) {
            System.out.println("Error! Cannot book tickets for " + movie.getStatus() + " movie.");
            return;
        }

        ShowTime st = movie.searchShowTime();
        if (st == null)
            return;

        Cineplex cineplex = cList.searchCineplex(st.getCineplexName());
        Cinema cinema = cineplex.searchCinema(st.getCinemaCode());

        GregorianCalendar cal = PublicHoliday.stringToDate(st.getDate());

        // retrive seat layout from showtime object
        SeatLayout seatingPlan = st.getSeatLayout();

        // seat selection
        try {
            if (seatingPlan.isFull() == true) {
                System.out.println("This cinema is fully booked.");
            } else {
                String seatID = seatSelector(seatingPlan);
                seatIDs = seatID;
                int seatRow = seatID.charAt(1) - '0';
                double price = priceCalculator(cinema, movie, cal, phl, tp, seatRow);
                totprice = price;
                System.out.println("Enter selection:");
                System.out.println("1: Select another seat");
                System.out.println("2: Checkout");
                int choice = sc.nextInt();
                while (choice == 1) {
                    seatID = seatSelector(seatingPlan);
                    seatIDs = seatIDs + " " + seatID;
                    seatRow = seatID.charAt(1) - '0';
                    price = priceCalculator(cinema, movie, cal, phl, tp, seatRow);
                    totprice += price;
                    System.out.println("Enter selection:");
                    System.out.println("1: Select another seat");
                    System.out.println("2: Checkout");
                    choice = sc.nextInt();
                }
                Booking booking = new Booking();
                booking.setMovieTitle(movie.getMovie().getTitle());
                booking.setShowTime(st);
                booking.setTransactionID(st.getCinemaCode());
                booking.setUser(user);
                booking.setSeatID(seatIDs);
                booking.setTotalPrice(totprice);
                System.out.println("Booking success!\n");
                bList.addBooking(booking); // add the booking to Booking List
                printBooking(booking);
                movie.setTicketSales(movie.getTicketSales() + price);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error! Please select a valid row & column number.");
        }
    }

    // the price of the ticket will be calculated based on the ages, movie show time
    // etc
    public static double priceCalculator(Cinema cinema, CinemaMovie movie, GregorianCalendar date,
            PublicHolidayList phl, TicketPrice tp, int SeatRow) {
        Scanner sc = new Scanner(System.in);
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
        double finalPrice = tp.getAdjustedPrice(age, cinema, date, movie, phl, SeatRow);
        return finalPrice;
    }
}
