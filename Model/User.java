package Model;
import java.io.*;

public class User implements Serializable{
    private String userId;
    private String mobileNum;
    private String email;

    public User(String id, String num, String email) {
        this.userId = id;
        this.mobileNum = num;
        this.email = email;
    }
    public void setUserId(String id){
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
