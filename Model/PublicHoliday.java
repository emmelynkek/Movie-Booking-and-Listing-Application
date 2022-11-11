package Model;
import java.io.Serializable;
import java.text.*;
import java.util.*;


/**
  Represents a public holiday
  Admin can create multiple public holidays 
  @author Emmelyn Kek 
  @version 2.0
  @since 2022-10-09
 */

public class PublicHoliday implements Serializable {
    /** 
     * The name of the public holiday
     */
    private String name; 
    
    /** 
     * The date of the public holiday
     * Date is in Gregorian Calender format 
     */
    private GregorianCalendar date; 
   
    /** 
     * Creates a new Public Holiday 
     * @param name Name of Public Holiday
     * @param date Date of Public Holiday
     */
    public PublicHoliday(String name, GregorianCalendar date) {
        this.name= name; 
        this.date = date; 
       
    } 

    /**
     * Converts string input in format dd-MMM-YYYY to Gregorian calender format
     * @param sdate Date in string format 
     * @return Date in Gregorian Calender format
     * @throws ParseException On input error
     */
    public static GregorianCalendar stringToDate(String sdate) throws ParseException{ //convert input string to gregoriancalender date format

        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = df.parse(sdate);
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal;
    }

    /** 
     * Gets the name of the public holiday
     * @return The name of the public holiday
     */
    public String getName() {
        return name;
    }

    /** 
     * Gets the date of the public holiday
     * @return The date of the public holiday in Gregorian calender format
     */
    public GregorianCalendar getDate() {
        return date;
    }

    /**
     * Changes the date of the public holiday
     * @param date Date of the public holiday
     */
	public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    /**
     * Changes the name of the public holiday
     * @param Name Name of the public holiday
     */
    public void setName( String Name) {
        this.name =Name;
    }
    
}