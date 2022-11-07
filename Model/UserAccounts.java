package Model;
import java.util.*;
import java.io.*;

public class UserAccounts implements Serializable{
    private HashMap<String, String> userAccounts; // Maps each user ID to a password

    public UserAccounts(){
        userAccounts = new HashMap<String, String>();
    }
    
    public void setAccount(String id, String password){  // Stores user ID and password in database
        userAccounts.put(id, password);
    }
   
    public Boolean isUser(String inputId){   // Returns true if user ID exists in database
        for (String id : userAccounts.keySet()) {
            if (inputId.equals(id))
                return true;
        }
        return false;
    }

    public Boolean validateUser(String id, String pwd){  // Returns true if user ID matches with password in database
        if (pwd.equals(userAccounts.get(id)))
            return true;
        else
            return false;
    }
}
