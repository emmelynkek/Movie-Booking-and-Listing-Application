package Model;
import java.io.*;

/**
    Represents the container Class used to store the accounts of our app users.
    Can be implemented by any Class that has a data structure to store account information.
    All subclasses will be Serializable.
    @author Julian Wong
    @version 1.0
    @since 2022-11-12
*/
public interface Accounts extends Serializable{
    /**
        * Checks if a User's ID exists in a data structure.
        * @param inputId This is the ID inputted by the User.
        * @return true if ID exists in data structure; returns false if otherwise.
    */
    public Boolean isUser(String inputId);
    
    /**
        * Checks if an input User's ID matches with the corresponding password in the data structure.
        * @param id This is the ID inputted by the User.
        * @param pwd This is the password inputted by the User.
        * @return true if ID matches with password; returns false if otherwise. 
    */
    public Boolean validateUser(String id, String pwd);

}
