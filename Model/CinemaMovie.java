package Model;

import java.util.*;
import java.io.*;

/**
 * Represents a movie that has been registered for screening in the cinema.
 * Cinema movies can be registered and removed by an app Admin.
 * A cinema movie can be booked by Movie-goers, as well as listed on the app.
 * Cinema movie information can also be modified by an app Admin.
 * @author Julian Wong
 * @version 1.0
 * @since 2022-11-12
 */
public class CinemaMovie implements Serializable {

    /**
     * The different showing statuses of the cinema movie.
     * Only cinema movies with status of PREVIEW and NOW_SHOWING can be booked by Movie-goers.
     * Cinema movies with END_OF_SHOWING status will be de-listed from the movie listing.
     * @see #COMING_SOON
     * @see #PREVIEW
     * @see #NOW_SHOWING
     * @see #END_OF_SHOWING
     */
    public enum Status {
        /**
         * Coming soon status
         */
        COMING_SOON,
        /**
         * Preview status
         */
        PREVIEW,
        /**
         * Now showing status
         */
        NOW_SHOWING,
        /**
         * End of showing status
         */
        END_OF_SHOWING;
    }

    /**
     * The different types of the cinema movie. THREE_D represents 3-D movies.
     * Each cinema movie type has its own price.
     * @see #REGULAR
     * @see #THREE_D
     * @see #BLOCKBUSTER
     */
    public enum Type {
        /**
         * Regular movie
         */
        REGULAR,
        /**
         * 3D movie
         */
        THREE_D,
        /**
         * Blockbuster movie
         */
        BLOCKBUSTER;
    }

    /**
     * The movie that has be registered as a cinema movie.
     */
    private Movie movie;

    /**
     * A list of ShowTime objects. Each ShowTime corresponds to a particular location, date and 
     * time that the cinema movie will be screened at.
     */
    private List<ShowTime> showTimes;

    /**
     * A list of Review objects. Each Review corresponds to a review that a Movie-goer has given to the movie.
     */
    private List<Review> reviews;

    /**
     * Showing status of the cinema movie.
     */
    private Status status;

    /**
     * The date at which the cinema movie will be de-listed and unavailable for booking.
     * Format of the date is in DD-MMM-YYYY (Eg: 31-Jan-2023 )
     */
    private String endDate;

    /**
     * Type of the cinema movie.
     */
    private Type type;

    /**
     * The average of all the individual ratings given to the cinema movie by Movie-goers.
     * Value of overall rating is to 1 decimal place. Overall rating will only be displayed if there are 
     * more than one individual rating. Else, "NA" will be displayed.
     */
    private float overallRating;

    /**
     * The total amount of sales generated from ticket selling across all cineplexes.
     */
    private double ticketSales;

    /**
     * Creates a Cinema Movie object.
     */
    public CinemaMovie() {
        showTimes = new ArrayList<ShowTime>();
        reviews = new ArrayList<Review>();
    }

    /**
     * Gets the Movie object of this Cinema Movie.
     * @return Movie of this Cinema Movie.
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Sets the movie corresponding to this Cinema Movie object.
     * @param movie This is the movie corresponding to this Cinema Movie object.
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    /**
     * Adds a show time to the List of showtimes of this Cinema Movie.
     * @param time This is the show time corresponding to this Cinema Movie.
     */
    public void setShowTimes(ShowTime time) {
        showTimes.add(time);
    }

    /**
     * Gets the List of showtimes of this Cinema Movie.
     * @return List of showtimes of this Cinema Movie.
     */
    public List<ShowTime> getShowTimes() {
        return showTimes;
    }

    /**
     * Adds a review to the List of reviews that belongs to this Cinema Movie.
     * @param review This is the review belonging to this Cinema Movie.
     */
    public void setReviews(Review review) {
        reviews.add(review);
        updateOverallRating();
    }

    /**
     * Gets the List of reviews of this Cinema Movie.
     * @return List of reviews of this Cinema Movie.
     */
    public List<Review> getReviews() {
        return reviews;
    }

