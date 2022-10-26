public class Cinema {
    enum cinemaType {
        PLATINUM,
        REGULAR;
    }

    private String code;
    private cinemaType type;

    public Cinema(String code, cinemaType t) {
        this.setCode(code);
        this.setCinemaClass(t);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCinemaClass(cinemaType t) {
        this.type = t;
    }

    public String getCode() {
        return this.code;
    }

    public cinemaType getCinemaType() {
        return this.type;
    }
}
