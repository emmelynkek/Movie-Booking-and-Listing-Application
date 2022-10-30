import java.io.Serializable;
import java.util.*;

public class CinemaMovie implements Serializable{

    enum Status{
        COMING_SOON, PREVIEW, NOW_SHOWING; 
    }

    enum Type{
        THREE_D, BLOCKBUSTER; // THREE_D = 3D 
    }

    private Movie movie;
    private List <String> cinemas;
    private List <String> timings;
    private List <Review> pastReviews;
    private Status status;
    private Type type;
    private float overallRating;
    private float ticketSales;
    

    public CinemaMovie(){
        cinemas = new ArrayList <String>();
        timings = new ArrayList <String>();
        pastReviews = new ArrayList <Review>(); 
    }

    public Movie getMovie(){
        return movie;
    }

    public void setMovie(Movie movie){
        this.movie = movie;
    }

    public List <String> getCinema(){
        return cinemas;
    }

    public void setCinema(String _cinema){
        cinemas.add(_cinema);
    }

    public List <String> getTimings(){
        return timings;
    }

    public void setTimings(String _timings){
        timings.add(_timings);
    }

    public void setPastReviews(Review review){
        pastReviews.add(review);
    }

    public List<Review> getPastReviews(){
        return pastReviews;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public Status getStatus(){
        return status;
    }

    public void setType(Type type){
        this.type = type;
    }

    public Type getType(){
        return type;
    }

    public void setOverallRating(float rating){
        this.overallRating = rating;
    }

    public float getOverallRating(){
        return overallRating;
    }

    public void setTicketSales(float sales){
        this.ticketSales = sales;
    }

    public float getTicketSales(){
        return ticketSales;
    }

}


