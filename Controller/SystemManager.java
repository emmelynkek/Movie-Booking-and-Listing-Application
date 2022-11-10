package Controller;
import Model.*;
import View.*;
import java.text.*;
import java.util.*;


public class SystemManager{
    //admin can: 
    //1. create public holiday and rates (done)
    //2. control prices for weekdays and holidays (done)
    //3. control prices for different ages  (done)
    //4. control rankings (wip, waiting for update)
    //5. create/update/delete movie listings (wip, waiting for update)


    public static GregorianCalendar stringToDate(String sdate) throws ParseException{ //convert input string to gregoriancalender date format
        /*String[] splitDate = sdate.split("-");
        int days = Integer.parseInt(splitDate[0]);
        int month = (Integer.parseInt(splitDate[1]) - 1);
        int year = Integer.parseInt(splitDate[2]);

        GregorianCalendar dateConverted = new GregorianCalendar(year, month, days);
        // System.out.println(dateConverted);
        return dateConverted;*/

        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = df.parse(sdate);
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal;

    }

    public static void CreatePublicHoliday(PublicHolidayList publicHolidayList) throws ParseException{ //admin can create public holiday
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Public Holiday:");
        String name = sc.nextLine(); 
        System.out.println("Enter the date in format DD-MMM-YYYY:");
        String date = sc.nextLine(); 
        GregorianCalendar date1 = stringToDate(date); 
        // System.out.print(date1);
    

        PublicHoliday ph = new PublicHoliday(name, date1);
        publicHolidayList.addPublicHoliday(ph); // *** change publicHolidayList to obj name of publichollist in main app
        // //to be removed == showing list after creating
        // int size =publicHolidayList.getList().size(); 
        // System.out.println("size of phl:"); 
        // System.out.println(size); 

        // for(int i=0; i<size; i++){ 
        //  System.out.println("---------------------------"); 

        // System.out.println(i); 
        // GregorianCalendar PHdate = publicHolidayList.getList().get(i); 
        // System.out.println("print out public holiday"); 
        // System.out.println(PHdate.get(GregorianCalendar.MONTH)) ; 
        // System.out.println(PHdate.get(GregorianCalendar.DAY_OF_MONTH)) ; }
    
    }




    public static void ChangePriceAdjustment(TicketPrice pa){ //admin can change base price and discounts

        Scanner sc = new Scanner(System.in);
        while(true){ 
            MenuDisplay.printPriceAdjustmentMenu();
            int choice; 
            choice = sc.nextInt();
            String buffer = sc.nextLine();
            switch(choice){ 
                case 1: 
                    System.out.println("Enter base price: "); 
                    double bp; 
                    bp = sc.nextDouble();
                    pa.setBasePrice(bp);
                    System.out.println("Base price updated!");
                    break; 

                case 2: 
                    System.out.println("Enter student discount: "); 
                    double spa; 
                    spa = sc.nextDouble();
                    pa.setStudentPA(spa);
                    System.out.println("Student discount updated!");
                    break; 

                case 3: 
                    System.out.println("Enter senior citizen discount: "); 
                    double epa; 
                    epa = sc.nextDouble();
                    pa.setElderlyPA(epa);
                    System.out.println("Senior Citizen discount updated!");
                    break; 

                case 4: 
                    System.out.println("Enter Mon/Tue/Wed discount: "); 
                    double wdpa; 
                    wdpa = sc.nextDouble();
                    pa.setWeekdayPA(wdpa);
                    System.out.println("Mon/Tue/Wed discount updated!");
                    break; 
           
            
                case 5: 
                    System.out.println("Enter weekend surcharge: "); 
                    double wpa; 
                    wpa = sc.nextDouble();
                    pa.setWeekendPA(wpa);
                    System.out.println("Weekend surcharge updated!");
                    break; 

                case 6: 
                    System.out.println("Enter public holiday surcharge: "); 
                    double phpa; 
                    phpa = sc.nextDouble();
                    pa.setPubHolPA(phpa);
                    System.out.println("Public Holiday surcharge updated!");
                    break; 

                case 7: 
                    System.out.println("Enter 3D movie surcharge: "); 
                    double tdpa; 
                    tdpa = sc.nextDouble();
                    pa.set3DPA(tdpa);
                    System.out.println("3D movie surcharge updated!");
                    break;
                case 8: 
                    System.out.println("Enter blockbuster movie surcharge: "); 
                    double bbpa; 
                    bbpa = sc.nextDouble();
                    pa.setBlockbusterPA(bbpa);;
                    System.out.println("Blockbuster movie surcharge updated!");
                    break; 

                case 9: 
                    System.out.println("Enter platinum suite surcharge: "); 
                    double ctpa; 
                    ctpa = sc.nextDouble();
                    pa.setCinemaTypePA(ctpa);
                    System.out.println("Platinum suites surcharge updated!");
                    break;
                    
                case 10: 
                    System.out.println("Enter premium seat surcharge: "); 
                    double stpa; 
                    stpa = sc.nextDouble();
                    pa.setSeatPA(stpa);
                    System.out.println("Premium seat surcharge updated!");
                    break; 

                case 11: 
                    System.out.println("Printing current price adjustments...: "); 
                    System.out.printf("Base Price: $%.2f\n", pa.getBasePrice());
                    System.out.printf("Student Discount: $%.2f\n", pa.getStudentPA());
                    System.out.printf("Senior Citizen Discount: $%.2f\n", pa.getElderlyPA());
                    System.out.printf("Mon/Tue/Wed Discount: $%.2f\n", pa.getWeekdayPA());
                    System.out.printf("Weekend Surcharge: $%.2f\n", pa.getWeekendPA());
                    System.out.printf("Public Holiday Surcharge: $%.2f\n", pa.getPubHolPA());
                    System.out.printf("3D Movie Surcharge: $%.2f\n", pa.get3DPA());
                    System.out.printf("Blockbuster Movie Surcharge: $%.2f\n", pa.getBlockbusterPA());
                    System.out.printf("Platinum Suite Surcharge: $%.2f\n", pa.getCinemaTypePA());
                    System.out.printf("Premium Seat Surcharge: $%.2f\n", pa.getSeatPA());
                    break; 
                
                default: 
                    return; 
            }
        }
    }

    

     public static void main(String[] args) throws Exception {
    //     PublicHolidayList phl = new PublicHolidayList(); 
    //    CreatePublicHoliday(phl);
    //    int size = phl.getList().size();
    //    System.out.println(size); 
    //    Scanner sc = new Scanner(System.in);
    //    System.out.println("enter date to compare in dd-MMM-YYYY"); 
    //    String date = sc.nextLine(); 
    //    GregorianCalendar gcdate = stringToDate(date);


    //    for(int i=0; i<size; i++){ 
    //     System.out.println(i); 
    //     GregorianCalendar PHdate = phl.getList().get(i); 
    //     System.out.println(PHdate); 
    //     System.out.println("---------------------------"); 
    //     if(gcdate.get(GregorianCalendar.DAY_OF_MONTH) == PHdate.get(GregorianCalendar.DAY_OF_MONTH) && gcdate.get(GregorianCalendar.MONTH) == PHdate.get(GregorianCalendar.MONTH) ){ 
    //         System.out.println("IS SAME"); 
    //     } 

    
        
     } 




      


    
      
    // }

} 

