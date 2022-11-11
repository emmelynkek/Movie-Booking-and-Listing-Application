package Model;
import java.io.*;

public interface Accounts extends Serializable{
    public Boolean isUser(String inputId);
    public Boolean validateUser(String id, String pwd);

}
