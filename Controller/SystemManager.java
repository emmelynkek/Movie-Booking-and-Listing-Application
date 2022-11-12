package Controller;
import Model.*;
import View.*;
import Helper.Format;
import java.text.*;
import java.util.*;


/**
  A manager class to help admin to create public holidays and change price adjustment
  @author  Emmelyn Kek 
  @version 1.0
  @since   2022-10-11
 */

public class SystemManager{

    /**
     * Convert date in string format dd-MMM-YYYY to date in Gregorian Calender format
     * @param sdate
     * @return
     * @throws ParseException
     */
    public static GregorianCalendar stringToDate(String sdate) throws ParseException{ //convert input string to gregoriancalender date format
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = df.parse(sdate);
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal;

    }

    /**
     * Creates public holiday
     * @param publicHolidayList Public Holiday list that stores all the public holidays
     * @throws ParseException On input error 
     */
    public static void CreatePublicHoliday(PublicHolidayList publicHolidayList) throws ParseException{ //admin can create public holiday
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Public Holiday:");
        String name = sc.nextLine(); 
        System.out.println("Enter the date in format DD-MMM-YYYY:");
        String date = sc.nextLine();
        if (!Format.isValidDateFormat(date))
            return;
        GregorianCalendar date1 = stringToDate(date); 

        PublicHoliday ph = new PublicHoliday(name, date1);
        publicHolidayList.addPublicHoliday(ph); 
    }

   
    /**
     * Allows user to change base price and price adjustment 
     * @param pa Price Adjustment object to be changed
     */
    public static void ChangePriceAdjustment(TicketPrice pa){ //admin can change base price and discounts

        Scanner sc = new Scanner(System.in);
        while(true){ 
            MenuDisplay.printPriceAdjustmentMenu();
            int choice; 
            choice = sc.nextInt();
            String buffer = sc.nextLine();
          
            switch(choice){ 
                case 1: 
                    double bp; 
                    Exception exception; 
                    do {
                        exception = null;
                
                        System.out.println("Enter the base price value: ");
                        try {
                            bp = sc.nextDouble();
                            pa.setBasePrice(bp);
                        } catch (InputMismatchException e) {
                            System.out.println("Error! Please input a number value!");
                            sc.next();
                            exception = e;
                        }
                    } while (exception != null);
                 
                    
                    System.out.println("Base price updated!");
                    break; 

                case 2: 
                    double spa; 
                    Exception exception1; 
                    do {
                        exception1 = null;
                        /* Get the vallue */ 
                        System.out.println("Enter the student discount: ");
                        try {
                            spa = sc.nextDouble();
                            pa.setStudentPA(spa);
                        } catch (InputMismatchException e) {
                            System.out.println("Error! Please input a number value!");
                            sc.next();
                            exception1 = e;
                        }
                    } while (exception1 != null);
               

                    System.out.println("Student price updated!");
                    break; 

                case 3: 
                    double epa; 
                    Exception exception2; 
                    do {
                        exception2 = null;
                        /* Get the vallue */ 
                        System.out.println("Enter the senior citizen discount: ");
                        try {
                            epa = sc.nextDouble();
                            pa.setElderlyPA(epa);;
                        } catch (InputMismatchException e) {
                            System.out.println("Error! Please input a number value!");
                            sc.next();
                            exception2 = e;
                        }
                    } while (exception2 != null);


                    System.out.println("Senior citizen discount updated!");
                    break; 


                case 4: 
                    double wdpa; 
                    Exception exception3; 
                    do {
                        exception3 = null;
                        /* Get the vallue */ 
                        System.out.println("Enter Mon/Tue/Wed discount: ");
                        try {
                            wdpa = sc.nextDouble();
                            pa.setWeekdayPA(wdpa);
                        } catch (InputMismatchException e) {
                            System.out.println("Error! Please input a number value!");
                            sc.next();
                            exception3 = e;
                        }
                    } while (exception3 != null);
                   

                    System.out.println("Mon/Tue/Wed discount updated!");
                    break; 
           
            
                case 5: 
                    double wpa; 
                    Exception exception4; 
                    do {
                        exception4 = null;
                        /* Get the vallue */ 
                        System.out.println("Enter weekend surcharge: ");
                        try {
                            wpa = sc.nextDouble();
                            pa.setWeekendPA(wpa);
                        } catch (InputMismatchException e) {
                            System.out.println("Error! Please input a number value!");
                            sc.next();
                            exception4 = e;
                        }
                    } while (exception4 != null);
                   
                    System.out.println("Weekend surcharge updated!");
                    break; 
           

                case 6: 
                    double phpa; 
                    Exception exception5; 
                    do {
                        exception5 = null;
                        /* Get the vallue */ 
                        System.out.println("Enter public holiday surcharge: ");
                        try {
                            phpa = sc.nextDouble();
                            pa.setPubHolPA(phpa);
                        } catch (InputMismatchException e) {
                            System.out.println("Error! Please input a number value!");
                            sc.next();
                            exception5= e;
                        }
                    } while (exception5 != null);
                  

                    System.out.println("Public holiday surcharge updated!");
                    break; 

                case 7: 
                    double tdpa; 
                    Exception exception6; 
                    do {
                        exception6 = null;
                        /* Get the vallue */ 
                        System.out.println("Enter 3D movie surcharge: ");
                        try {
                            tdpa = sc.nextDouble();
                            pa.set3DPA(tdpa);
                        } catch (InputMismatchException e) {
                            System.out.println("Error! Please input a number value!");
                            sc.next();
                            exception6= e;
                        }
                    } while (exception6 != null);
        

                    System.out.println("3D movie surcharge updated!");
                    break; 
                case 8: 
                    double bbpa; 
                    Exception exception7; 
                    do {
                        exception7 = null;
                        /* Get the vallue */ 
                        System.out.println("Enter blockbuster movie surcharge: ");
                        try {
                            bbpa = sc.nextDouble();
                            pa.setBlockbusterPA(bbpa);
                        } catch (InputMismatchException e) {
                            System.out.println("Error! Please input a number value!");
                            sc.next();
                            exception7= e;
                        }
                    } while (exception7 != null);
            

                    System.out.println("Blockbuster movie surcharge updated!");
                    break;

                case 9: 
                    double ctpa; 
                    Exception exception8; 
                    do {
                        exception8 = null;
                        /* Get the vallue */ 
                        System.out.println("Enter plainum suite surcharge: ");
                        try {
                            ctpa = sc.nextDouble();
                            pa.setCinemaTypePA(ctpa);
                        } catch (InputMismatchException e) {
                            System.out.println("Error! Please input a number value!");
                            sc.next();
                            exception8= e;
                        }
                    } while (exception8 != null);
               

                    System.out.println("Platinum suite surcharge updated!");
                    break;
                    
                case 10: 
                    double stpa; 
                    Exception exception9; 
                    do {
                        exception9 = null;
                        /* Get the vallue */ 
                        System.out.println("Enter premium seat surcharge: ");
                        try {
                            stpa = sc.nextDouble();
                            pa.setSeatPA(stpa);
                        } catch (InputMismatchException e) {
                            System.out.println("Error! Please input a number value!");
                            sc.next();
                            exception9= e;
                        }
                    } while (exception9 != null);
                 

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

}

