package Model;
import java.io.*;

public class Cinema implements Serializable{
    public enum cinemaType {
        PLATINUM,
        REGULAR;
    }
    private String code;
    private cinemaType type;

    public Cinema(String code, cinemaType t){
        this.setCode(code);
        this.setCinemaType(t);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setCinemaType(cinemaType t) {
        this.type = t;
    }

    public cinemaType getCinemaType() {
        return this.type;
    }
}
