import java.util.GregorianCalendar;
import java.util.*;

enum MovieGoerAge {
    ADULT,
    STUDENT,
    SENIOR_CITIZEN
}

public class PriceAdjustment {
    private double basePrice; 
    private double studentPA; 
    private double elderlyPA; 
    private double weekdayPA; 
    private double weekendPA; 
    private double publicHolPA;
    private double movTypePA;
    private double cinemaTypePA;
  


    public PriceAdjustment() {
        this.basePrice = 9.00;
        this.studentPA = 2.00; 
        this.elderlyPA = 5.00; 
        this.weekdayPA = 0.50; 
        this.weekendPA = 2.00;
        this.publicHolPA = 2.00; 
        this.movTypePA = 2.00;  
        this.cinemaTypePA =10; 
    

    }

    public double getBasePrice() {
        return basePrice;
    }
    public double getStudentPA() {
        return studentPA;
    }
    public double getElderlyPA() {
        return elderlyPA;
    }
    public double getWeekdayPA() {
        return weekdayPA;
    }

    public double getWeekendPA() {
        return weekendPA;
    }

    public double getMovieTypePA() {
        return movTypePA;
    }
    public double getCinemaTypePA() {
        return cinemaTypePA;
    }
    public double getPubHolPA() {
        return publicHolPA;
    }



    public void setBasePrice(double bp) {
        this.basePrice= bp;
    }

    public void setStudentPA(double spa) {
         this.studentPA = spa;
    }

    public void setElderlyPA(double epa ) {
         this.elderlyPA = epa;
    }

    public void setWeekdayPA(double wdpa ) {
        this.weekdayPA = wdpa;
   }

   public void setWeekendPA(double wpa ) {
    this.weekendPA = wpa;
  }

    public void setMovieTypePA(double mtpa) {
     this.movTypePA=mtpa ;
    }
    public void setCinemaTypePA(double ctpa) {
    this.cinemaTypePA = ctpa;
    }
    public void setPubHolPA(double phpa) {
        this.publicHolPA = phpa;
    }



    


    public double getAdjustedPrice(MovieGoerAge age, Cinema cinema, GregorianCalendar date, CinemaMovie movie, PublicHolidayList phl) {
        double priceAdjustment = 0;
        // assuming that the original price for Adults is $9
    
        if (age == MovieGoerAge.STUDENT) {
            priceAdjustment -= studentPA;
        } else if (age == MovieGoerAge.SENIOR_CITIZEN) {
            priceAdjustment -= elderlyPA;
        } else {

            
        //for public holiday

        int size = phl.getList().size();

        for(int i=0; i<size; i++){ 
            GregorianCalendar PHdate = phl.getList().get(i); 
            if(date.get(GregorianCalendar.DAY_OF_MONTH) == PHdate.get(GregorianCalendar.DAY_OF_MONTH) && date.get(GregorianCalendar.MONTH) == PHdate.get(GregorianCalendar.MONTH) ){ 
                priceAdjustment += this.publicHolPA; 
            } 
        }

        //for weekday 

        if (date.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.MONDAY|| date.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.TUESDAY || date.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.WEDNESDAY) {
            priceAdjustment -= weekdayPA;
            if (movie.getType() == CinemaMovie.Type.THREE_D) {
                priceAdjustment += movTypePA;
            }
        } 

        //for weekend

        else if (date.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.FRIDAY || date.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SATURDAY || date.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SUNDAY) {
            priceAdjustment += weekendPA;
            if (movie.getType() == CinemaMovie.Type.THREE_D) {
                priceAdjustment += movTypePA;
            }
        }

        //for cinema type
        
        if (cinema.getCinemaType() == Cinema.cinemaType.PLATINUM) {
            priceAdjustment += cinemaTypePA;
        }

         }
        return this.basePrice + priceAdjustment;
}

}
