package Model;
import java.util.*;

/**
  Represents the container Class used to store the accounts of Movie-goers who use our app.
  @author Julian Wong
  @version 1.0
  @since 2022-11-12
*/
public class MoviegoerAccounts implements Accounts{
    /**
     * Data structre that maps each Movie-goer's ID to a password.
     */
    private HashMap<String, String> loginInfo;
    
    /**
     * Data structre that maps each Movie-goer's ID to a Moviegoer object
     */
    private HashMap<String, Moviegoer> accounts; 
    
    /**
     * Creates a new instance of MoviegoerAccounts to store Moviegoer account info.
     */
    public MoviegoerAccounts(){
        loginInfo = new HashMap<String, String>();
        accounts = new HashMap<String, Moviegoer>();
    }
    
    /**
     * Adds a new Moviegoer into the database.
     * @param user This is the Moviegoer object which contains info about the admin.
     * @param password This is the password of the Moviegoer's account.
     */
    public void setAccount(Moviegoer user, String password){
        loginInfo.put(user.getId(), password);
        accounts.put(user.getId(), user);
    }
    
    /**
     * Checks if if Moviegoer ID exists in database.
     * @param inputId This is the ID inputted by the Moviegoer.
     * @return true if Moviegoer ID exists in database; returns false if otherwise.
     */
    public Boolean isUser(String inputId){ 
        for (String id : loginInfo.keySet()) {
            if (inputId.equals(id))
                return true;
        }
        return false;
    }
    
    /**
     * Checks if an input Moviegoer ID matches with the corresponding password in the database.
     * @param id This is the ID inputted by the Moviegoer.
     * @param pwd This is the password inputted by the Moviegoer.
     * @return true if Moviegoer ID matches with password in database; returns false if otherwise.
     */
    public Boolean validateUser(String id, String pwd){ 
        if (pwd.equals(loginInfo.get(id)))
            return true;
        else
            return false;
    }
    
    /**
     * Method used to access a Moviegoer object by its corresponding Admin ID
     * @param id This is the ID inputted by the Moviegoer.
     * @return corresponding Moviegoer object from the database.
     */
    public Moviegoer getUser(String id){   
        return accounts.get(id);
    }
}
