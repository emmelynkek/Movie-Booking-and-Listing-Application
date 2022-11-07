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
        System.out.println("Press 7 to configure System settings");
        System.out.println("Press 8 to Exit");
        System.out.printf("\n");
    }
}
