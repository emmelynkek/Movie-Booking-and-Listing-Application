import java.util.*;

public class PublicHolidayList {
    private List <PublicHoliday> publicHolidayList;    //contains List of all avaliable movies 

    public PublicHolidayList(){
        publicHolidayList = new ArrayList <PublicHoliday>();
    }

    public List <PublicHoliday> getList(){
        return publicHolidayList;
    }

    public void addPubliHoliday(PublicHoliday ph){
        publicHolidayList.add(ph);
    }
    
}
