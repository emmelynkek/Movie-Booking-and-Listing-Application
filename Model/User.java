package Model;
import java.io.*;
   
/**
  Represents the Interface class to store login info for app users. Implemented by Moviegoer class and Admin Class.
  @author Julian Wong
  @version 1.0
  @since 2022-11-12
*/
public interface User extends Serializable{
    
    /**
     * Sets the ID for an app user.
     * @param id This is the ID of an app user.
     */
    public void setId(String id);
    
     /**
     * Gets ID of an app user.
     * @return ID of the an app user.
     */
    public String getId();
}

