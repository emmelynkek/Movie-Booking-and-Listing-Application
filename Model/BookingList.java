package Model;
import java.io.Serializable;
import java.util.*;

/**
 * Represents a list of bookings made on MOBLIMA.
 * @author  Ng Li Lin Evonne
 * @version 1.0
 * @since   2022-10-30
 */
public class BookingList implements Serializable {
    
    /**
     * The list of bookings of this booking list.
     */
    private List<Booking> bookingList;

    /**
     * Creates a new BookingList containing Bookings.
     */
    public BookingList() {
        this.bookingList = new ArrayList<Booking>();
    }

    /**
     * Gets the list of bookings of this BookingList.
     * @return this BookingList's list of bookings.
     */
    public List<Booking> getList() {
        return bookingList;
    }

    /**
     * Adds a Booking to this BookingList's list of Bookings.
     * @param b The Booking to be added.
     */
    public void addBooking(Booking b) {
        bookingList.add(b);
    }
}
