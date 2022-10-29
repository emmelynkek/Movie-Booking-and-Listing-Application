import java.util.*;

public class UserMovieManager{  // Contains only static methods, can call directly with Class name
    public static void displayMovieList(List <CinemaMovie> movieList){
        for (CinemaMovie movie: movieList){
            System.out.println("Movie title: "+ movie.getMovie().getTitle());
            System.out.println("Showing status: "+ movie.getStatus());
            System.out.println("Movie type: "+ movie.getType());
            System.out.println("Overall reviewer rating: "+ movie.getOverallRating());
            System.out.printf("Overall ticket sales: $%.2f\n", movie.getTicketSales());
            System.out.printf("\n");
        }
    }

    public static void displayMovieDetails(CinemaMovie movie){
        System.out.println("Movie title: "+ movie.getMovie().getTitle());
        System.out.println("Showing status: "+ movie.getStatus());
        System.out.println("SYNOPSIS: "+ movie.getMovie().getSynopsis());
        System.out.println("Director: "+ movie.getMovie().getDirectorName());
        System.out.print("Cast: ");
        for (String name: movie.getMovie().getCastNames())
            System.out.printf("%s   ", name);
        System.out.printf("\n");
        System.out.println("Overall reviewer rating: "+ movie.getOverallRating());
        System.out.println("User reviews:");
        for (Review review: movie.getPastReviews())
            review.displayReview();
        System.out.printf("\n");

    }

    public static CinemaMovie searchMovie(List <CinemaMovie> movieList, String title){
        for (CinemaMovie movie: movieList){
            if (movie.getMovie().getTitle().equals(title)){
                //System.out.printf("Movie found!\n");
                return movie;
            }
        }
        System.out.printf("Error! Movie not found.\n");
        return null;
    }


}
