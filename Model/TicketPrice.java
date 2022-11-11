package Model;
import java.util.GregorianCalendar;
import Model.Cinema.cinemaType;
import java.io.*;

/**
  Represents ticket prices and price adjustments 
  @author Emmelyn Kek 
  @version 4.0
  @since 2022-11-11
 */

public class TicketPrice implements Serializable {
    /**
     * Base price of ticket
     */
    private double basePrice;
    /**
     * Price adjustment if moviegoer is a student
     */
    private double studentPA;
    /**
     * Price adjustment if moviegoer is an elderly
     */
    private double elderlyPA;
    /**
     * Price adjustment if movie is on a weekday
     */
    private double weekdayPA;
    /**
     * Price adjustment if movie is on a weekend
     */
    private double weekendPA;
    /**
     * Price adjustment if movie is on a public holiday
     */
    private double publicHolPA;
    /**
     * Price adjustment if movie is a 3D movie
     */
    private double threeDPA;
    /**
     * Price adjustment if movie is a blockbuster movie
     */
    private double blockbusterPA;
    /**
     * Price adjustment if cinema type is platinum 
     */
    private double cinemaTypePA;
    /**
     * Price adjustment if seat type is premium 
     */
    private double seatTypePA;
    
    /**
     * Different ages of moveigoers 
     */
    public enum MovieGoerAge {
        ADULT,
        STUDENT,
        SENIOR_CITIZEN
    }
    
    /** 
     * Creates a new ticket price object with preset base price and price adjustment 
     */
    public TicketPrice() {
        this.basePrice = 9.50;
        this.studentPA = 2.50;
        this.elderlyPA = 5.50;
        this.weekdayPA = 1.00;
        this.weekendPA = 2.00;
        this.publicHolPA = 2.00;
        this.threeDPA = 2.00;
        this.blockbusterPA = 1.00;
        this.cinemaTypePA = 10.00;
        this.seatTypePA = 4.00;
    }

    /**
     * Gets base price of seat
     * @return Base price of seat
     */
    public double getBasePrice() {
        return basePrice;
    }
    /**
     * Gets price adjustment for students
     * @return Student price adjustment
     */
    public double getStudentPA() {
        return studentPA;
    }
    /**
     * Gets price adjustment for elderly
     * @return Elderly price adjustment
     */
    public double getElderlyPA() {
        return elderlyPA;
    }
    /**
     * Gets price adjustment for weekdays
     * @return Weekday price adjustment
     */
    public double getWeekdayPA() {
        return weekdayPA;
    }
    /**
     * Gets price adjustment for weekends
     * @return Weekend price adjustment
     */
    public double getWeekendPA() {
        return weekendPA;
    }
    /**
     * Gets price adjustment for 3D movies
     * @return 3D movie price adjustment
     */
    public double get3DPA() {
        return threeDPA;
    }
    /**
     * Gets price adjustment for blockbuster movies
     * @return Blockbuster movie price adjustment
     */
    public double getBlockbusterPA() {
        return blockbusterPA;
    }
    /**
     * Gets price adjustment for platinum cinema type 
     * @return Platinum cinema type price adjustment
     */
    public double getCinemaTypePA() {
        return cinemaTypePA;
    }
    /**
     * Gets price adjustment for public holiday 
     * @return Public holiday price adjustment
     */
    public double getPubHolPA() {
        return publicHolPA;
    }
    /**
     * Gets price adjustment for premium seats 
     * @return Premium seats price adjustment
     */
    public double getSeatPA() {
        return seatTypePA;
    }
    /**
     * Changes base price of tickets
     * @param bp Base price of tickets 
     */
    public void setBasePrice(double bp) {
        this.basePrice = bp;
    }
    /**
     * Changes price adjustments for students 
     * @param spa Student price adjustment
     */
    public void setStudentPA(double spa) {
        this.studentPA = spa;
    }
    /**
     * Changes price adjustments for the elderly 
     * @param epa Elderly price adjustment
     */
    public void setElderlyPA(double epa) {
        this.elderlyPA = epa;
    }
    /**
     * Changes price adjustments for weekdays 
     * @param wdpa Weekday price adjustment
     */
    public void setWeekdayPA(double wdpa) {
        this.weekdayPA = wdpa;
    }
    /**
     * Changes price adjustments for weekends 
     * @param wpa Weekend price adjustment
     */
    public void setWeekendPA(double wpa) {
        this.weekendPA = wpa;
    }
    /**
     * Changes price adjustments for 3D movies 
     * @param tdpa 3D movie price adjustment
     */
    public void set3DPA(double tdpa) {
        this.threeDPA = tdpa;
    }
    /**
     * Changes price adjustments for blockbuster movies 
     * @param bbpa Blockbuster movie price adjustment
     */
    public void setBlockbusterPA(double bbpa) {

        this.blockbusterPA = bbpa;
    }
    /**
     * Changes price adjustments for platinum type cinemas 
     * @param ctpa Platinum cinema price adjustment
     */
    public void setCinemaTypePA(double ctpa) {
        this.cinemaTypePA = ctpa;
    }
    /**
     * Changes price adjustments for public holidays 
     * @param phpa Public holiday price adjustment
     */
    public void setPubHolPA(double phpa) {
        this.publicHolPA = phpa;
    }
    /**
     * Changes price adjustments for premium seats 
     * @param stpa Premium seats price adjustment
     */
    public void setSeatPA(double stpa) {
        this.seatTypePA = stpa;
    }

