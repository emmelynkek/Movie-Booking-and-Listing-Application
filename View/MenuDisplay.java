package View;

/**
 * Represents the user interface for all the menus used in our application.
 * @author Evonne Ng
 * @version 1.0
 * @since 2022-11-11
 */
public class MenuDisplay {

    /**
     * Prints the menu display for the login page.
     */
    public static void printLogin() {
        System.out.printf("\n");
        System.out.println(" +-------------------------------+");
        System.out.println(" | Press 1 for Movie-goer Login  |");
        System.out.println(" |                               |");
        System.out.println(" | Press 2 for Admin Login       |");
        System.out.println(" |                               |");
        System.out.println(" | Press any key to Exit         |");
        System.out.println(" +-------------------------------+");
        System.out.printf("\n");
    }

    /**
     * Prints the menu display for users after they log in into the application.
     */
    public static void printUserMenu() {
        System.out.printf("\n");
        System.out.println("+------------------------------------------+");
        System.out.println("| Press 1 to view Movie List               |");
        System.out.println("|                                          |");
        System.out.println("| Press 2 to view Top 5 Ranking Movie List |");
        System.out.println("|                                          |");
        System.out.println("| Press 3 to view Movie details            |");
        System.out.println("|                                          |");
        System.out.println("| Press 4 to add Movie review              |");
        System.out.println("|                                          |");
        System.out.println("| Press 5 to book and purchase ticket      |");
        System.out.println("|                                          |");
        System.out.println("| Press 6 to view booking history          |");
        System.out.println("|                                          |");
        System.out.println("| Press 7 to Exit                          |");
        System.out.println("+------------------------------------------+");
        System.out.printf("\n");
    }

    /**
     * Prints the menu display for admin after they log in into the application.
     */
    public static void printAdminMenu() {
        System.out.printf("\n");
        System.out.println("+-----------------------------------------+");
        System.out.println("| Press 1 to add new Movie                |");
        System.out.println("|                                         |");
        System.out.println("| Press 2 to update Movie details         |");
        System.out.println("|                                         |");
        System.out.println("| Press 3 to remove Movie                 |");
        System.out.println("|                                         |");
        System.out.println("| Press 4 to add new Movie showtime       |");
        System.out.println("|                                         |");
        System.out.println("| Press 5 to update Movie showtime        |");
        System.out.println("|                                         |");
        System.out.println("| Press 6 to remove Movie showtime        |");
        System.out.println("|                                         |");
        System.out.println("| Press 7 to change or view ticket prices |");
        System.out.println("|                                         |");
        System.out.println("| Press 8 to add public holidays          |");
        System.out.println("|                                         |");
        System.out.println("| Press 9 to change Top 5 List sorting    |");
        System.out.println("|                                         |");
        System.out.println("| Press 0 to Exit                         |");
        System.out.println("+-----------------------------------------+");
        System.out.printf("\n");
    }

    /**
     * Prints the menu display for users to select their age category.
     */
    public static void printAgeMenu() {
        System.out.printf("\n");
        System.out.println("Please select the movie-goer's age category: ");
        System.out.println("+-------------------+");
        System.out.println("| 1. Adult          |");
        System.out.println("|                   |");
        System.out.println("| 2. Student        |");
        System.out.println("|                   |");
        System.out.println("| 3. Senior Citizen |");
        System.out.println("+-------------------+");
        System.out.printf("\n");
    }

    /**
     * Prints the menu display to let admin configure how the top 5 movie list is sorted.
     */
    public static void printSortMenu() {
        System.out.printf("\n");
        System.out.println("+------------------------------+");
        System.out.println("| Sort Top 5 List by:          |");
        System.out.println("|------------------------------|");
        System.out.println("| 1. Overall reviewers' rating |");
        System.out.println("|                              |");
        System.out.println("| 2. Ticket Sales              |");
        System.out.println("+------------------------------+");
        System.out.printf("\n");
    }

    /**
     * Prints the menu display to allow admin to change the price adjustments.
     */
    public static void printPriceAdjustmentMenu() {
        System.out.printf("\n");
        System.out.println("+--------------------------------------------+");
        System.out.println("| 1. Change base price                       |");
        System.out.println("|                                            |");
        System.out.println("| 2. Change student discount                 |");
        System.out.println("|                                            |");
        System.out.println("| 3. Change senior citizen discount          |");
        System.out.println("|                                            |");
        System.out.println("| 4. Change weekday discount                 |");
        System.out.println("|                                            |");
        System.out.println("| 5. Change weekend surcharge                |");
        System.out.println("|                                            |");
        System.out.println("| 6. Change public holiday surcharge         |");
        System.out.println("|                                            |");
        System.out.println("| 7. Change 3D movie surcharge               |");
        System.out.println("|                                            |");
        System.out.println("| 8. Change blockbuster movie surcharge      |");
        System.out.println("|                                            |");
        System.out.println("| 9. Change platinum suite surcharge         |");
        System.out.println("|                                            |");
        System.out.println("| 10. Change premium seat surcharge          |");
        System.out.println("|                                            |");
        System.out.println("| 11. View current price adjustments         |");
        System.out.println("|                                            |");
        System.out.println("| 12. Exit                                   |");
        System.out.println("+--------------------------------------------+");
        System.out.println("Enter the number of your choice: ");
    }

}
