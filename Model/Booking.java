package Model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a booking made by a user. One booking is made for each transaction.
 * @author  Evonne Ng
 * @version 1.0
 * @since   2022-10-30
 */
public class Booking implements Serializable {

    /**
     * The title of the movie in this booking.
     */
    private String movieTitle;

    /**
     * The showtime in this booking.
     */
    private ShowTime showTime;

    /**
     * The transaction ID of this booking.
     */
    private String transactionID;

    /**
     * The total amount paid for this booking.
     */
    private double totalPrice;

    /**
     * The user that made this booking.
     */
    private Moviegoer moviegoer;

    /**
     * The seats booked for this booking.
     */
    private String seatID;

    /**
     * Sets the showtime of this Booking.
     * @param showTime This Booking's showtime.
     */
    public void setShowTime(ShowTime showTime) {
        this.showTime = showTime;
    }

    /**
     * Gets the showtime of this Booking.
     * @return this Booking's showtime.
     */
    public ShowTime getShowTime() {
        return this.showTime;
    }

    /**
     * Sets the movie title of this Booking.
     * @param name This Booking's movie title.
     */
    public void setMovieTitle(String name) {
        this.movieTitle = name;
    }

    /**
     * Gets the movie title of this Booking.
     * @return this Booking's movie title.
     */
    public String getMovieTitle() {
        return this.movieTitle;
    }

    /**
     * Sets the transaction ID of this Booking. Transaction ID contains the cinema code and datetime of booking.
     * @param cinemaCode the cinema code of the cinema in
     *                   this Booking.
     */
    public void setTransactionID(String cinemaCode) {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        String formattedDate = date.format(formatObj);
        transactionID = cinemaCode + formattedDate;
    }

    /**
     * Gets the transaction ID of this Booking.
     * @return this Booking's transaction ID.
     */
    public String getTransactionID() {
        return this.transactionID;
    }

    /**
     * Sets the total amount paid by the user during the transaction.
     * @param price the total price of the tickets for
     *              this Booking.
     */
    public void setTotalPrice(double price) {
        this.totalPrice = price;
    }

    /**
     * Gets the total amount paid by the user for this Booking.
     * @return this Booking's total price.
     */
    public double getTotalPrice() {
        return this.totalPrice;
    }

    /**
     * Sets the user who made this Booking.
     * @param user This Booking's user.
     */
    public void setMoviegoer(Moviegoer moviegoer) {
        this.moviegoer = moviegoer;
    }

    /**
     * Gets the user who made this Booking.
     * @return this Booking's user.
     */
    public Moviegoer getMoviegoer() {
        return this.moviegoer;
    }

    /**
     * Sets the ID(s) of the seats booked by the user for this Booking. Seat IDs are arranged according to
     * the order the seats are booked.
     * @param seatID This Booking's seat ID(s).
     */
    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }

    /**
     * Gets the seat ID(s) the user selected for this Booking.
     * @return this Booking's seat ID(s).
     */
    public String getSeatID() {
        return this.seatID;
    }

}