import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat; 
import java.util.Date;



public class PublicHoliday implements Serializable {
    private String name; //name of public holiday
    private Date date; //date 
    private double rate; //rate to charge for public holiay 
    


    public PublicHoliday(String name, Date date, double rate) {
        this.name = name;
        this.date = date;
        this.rate = rate;
    }

	

	 public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }
	

    public double getRate() {
        return rate;
    }


	public void setDate(Date date) {
        this.date = date;
    }

    public void setName( String Name) {
        this.name =Name;
    }

    public void setRate( double rate) {
        this.rate =rate;
    }

	

    private  String formatTimeMMdd(Date date) {
    	return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }
    

    public  void printDetail( ) {
        System.out.println("Name  :" + name + "\n"+
            "Date      : " + formatTimeMMdd(date) + "\n" +
               "Price rate: " + rate);
    }

  
    public String toString() {
        return (name + " (" + formatTimeMMdd(date) + ")");
    }
    
   




    
}
