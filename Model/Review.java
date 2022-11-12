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
     * Moviegoer's rating in the review. Integer in the range of 0 to 10.
     * Each rating will affect the overall reviewer rating of the cinema movie.
     */
    private int rating;  
    
    /**
     * Creates a review.
     * @param id This is the user ID of the movie-goer who posted this Review.
     * @param description This is the text description of this Review.
     * @param rating This is the rating given by a movie-goer in this Review.
     */
    public Review(String id, String description, int rating){
        this.userId = id;
        this.description = description;
        this.rating = rating;

    }
    
    /**
     * Sets the text description of this review.
     * @param description This is the text description of this review.
     */
    public void setDescription(String description){
        this.description = description;
    }
    
    /**
     * Gets the text description of this review.
     * @return text description of this review.
     */
    public String getDescription(){
        return description;
    }
    
    /**
     * Sets the rating given by a movie-goer to the cinema movie.
     * @param rating This is the rating given by a movie-goer to the cinema movie.
     */
    public void setRating(int rating){
        this.rating = rating;
    }
    
    /**
     * Gets the individual rating of this review.
     * @return the individual rating of this review.
     */
    public int getRating(){
        return rating;
    }
    
    /**
     * Sets the user ID of the movie-goer who posted this Review.
     * @param id This is the user ID of the movie-goer who posted this Review.
     */
    public void setUserId(String id){
        this.userId = id;
    }
    
    /**
     * Gets the user ID of the movie-goer who posted this review.
     * @return the user ID of the movie-goer who posted this review.
     */
    public String getUserId(){
        return userId;
    }
    
    /**
     * Displays the details of a review.
     * The user id of the reviewer, review description and individual rating will be displayed.
     */
    public void displayReview(){
        System.out.printf("Reviewed by: %s\n", userId);
        System.out.printf("Description: %s\n", description);
        System.out.printf("Rating: %d\n", rating);
        System.out.printf("\n");
    }
}
