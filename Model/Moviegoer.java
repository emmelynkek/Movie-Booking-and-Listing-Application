package Model;
import java.util.*;

/**
  Represents the Class used to store the information of a Moviegoer using our app.
  @author Julian Wong
  @version 1.0
  @since 2022-11-12
*/
public class Moviegoer implements User{
    /**
     * ID of this Moviegoer.
     */
    private String userId;
    
    /**
     * Mobile number of this Moviegoer.
     */
    private String mobileNum;
    
    /**
     * Email address of this Moviegoer.
     */
    private String email;
    
    /**
     * Creates a new Moviegoer with the given input parameters.
     * @param id This is the ID of the Moviegoer.
     * @param num This is the mobile number of the Moviegoer.
     * @param email This is the email address of this Moviegoer.
     */
    public Moviegoer(String id, String num, String email) {
        this.userId = id;
        this.mobileNum = num;
        this.email = email;
    }
    
    /**
     * Method to set or modify the ID for this Moviegoer object.
     * @param id This is the ID inputted by the Moviegoer.
     */
    public void setId(String id){
        userId = id;
    }
    
    /**
     * Method to access the ID for this Moviegoer object.
     * @return ID of the Moviegoer.
     */
    public String getId(){
        return userId;
    }
    
    /**
     * Method to access the mobile number for this Moviegoer object.
     * @return mobile number of the Moviegoer.
     */
    public String getNum() {
        return this.mobileNum;
    }
    
    /**
     * Method to access the email address for this Moviegoer object.
     * @return email address of the Moviegoer.
     */
    public String getEmail() {
        return this.email;
    }

}
