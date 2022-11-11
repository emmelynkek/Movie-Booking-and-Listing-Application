package Model;
import java.io.*;

/**
  Represents a seat in the cinema.
  A cinema will contain a set of seats.
  @author Emmelyn Kek 
  @version 1.0
  @since 2022-10-11
 */

public class Seat implements Serializable{

    /** 
     * The availability of the seat
     */
    private boolean available; 
     
    /** 
     * Creates a new Seat with a given availablity
     * @param availability This seat's availability
     */
    public Seat (boolean availability){ 
        this.available = availability;
    }

    /** 
     * Changes the availability of the seat
     * @param availability This seat's new availability
     */
    public void setAvailable(boolean availability) {
		this.available = availability;
	}

    /** 
     * Gets the availability of the seat
     * @return This seat's availability 
     */
	public boolean getAvailable() {
		return available;
	}
}
