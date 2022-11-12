package Controller;
import Model.*;
import Helper.*;
import java.util.*;
import java.util.regex.*;

/**
  Contains static methods for Admin to add/edit/remove Show Times. 
  @author Julian Wong
  @version 1.0
  @since 2022-11-12
*/
public class ShowTimeManager{
    
    /**
     * Method for Admin to add a new Show Time to a Cinema Movie.
     * @param cList This is the list of all available cineplexes.
     * @param mList This is the list of all available cinema movies.
     */
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
    
    /**
     * Method for Admin to update the attributes of a Show Time for a Cinema Movie.
     * Admin can update cineplex name, cinema code, date and start & end time.
     * After getting user input, this method will create a new ShowTime obj and invoke isValidShowTime() to perform validation.
     * @param cList This is the list of all available cineplexes.
     * @param mList This is the list of all available cinema movies.
     */
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
            Cineplex cineplex = cList.searchCineplex(input); 
            if (cineplex==null)
                return;

            ShowTime temp = new ShowTime();           
            temp.setCinemaCode(showTime.getCinemaCode());
            temp.setCineplexName(input);
            temp.setDate(showTime.getDate());
            temp.setStartTime(showTime.getStartTime());
            temp.setEndTime(showTime.getEndTime());
            if(!cinemaMovie.isValidShowTime(temp))
                return;

            showTime.setCineplexName(cineplex.getName());  
            System.out.println("Cineplex name updated!");
        }
        else if (choice==2){
            System.out.println("Enter new cinema code (Regular cinemas: R0, R1, R2; Platinum cinema: P3): ");
            input = sc.nextLine();
            Cineplex cineplex = cList.searchCineplex(showTime.getCineplexName()); 
            Cinema cinema = cineplex.searchCinema(input);  
            if (cinema==null){
                return;
            }

            ShowTime temp = new ShowTime();        
            temp.setCinemaCode(input);
            temp.setCineplexName(showTime.getCineplexName());
            temp.setDate(showTime.getDate());
            temp.setStartTime(showTime.getStartTime());
            temp.setEndTime(showTime.getEndTime());
            if(!cinemaMovie.isValidShowTime(temp))
                return;

            showTime.setCinemaCode(cinema.getCode());   
            System.out.println("Cinema code updated!");
        }
        else if (choice==3){
            System.out.println("Enter new date (format: dd-mmm-yyyy): ");
            input = sc.nextLine();

            if (!Format.isValidDateFormat(input))
                return;
            
            ShowTime temp = new ShowTime();        
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

            ShowTime temp = new ShowTime();           
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
    
    /**
     * Method for Admin to remove a Show Time of a Cinema Movie.
     * @param mList This is the list of all available cinema movies.
     */
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

