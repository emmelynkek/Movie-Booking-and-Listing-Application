package Controller;
import Model.*;
import Model.CinemaMovie.Status;

import java.util.*;

public class MovieDisplayManager{  // Contains static methods to display Movie Listings (for Users)
    public static void displayMovieList(MovieList mList){
        List <CinemaMovie> movieList = mList.getList();
        if (movieList.isEmpty()){
            System.out.println("Error! Movie List is empty.");
            return;
        }
        for (CinemaMovie movie: movieList){
            if (movie.getStatus() == Status.END_OF_SHOWING) continue;
            System.out.println("Movie title: "+ movie.getMovie().getTitle());
            System.out.println("Showing status: "+ movie.getStatus());
            System.out.println("Movie type: "+ movie.getType());
            if (movie.getReviews().size()<=1)
                System.out.println("Overall reviewer rating: NA");
            else
                System.out.printf("Overall reviewer rating: %.1f\n", movie.getOverallRating());
            System.out.printf("Overall ticket sales: $%.2f\n", movie.getTicketSales());
            System.out.printf("\n");
        }
    }

    public static void displayTop5List(Top5List t5List){
        List <CinemaMovie> movieList = t5List.getList();
        if (movieList.isEmpty()){
            System.out.println("Error! Top 5 List is empty.");
            return;
        }
        else if (t5List.getSortBy() == Top5List.sortBy.RATING)
            System.out.println("Top 5 List sorted by RATING:");
        else if (t5List.getSortBy() == Top5List.sortBy.SALES)
            System.out.println("Top 5 List sorted by TICKET SALES:");
            
        for (CinemaMovie movie: movieList){
            System.out.println("Movie title: "+ movie.getMovie().getTitle());
            System.out.println("Showing status: "+ movie.getStatus());
            System.out.println("Movie type: "+ movie.getType());
            if (movie.getReviews().isEmpty())
                System.out.println("Overall reviewer rating: NA");
            else
                System.out.printf("Overall reviewer rating: %.1f\n", movie.getOverallRating());
            System.out.printf("Overall ticket sales: $%.2f\n", movie.getTicketSales());
            System.out.printf("\n");
        }
    }

    public static void displayMovieDetails(MovieList mList){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter title of movie to display details: ");
        String input = sc.nextLine();
        CinemaMovie cinemaMovie = mList.searchMovie(input);
        if (cinemaMovie==null)
            return;
        System.out.println("Movie title: "+ cinemaMovie.getMovie().getTitle());
        System.out.println("Showing status: "+ cinemaMovie.getStatus());
        System.out.println("Director: "+ cinemaMovie.getMovie().getDirectorName());
        System.out.print("Cast: ");
        for (String name: cinemaMovie.getMovie().getCastNames())
            System.out.printf("%s   ", name);
        System.out.printf("\n");
        System.out.println("SYNOPSIS: "+ cinemaMovie.getMovie().getSynopsis());
        if (cinemaMovie.getReviews().isEmpty())
            System.out.println("Overall reviewer rating: NA");
        else
            System.out.printf("Overall reviewer rating: %.1f\n", cinemaMovie.getOverallRating());
        System.out.println("End of showing date: "+cinemaMovie.getEndDate());
        System.out.printf("************************\n");
        if (cinemaMovie.getShowTimes().isEmpty())
            System.out.println("Show times: NA");
        else{
            for (ShowTime time: cinemaMovie.getShowTimes())
                time.displayShowTimes();
        }
        System.out.printf("************************\n");
        if (cinemaMovie.getReviews().isEmpty()){
            System.out.println("User reviews: NA");
        }
        else{
            System.out.println("User reviews:");
            for (Review review: cinemaMovie.getReviews())
                review.displayReview();
            System.out.printf("\n");
        }
    }

}
