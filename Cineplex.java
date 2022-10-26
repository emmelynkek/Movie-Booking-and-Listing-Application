import java.util.ArrayList;

public class Cineplex {
    private String name;
    private ArrayList<Cinema> cinemaArray;
    private int numberofReg;
    private int numberofPlat;

    Cineplex(String n, int num1, int num2) {
        this.setName(n);
        this.setNumReg(num1);
        this.setNumPlat(num2);
        this.cinemaArray = new ArrayList<Cinema>();
        for (int i = 0; i < num1; i++) {
            cinemaArray.add(new Cinema("R" + i, Cinema.cinemaType.REGULAR));
        }
        for (int j = 0; j < num2; j++) {
            cinemaArray.add(new Cinema("P" + j, Cinema.cinemaType.PLATINUM));
        }
    }

    public ArrayList<Cinema> getCinema() {
        return this.cinemaArray;
    }

    public String getName() {
        return this.name;
    }

    public int getNumReg() {
        return this.numberofReg;
    }

    public int getNumPlat() {
        return this.numberofPlat;
    }

    public void setCinema(ArrayList<Cinema> cinemas) {
        this.cinemaArray = cinemas;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setNumReg(int number) {
        this.numberofReg = number;
    }

    public void setNumPlat(int number) {
        this.numberofPlat = number;
    }
}
