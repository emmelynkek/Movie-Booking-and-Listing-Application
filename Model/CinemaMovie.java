package Model;
import java.util.*;
import java.io.*;

/**
  Represents a movie that has been registered for screening in the cinema.
  Cinema movies can be registered and removed by an app Admin.
  A cinema movie can be booked by Movie-goers, as well as listed on the app. 
  Cinema movie information can also be modified by an app Admin.
  @author Julian Wong
  @version 1.0
  @since 2022-11-12
*/
public class CinemaMovie implements Serializable{
    
    /**
     * Showing status of the cinema movie.
     * Only cinema movies with status of PREVIEW and NOW_SHOWING can be booked by Movie-goers.
     * Cinema movies with END_OF_SHOWING status will be de-listed from the movie listing.
     */
    public enum Status{
        COMING_SOON, PREVIEW, NOW_SHOWING, END_OF_SHOWING;
    }
    
    /**
     * Type of the cinema movie.
     * THREE_D represents 3-D movies.
     * Each cinema movie type has its own price 
     */
    public enum Type{
        REGULAR, THREE_D, BLOCKBUSTER;
    }
    
    /**
     * The movie that has be registered as a cinema movie.
     */
    private Movie movie;
    
    /**
     * A list of ShowTime objects
     * Each ShowTime corresponds to a particular location, date and time that the cinema movie will be screened at.
     */
    private List <ShowTime> showTimes;
    
    /**
     * A list of Review objects
     * Each Review corresponds to a review that a Movie-goer has given to the movie.
     */
    private List <Review> reviews;
    
    /**
     * Showing status of the cinema movie.
     */
    private Status status;
    
    /**
     * The date at which the cinema movie will be de-listed and unavailable for booking.
     * Format of the date is in DD-MMM-YYYY (Eg: 31-Jan-2023 )
     */
    private String endDate;
    
    /**
     * Type of the cinema movie.
     */
    private Type type;
    
    /**
     * The average of all the individual ratings given to the cinema movie by Movie-goers.
     * Value of overall rating is to 1 decimal place.
     * Overall rating will only be displayed if there are more than one individual rating.
     * Else, "NA" will be displayed.
     */
    private float overallRating; 
    
    /**
     * The total amount of sales generated from ticket selling across all cineplexes.
     */
    private double ticketSales;
    
    /**
     * Creates a Cinema Movie object.
     */
    public CinemaMovie(){
        showTimes = new ArrayList <ShowTime>();
        reviews = new ArrayList <Review>(); 
    }
    
    /**
     * Method to access Movie object within Cinema Movie.
     * @return Movie of this Cinema Movie.
     */
    public Movie getMovie(){
        return movie;
    }
    
    /**
     * Method to set the movie corresponding to this Cinema Movie object.
     * @param movie This is the movie corresponding to this Cinema Movie object.
     */
    public void setMovie(Movie movie){
        this.movie = movie;
    }
    
    /**
     * Method to add a show time to the List of showtimes of the Cinema Movie object.
     * @param time This is the show time corresponding to the Cinema Movie object.
     */
    public void setShowTimes(ShowTime time){
        showTimes.add(time);
    }
    
    /**
     * Method to access the List of showtimes of the Cinema Movie object.
     * @return List of showtimes of the Cinema Movie object.
     */
    public List <ShowTime> getShowTimes(){
        return showTimes;
    }
    
    /**
     * Method to add a review to the List of reviews that belongs to the Cinema Movie object.
     * @param review This is the review belonging to the Cinema Movie object.
     */
    public void setReviews(Review review){
        reviews.add(review);
        updateOverallRating();
    }
    
    /**
     * Method to access the List of reviews of the Cinema Movie object.
     * @return List of reviews of the Cinema Movie object.
     */
    public List<Review> getReviews(){
        return reviews;
    }
    
    /**
     * Method to set the showing status corresponding to this Cinema Movie object.
     * @param movie This is the showing status of the Cinema Movie object.
     */
    public void setStatus(Status status){
        this.status = status;
    }

    /**
     * Method to access the showing status of the Cinema Movie object.
     * @return showing status of the Cinema Movie object.
     */
    public Status getStatus(){
        return status;
    }
    
    /**
     * Method to set the end of showing date of the Cinema Movie object.
     * @param date This is the end of showing dates of the Cinema Movie object.
     */
    public void setEndDate(String date){
        this.endDate = date;
    }
    
    /**
     * Method to access the end of showing date of the Cinema Movie object.
     * @return end of showing date of the Cinema Movie object.
     */
    public String getEndDate(){
        return endDate;
    }
    
    /**
     * Method to set the movie type of the Cinema Movie object.
     * @param type This is the movie type of the Cinema Movie object.
     */
    public void setType(Type type){
        this.type = type;
    }
    
    /**
     * Method to access the movie type of the Cinema Movie object.
     * @return movie type of the Cinema Movie object.
     */
    public Type getType(){
        return type;
    }
    
    /**
     * Method to set the overall reviewer rating of the Cinema Movie object.
     * @param rating This is the overall reviewer rating of the Cinema Movie object.
     */
    public void setOverallRating(float rating){
        this.overallRating = rating;
    }
    
    /**
     * Method to access the overall reviewer rating of the Cinema Movie object.
     * @return overall reviewer rating of the Cinema Movie object.
     */
    public float getOverallRating(){
        return overallRating;
    }
    
    /**
     * Method to set the total ticket sales of the Cinema Movie object.
     * @param sales This is the total ticket sales of the Cinema Movie object.
     */
    public void setTicketSales(double sales){
        this.ticketSales = sales;
    }
    
    /**
     * Method to access the total ticket sales of the Cinema Movie object.
     * @return total ticket sales of the Cinema Movie object.
     */
    public double getTicketSales(){
        return ticketSales;
    }
    
    /**
     * Method to select a particular show time of the Cinema Movie object.
     * Users can select a show time from the list of all availble show times for the cinema movie.
     * Users will input an integer to make their selection.
     * @return ShowTime object that has been selected by the user.
     * @retun null if invalid selection is made.
     */
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
    
    /**
     * Method to update the overall reviewer rating of the cinema movie.
     * This method is called whenever a new review is added.
     */
    public void updateOverallRating(){ 
        if (reviews.size()==0)
            return;
        float temp = 0f;
        for (Review review : reviews){
            temp += review.getRating();
        }
        overallRating = temp / reviews.size();
    }
    
    /**
     * Method check if input show time clashes with other show times that are already in the database.
     * @param st The show time that we want to validate.
     * @return true if input show time does not clash with pre-existing show times; returns false if otherwise.
     */
    public Boolean isValidShowTime(ShowTime st){ 
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

