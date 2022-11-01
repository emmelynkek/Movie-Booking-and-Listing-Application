import java.util.GregorianCalendar;

enum MovieGoerAge {
    ADULT,
    STUDENT,
    SENIOR_CITIZEN
}

public class PriceAdjustment {
    public PriceAdjustment() {

    }

    public double getAdjustedPrice(MovieGoerAge age, Cinema cinema, GregorianCalendar date, CinemaMovie movie) {
        double priceAdjustment = 0;
        // assuming that the original price for Adults is $9
        if
        else if (age == MovieGoerAge.STUDENT) {
            priceAdjustment -= 2;
        } else if (age == MovieGoerAge.SENIOR_CITIZEN) {
            priceAdjustment -= 5;
        } else {
            if (date.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.MONDAY
                    || date.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.TUESDAY
                    || date.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.WEDNESDAY) {
                priceAdjustment -= 0.5;
                if (movie.getType() == CinemaMovie.Type.THREE_D) {
                    priceAdjustment += 2;
                }
            } else if (date.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.FRIDAY
                    || date.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SATURDAY
                    || date.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SUNDAY) {
                priceAdjustment += 2;
                if (movie.getType() == CinemaMovie.Type.THREE_D) {
                    priceAdjustment += 4;
                }
            }
            if (movie.getType() == CinemaMovie.Type.BLOCKBUSTER) {
                priceAdjustment += 1;
            }
        }
        if (cinema.getCinemaType() == Cinema.cinemaType.PLATINUM) {
            priceAdjustment += 10;
        }
        return priceAdjustment;
    }
}
