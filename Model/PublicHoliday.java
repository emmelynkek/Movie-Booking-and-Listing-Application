package Model;
import java.io.Serializable;
import java.text.*;
import java.util.*;



public class PublicHoliday implements Serializable {
    private String name; //name of public holiday
    private GregorianCalendar date; //date shd be in form dd-MM-YYYY
   

    public PublicHoliday(String name, GregorianCalendar date) {
        this.name= name; 
        this.date = date; 
       
    } 

    public static GregorianCalendar stringToDate(String sdate) throws ParseException{ //convert input string to gregoriancalender date format
        /*String[] splitDate = sdate.split("-");
        int days = Integer.parseInt(splitDate[0]);
        int month = (Integer.parseInt(splitDate[1]) - 1);
        int year = Integer.parseInt(splitDate[2]);

        GregorianCalendar dateConverted = new GregorianCalendar(year, month, days);
        return dateConverted;*/

        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = df.parse(sdate);
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal;
    }


    public String getName() {
        return name;
    }

    public GregorianCalendar getDate() {
        return date;
    }
 
	public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public void setName( String Name) {
        this.name =Name;
    }

    public static void main(String[] args) throws ParseException {
        String s = "18-Oct-2002"; 
        System.out.print(stringToDate(s)); 



    }

 


	




    
}