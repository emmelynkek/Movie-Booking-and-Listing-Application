package Model;

import java.util.GregorianCalendar;

import Model.Cinema.cinemaType;

import java.io.*;

public class TicketPrice implements Serializable {
    private double basePrice;
    private double studentPA;
    private double elderlyPA;
    private double weekdayPA;
    private double weekendPA;
    private double publicHolPA;
    private double threeDPA;
    private double blockbusterPA;
    private double cinemaTypePA;
    private double seatTypePA;

    public enum MovieGoerAge {
        ADULT,
        STUDENT,
        SENIOR_CITIZEN
    }

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

    public double getBasePrice() {
        return basePrice;
    }

    public double getStudentPA() {
        return studentPA;
    }

    public double getElderlyPA() {
        return elderlyPA;
    }

    public double getWeekdayPA() {
        return weekdayPA;
    }

    public double getWeekendPA() {
        return weekendPA;
    }

    public double get3DPA() {
        return threeDPA;
    }

    public double getBlockbusterPA() {
        return blockbusterPA;
    }

    public double getCinemaTypePA() {
        return cinemaTypePA;
    }

    public double getPubHolPA() {
        return publicHolPA;
    }

    public double getSeatPA() {
        return seatTypePA;
    }

    public void setBasePrice(double bp) {
        this.basePrice = bp;
    }

    public void setStudentPA(double spa) {
        this.studentPA = spa;
    }

    public void setElderlyPA(double epa) {
        this.elderlyPA = epa;
    }

    public void setWeekdayPA(double wdpa) {
        this.weekdayPA = wdpa;
    }

    public void setWeekendPA(double wpa) {
        this.weekendPA = wpa;
    }

    public void set3DPA(double tdpa) {
        this.threeDPA = tdpa;
    }

    public void setBlockbusterPA(double bbpa) {

        this.blockbusterPA = bbpa;
    }

    public void setCinemaTypePA(double ctpa) {
        this.cinemaTypePA = ctpa;
    }

    public void setPubHolPA(double phpa) {
        this.publicHolPA = phpa;
    }

    public void setSeatPA(double stpa) {
        this.seatTypePA = stpa;
    }

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
