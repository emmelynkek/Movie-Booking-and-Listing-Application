import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Booking implements Serializable{
    private String transactionID;
    private String cinemaCode;
    private String cineplex;
    private double totalPrice;
    private MovieGoer user;
    private Movie movie;
    private String movieDateTime;
    private String seatID;

    public Booking(String code, String cineplex, double price, MovieGoer m, Movie movie, String moviedateTime,
            String seatId) {
        this.setTransactionID(code);
        this.cinemaCode = code;
        this.cineplex = cineplex;
        this.totalPrice = price;
        this.user = m;
        this.movie = movie;
        this.movieDateTime = moviedateTime;
        this.seatID = seatId;
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

    public void setcinemaCode(String s) {
        this.cinemaCode = s;
    }

    public String getCinemaCode() {
        return this.cinemaCode;
    }

    public void setCineplex(String s) {
        this.cineplex = s;
    }

    public String getCineplex() {
        return this.cineplex;
    }

    public void setTotalPrice(double price) {
        this.totalPrice = price;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void setMovieGoer(MovieGoer m) {
        this.user = m;
    }

    public MovieGoer getMovieGoer() {
        return this.user;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public void setmovieDateTime(String s) {
        this.movieDateTime = s;
    }

    public String getmovieDateTime() {
        return this.movieDateTime;
    }

    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }

    public String getSeatID() {
        return this.seatID;
    }

}
