package Controller;

import Model.*;
import View.*;
import Model.TicketPrice.MovieGoerAge;
import Model.CinemaMovie.*;

import java.text.ParseException;
import java.util.*;

/**
 * BookingManager is a control class which handles bookings by the user.
 * BookingManager contains methods
 * that allow users to select seats, calculate price of ticket, create a new
 * booking and view bookings.
 * 
 * @author Evonne Ng
 * @version 2.0
 * @since 2022-11-06
 */
public class BookingManager {

    /**
     * Selects seat from a specified seat layout. This method will display an error
     * if the chosen seat is
     * already taken and display a success message if the chosen seat has not been
     * taken. When a seat is
     * successfully booked, the specified seat will be marked as unavailable.
     * 
     * @param layout the seating plan of the cinema during showtime.
     * @return the row and column of the successfully booked seat.
     */
    public static String seatSelector(SeatLayout layout) {
        Scanner sc = new Scanner(System.in);
        layout.getSeatlayout();
        int row = 1;
        int col = 1;
        boolean condition = true; 
        do {
            // Exception exception;
            // do {
            //     exception = null;
            //     System.out.println("Enter a row number: ");
            //     try {
            //         row = sc.nextInt();
            //         System.out.println("Enter column number: ");
            //         col = sc.nextInt();
            //     } catch (InputMismatchException e) {
            //         System.out.println("Error! Please input a number value!");
            //         exception = e;
            //     }
            // } while (exception != null);

            Exception exception1;

            do {
                exception1 = null;
                /* Get the vallue */ 
                System.out.println("Enter the row number: ");
                try {
                    row = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Error! Please input a number value!");
                    sc.next();
                    exception1 = e;
                }
            } while (exception1 != null);


         
            Exception exception2;

            do {
                exception2 = null;
                /* Get the vallue */ 
                System.out.println("Enter the column number: ");
                try {
                    col = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Error! Please input a number value!");
                    sc.next();
                    exception2 = e;
                }
            } while (exception2 != null);


            if (layout.getSeatavailability(row, col) == true) {
                layout.setSeatavailability(row, col, false);
                System.out.println("Seat successfully booked!");
                condition = false; 
            } else {
                System.out.println("The seat is not available. Please choose another seat.");
            }
        } while (condition);
        return "R" + row + "C" + col;
    }

    /**
     * Prints the booking receipt of the transaction. Each receipt will contain
     * details such as Transaction ID,
     * Cineplex name, Seats booked, Movie name, Movie date and time, Total price
     * paid and User details.
     * 
     * @param booking the Booking to print the receipt for.
     */
    public static void printBooking(Booking booking) {
        ShowTime showTime = booking.getShowTime();
        System.out.println("Transaction ID: " + booking.getTransactionID());
        System.out.println("Cineplex: " + showTime.getCineplexName() + " | Cinema Hall: " + showTime.getCinemaCode());
        System.out.println("Seats Booked: " + booking.getSeatID());
        System.out.println("Movie: " + booking.getMovieTitle());
        System.out.printf("Movie Date & Time: %s %s to %s\n", showTime.getDate(), showTime.getStartTime(),
                showTime.getEndTime());
        System.out.printf("Total Paid: $%.2f\n", booking.getTotalPrice());
        System.out.println("Booked By: " + booking.getMoviegoer().getId());
        System.out.println("Mobile Number: " + booking.getMoviegoer().getNum());
        System.out.println("Email Address: " + booking.getMoviegoer().getEmail() + "\n");
    }

    /**
     * Prints all the receipts of the Bookings in a specified booking list for a
     * specified user.
     * 
     * @param bookingList the booking list to print the receipts for.
     * @param user        the user who made the bookings. Only bookings
     *                    made by the specified user will be printed.
     */
    public static void printBookingHist(BookingList bookingList, Moviegoer user) {
        Boolean empty = true;
        Header.printBookingHistory();
        for (Booking booking : bookingList.getList()) {
            if (booking.getMoviegoer().getId().equals(user.getId())) {
                printBooking(booking);
                empty = false;
            }
        }
        if (empty)
            System.out.println("Error! Booking history is empty.");
    }

    /**
     * Registers a new transaction made by a user. This method will allow the user
     * to choose a Showtime and
     * select seats from that Showtime. Price for each ticket will be calculated and
     * its details will be displayed.
     * 
     * @param cList the list of Cineplexes from the database.
     * @param mList the list of Movies from the database.
     * @param bList the list of Bookings from the database. A new Booking
     *              will be added to the Booking list if successful.
     * @param phl   the list of Public Holidays from the database.
     * @param user  the user who is making the booking.
     * @param tp    the ticket price to calculate pricing.
     * @throws Exception if seat chosen does not exist in the seating plan.
     */
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

        SeatLayout seatingPlan = st.getSeatLayout();

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
                booking.setMoviegoer(user);
                booking.setSeatID(seatIDs);
                booking.setTotalPrice(totprice);
                System.out.println("Booking success!\n");
                bList.addBooking(booking);
                printBooking(booking);
                movie.setTicketSales(movie.getTicketSales() + totprice);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error! Please select a valid row & column number.");
        }
    }

    /**
     * Calculates the price of a ticket based on Cinema type, Movie type, Seat type,
     * day of the week and age
     * of user. This method will prompt user to input their age category.
     * 
     * @param cinema  the Cinema on the movie ticket.
     * @param movie   the Movie on the ticket.
     * @param date    the date of the movie.
     * @param phl     the list of public holidays from the database.
     * @param tp      the ticket price to calculate pricing.
     * @param SeatRow the row of the seat chosen. Premium seats are on rows 7
     *                and 8.
     * @return the final price of the ticket.
     */
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
