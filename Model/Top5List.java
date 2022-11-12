package Model;
import java.util.*;

import Model.CinemaMovie.Status;

import java.io.*;

/**
  Represents the Class that contains the Top 5 cinema movies.
  Cinema movies can be ranked by overall reviewer rating or total tickets sales.
  Cinema movies are sorted in descending order.
  @author Julian Wong
  @version 1.0
  @since 2022-11-12
*/
public class Top5List implements Serializable{
    
    /**
     * The order used to sort the top 5 list.
     */
    public enum sortBy{
        SALES, RATING; 
    }
    
    /**
     * The list that stores the top 5 cinema movies
     */
    private List <CinemaMovie> top5List;
    
    /**
     * The order used to sort the top 5 list.
     */
    private sortBy type;
    
    /**
     * Creates a new top 5 list object.
     */
    public Top5List(){   
        top5List = new ArrayList <CinemaMovie>();
    }
    
    /**
     * Gets the list of top 5 cinema movies from this Top5List.
     * @return the list of top 5 cinema movies of this Top5List.
     */
    public List <CinemaMovie> getList(){
        return top5List;
    }
    
    /**
     * Adds a cinema movie to the list of top 5 cinema movies.
     * @param movie The cinema movie to be added to this top 5 list.
     */
    public void addMovie(CinemaMovie movie){
        top5List.add(movie);
    }
    
    /**
     * Changes the sorting order of the top 5 cinema movies.
     * @param type The sorting order of the top 5 cinema movies.
     */
    public void setSortBy(sortBy type){
        this.type = type;
    }
    
    /**
     * Gets the sorting order of the top 5 cinema movies.
     * @return the sorting order of the top 5 cinema movies.
     */
    public sortBy getSortBy(){
        return type;
    }
    
    /**
     * Sorts Top 5 List based on sortBy. Method is called whenever Movie-goer wants to display the top 5 list.
     * @param movieList The list of all available cinema movies, which will be used as the reference to build the top 5 list.
     */
    public void sortList(MovieList movieList){

        List <CinemaMovie> temp = new ArrayList <CinemaMovie>();
        top5List.clear();
        temp.addAll(movieList.getList());
        
        if (type == sortBy.SALES)
            Collections.sort(temp, TicketSalesComparator);
            
        else if (type == sortBy.RATING)
            Collections.sort(temp, OverallRatingComparator);

        while(top5List.size()<5 && !temp.isEmpty()){
            if (temp.get(0).getStatus() == Status.END_OF_SHOWING)
                temp.remove(0);
            else
                top5List.add(temp.remove(0));
        }
    }
    
    /**
     * A Comparator class that sorts the top 5 list by total ticket sales.
     */
    public static final Comparator<CinemaMovie> TicketSalesComparator = new Comparator<CinemaMovie>() {
        @Override
        public int compare(CinemaMovie m1, CinemaMovie m2) {
            return (int) (m2.getTicketSales() - m1.getTicketSales());
        }
    };
    
    /**
     * A Comparator class that sorts the top 5 list by overall reviwer rating.
     */
    public static final Comparator<CinemaMovie> OverallRatingComparator = new Comparator<CinemaMovie>() {
        @Override
        public int compare(CinemaMovie m1, CinemaMovie m2) {
            double val = m2.getOverallRating() - m1.getOverallRating();
            if (val>0d && val<1d)
                return 1;
            else if (val<0d && val>-1d)
                return -1;
            else
                return (int) val;
        }
    };
}
