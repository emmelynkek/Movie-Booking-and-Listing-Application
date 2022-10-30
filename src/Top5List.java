import java.io.Serializable;
import java.util.*;

public class Top5List implements Serializable{
    enum sortBy{
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

        for (int i=0;i<5;i++){
            if (temp.isEmpty())
                break;
            top5List.add(temp.remove(0));
        }
    }

    public Comparator<CinemaMovie> TicketSalesComparator = new Comparator<CinemaMovie>() {
        @Override
        public int compare(CinemaMovie m1, CinemaMovie m2) {
            return (int) (m2.getTicketSales() - m1.getTicketSales());
        }
    };

    public Comparator<CinemaMovie> OverallRatingComparator = new Comparator<CinemaMovie>() {
        @Override
        public int compare(CinemaMovie m1, CinemaMovie m2) {
            return (int) (m2.getOverallRating() - m1.getOverallRating());
        }
    };
}
