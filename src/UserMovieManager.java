import java.util.*;

public class UserMovieManager{
    private List <Movie> movieList;    //contains List of all avaliable movies 

    public UserMovieManager(){
        movieList = new ArrayList<Movie>();
    }

    public void addMovie(Movie movie){
        movieList.add(movie);
    }

    public void displayMovieList(){
        for (Movie movie: movieList){
            System.out.println("Movie title: "+ movie.getTitle());
            System.out.println("Showing status: "+ movie.getStatus());
            System.out.println("Movie type: "+ movie.getType());
            System.out.print("Overall reviewer rating: "+ movie.getOverallRating());
            System.out.printf("\n");
        }
    }

    public void displayMovieDetails(Movie movie){
        System.out.println("Movie title: "+ movie.getTitle());
        System.out.println("Showing status: "+ movie.getStatus());
        System.out.println("SYNOPSIS: "+ movie.getSynopsis());
        System.out.println("Director: "+ movie.getDirectorName());
        System.out.print("Cast: ");
        for (String name: movie.getCastNames())
            System.out.printf("%s   ", name);
        System.out.printf("\n");
        System.out.println("Overall reviewer rating: "+ movie.getOverallRating());
        System.out.println("User reviews:");
        for (Review review: movie.getPastReviews())
            review.displayReview();
        System.out.printf("\n");

        //List reviews
    }

    public Movie searchMovie(String title){
        for (Movie movie: movieList){
            if (movie.getTitle().equals(title)){
                //System.out.printf("Movie found!\n");
                return movie;
            }
        }
        System.out.printf("Error! Movie not found.\n");
        return null;
    }


}
