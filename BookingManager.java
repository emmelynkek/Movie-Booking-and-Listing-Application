import java.util.Scanner;
import java.text.SimpleDateFormat;

public class BookingManager {
    Scanner sc = new Scanner(System.in);

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

    public void makeBooking(ShowTime st, MovieGoer user, PublicHolidayList phl) {
        double finalPrice = priceCalculator(st, phl);
        SimpleDateFormat formatObj = new SimpleDateFormat("dd-MMM-yyyy hh:mm");
        String formattedDate = formatObj.format(st.getDateTime().getTime());
        SeatLayout seatingPlan = st.getSeatingPlan();

        if (seatingPlan.isFull() == true) {
            System.out.println("This cinema is fully booked.");
        } else {
            String seatID = seatSelector(seatingPlan);
            Booking booking = new Booking(st.getCinema().getCode(), st.getCineplex().getName(), finalPrice, user,
                    st.getMovie(),
                    formattedDate, seatID);
            System.out.println("Transaction Success");
            printBooking(booking);
        }
    }

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
}
