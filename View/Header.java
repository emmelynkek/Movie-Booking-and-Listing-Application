package View;

/**
  Contains static methods to print headers and breadcrumbs.
  @author Julian Wong
  @version 1.0
  @since 2022-11-12
*/
public class Header {
    
    /**
     * Method to print MOBALIMA text art and welcome banner.
     */
    public static void printMobalima(){
        
        System.out.println("███╗   ███╗ ██████╗ ██████╗ ██╗     ██╗███╗   ███╗ █████╗ ");
        System.out.println("████╗ ████║██╔═══██╗██╔══██╗██║     ██║████╗ ████║██╔══██╗");
        System.out.println("██╔████╔██║██║   ██║██████╔╝██║     ██║██╔████╔██║███████║");
        System.out.println("██║╚██╔╝██║██║   ██║██╔══██╗██║     ██║██║╚██╔╝██║██╔══██║");
        System.out.println("██║ ╚═╝ ██║╚██████╔╝██████╔╝███████╗██║██║ ╚═╝ ██║██║  ██║");
        System.out.println("╚═╝     ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝╚═╝╚═╝     ╚═╝╚═╝  ╚═╝");
                                                          
        System.out.printf("\n");
        System.out.println("Welcome to MOvie Booking and Listing Management Application (MOBLIMA)!");
        System.out.printf("\n");
    }
    
    /**
     * Method to print movie listing breadcrumbs.
     */
    public static void printMovieList(){
        System.out.printf("\n");
        System.out.println("+---------------+");                 
        System.out.println("| Movie Listing |");                  
        System.out.println("+---------------+"); 
        System.out.printf("\n");
    }
    
    /**
     * Method to print top 5 listing breadcrumbs.
     */
    public static void printTop5List(){
        System.out.printf("\n");
        System.out.println("+---------------+");                 
        System.out.println("| Top 5 Listing |");                  
        System.out.println("+---------------+"); 
        System.out.printf("\n");                                                                    
    }
    
    /**
     * Method to print movie details breadcrumbs.
     */
    public static void printMovieDetails(){
        System.out.printf("\n");
        System.out.println("+---------------+");                 
        System.out.println("| Movie Details |");                  
        System.out.println("+---------------+"); 
        System.out.printf("\n");
    }
    
    /**
     * Method to print book ticket breadcrumbs.
     */
    public static void printBookTicket(){
        System.out.printf("\n");
        System.out.println("+-------------------------+");                 
        System.out.println("| Book & Purchase Tickets |");                  
        System.out.println("+-------------------------+"); 
        System.out.printf("\n");
    }

    /**
     * Method to print booking history breadcrumbs.
     */
    public static void printBookingHistory(){
        System.out.printf("\n");
        System.out.println("+-----------------+");                 
        System.out.println("| Booking History |");                  
        System.out.println("+-----------------+"); 
        System.out.printf("\n");
    }

}
