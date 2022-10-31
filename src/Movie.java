import java.io.Serializable;
import java.util.*;

public class Movie implements Serializable{
    private String title;
    private String synopsis;
    private String directorName;
    private List<String> castNames;
 
    public Movie(){
        castNames = new ArrayList<String>();
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setSynopsis(String synopsis){
        this.synopsis = synopsis;
    }

    public String getSynopsis(){
        return synopsis;
    }

    public void setDirectorName(String name){
        this.directorName = name;
    }

    public String getDirectorName(){
        return directorName;
    }

    public void setCastNames(String name){
        castNames.add(name);
    }

    public List <String> getCastNames(){
        return castNames;
    }    
    
}