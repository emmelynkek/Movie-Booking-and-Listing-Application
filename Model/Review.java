package Model;
import java.io.*;

public class Review implements Serializable{
    private String userId;
    private String description;
    private int rating;  // Integer in range of 0 to 10

    public Review(String id, String description, int rating){
        this.userId = id;
        this.description = description;
        this.rating = rating;

    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setRating(int rating){
        this.rating = rating;
    }

    public int getRating(){
        return rating;
    }

    public void setUserId(String id){
        this.userId = id;
    }

    public String getUserId(){
        return userId;
    }

    public void displayReview(){
        System.out.printf("Reviewed by: %s\n", userId);
        System.out.printf("Description: %s\n", description);
        System.out.printf("Rating: %d\n", rating);
        System.out.printf("\n");
    }
}
