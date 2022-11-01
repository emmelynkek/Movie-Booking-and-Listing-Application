import java.io.Serializable;

public class Cinema implements Serializable{
    enum cinemaType {
        PLATINUM,
        REGULAR;
    }

    private String code;
    private cinemaType type;

    public Cinema(String code, cinemaType t) {
        this.setCode(code);
        this.setCinemaType(t);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCinemaType(cinemaType t) {
        this.type = t;
    }

    public String getCode() {
        return this.code;
    }

    public cinemaType getCinemaType() {
        return this.type;
    }
}
