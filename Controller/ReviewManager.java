package Controller;
import Model.*;
import java.util.*;

/**
  Contains static methods for movie-goers to add a review to a cinema movie.
  @author  Julian Wong
  @version 1.0
  @since   2022-11-12
*/
public class ReviewManager {
    
    /**
     * Adds a review to a cinema movie.
     * @param user  The user who will be making the review
     * @param mList The list of all available cinema movies.
     */
    public static void addReview(Moviegoer user, MovieList mList){
        Scanner sc = new Scanner(System.in);

        CinemaMovie cinemaMovie = mList.searchMovie();
        if (cinemaMovie==null)
            return;
        System.out.println("Enter review: ");
        String desc = sc.nextLine();
        System.out.println("Enter a rating from 1 to 10: ");
        try{
            int rating = sc.nextInt();
            String input = sc.nextLine();
            while (rating<1 || rating>10){
                System.out.println("Error! Rating must be an int from 1 to 10");
                System.out.println("Enter a rating from 1 to 10: ");
                rating = sc.nextInt();
                input = sc.nextLine();
            }
            Review review = new Review(user.getId(), desc, rating);
            cinemaMovie.setReviews(review);
            System.out.println("Review has been added!");
            System.out.printf("\n");
        }
        catch(InputMismatchException e){
            System.out.println("Error! Rating must be an int from 1 to 10");
        }
    }
}
