import java.util.*;

public class BookingHistory {
    private List<Booking> bookingList;

    public BookingHistory() {
        this.bookingList = new ArrayList<Booking>();
    }

    public List<Booking> getList() {
        return bookingList;
    }

    public void addBooking(Booking b) {
        bookingList.add(b);
    }

    public void printBookingHist() {
        for (int i = 0; i < this.bookingList.size(); i++) {
            bookingList.get(i).printBooking();
        }
    }
}
