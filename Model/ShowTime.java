package Model;
import java.io.*;

public class ShowTime implements Serializable{
    private String date;         // eg: 31-Jan-2023
    private String startTime;    // Military time, eg: 1600, 0400 (for easier comparison)
    private String endTime;      // Military time, eg: 1800, 0600 (for easier comparison)
    private SeatLayout layout;   // One SeatLayout for each ShowTime
    private String cinemaCode;   
    private String cineplexName;

    public ShowTime(){
        layout = new SeatLayout();
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getDate(){
        return date;
    }

    public void setStartTime(String time){
        this.startTime = time;
    }

    public String getStartTime(){
        return startTime;
    }

    public void setEndTime(String time){
        this.endTime = time;
    }

    public String getEndTime(){
        return endTime;
    }

    public SeatLayout getSeatLayout(){
        return layout;
    }

    public void setCinemaCode(String name){
        this.cinemaCode = name;
    }

    public String getCinemaCode(){
        return cinemaCode;
    }

    public void setCineplexName(String name){
        this.cineplexName = name;
    }

    public String getCineplexName(){
        return cineplexName;
    }

    public void displayShowTimes(){
        System.out.printf("%s | Cinema %s | ",cineplexName, cinemaCode);
        System.out.println(date+" "+startTime+" to "+endTime);
    }

}
