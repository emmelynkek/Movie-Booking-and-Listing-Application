import java.util.GregorianCalendar;
import java.util.Scanner;

import java.text.SimpleDateFormat;

public class BookingManager {
    Scanner sc = new Scanner(System.in);

    public BookingManager() {
    };

    // seat selection
    public String seatSelector(SeatLayout layout) {
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

    public void printBooking(Booking booking) {
        System.out.println("Transaction ID: " + booking.getTransactionID());
        System.out.println("Cineplex | Cinema Hall: " + booking.getCineplex() + " | " + booking.getCinemaCode());
        System.out.println("Seats Booked: " + booking.getSeatID());
        System.out.println("Movie: " + booking.getMovie().getTitle());
        System.out.println("Movie Date & Time: " + booking.getmovieDateTime());
        System.out.println("Total Paid: " + booking.getTotalPrice());
        System.out.println("Booked By: " + booking.getMovieGoer().getName());
    }

    public void printBookingHist(BookingHistory history) {
        for (int i = 0; i < history.getList().size(); i++) {
            printBooking(history.getList().get(i));
        }
    }

    // for an input showtime, user and public holiday list, a booking will be made
    // and the receipt will be printed.
    public void makeBooking(ShowTime st, MovieGoer user, PublicHolidayList phl) {
        double finalPrice = priceCalculator(st, phl);
        // convert the date to string format
        SimpleDateFormat formatObj = new SimpleDateFormat("dd-MMM-yyyy hh:mm");
        String formattedDate = formatObj.format(st.getDateTime().getTime());

        // retrive seat layout from showtime object
        SeatLayout seatingPlan = st.getSeatingPlan();

        // seat selection
        if (seatingPlan.isFull() == true) {
            System.out.println("This cinema is fully booked.");
        } else {
            String seatID = seatSelector(seatingPlan);
            Booking booking = new Booking(st.getCinema().getCode(), st.getCineplex().getName(), finalPrice, user,
                    st.getMovie(),
                    formattedDate, seatID);
            System.out.println("Transaction Success");
            user.getHistory().addBooking(booking); // add the booking to the user's booking history
            printBooking(booking);
        }
    }

    // the price of the ticket will be calculated based on the ages, movie show time etc
    public double priceCalculator(ShowTime st, PublicHolidayList phl) {
        PriceAdjustment calculatePrice = new PriceAdjustment();
        MovieGoerAge age = null;
        System.out.println("Please select the movie-goer's age category: ");
        System.out.println("1. Adult");
        System.out.println("2. Student (must be able to produce a valid student pass)");
        System.out.println("3. Senior Citizen (55 years old and above)");
        int userAge = sc.nextInt();
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
                break;
        }
        double price = calculatePrice.getAdjustedPrice(age, st.getCinema(), st.getDateTime(), st.getCinemaMovie(), phl);
        return price;
    }

    public static void main(String[] args) throws Exception {
        GregorianCalendar timing = new GregorianCalendar(2022, 12, 20, 13, 0);
        Cineplex jurongPoint = new Cineplex("Jurong Point");
        Cinema c = jurongPoint.getCinema().get(0);
        PublicHolidayList publicHoliday = new PublicHolidayList();
        Movie Minions = new Movie();
        Minions.setTitle("Minions");
        CinemaMovie cinemaM = new CinemaMovie();
        cinemaM.setType(CinemaMovie.Type.BLOCKBUSTER);
        ShowTime sTime = new ShowTime(timing, jurongPoint, c, Minions);
        MovieGoer user = new MovieGoer("test", 999, "test@gmail.com");
        BookingManager manager = new BookingManager();
        manager.makeBooking(sTime, user, publicHoliday);
    }
}
