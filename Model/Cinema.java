package Model;

import java.io.*;

/**
 * Represents a cinema hall in a cineplex. A cinema can show many different movies at different times.
 * @author  Ng Li Lin Evonne
 * @version 1.0
 * @since   2022-10-26
 */
public class Cinema implements Serializable {
    /**
     * The different types of cinemas.
     * @see #PLATINUM
     * @see #REGULAR
     */
    public enum cinemaType {

        /**
         * Platinum cinema
         */
        PLATINUM,

        /**
         * Regular cinema
         */
        REGULAR;
    }

    /**
     * The unique code of this cinema.
     */
    private String code;

    /**
     * The type of this cinema.
     */
    private cinemaType type;

    /**
     * Creates a new Cinema with the given cinema code and type.
     * @param code This Cinema's code.
     * @param t    This Cinema's type.
     */
    public Cinema(String code, cinemaType t) {
        this.setCode(code);
        this.setCinemaType(t);
    }

    /**
     * Changes the code of this Cinema.
     * @param code This Cinema's new code. Should include an alphabet representing this Cinema's type and a number.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the code of this Cinema.
     * @return this Cinema's code.
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Changes the type of this Cinema.
     * @param t This Cinema's new type. Should be either Regular or Platinum.
     */
    public void setCinemaType(cinemaType t) {
        this.type = t;
    }

    /**
     * Gets the type of this Cinema.
     * @return this Cinema's type.
     */
    public cinemaType getCinemaType() {
        return this.type;
    }
}
