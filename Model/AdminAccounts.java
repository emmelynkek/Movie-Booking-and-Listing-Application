package Model;
import java.util.*;

/**
  Represents the container Class used to store the accounts of app administrators.
  @author Julian Wong
  @version 1.0
  @since 2022-11-12
*/

public class AdminAccounts implements Accounts{
    /**
     * Data structure that maps each admin ID to a password.
     */
    private HashMap<String, String> loginInfo;
    
    /**
     * Data structure that maps each admin ID to a Admin object
     */
    private HashMap<String, Admin> accounts;
    
    /**
     * Creates a new instance of AdminAccounts to store Admin account info.
     */
    public AdminAccounts(){
        loginInfo = new HashMap<String, String>();
        accounts = new HashMap<String, Admin>();
    }
    
    /**
     * Adds a new Admin into the database.
     * @param admin This is the Admin object which contains info about the admin.
     * @param password This is the password of the Admin's account.
     */
    public void setAccount(Admin admin, String password){
        loginInfo.put(admin.getId(), password);
        accounts.put(admin.getId(), admin);
    }
    
    /**
     * Checks if if admin ID exists in database.
     * @param inputId This is the ID inputted by the Admin.
     * @return true if Admin ID exists in database; returns false if otherwise.
     */
    public Boolean isUser(String inputId){
        for (String id : loginInfo.keySet()) {
            if (inputId.equals(id))
                return true;
        }
        return false;
    }
    
    /**
     * Checks if an input Admin ID matches with the corresponding password in the database.
     * @param inputId This is the ID inputted by the Admin.
     * @param pwd This is the password inputted by the Admin.
     * @return true if Admin ID matches with password in database; returns false if otherwise.
     */
    public Boolean validateUser(String id, String pwd){ 
        if (pwd.equals(loginInfo.get(id)))
            return true;
        else
            return false;
    }
    
    /**
     * Gets an Admin object by its corresponding Admin ID
     * @param id This is the ID inputted by the Admin.
     * @return corresponding Admin object from the database.
     */
    public Admin getAdmin(String id){  
        return accounts.get(id);
    }
}
