package Model;
import java.util.*;


public class MoviegoerAccounts implements Accounts{
    private HashMap<String, String> loginInfo; // Maps each user ID to a password
    private HashMap<String, Moviegoer> accounts; // Maps each user ID to a User object

    public MoviegoerAccounts(){
        loginInfo = new HashMap<String, String>();
        accounts = new HashMap<String, Moviegoer>();
    }
    
    public void setAccount(Moviegoer user, String password){  // Stores user info in database
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

    public Moviegoer getUser(String id){   // Get User object from the database by userID
        return accounts.get(id);
    }
}
