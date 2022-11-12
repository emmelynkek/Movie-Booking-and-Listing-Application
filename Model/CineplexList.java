package Model;
import java.io.*;
import java.util.*;

/**
 * Represents a container Class used to store the list of all Cineplexes in the database.
 * @author  Evonne Ng
 * @version 1.0
 * @since   2022-11-12
 */
public class CineplexList implements Serializable {
    
    /**
     * List of all available cineplexes.
     */
    private List<Cineplex> list;

    /**
     * Creates a new CineplexList containing Cineplexes.
     */
    public CineplexList() {
        list = new ArrayList<Cineplex>();
    }

    /**
     * Adds a Cineplex to the list of Cineplexes.
     * @param cineplex The Cineplex to be added.
     */
    public void addCineplex(Cineplex cineplex) {
        list.add(cineplex);
    }
    
    /**
     * Gets the list of Cineplexes of this CineplexList.
     * @return this CineplexList's list of Cineplexes.
     */
    public List<Cineplex> getList() {
        return list;
    }
    
    /**
     * Searches the list of Cineplexes in this CineplexList for a specific Cineplex.
     * @param name the name of the Cineplex to find.
     * @return     the Cineplex with a name that corresponds to the specific name. If no Cineplex can be found,
     *             a null is returned.
     */
    public Cineplex searchCineplex(String name){   
        for (Cineplex cineplex: list){
            if (cineplex.getName().equals(name)){
                return cineplex;
            }
        }
        System.out.printf("Error! Cineplex not found.\n");
        return null;
    }
}
