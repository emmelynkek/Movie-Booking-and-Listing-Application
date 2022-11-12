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
     * @param id This is the ID of this Moviegoer.
     * @param num This is the mobile number of this Moviegoer.
     * @param email This is the email address of this Moviegoer.
     */
    public Moviegoer(String id, String num, String email) {
        this.userId = id;
        this.mobileNum = num;
        this.email = email;
    }
    
    /**
     * Sets or modifies the ID for this Moviegoer.
     * @param id This Moviegoer's username.
     */
    public void setId(String id){
        userId = id;
    }
    
    /**
     * Gets the ID for this Moviegoer.
     * @return ID of this Moviegoer.
     */
    public String getId(){
        return userId;
    }
    
    /**
     * Gets the mobile number of this Moviegoer.
     * @return mobile number of this Moviegoer.
     */
    public String getNum() {
        return this.mobileNum;
    }
    
    /**
     * Gets the email address for this Moviegoer.
     * @return email address of this Moviegoer.
     */
    public String getEmail() {
        return this.email;
    }
 
}
