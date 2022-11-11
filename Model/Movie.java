package Model;
import java.util.*;
import java.io.*;

/**
  Represents the Class used to store descriptive information about a movie.
  @author Julian Wong
  @version 1.0
  @since 2022-11-12
*/
public class Movie implements Serializable{
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
    public Movie(){
        castNames = new ArrayList<String>();
    }
    
    /**
     * Method to set the title for this Movie.
     * @param title This is the title of the Movie.
     */
    public void setTitle(String title){
        this.title = title;
    }
    
    /**
     * Method to access the title for this Movie.
     * @return title of the Movie.
     */
    public String getTitle(){
        return title;
    }
    
    /**
     * Method to set the synopsis for this Movie.
     * @param synopsis This is the synopsis of the Movie.
     */
    public void setSynopsis(String synopsis){
        this.synopsis = synopsis;
    }
    
    /**
     * Method to access the synopsis for this Movie.
     * @return synopsis of the Movie.
     */
    public String getSynopsis(){
        return synopsis;
    }
    
    /**
     * Method to set the director's name for this Movie.
     * @param name This is the name of Movie director.
     */
    public void setDirectorName(String name){
        this.directorName = name;
    }
    
    /**
     * Method to access the director's name for this Movie.
     * @return director's name of the Movie.
     */
    public String getDirectorName(){
        return directorName;
    }
    
    /**
     * Method to set the casts' name for this Movie.
     * @param name This is the name of a Movie cast member.
     */
    public void setCastNames(String name){
        castNames.add(name);
    }
    
    /**
     * Method to access the list of casts's name for this Movie.
     * @return list of casts's name of the Movie.
     */
    public List <String> getCastNames(){
        return castNames;
    }    
    
}
