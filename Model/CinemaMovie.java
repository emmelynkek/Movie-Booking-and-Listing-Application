package Model;
import java.util.*;
import java.io.*;

public class CinemaMovie implements Serializable{

    public enum Status{
        COMING_SOON, PREVIEW, NOW_SHOWING, END_OF_SHOWING;
    }

    public enum Type{
        REGULAR, THREE_D, BLOCKBUSTER; // THREE_D = 3D 
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
        int i=1;

        if (showTimes.isEmpty()){
            System.out.println("Error! Movie has no show times.");
            return null;
        }

        for (ShowTime showTime : showTimes){
            System.out.printf("(%d) ", i);
            showTime.displayShowTimes();
            i++;
        }
        System.out.println("Select showtime: ");
        String input = sc.nextLine();
        try{
            int index = Integer.parseInt(input);
            if (index > showTimes.size() || index<1){
                System.out.println("Error! Please select a showtime from the list.");
                return null;
            }
            return showTimes.get(index-1);
        }
        catch (NumberFormatException e){
            System.out.println("Error! Please select a showtime from the list.");
            return null;
        }

    }

    public void updateOverallRating(){  // Updates the overall rating. Called whenever a new Review is added
        if (reviews.size()==0)
            return;
        float temp = 0f;
        for (Review review : reviews){
            temp += review.getRating();
        }
        overallRating = temp / reviews.size();
    }

    public Boolean isValidShowTime(ShowTime st){   // Returns false if start & end times of input ShowTime clashes with start & end times of other ShowTimes
        for (ShowTime time : showTimes){
            if (st.getCineplexName().equals(time.getCineplexName()) && st.getCinemaCode().equals(time.getCinemaCode())
                && st.getDate().equals(time.getDate())){
                int stStart = Integer.parseInt(st.getStartTime());
                int stEnd = Integer.parseInt(st.getEndTime());
                int timeStart = Integer.parseInt(time.getStartTime());
                int timeEnd = Integer.parseInt(time.getEndTime());
                if ((stStart >= timeStart && stStart <= timeEnd) || (stEnd >= timeStart && stEnd <= timeEnd)){
                    System.out.println("Error! Input show time clashes with show times in database.");
                    return false;
                }        
            }
        }
        return true;
    }

}

