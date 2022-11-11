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

    public CinemaMovie searchMovie(){
        Scanner sc = new Scanner(System.in);
        int i=1;

        if (movieList.isEmpty()){
            System.out.println("Error! Movie has no show times.");
            return null;
        }

        for (CinemaMovie movie : movieList)
            System.out.printf("(%d) %s \n", i++, movie.getMovie().getTitle());

        System.out.println("Select movie: ");
        String input = sc.nextLine();
        try{
            int index = Integer.parseInt(input);
            if (index > movieList.size() || index<1){
                System.out.println("Error! Please select a movie from the list.");
                return null;
            }
            return movieList.get(index-1);
        }
        catch (NumberFormatException e){
            System.out.println("Error! Please select a movie from the list.");
            return null;
        }   
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
