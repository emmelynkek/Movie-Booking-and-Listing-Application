package Controller;
import Model.*;
import Model.CinemaMovie.Status;
import View.*;

import java.util.*;

/**
  Contains static methods to display Movie Listings for movie-goers.
  @author Julian Wong
  @version 1.0
  @since 2022-11-12
*/
public class MovieDisplayManager{
    
    /**
     * Method to display the list of all available cinema movies.
     * Basic info about each cinema movie is displayed.
     * Eg: Title, showing status, movie type, overall reviewer rating and overall ticket sales.
     * @param mList This is the list of all available cinema movies.
     */
    public static void displayMovieList(MovieList mList){
        List <CinemaMovie> movieList = mList.getList();
        if (movieList.isEmpty()){
            System.out.printf("\n");
            System.out.println("Error! Movie List is empty.");
            System.out.printf("\n");
            return;
        }
        Header.printMovieList();
        for (CinemaMovie movie: movieList){
            if (movie.getStatus() == Status.END_OF_SHOWING) continue;
            System.out.println("Movie title             | "+ movie.getMovie().getTitle());
            System.out.println("Showing status          | "+ movie.getStatus());
            System.out.println("Movie type              | "+ movie.getType());
            if (movie.getReviews().size()<=1)
                System.out.println("Overall reviewer rating | NA");
            else
                System.out.printf("Overall reviewer rating | %.1f\n", movie.getOverallRating());
            System.out.printf("Overall ticket sales    | $%.2f\n", movie.getTicketSales());
            System.out.printf("\n");
        }
    }
    
    /**
     * Method to display the list of top 5 ranking cinema movies.
     * Top 5 movies are displayed in descending order
     * Top 5 movies can be ranked by overall reviewer rating or overall ticket sales.
     * The ranking method is determined by app Admin.
     * Basic info about each cinema movie is displayed.
     * Eg: Title, showing status, movie type, overall reviewer rating and overall ticket sales.
     * @param t5List This is the list of top 5 cinema movies.
     */
    public static void displayTop5List(Top5List t5List){
        List <CinemaMovie> movieList = t5List.getList();
        if (movieList.isEmpty()){
            System.out.printf("\n");
            System.out.println("Error! Top 5 List is empty.");
            System.out.printf("\n");
            return;
        }
        Header.printTop5List();
        if (t5List.getSortBy() == Top5List.sortBy.RATING){
            System.out.println("Top 5 List sorted by RATING:");
            System.out.printf("\n");
        }
        else if (t5List.getSortBy() == Top5List.sortBy.SALES){
            System.out.println("Top 5 List sorted by TICKET SALES:");
            System.out.printf("\n");
        }
            
        for (CinemaMovie movie: movieList){
            System.out.println("Movie title             | "+ movie.getMovie().getTitle());
            System.out.println("Showing status          | "+ movie.getStatus());
            System.out.println("Movie type              | "+ movie.getType());
            if (movie.getReviews().isEmpty())
                System.out.println("Overall reviewer rating | NA");
            else
                System.out.printf("Overall reviewer rating | %.1f\n", movie.getOverallRating());
            System.out.printf("Overall ticket sales    | $%.2f\n", movie.getTicketSales());
            System.out.printf("\n");
        }
    }
    
    /**
     * Method to display additional information of a particular cinema movie.
     * @param mList This is the list of all available cinema movies.
     */
    public static void displayMovieDetails(MovieList mList){
        Scanner sc = new Scanner(System.in);
        
        CinemaMovie cinemaMovie = mList.searchMovie();
        if (cinemaMovie==null)
            return;
        Header.printMovieDetails();
        System.out.printf("\n");
        System.out.println("Movie title             | "+ cinemaMovie.getMovie().getTitle());
        System.out.println("Showing status          | "+ cinemaMovie.getStatus());
        System.out.println("Director                | "+ cinemaMovie.getMovie().getDirectorName());
        System.out.print("Casts                   | ");
        for (String name: cinemaMovie.getMovie().getCastNames())
            System.out.printf("%s   ", name);
        System.out.printf("\n");
        System.out.println("Synopsis                | "+ cinemaMovie.getMovie().getSynopsis());
        if (cinemaMovie.getReviews().isEmpty())
            System.out.println("Overall reviewer rating | NA");
        else
            System.out.printf("Overall reviewer rating | %.1f\n", cinemaMovie.getOverallRating());
        System.out.println("End of showing date     | "+cinemaMovie.getEndDate());
        if (cinemaMovie.getShowTimes().isEmpty())
            System.out.println("Show times              | NA");
        else{
            System.out.printf("\n");
            System.out.println("Show times: ");
            for (ShowTime time: cinemaMovie.getShowTimes())
                time.displayShowTimes();
        }
        if (cinemaMovie.getReviews().isEmpty()){
            System.out.println("User reviews            | NA");
        }
        else{
            System.out.println("User reviews:");
            for (Review review: cinemaMovie.getReviews())
                review.displayReview();
        }
    }

}
