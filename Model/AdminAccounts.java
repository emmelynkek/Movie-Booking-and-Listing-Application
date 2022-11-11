package Model;
import java.util.*;

public class AdminAccounts implements Accounts{
    private HashMap<String, String> loginInfo; // Maps each admin ID to a password
    private HashMap<String, Admin> accounts; // Maps each admin ID to a Admin object

    public AdminAccounts(){
        loginInfo = new HashMap<String, String>();
        accounts = new HashMap<String, Admin>();
    }
    
    public void setAccount(Admin admin, String password){  // Stores admin info in database
        loginInfo.put(admin.getId(), password);
        accounts.put(admin.getId(), admin);
    }
   
    public Boolean isUser(String inputId){   // Returns true if admin ID exists in database
        for (String id : loginInfo.keySet()) {
            if (inputId.equals(id))
                return true;
        }
        return false;
    }

    public Boolean validateUser(String id, String pwd){  // Returns true if admin ID matches with password in database
        if (pwd.equals(loginInfo.get(id)))
            return true;
        else
            return false;
    }

    public Admin getAdmin(String id){   // Get admin object from the database by adminID
        return accounts.get(id);
    }
}
