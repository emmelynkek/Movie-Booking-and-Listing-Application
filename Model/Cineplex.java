package Model;

import java.io.*;
import java.util.ArrayList;

/**
 * Represents a cineplex that contains many cinemas.
 * Users can choose which cineplex they want to go to.
 * @author  Ng Li Lin Evonne
 * @version 1.0
 * @since   2022-10-26
 */
public class Cineplex implements Serializable {

    /**
     * The name of this Cineplex.
     */
    private String name;

    /**
     * The list of Cinemas of this Cineplex.
     */
    private ArrayList<Cinema> cinemaArray;

    /**
     * Creates a new Cineplex with the given name
     * and a fixed list of 3 Regular Cinemas and 1 Platinum Cinema.
     * The name should be the location of the Cineplex.
     * @param n This Cineplex's name.
     */
    public Cineplex(String n) {
        this.setName(n);
        this.cinemaArray = new ArrayList<Cinema>();
        for (int i = 0; i < 3; i++) {
            cinemaArray.add(new Cinema("R" + i, Cinema.cinemaType.REGULAR));
        }
        cinemaArray.add(new Cinema("P3", Cinema.cinemaType.PLATINUM));
    }

    /**
     * Gets the list of Cinemas of this Cineplex.
     * @return this Cineplex's list of Cinemas.
     */
    public ArrayList<Cinema> getCinemaArray() {
        return this.cinemaArray;
    }

    /**
     * Gets the name of this Cineplex.
     * @return this Cineplex's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Changes the list of Cinemas of this Cineplex.
     * @param cinemas This Cineplex's new list of Cinemas.
     */
    public void setCinema(ArrayList<Cinema> cinemas) {
        this.cinemaArray = cinemas;
    }

    /**
     * Changes the name of this Cineplex.
     * @param n This Cineplex's new name.
     */
    public void setName(String n) {
        this.name = n;
    }

    /**
     * Searches the list of Cinemas in this Cineplex
     * for a specified Cinema code.
     * @param  code the Cinema code to find.
     * @return the Cinema with a code that corresponds
     *         to the specified code. If no Cinema can be
     *         found, a null is returned.
     */
    public Cinema searchCinema(String code) {
        for (Cinema cinema : cinemaArray) {
            if (cinema.getCode().equals(code)) {
                return cinema;
            }
        }
        System.out.printf("Error! Cinema not found.\n");
        return null;
    }

}
