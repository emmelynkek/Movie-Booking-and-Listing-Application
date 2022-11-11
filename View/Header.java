package View;

public class Header {
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

    public static void printMovieList(){
        System.out.printf("\n");
        System.out.println("+---------------+");                 
        System.out.println("| Movie Listing |");                  
        System.out.println("+---------------+"); 
        System.out.printf("\n");
    }

    public static void printTop5List(){
        System.out.printf("\n");
        System.out.println("+---------------+");                 
        System.out.println("| Top 5 Listing |");                  
        System.out.println("+---------------+"); 
        System.out.printf("\n");                                                                    
    }

    public static void printMovieDetails(){
        System.out.printf("\n");
        System.out.println("+---------------+");                 
        System.out.println("| Movie Details |");                  
        System.out.println("+---------------+"); 
        System.out.printf("\n");
    }

    public static void printBookTicket(){
        System.out.printf("\n");
        System.out.println("+-------------------------+");                 
        System.out.println("| Book & Purchase Tickets |");                  
        System.out.println("+-------------------------+"); 
        System.out.printf("\n");
    }

    
    public static void printBookingHistory(){
        System.out.printf("\n");
        System.out.println("+-----------------+");                 
        System.out.println("| Booking History |");                  
        System.out.println("+-----------------+"); 
        System.out.printf("\n");
    }

    public static void main(String[] args){
        printMobalima();
        //printLogin();
        //System.out.printf("Login\n");
        MenuDisplay.printLogin();
    }
}