    /**
     * Gets adjusted price base on age, cinema type, date, movie type, public holiday and seat type
     * @param age Age of moviegoer
     * @param cinema Type of cinema
     * @param date Date of movie
     * @param movie Movie
     * @param phl Public Holiday List
     * @param seatRow The row the chosen seat is located at 
     * @return Final adjusted price of ticket
     */
    public double getAdjustedPrice(MovieGoerAge age, Cinema cinema, GregorianCalendar date, CinemaMovie movie,
            PublicHolidayList phl, int seatRow) {
        double priceAdjustment = 0;
        System.out.println("Detailed price breakdown:");
        System.out.printf("Base ticket price: $%.2f\n", this.basePrice);
        if (movie.getType() == CinemaMovie.Type.THREE_D) {
            priceAdjustment += threeDPA;
            System.out.printf("3D movie surcharge: +$%.2f\n", this.threeDPA);
        } else if (movie.getType() == CinemaMovie.Type.BLOCKBUSTER) {
            priceAdjustment += blockbusterPA;
            System.out.printf("Blockbuster movie surcharge: +$%.2f\n", this.blockbusterPA);
        }
        if (cinema.getCinemaType() == Cinema.cinemaType.PLATINUM) {
            priceAdjustment += cinemaTypePA;
            System.out.printf("Platinum movie suites surcharge: +$%.2f\n", this.cinemaTypePA);
        }
        if (seatRow == 7 || seatRow == 8) {
            priceAdjustment += seatTypePA;
            System.out.printf("Premium seat surcharge: +$%.2f\n", this.seatTypePA);
        }
        int size = phl.getList().size();
        int flag = 0;
        for (int i = 0; i < size; i++) {
            GregorianCalendar PHdate = phl.getList().get(i);

            if (date.get(GregorianCalendar.DAY_OF_MONTH) == PHdate.get(GregorianCalendar.DAY_OF_MONTH)
                    && date.get(GregorianCalendar.MONTH) == PHdate.get(GregorianCalendar.MONTH)) {
                priceAdjustment += this.publicHolPA;
                flag = 1;
                System.out.printf("Public Holiday surcharge: +$%.2f\n", this.publicHolPA);
                break;
            }
        }
        // student and seniors citizen discounts not applicable on public holidays and
        // weekends
        if (flag == 0) {
            if (date.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SATURDAY
                    || date.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SUNDAY) {
                priceAdjustment += weekendPA;
                System.out.printf("Weekend surcharge: +$%.2f\n", this.weekendPA);
            } else {
                if (age == MovieGoerAge.STUDENT) {
                    priceAdjustment -= studentPA;
                    System.out.printf("Student discount: -$%.2f\n", this.studentPA);
                } else if (age == MovieGoerAge.SENIOR_CITIZEN) {
                    priceAdjustment -= elderlyPA;
                    System.out.printf("Senior Citizen discount: -$%.2f\n", this.elderlyPA);
                } // weekday discount is only applied for adult tickets
                else {
                    if (date.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.MONDAY
                            || date.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.TUESDAY
                            || date.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.WEDNESDAY) {

                        priceAdjustment -= weekdayPA;
                        System.out.printf("Mon/Tue/Wed discount: -$%.2f\n", this.weekdayPA);
                    }
                }
            }
        }
        double finalp = this.basePrice + priceAdjustment;
        System.out.printf("Final ticket price: $%.2f\n\n", finalp);
        return finalp;
    }
}
