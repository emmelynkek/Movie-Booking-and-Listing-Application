package Model;
import java.io.Serializable;
import java.util.*;

public class BookingList implements Serializable{
    private List<Booking> bookingList;

    public BookingList() {
        this.bookingList = new ArrayList<Booking>();
    }

    public List<Booking> getList() {
        return bookingList;
    }

    public void addBooking(Booking b) {
        bookingList.add(b);
    }

    public Booking searchBooking(String userId){   
        for (Booking booking: bookingList){
            if (booking.getUserID().equals(userId)){
                return booking;
            }
        }
        System.out.printf("Error! Booking not found.\n");
        return null;
    }
}
