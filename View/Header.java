package View;

public class Header {
    public static void printMobalima(){
        System.out.println("███╗░░░███╗░█████╗░██████╗░░█████╗░██╗░░░░░██╗███╗░░░███╗░█████╗░");
        System.out.println("████╗░████║██╔══██╗██╔══██╗██╔══██╗██║░░░░░██║████╗░████║██╔══██╗");
        System.out.println("██╔████╔██║██║░░██║██████╦╝███████║██║░░░░░██║██╔████╔██║███████║");
        System.out.println("██║╚██╔╝██║██║░░██║██╔══██╗██╔══██║██║░░░░░██║██║╚██╔╝██║██╔══██║");
        System.out.println("██║░╚═╝░██║╚█████╔╝██████╦╝██║░░██║███████╗██║██║░╚═╝░██║██║░░██║");
        System.out.println("╚═╝░░░░░╚═╝░╚════╝░╚═════╝░╚═╝░░╚═╝╚══════╝╚═╝╚═╝░░░░░╚═╝╚═╝░░╚═╝");
        System.out.printf("\n");
        System.out.println("Welcome to MOvie Booking and Listing Management Application (MOBALIMA)!");
        System.out.printf("\n");
    }

    public static void printLogin(){
        System.out.println("     __                _     ");
        System.out.println("    / /   ____  ____ _(_)___ ");
        System.out.println("   / /   / __ \\/ __ `/ / __ \\");
        System.out.println("  / /___/ /_/ / /_/ / / / / /");
        System.out.println(" /_____/\\____/\\__, /_/_/ /_/ ");
        System.out.println("             /____/          ");
        System.out.printf("\n");
    }

    public static void printAdminMenu(){

        System.out.println("    ___       __          _          __  ___                ");
        System.out.println("   /   | ____/ /___ ___  (_)___     /  |/  /__  ____  __  __");
        System.out.println("  / /| |/ __  / __ `__ \\/ / __ \\   / /|_/ / _ \\/ __ \\/ / / /");
        System.out.println(" / ___ / /_/ / / / / / / / / / /  / /  / /  __/ / / / /_/ / ");
        System.out.println("/_/  |_\\__,_/_/ /_/ /_/_/_/ /_/  /_/  /_/\\___/_/ /_/\\__,_/  ");
                                                                 
             
    }

    public static void printUserMenu(){

        System.out.println("   __  __                  __  ___                ");
        System.out.println("  / / / /_______  _____   /  |/  /__  ____  __  __");
        System.out.println(" / / / / ___/ _ \\/ ___/  / /|_/ / _ \\/ __ \\/ / / /");
        System.out.println("/ /_/ (__  )  __/ /     / /  / /  __/ / / / /_/ / ");
        System.out.println("\\____/____/\\___/_/     /_/  /_/\\___/_/ /_/\\__,_/  ");
                                                        
      
    }



    public static void main(String[] args){
        printMobalima();
        //printLogin();
        //System.out.printf("Login\n");
        MenuDisplay.printLogin();
    }
}
