package Model;

import java.util.*;
import java.io.*;

/**
 * Represents the Class used to store descriptive information about a movie.
 * 
 * @author Julian Wong
 * @version 1.0
 * @since 2022-11-12
 */
public class Movie implements Serializable {
    /**
     * Title of the movie.
     */
    private String title;

    /**
     * Synopsis of the movie.
     */
    private String synopsis;

    /**
     * Name of the movie director.
     */
    private String directorName;

    /**
     * List of names of cast members of the movie.
     */
    private List<String> castNames;

    /**
     * Creates a new Movie object.
     */
    public Movie() {
        castNames = new ArrayList<String>();
    }

    /**
     * Changes the title for this Movie.
     * @param title This Movie's title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the title of this Movie.
     * @return this Movie's title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the synopsis of this Movie.
     * @param synopsis This Movie's new synopsis.
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * Gets the synopsis of this Movie.
     * @return this Movie's synopsis.
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * Sets the director's name for this Movie.
     * @param name this Movie's director's name.
     */
    public void setDirectorName(String name) {
        this.directorName = name;
    }

    /**
     * Gets the director's name for this Movie.
     * @return this Movie's director's name.
     */
    public String getDirectorName() {
        return directorName;
    }

    /**
     * Sets the casts' name for this Movie.
     * @param name This is the name of a Movie cast member.
     */
    public void setCastNames(String name) {
        castNames.add(name);
    }

    /**
     * Gets the list of casts's name for this Movie.
     * @return this Movie's list of cast.
     */
    public List<String> getCastNames() {
        return castNames;
    }

}
