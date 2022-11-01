import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Date;


public class PublicHoliday implements Serializable {
    private String name; //name of public holiday
    private String date; //date shd be in form dd-MM-YYYY
    private double rate; //rate to charge for public holiay 

    public PublicHoliday(String name, String date, double rate) {
        this.name= name; 
        this.date = date; 
        this.rate = rate;
    } 

    public static  GregorianCalendar stringToDate(String sdate) throws ParseException{ //convert input string to gregoriancalender date format
        String[] splitDate = sdate.split("-");
        int days = Integer.parseInt(splitDate[0]);
        int month = (Integer.parseInt(splitDate[1]) - 1);
        int year = Integer.parseInt(splitDate[2]);

        GregorianCalendar dateConverted = new GregorianCalendar(year, month, days);
        return dateConverted;

    }



    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }
	

    public double getRate() {
        return rate;
    }


	public void setDate(String date) {
        this.date = date;
    }

    public void setName( String Name) {
        this.name =Name;
    }

    public void setRate( double rate) {
        this.rate =rate;
    }


    public static void main(String[] args)throws Exception {   
        PublicHoliday ph = new PublicHoliday("National day", "20-10-2002", 10.00); 
        GregorianCalendar date1 = stringToDate(ph.getDate()); 
        System.out.println(date1); 

   
    } 

	




    
}
