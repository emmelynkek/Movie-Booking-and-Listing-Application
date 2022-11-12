package Model;

import java.util.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.*;

/**
 * Represents the container Class used to store the list of all Cinema Movies in
 * the database.
 * @author Julian Wong
 * @version 1.0
 * @since 2022-11-12
 */
public class MovieList implements Serializable {

    /**
     * List of all available cinema movies.
     */
    private List<CinemaMovie> movieList;

    /**
     * Creates a list of cinema movies in this MovieList.
     */
    public MovieList() {
        movieList = new ArrayList<CinemaMovie>();
    }

    /**
     * Gets the list of cinema movies.
     * @return list of cinema movies of this MovieList.
     */
    public List<CinemaMovie> getList() {
        return movieList;
    }

    /**
     * Adds a cinema movie to the list of cinema movies.
     * @param movie The cinema movie to be added.
     */
    public void addMovie(CinemaMovie movie) {
        movieList.add(movie);
    }

    /**
     * Searches a particular cinema movie. Users can select a cinema movie from the list of all available
     * cinema movies. Users will input an integer to make their selection.
     * @return CinemaMovie object that has been selected by the user.
     * @retun null if invalid selection is made.
     */
    public CinemaMovie searchMovie() {
        Scanner sc = new Scanner(System.in);
        int i = 1;

        if (movieList.isEmpty()) {
            System.out.println("Error! Movie has no show times.");
            return null;
        }

        for (CinemaMovie movie : movieList)
            System.out.printf("(%d) %s \n", i++, movie.getMovie().getTitle());

        System.out.println("Select movie: ");
        String input = sc.nextLine();
        try {
            int index = Integer.parseInt(input);
            if (index > movieList.size() || index < 1) {
                System.out.println("Error! Please select a movie from the list.");
                return null;
            }
            return movieList.get(index - 1);
        } catch (NumberFormatException e) {
            System.out.println("Error! Please select a movie from the list.");
            return null;
        }
    }

    /**
     * Checks endDate attribute of each CinemaMovie.
     * If endDate is equal to the current date, showing status of the cinema movie is updated to END_OF_SHOWING
     */
    public void checkEndDate() {
        try{
            SimpleDateFormat SDformat = new SimpleDateFormat("dd-MMM-yyyy");
            LocalDate date = LocalDate.now();
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
            String formattedDate = date.format(dateFormat);
            SimpleDateFormat curDatetime = new SimpleDateFormat("dd-MMM-yyyy");
            Date current = curDatetime.parse(formattedDate);
            for (CinemaMovie movie : movieList) {
                Date endDate = SDformat.parse(movie.getEndDate());
                if (endDate.before(current) || endDate.equals(current)) {
                    movie.setStatus(CinemaMovie.Status.END_OF_SHOWING);
                }
            }
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        
    }
}
