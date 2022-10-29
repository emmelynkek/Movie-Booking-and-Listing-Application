import java.util.*;

public class MovieList {
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
}
