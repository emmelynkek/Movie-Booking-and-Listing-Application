import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class AdminConfigSettings {
    //admin can: 
    //1. create public holiday and rates (done)
    //2. control prices for weekdays and holidays (done)
    //3. control prices for different ages  (done)
    //4. control rankings (wip, waiting for update)
    //5. create/update/delete movie listings (wip, waiting for update)


    public AdminConfigSettings(){ 
    }

    public static GregorianCalendar stringToDate(String sdate) throws ParseException{ //convert input string to gregoriancalender date format
        String[] splitDate = sdate.split("-");
        int days = Integer.parseInt(splitDate[0]);
        int month = (Integer.parseInt(splitDate[1]) - 1);
        int year = Integer.parseInt(splitDate[2]);

        GregorianCalendar dateConverted = new GregorianCalendar(year, month, days);
        // System.out.println(dateConverted);
        return dateConverted;

    }

    public void CreatePublicHoliday(PublicHolidayList publicHolidayList) throws ParseException{ //admin can create public holiday
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Public Holiday:");
        String name = sc.nextLine(); 
        System.out.println("Enter the date in format dd-MM-YYYY:");
        String date = sc.nextLine(); 
        GregorianCalendar date1 = stringToDate(date); 
        System.out.print(date1);
    

        PublicHoliday ph = new PublicHoliday(name, date1);
        publicHolidayList.addPublicHoliday(ph); // *** change publicHolidayList to obj name of publichollist in main app

    }

    public static void ChangePriceAdjustment(PriceAdjustment pa){ //admin can change base price and discounts

        Scanner sc = new Scanner(System.in);
        boolean condition = true; 

        while(condition){ 
            System.out.println("(1) Change base price");
            System.out.println("(2) Change student price adjustment");
            System.out.println("(3) Change elderly price adjustment");
            System.out.println("(4) Change weekday price adjustment");
            System.out.println("(5) Change weekend price adjustment");
            System.out.println("(6) Change public holiday price adjustment");
            System.out.println("(7) Change movie type price adjustment");
            System.out.println("(8) Change cinema type price adjustment");
            System.out.println("(9) Exit");
            System.out.println("Enter the number of your choice: "); 
            int choice; 
            choice = sc.nextInt();
            switch(choice){ 
                case 1: 
                System.out.println("Enter base price: "); 
                double bp; 
                bp = sc.nextDouble();
                pa.setBasePrice(bp);

                break; 

                case 2: 
                System.out.println("Enter student price adjustment: "); 
                double spa; 
                spa = sc.nextDouble();
                pa.setStudentPA(spa);
               
                break; 

                case 3: 
                System.out.println("Enter elderly price adjustment: "); 
                double epa; 
                epa = sc.nextDouble();
                pa.setElderlyPA(epa);
                break; 

                case 4: 
                System.out.println("Enter weekday price adjustment: "); 
                double wdpa; 
                wdpa = sc.nextDouble();
                pa.setWeekdayPA(wdpa);
                break; 
           
            
                case 5: 
                System.out.println("Enter weekend price adjustment: "); 
                double wpa; 
                wpa = sc.nextDouble();
                pa.setWeekendPA(wpa);
                break; 

                case 6: 
                System.out.println("Enter public holiday price adjustment: "); 
                double phpa; 
                phpa = sc.nextDouble();
                pa.setPubHolPA(phpa);
                break; 

                case 7: 
                System.out.println("Enter movie type price adjustment: "); 
                double mtpa; 
                mtpa = sc.nextDouble();
                pa.setMovieTypePA(mtpa);
                break; 

                case 8: 
                System.out.println("Enter cinema type price adjustment: "); 
                double ctpa; 
                ctpa = sc.nextDouble();
                pa.setCinemaTypePA(ctpa);
                break; 
                
                case 9: 
                condition= false; 
                break; 

            }



        }
       


    }

    public static void main(String[] args) throws Exception {
    
        
        //  ChangePriceAdjustment(); 
        // int size = publicHolidayList.size();
        // System.out.println(size);
        // String date = "18-10-2002"; 
        // GregorianCalendar gdate = stringToDate(date);

        // for(int i=0; i<size; i++){ 
        //     GregorianCalendar PHdate = publicHolidayList.get(i); 
        //     if(gdate.get(GregorianCalendar.DAY_OF_MONTH) == PHdate.DAY_OF_MONTH ){ 
        //        System.out.println("yes can work!"); 
        //     } 
            
        //     // AND date.get(GregorianCalendar.MONTH) == PHdate.MONTH

            
        // }




    }

   










}
