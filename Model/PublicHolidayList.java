package Model;
import java.io.*;
import java.util.*;

/**
  Represents the list used to store public holidays 
  Admin can create multiple public holidays and store it inside this list
  @author Emmelyn Kek 
  @version 1.0
  @since 2022-10-09
 */
public class PublicHolidayList implements Serializable{
    /**
     * List storing all public holidays 
     */
    private List <GregorianCalendar> publicHolidayList;    //contains List of all avaliable public holidays 

    /**
     * Creates a new list to store all public holidays
     */
    public PublicHolidayList(){
        publicHolidayList = new ArrayList <GregorianCalendar>();
    }

    /**
     * Gets the public holiday list 
     * @return Public holiday list 
     */
    public List <GregorianCalendar> getList(){
        return publicHolidayList;
    }

    /**
     * Adds a public holiday object to the public holiday list
     * @param ph Public Holiday object to be added to the list
     */
    public void addPublicHoliday(PublicHoliday ph){
        publicHolidayList.add(ph.getDate());
    }
    
}
