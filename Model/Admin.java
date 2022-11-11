package Model;

public class Admin implements User{
    private String adminId;
    
    public void setId(String id){
        adminId = id;
    }

    public String getId(){
        return adminId;
    }
}
