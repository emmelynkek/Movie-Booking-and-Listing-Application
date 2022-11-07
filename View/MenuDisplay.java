package View;

public class MenuDisplay {
    public static void printLogin(){
        System.out.printf("\n");
        System.out.println(" +-------------------------+");
        System.out.println(" | Press 1 for User Login  |");                                            
        System.out.println(" |                         |");                                             
        System.out.println(" | Press 2 for Admin Login |");                                             
        System.out.println(" |                         |");                                             
        System.out.println(" | Press any key to Exit   |");                                             
        System.out.println(" +-------------------------+");
        System.out.printf("\n");
    }

    public static void printUserMenu(){
        System.out.printf("\n");
        System.out.println("Press 1 to view Movie List");
        System.out.println("Press 2 to view Top 5 Ranking Movie List");
        System.out.println("Press 3 to view Movie details");
        System.out.println("Press 4 to add Movie review");
        System.out.println("Press 5 to book and purchase ticket");
        System.out.println("Press 6 to view booking history");
        System.out.println("Press 7 to Exit");
        System.out.printf("\n");
    }

    public static void printAdminMenu(){
        System.out.printf("\n");
        System.out.println("Press 1 to add new Movie");
        System.out.println("Press 2 to update Movie details");
        System.out.println("Press 3 to remove Movie");
        System.out.println("Press 4 to add new Movie showtime");
        System.out.println("Press 5 to update Movie showtime");
        System.out.println("Press 6 to remove Movie showtime");
        System.out.println("Press 7 to change ticket prices");
        System.out.println("Press 8 to add public holidays");
        System.out.println("Press 9 to change Top 5 List sorting");
        System.out.println("Press 0 to Exit");
        System.out.printf("\n");
    }

    public static void printAgeMenu(){
        System.out.printf("\n");
        System.out.println("Please select the movie-goer's age category: ");
        System.out.println("1. Adult");
        System.out.println("2. Student (must be able to produce a valid student pass)");
        System.out.println("3. Senior Citizen (55 years old and above)");
        System.out.printf("\n");
    }

    public static void printSortMenu(){
        System.out.printf("\n");
        System.out.println("Sort Top 5 List by: ");
        System.out.println("1. Overall reviewers' rating");
        System.out.println("2. Ticket Sales");
        System.out.printf("\n");
    }

    public static void printPriceAdjustmentMenu(){
        System.out.printf("\n");
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
    }

}
