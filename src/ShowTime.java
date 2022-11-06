import java.io.Serializable;

import java.util.GregorianCalendar;

public class ShowTime implements Serializable {
    private Movie movie;
    private Cineplex cineplex;
    private Cinema cinema;
    private GregorianCalendar dateTime;
    private SeatLayout seatingPlan;
    private CinemaMovie cinemaMovie;

    public ShowTime(GregorianCalendar dateTime, Cineplex cineplex, Cinema cinema, Movie movie) {
        this.movie = movie;
        this.dateTime = dateTime;
        this.cineplex = cineplex;
        this.cinema = cinema;
        this.seatingPlan = new SeatLayout();
    }

    public SeatLayout getSeatingPlan() {
        return seatingPlan;
    }

    public Movie getMovie() {
        return movie;
    }

    public Cineplex getCineplex() {
        return cineplex;
    }

    public GregorianCalendar getDateTime() {
        return dateTime;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public CinemaMovie getCinemaMovie() {
        return cinemaMovie;
    }
    
}
