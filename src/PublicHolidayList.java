import java.util.*;

public class PublicHolidayList {
    private List <PublicHoliday> publicHolidayList;    //contains List of all avaliable public holidays 

    public PublicHolidayList(){
        publicHolidayList = new ArrayList <PublicHoliday>();
    }

    public List <PublicHoliday> getList(){
        return publicHolidayList;
    }

    public void addPublicHoliday(PublicHoliday ph){
        publicHolidayList.add(ph);
    }
    
}
