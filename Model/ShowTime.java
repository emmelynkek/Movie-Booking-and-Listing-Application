package Model;
import java.io.*;

/**
  Represents the Class that contains information about a cinema movie's show time.
  @author Julian Wong
  @version 1.0
  @since 2022-11-12
*/
public class ShowTime implements Serializable{
    
    /**
     * The date at which the cinema movie will be screened.
     * Format is DD-MMM-YYYY (Eg: 31-Jan-2023)
     */
    private String date;
    
    /**
     * The time at which the cinema movie will start screening.
     * Format is military time (Eg: 1600, 0400)
     */
    private String startTime;
    
    /**
     * The time at which the cinema movie will stop screening.
     * Format is military time (Eg: 1600, 0400)
     */
    private String endTime;
    
    /**
     * SeatLayout contains info about available seats for a show time
     * One SeatLayout for each show time.
     */
    private SeatLayout layout;
    
    /**
     * The code of the cinema which the cinema movie will be screened.
     * Can only take the values of R0, R1, R2 or P3.
     */
    private String cinemaCode;
    
    /**
     * The name of the cineplex which the cinema movie will be screened.
     */
    private String cineplexName;
    
    /**
     * Creates a new ShowTime object.
     */
    public ShowTime(){
        layout = new SeatLayout();
    }
    
    /**
     * Method to set the date at which the cinema movie will be screened.
     * @param date This is the date at which the cinema movie will be screened.
     */
    public void setDate(String date){
        this.date = date;
    }
    
    /**
     * Method to access the date at which the cinema movie will be screened.
     * @return the date at which the cinema movie will be screened.
     */
    public String getDate(){
        return date;
    }
    
    /**
     * Method to set the time at which the cinema movie will start screening.
     * @param time This is the time at which the cinema movie will start screening.
     */
    public void setStartTime(String time){
        this.startTime = time;
    }
    
    /**
     * Method to access the time at which the cinema movie will start screening.
     * @return the time at which the cinema movie will start screening.
     */
    public String getStartTime(){
        return startTime;
    }
    
    /**
     * Method to set the time at which the cinema movie will stop screening.
     * @param time This is the time at which the cinema movie will stop screening.
     */
    public void setEndTime(String time){
        this.endTime = time;
    }
    
    /**
     * Method to access the time at which the cinema movie will stop screening.
     * @return the time at which the cinema movie will stop screening.
     */
    public String getEndTime(){
        return endTime;
    }
    
    /**
     * Method to access the seat layout of the show time.
     * @return the seat layout of the show time.
     */
    public SeatLayout getSeatLayout(){
        return layout;
    }
    
    /**
     * Method to set the code of the cinema which the cinema movie will be screened.
     * @param name This is the code of the cinema which the cinema movie will be screened.
     */
    public void setCinemaCode(String name){
        this.cinemaCode = name;
    }
    
    /**
     * Method to access the code of the cinema which the cinema movie will be screened.
     * @return the code of the cinema which the cinema movie will be screened.
     */
    public String getCinemaCode(){
        return cinemaCode;
    }
    
    /**
     * Method to set the name of the cineplex which the cinema movie will be screened.
     * @param name This is the name of the cineplex which the cinema movie will be screened.
     */
    public void setCineplexName(String name){
        this.cineplexName = name;
    }
    
    /**
     * Method to access the name of the cineplex which the cinema movie will be screened.
     * @return the name of the cineplex which the cinema movie will be screened.
     */
    public String getCineplexName(){
        return cineplexName;
    }
    
    /**
     * Method to display the details of a show time.
     * The cineplex name, cinema code and start & end times of the show time will be displayed.
     */
    public void displayShowTimes(){
        System.out.printf("%s | Cinema %s | ",cineplexName, cinemaCode);
        System.out.println(date+" "+startTime+" to "+endTime);
    }

}
