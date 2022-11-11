package Controller;
import Model.*;
import Helper.*;
import java.util.*;
import java.util.regex.*;

public class ShowTimeManager{ // Contains static methods to add/edit/remove Show Times 
    public static void createShowTime(CineplexList cList, MovieList mList){
        Scanner sc = new Scanner(System.in);

        CinemaMovie cinemaMovie = mList.searchMovie();
        if (cinemaMovie==null)
            return;
        ShowTime showTime = new ShowTime();
        System.out.println("Enter date (format: dd-mmm-yyyy):");
        String input = sc.nextLine();
        if (!Format.isValidDateFormat(input))
            return;
        showTime.setDate(input);
        System.out.println("Enter start time (format: hhmm):");
        input = sc.nextLine();
        if (!Format.isValidTimeFormat(input))
            return;
        showTime.setStartTime(input);
        System.out.println("Enter end time (format: hhmm):");
        input = sc.nextLine();
        if (!Format.isValidTimeFormat(input))
            return;
        showTime.setEndTime(input);

        System.out.println("Enter cineplex name to create show time for: ");
        input = sc.nextLine();
        Cineplex cineplex = cList.searchCineplex(input);
        if (cineplex==null)
            return;
        showTime.setCineplexName(cineplex.getName());
        System.out.println("Enter cinema code (Regular cinemas: R0, R1, R2; Platinum cinema: P3): ");
        input = sc.nextLine();
        Cinema cinema = cineplex.searchCinema(input);
        if (cinema==null)
            return;
        showTime.setCinemaCode(cinema.getCode());

        if(!cinemaMovie.isValidShowTime(showTime))
            return;

        cinemaMovie.setShowTimes(showTime);
        System.out.println("New showtime created!");
    }

    public static void updateShowTime(CineplexList cList, MovieList mList){
        Scanner sc = new Scanner(System.in);

        CinemaMovie cinemaMovie = mList.searchMovie();
        if (cinemaMovie==null)
            return;
        ShowTime showTime = cinemaMovie.searchShowTime();
        if (showTime==null)
            return;
        int choice;
        System.out.println("Select attribute to update: ");
        System.out.println("1: Update cineplex name");
        System.out.println("2: Update cinema code");
        System.out.println("3: Update date");
        System.out.println("4: Update start & end time");
            
        choice = sc.nextInt();
        String input = sc.nextLine();

        if (choice==1){
            System.out.println("Enter new cineplex name: ");
            input = sc.nextLine();
            Cineplex cineplex = cList.searchCineplex(input); // Search for Cineplex in database with given Cineplex name as input
            if (cineplex==null)
                return;

            ShowTime temp = new ShowTime();  // Create new ShowTime obj to check if new show time will clash with show times in database              
            temp.setCinemaCode(showTime.getCinemaCode());
            temp.setCineplexName(input);
            temp.setDate(showTime.getDate());
            temp.setStartTime(showTime.getStartTime());
            temp.setEndTime(showTime.getEndTime());
            if(!cinemaMovie.isValidShowTime(temp))
                return;

            showTime.setCineplexName(cineplex.getName());  // This ensures that only Cineplex names stored in database can be assigned as new name
            System.out.println("Cineplex name updated!");
        }
        else if (choice==2){
            System.out.println("Enter new cinema code (Regular cinemas: R0, R1, R2; Platinum cinema: P3): ");
            input = sc.nextLine();
            Cineplex cineplex = cList.searchCineplex(input); //get Cineplex name of current showTime, and use it to search for corresponding Cineplex object
            if (cineplex==null)
                return; 
            Cinema cinema = cineplex.searchCinema(cineplex.getName());  // Search for Cinema code in current Cineplex with given input code 
            if (cinema==null){
                return;
            }

            ShowTime temp = new ShowTime();  // Create new ShowTime obj to check if new show time will clash with show times in database              
            temp.setCinemaCode(input);
            temp.setCineplexName(showTime.getCineplexName());
            temp.setDate(showTime.getDate());
            temp.setStartTime(showTime.getStartTime());
            temp.setEndTime(showTime.getEndTime());
            if(!cinemaMovie.isValidShowTime(temp))
                return;

            showTime.setCinemaCode(cinema.getCode());   // This ensures that only Cinema codes stored in database can be assigned as new code
            System.out.println("Cinema code updated!");
        }
        else if (choice==3){
            System.out.println("Enter new date (format: dd-mmm-yyyy): ");
            input = sc.nextLine();

            if (!Format.isValidDateFormat(input))
                return;
            
            ShowTime temp = new ShowTime();  // Create new ShowTime obj to check if new show time will clash with show times in database              
            temp.setCinemaCode(showTime.getCinemaCode());
            temp.setCineplexName(showTime.getCineplexName());
            temp.setDate(input);
            temp.setStartTime(showTime.getStartTime());
            temp.setEndTime(showTime.getEndTime());
            if(!cinemaMovie.isValidShowTime(temp))
                return;

            showTime.setDate(input);
            System.out.println("Date updated!");
        }
        else if (choice==4){
            System.out.println("Enter new start time (format: hhmm):");
            String start = sc.nextLine();
            if (!Format.isValidTimeFormat(start))
                return;

            System.out.println("Enter new end time (format: hhmm):");
            String end = sc.nextLine();
            if (!Format.isValidTimeFormat(end))
                return;

            ShowTime temp = new ShowTime();  // Create new ShowTime obj to check if new show time will clash with show times in database               
            temp.setCinemaCode(showTime.getCinemaCode());
            temp.setCineplexName(showTime.getCineplexName());
            temp.setDate(showTime.getDate());
            temp.setStartTime(start);
            temp.setEndTime(end);
            if(!cinemaMovie.isValidShowTime(temp))
                return;

            showTime.setStartTime(start);
            showTime.setEndTime(end);
            System.out.println("Start & end time updated!");
        }
    }

    public static void removeShowTime(MovieList mList){
        Scanner sc = new Scanner(System.in);

        CinemaMovie cinemaMovie = mList.searchMovie();
        if (cinemaMovie==null)
            return;
            
        ShowTime showTime = cinemaMovie.searchShowTime();
        if (showTime==null)
            return;

        cinemaMovie.getShowTimes().remove(showTime);
        System.out.println("Show time has been removed from database!");
    }

    
    
}

