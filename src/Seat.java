import java.io.Serializable;

public class Seat implements Serializable{
    private boolean available; 

    public Seat (boolean availability){ 
        this.available = availability;
    }

    public void setAvailable(boolean availability) {
		this.available = availability;
	}
	
	public boolean getAvailable() {
		return available;
	}
    
    
}
