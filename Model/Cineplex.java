package Model;
import java.io.*;
import java.util.ArrayList;

public class Cineplex implements Serializable{
    private String name;
    private ArrayList<Cinema> cinemaArray;

    public Cineplex(String n){
        this.setName(n);
        this.cinemaArray = new ArrayList<Cinema>();
        for (int i = 0; i < 3; i++) {
            cinemaArray.add(new Cinema("R" + i, Cinema.cinemaType.REGULAR));
        }
        cinemaArray.add(new Cinema("P3", Cinema.cinemaType.PLATINUM));
    }

    public ArrayList<Cinema> getCinemaArray() {
        return this.cinemaArray;
    }

    public String getName() {
        return this.name;
    }

    public void setCinema(ArrayList<Cinema> cinemas) {
        this.cinemaArray = cinemas;
    }

    public void setName(String n) {
        this.name = n;
    }

    public Cinema searchCinema(String code){   
        for (Cinema cinema: cinemaArray){
            if (cinema.getCode().equals(code)){
                return cinema;
            }
        }
        System.out.printf("Error! Cinema not found.\n");
        return null;
    }

}
