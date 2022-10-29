import java.util.*;

public class AdminAccounts {
    private HashMap<String, String> adminAccounts;

    public AdminAccounts(){
        adminAccounts = new HashMap<String, String>();
    }
    
    public void setAccount(String id, String password){  // Stores Admin ID and password in database
        adminAccounts.put(id, password);
    }
   
    public Boolean isAdmin(String inputId){   // Returns true if Admin ID exists in database
        for (String id : adminAccounts.keySet()) {
            if (inputId.equals(id))
                return true;
        }
        return false;
    }

    public Boolean validateAdmin(String id, String pwd){  // Returns true if Admin ID matches with corresponding password in database
        if (pwd.equals(adminAccounts.get(id)))
            return true;
        else
            return false;
}
