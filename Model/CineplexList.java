package Model;
import java.io.*;
import java.util.*;

public class CineplexList implements Serializable{
    private List<Cineplex> list;

    public CineplexList(){
        list = new ArrayList<Cineplex>();
    }

    public void addCineplex(Cineplex cineplex){
        list.add(cineplex);
    }

    public List<Cineplex> getCineplexList(){
        return list;
    }

    public Cineplex searchCineplex(String name){   
        for (Cineplex cineplex: list){
            if (cineplex.getName().equals(name)){
                return cineplex;
            }
        }
        System.out.printf("Error! Cineplex not found.\n");
        return null;
    }
}
