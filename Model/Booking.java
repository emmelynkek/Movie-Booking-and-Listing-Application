package Model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Booking implements Serializable{
    private String movieTitle;
    private ShowTime showTime; // Contains info about date, time, cinema code, cineplex name and seat layout
    private String transactionID;
    private double totalPrice;
    private User user;
    private String seatID;

    public void setShowTime(ShowTime showTime){
        this.showTime = showTime;
    }

    public ShowTime getShowTime(){
        return this.showTime;
    }

    public void setMovieTitle(String name) {
        this.movieTitle = name;
    }

    public String getMovieTitle() {
        return this.movieTitle;
    }
    
    public void setTransactionID(String cinemaCode) {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        String formattedDate = date.format(formatObj);
        transactionID = cinemaCode + formattedDate;
    }

    public String getTransactionID() {
        return this.transactionID;
    }

    public void setTotalPrice(double price) {
        this.totalPrice = price;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }

    public String getSeatID() {
        return this.seatID;
    }

}