package Main;
import Model.*;
import Controller.*;
import Data.*;
import View.*;
import java.util.*;

public class MainApp {
    public static void main(String[] args) throws Exception{
        Header.printMobalima();

        AdminAccounts adminDb = SerializeDB.readAdminAccounts("Data/AdminAccounts.txt");
        UserAccounts userDb = SerializeDB.readUserAccounts("Data/UserAccounts.txt");
        CineplexList cList = SerializeDB.readCineplexList("Data/CineplexList.txt");
        MovieList mList = SerializeDB.readMovieList("Data/MovieList.txt");
        mList.checkEndDate();
        Top5List t5List = SerializeDB.readTop5List("Data/Top5List.txt");
        BookingList bList = SerializeDB.readBookingList("Data/BookingList.txt");
        PublicHolidayList pList = SerializeDB.readPublicHolidayList("Data/PublicHolidayList.txt");
        TicketPrice ticketPrice = SerializeDB.readTicketPrice("Data/TicketPrice.txt");

        Scanner sc = new Scanner(System.in);
        User user = null;
        Admin admin = null;
        String id, pwd, input;
        
        while(user == null && admin == null){
            MenuDisplay.printLogin();
            System.out.print("Enter selection: ");
            input = sc.nextLine();
            switch(input){
                case "1": 
                    System.out.println("Enter user ID: ");
                    id = sc.nextLine();
                    System.out.println("Enter user password: ");
                    pwd = sc.nextLine();
                    if (!userDb.isUser(id))
                        System.out.println("Account not found!");
                    else if (!userDb.validateUser(id, pwd))
                        System.out.println("Wrong password!");
                    else{
                        System.out.println("Login success!");
                        user = userDb.getUser(id);
                    }
                    break;
                case "2": 
                    System.out.println("Enter Admin ID: ");
                    id = sc.nextLine();
                    System.out.println("Enter Admin password: ");
                    pwd = sc.nextLine();
                    if (!adminDb.isAdmin(id))
                        System.out.println("Account not found!");
                    else if (!adminDb.validateAdmin(id, pwd))
                        System.out.println("Wrong password!");
                    else{
                        System.out.println("Login success!");
                        admin = new Admin();
                        admin.setAdminId(id);
                    }
                    break;
                default:
                    System.exit(0);
            }
        }

        if (user!=null){
            MenuDisplay.printUserMenu();
            System.out.print("Enter selection: ");
            input = sc.nextLine();
            while(true){
                if (input.equals("1"))
                    MovieDisplayManager.displayMovieList(mList);
                else if (input.equals("2")){
                    t5List.sortList(mList);
                    MovieDisplayManager.displayTop5List(t5List);
                }
                else if (input.equals("3"))
                    MovieDisplayManager.displayMovieDetails(mList);
                else if (input.equals("4"))
                    ReviewManager.addReview(user, mList);
                else if (input.equals("5"))
                    BookingManager.makeBooking(cList, mList, bList, pList, user);
                else if (input.equals("6"))
                    BookingManager.printBookingHist(bList, user);
                else
                    break;
                MenuDisplay.printUserMenu();
                System.out.print("Enter selection: ");
                input = sc.nextLine(); 
            }
        }

        if (admin!=null){
            MenuDisplay.printAdminMenu();
            System.out.print("Enter selection: ");
            input = sc.nextLine();
            while(true){
                if (input.equals("1"))
                    MovieListingManager.createMovieListing(mList);
                else if (input.equals("2"))
                    MovieListingManager.updateMovieListing(mList);
                else if (input.equals("3"))
                    MovieListingManager.removeMovieListing(mList);
                else if (input.equals("4"))
                    ShowTimeManager.createShowTime(cList, mList);
                else if (input.equals("5"))
                    ShowTimeManager.updateShowTime(cList, mList);
                else if (input.equals("6"))
                    ShowTimeManager.removeShowTime(mList);
                else if (input.equals("7"))
                    SystemManager.ChangePriceAdjustment(ticketPrice);
                else if (input.equals("8"))
                    SystemManager.CreatePublicHoliday(pList);
                else if (input.equals("9"))
                    MovieListingManager.sortTop5List(t5List);
                else
                    break;
                MenuDisplay.printAdminMenu();
                System.out.print("Enter selection: ");
                input = sc.nextLine(); 
            }
        }

        SerializeDB.writeSerializedObject("Data/AdminAccounts.txt", adminDb);
        SerializeDB.writeSerializedObject("Data/UserAccounts.txt", userDb);
        SerializeDB.writeSerializedObject("Data/CineplexList.txt", cList);
        SerializeDB.writeSerializedObject("Data/MovieList.txt", mList);
        SerializeDB.writeSerializedObject("Data/Top5List.txt", t5List);
        SerializeDB.writeSerializedObject("Data/BookingList.txt", bList);
        SerializeDB.writeSerializedObject("Data/PublicHolidayList.txt", pList);
        SerializeDB.writeSerializedObject("Data/TicketPrice.txt", ticketPrice);

        System.out.printf("\n");
        System.out.println("Thank you for using MOBLIMA!"); 
        sc.close();
    }
}