    /**
     * Sets the showing status corresponding to this Cinema Movie.
     * @param movie This is the showing status of this Cinema Movie.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Gets the showing status of this Cinema Movie.
     * @return showing status of this Cinema Movie.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the end of showing date of this Cinema Movie.
     * @param date This is the end of showing dates of this Cinema Movie.
     */
    public void setEndDate(String date) {
        this.endDate = date;
    }

    /**
     * Gets the end of showing date of this Cinema Movie.
     * @return end of showing date of this Cinema Movie.
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the movie type of this Cinema Movie.
     * @param type This is the movie type of this Cinema Movie.
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * Gets the movie type of this Cinema Movie.
     * @return this Cinema Movie's movie type.
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets the overall reviewer rating of this Cinema Movie.
     * @param rating This is the overall reviewer rating of this Cinema Movie.
     */
    public void setOverallRating(float rating) {
        this.overallRating = rating;
    }

    /**
     * Gets the overall reviewer rating of this Cinema Movie.
     * @return This Cinema Movie's overall reviewer rating.
     */
    public float getOverallRating() {
        return overallRating;
    }

    /**
     * Sets the total ticket sales of this Cinema Movie.
     * @param sales This is the total ticket sales of this Cinema Movie.
     */
    public void setTicketSales(double sales) {
        this.ticketSales = sales;
    }

    /**
     * Gets the total ticket sales of this Cinema Movie.
     * @return total ticket sales of this Cinema Movie.
     */
    public double getTicketSales() {
        return ticketSales;
    }

    /**
     * Searches for a particular show time of the Cinema Movie object. Users can select a show time from the list of all
     * availble show times for the cinema movie. Users will input an integer to make their selection.
     * @return ShowTime object that has been selected by the user.
     * @retun null if invalid selection is made.
     */
    public ShowTime searchShowTime() {
        Scanner sc = new Scanner(System.in);
        int i = 1;

        if (showTimes.isEmpty()) {
            System.out.println("Error! Movie has no show times.");
            return null;
        }

        for (ShowTime showTime : showTimes) {
            System.out.printf("(%d) ", i);
            showTime.displayShowTimes();
            i++;
        }
        System.out.println("Select showtime: ");
        String input = sc.nextLine();
        try {
            int index = Integer.parseInt(input);
            if (index > showTimes.size() || index < 1) {
                System.out.println("Error! Please select a showtime from the list.");
                return null;
            }
            return showTimes.get(index - 1);
        } catch (NumberFormatException e) {
            System.out.println("Error! Please select a showtime from the list.");
            return null;
        }

    }

    /**
     * Updates the overall reviewer rating of the cinema movie. This method is called whenever a new review is added.
     */
    public void updateOverallRating() {
        if (reviews.size() == 0)
            return;
        float temp = 0f;
        for (Review review : reviews) {
            temp += review.getRating();
        }
        overallRating = temp / reviews.size();
    }

    /**
     * Checks if input show time clashes with other show times that are already in the database.
     * @param st The show time that we want to validate.
     * @return true if input show time does not clash with pre-existing show times;
     *         returns false if otherwise.
     */
    public Boolean isValidShowTime(ShowTime st) {
        for (ShowTime time : showTimes) {
            if (st.getCineplexName().equals(time.getCineplexName()) && st.getCinemaCode().equals(time.getCinemaCode())
                    && st.getDate().equals(time.getDate())) {
                int stStart = Integer.parseInt(st.getStartTime());
                int stEnd = Integer.parseInt(st.getEndTime());
                int timeStart = Integer.parseInt(time.getStartTime());
                int timeEnd = Integer.parseInt(time.getEndTime());
                if ((stStart >= timeStart && stStart <= timeEnd) || (stEnd >= timeStart && stEnd <= timeEnd)) {
                    System.out.println("Error! Input show time clashes with show times in database.");
                    return false;
                }
            }
        }
        return true;
    }

}
