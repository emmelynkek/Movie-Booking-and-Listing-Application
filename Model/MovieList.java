package Model;
import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.*;

public class MovieList implements Serializable{
    private List <CinemaMovie> movieList;    //contains List of all avaliable movies 

    public MovieList(){
        movieList = new ArrayList <CinemaMovie>();
    }

    public List <CinemaMovie> getList(){
        return movieList;
    }

    public void addMovie(CinemaMovie movie){
        movieList.add(movie);
    }

    public CinemaMovie searchMovie(String title){   
        for (CinemaMovie movie: movieList){
            if (movie.getMovie().getTitle().equals(title)){
                return movie;
            }
        }
        System.out.printf("Error! Movie not found.\n");
        return null;
    }

    public void checkEndDate(){   // Check endDate of each CinemaMovie and update status to END_OF_SHOWING if endDate == current date.
        LocalDate date = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String formattedDate = date.format(dateFormat);
        for (CinemaMovie movie: movieList){
            if (movie.getEndDate().equals(formattedDate))
                movie.setStatus(CinemaMovie.Status.END_OF_SHOWING);
        }
    }
}
