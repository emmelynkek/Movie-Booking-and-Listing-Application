package Controller;
import Model.*;
import java.util.*;

public class ReviewManager {
    public static void addReview(User user, MovieList mList){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter title of movie to add review: ");
        String input = sc.nextLine();
        CinemaMovie cinemaMovie = mList.searchMovie(input);
        if (cinemaMovie==null)
            return;
        System.out.println("Enter review: ");
        String desc = sc.nextLine();
        System.out.println("Enter a rating from 1 to 10: ");
        int rating = sc.nextInt();
        input = sc.nextLine();
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
}
