package Model;
import java.io.*;

/**
  Represents a review for a particular cinema movie that is posted by a Movie-goer on the app.
  @author Julian Wong
  @version 1.0
  @since 2022-11-12
*/
public class Review implements Serializable{
    
    /**
     * User ID of the movie-goer who posted the review.
     */
    private String userId;
    
    /**
     * Text description of the review.
     */
    private String description;
    
    /**
     * Integer in the range of 0 to 10
     * Each rating will affect the overall reviewer rating of the cinema movie.
     */
    private int rating;  
    
    /**
     * Method to create a review.
     * @param id This is the user ID of the movie-goer who posted the review.
     * @param description This is the text description of the review.
     * @param rating This is the rating given by a movie-goer.
     */
    public Review(String id, String description, int rating){
        this.userId = id;
        this.description = description;
        this.rating = rating;

    }
    
    /**
     * Method to set the text description of the review.
     * @param description This is the text description of the review.
     */
    public void setDescription(String description){
        this.description = description;
    }
    
    /**
     * Method to access the text description of the review.
     * @return text description of the review.
     */
    public String getDescription(){
        return description;
    }
    
    /**
     * Method to set the rating given by a movie-goer to the cinema movie.
     * @param rating This is the rating given by a movie-goer to the cinema movie.
     */
    public void setRating(int rating){
        this.rating = rating;
    }
    
    /**
     * Method to access the individual rating of the review.
     * @return the individual rating of the review.
     */
    public int getRating(){
        return rating;
    }
    
    /**
     * Method to set the user ID of the movie-goer who posted the review.
     * @param id This is the user ID of the movie-goer who posted the review.
     */
    public void setUserId(String id){
        this.userId = id;
    }
    
    /**
     * Method to access the user ID of the movie-goer who posted the review.
     * @return the the user ID of the movie-goer who posted the review.
     */
    public String getUserId(){
        return userId;
    }
    
    /**
     * Method to display the details of a review.
     * The user id of the reviewer, review description and individual rating will be displayed.
     */
    public void displayReview(){
        System.out.printf("Reviewed by: %s\n", userId);
        System.out.printf("Description: %s\n", description);
        System.out.printf("Rating: %d\n", rating);
        System.out.printf("\n");
    }
}
