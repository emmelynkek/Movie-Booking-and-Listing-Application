import java.lang.reflect.GenericSignatureFormatError;
import java.util.*;

public class PublicHolidayList {
    private List <GregorianCalendar> publicHolidayList;    //contains List of all avaliable public holidays 

    public PublicHolidayList(){
        publicHolidayList = new ArrayList <GregorianCalendar>();
    }

    public List <GregorianCalendar> getList(){
        return publicHolidayList;
    }

    public void addPublicHoliday(PublicHoliday ph){
        publicHolidayList.add(ph.getDate());
    }
    
}
