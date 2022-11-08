package Model;
import java.util.*;
import java.io.*;

public class CinemaMovie implements Serializable{

    public enum Status{
        COMING_SOON, PREVIEW, NOW_SHOWING, END_OF_SHOWING;
    }

    public enum Type{
        THREE_D, BLOCKBUSTER; // THREE_D = 3D 
    }

    private Movie movie;
    private List <ShowTime> showTimes; // Contains info about date, time, cinema code, cineplex name and seat layout
    private List <Review> reviews;
    private Status status;
    private String endDate; // The date at which the movie will be de-listed and unavailable for booking. Eg: 31-Jan-2023 
    private Type type;
    private float overallRating;  // Store overallRating as a String to prevent logic bug when OverallRatingComparator() is called.
    private double ticketSales;
    

    public CinemaMovie(){
        showTimes = new ArrayList <ShowTime>();
        reviews = new ArrayList <Review>(); 
    }

    public Movie getMovie(){
        return movie;
    }

    public void setMovie(Movie movie){
        this.movie = movie;
    }

    public void setShowTimes(ShowTime time){
        showTimes.add(time);
    }

    public List <ShowTime> getShowTimes(){
        return showTimes;
    }

    public void setReviews(Review review){
        reviews.add(review);
        updateOverallRating();
    }

    public List<Review> getReviews(){
        return reviews;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public Status getStatus(){
        return status;
    }

    public void setEndDate(String date){
        this.endDate = date;
    }

    public String getEndDate(){
        return endDate;
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

    public void setTicketSales(double sales){
        this.ticketSales = sales;
    }

    public double getTicketSales(){
        return ticketSales;
    }

    public ShowTime searchShowTime(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter showtime date (in dd-MMM-YYYY format):");
        String date = sc.nextLine();
        System.out.println("Enter movie start time (in military time format, e.g. 0100 for 1am):");
        String start = sc.nextLine();
        // System.out.println("Enter end time:");
        // String end = sc.nextLine();
        System.out.println("Enter Cineplex name:");
        String name = sc.nextLine();
        // System.out.println("Enter cinema code:");
        // String code = sc.nextLine();
        for (ShowTime showTime : showTimes){
            if (showTime.getCineplexName().equals(name) && showTime.getDate().equals(date) && 
                showTime.getStartTime().equals(start)){
                return showTime;
            }
        }
        System.out.println("Error! Showtime not found.");
        return null;
    }

    public void updateOverallRating(){  // Updates the overall rating. Called whenever a new Review is added
        if (reviews.size()==0)
            return;
        float temp = 0f;
        for (Review review : reviews){
            temp += review.getRating();
        }
        overallRating = temp / reviews.size();
        //overallRating = String.format("%.1f", avg);
    }

}


