package Model;
import java.io.Serializable;
import java.util.*;

/**
 * Represents a list of bookings made on MOBALIMA.
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

    /**
     * Searches the list of bookings in this BookingList for 
     * a specified Booking made by a specified user.
     * @param userId the username of the user who made the
     *               specified Booking.
     * @return       the Booking made by the specified user.
     *               If no Booking can be found, a null is returned.
     */
    public Booking searchBooking(String userId){   
        for (Booking booking: bookingList){
            if (booking.getUser().getId().equals(userId)){
                return booking;
            }
        }
        System.out.printf("Error! Booking not found.\n");
        return null;
    }
}
