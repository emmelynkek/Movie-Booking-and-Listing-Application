package Model;
import java.util.*;

public class Moviegoer implements User{
    private String userId;
    private String mobileNum;
    private String email;

    public Moviegoer(String id, String num, String email) {
        this.userId = id;
        this.mobileNum = num;
        this.email = email;
    }
    public void setId(String id){
        userId = id;
    }

    public String getId(){
        return userId;
    }

    public String getNum() {
        return this.mobileNum;
    }

    public String getEmail() {
        return this.email;
    }

}
