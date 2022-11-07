package Model;
import java.util.*;

import Model.CinemaMovie.Status;

import java.io.*;

public class Top5List implements Serializable{
    public enum sortBy{
        SALES, RATING; 
    }

    private List <CinemaMovie> top5List;
    private sortBy type;
    

    public Top5List(){   
        top5List = new ArrayList <CinemaMovie>();
    }

    public List <CinemaMovie> getList(){
        return top5List;
    }

    public void addMovie(CinemaMovie movie){
        top5List.add(movie);
    }

    public void setSortBy(sortBy type){
        this.type = type;
    }

    public sortBy getSortBy(){
        return type;
    }

    public void sortList(MovieList movieList){ //Method to sort Top 5 List based on sortBy

        List <CinemaMovie> temp = new ArrayList <CinemaMovie>();
        top5List.clear();
        temp.addAll(movieList.getList());
        
        if (type == sortBy.SALES)
            Collections.sort(temp, TicketSalesComparator);
            
        else if (type == sortBy.RATING)
            Collections.sort(temp, OverallRatingComparator);

        int i=0;
        while(top5List.size()<5 && i<temp.size()){
            if (temp.get(i).getStatus() == Status.END_OF_SHOWING)
                i++;
            else{
                top5List.add(temp.remove(i));
                i++;
            }
        }
    }

    public static final Comparator<CinemaMovie> TicketSalesComparator = new Comparator<CinemaMovie>() {
        @Override
        public int compare(CinemaMovie m1, CinemaMovie m2) {
            return (int) (m2.getTicketSales() - m1.getTicketSales());
        }
    };

    public static final Comparator<CinemaMovie> OverallRatingComparator = new Comparator<CinemaMovie>() {
        @Override
        public int compare(CinemaMovie m1, CinemaMovie m2) {
            double val = m2.getTicketSales() - m1.getTicketSales();
            if (val>0 && val<1)
                return 1;
            else if (val<0 && val>-1)
                return -1;
            else
                return (int) val;
        }
    };
}
