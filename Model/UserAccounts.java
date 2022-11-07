package Model;
import java.util.*;
import java.io.*;

public class UserAccounts implements Serializable{
    private HashMap<String, String> loginInfo; // Maps each user ID to a password
    private HashMap<String, User> accounts; // Maps each user ID to a User object

    public UserAccounts(){
        loginInfo = new HashMap<String, String>();
        accounts = new HashMap<String, User>();
    }
    
    public void setAccount(User user, String password){  // Stores user info in database
        loginInfo.put(user.getId(), password);
        accounts.put(user.getId(), user);
    }
   
    public Boolean isUser(String inputId){   // Returns true if user ID exists in database
        for (String id : loginInfo.keySet()) {
            if (inputId.equals(id))
                return true;
        }
        return false;
    }

    public Boolean validateUser(String id, String pwd){  // Returns true if user ID matches with password in database
        if (pwd.equals(loginInfo.get(id)))
            return true;
        else
            return false;
    }

    public User getUser(String id){   // Get User object from the database by userID
        return accounts.get(id);
    }
}
