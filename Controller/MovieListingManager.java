package Controller;

import Model.*;
import View.*;
import Helper.*;
import java.util.*;

public class MovieListingManager { // Contains static methods to add/edit/remove Movie Listing (for Admin)
    public static void createMovieListing(MovieList list) {
        Movie movie = new Movie();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter movie title: ");
        String input = sc.nextLine();
        movie.setTitle(input);
        System.out.println("Enter director's name: ");
        input = sc.nextLine();
        movie.setDirectorName(input);
        System.out.println("Enter casts' name (enter 0 to stop): ");
        input = sc.nextLine();
        while (!input.equals("0")) {
            movie.setCastNames(input);
            input = sc.nextLine();
        }
        System.out.println("Enter synopsis: ");
        input = sc.nextLine();
        movie.setSynopsis(input);

        CinemaMovie cinemaMovie = new CinemaMovie();
        cinemaMovie.setMovie(movie);
        System.out.println("Select movie status: ");
        System.out.println("1: COMING_SOON");
        System.out.println("2: PREVIEW");
        System.out.println("3: NOW_SHOWING");
        int choice = sc.nextInt();
        input = sc.nextLine();
        if (choice == 1)
            cinemaMovie.setStatus(CinemaMovie.Status.COMING_SOON);
        else if (choice == 2)
            cinemaMovie.setStatus(CinemaMovie.Status.PREVIEW);
        else if (choice == 3)
            cinemaMovie.setStatus(CinemaMovie.Status.NOW_SHOWING);
        System.out.println("Enter End of Showing date (format: dd-mmm-yyyy): ");
        input = sc.nextLine();
        if (!Format.isValidDateFormat(input))
            return;

        cinemaMovie.setEndDate(input);
        System.out.println("Select movie type:");
        System.out.println("1: Regular");
        System.out.println("2: 3D");
        System.out.println("3: Blockbuster");
        choice = sc.nextInt();
        input = sc.nextLine();
        if (choice == 1)
            cinemaMovie.setType(CinemaMovie.Type.REGULAR);
        else if (choice == 2)
            cinemaMovie.setType(CinemaMovie.Type.THREE_D);
        else if (choice == 3)
            cinemaMovie.setType(CinemaMovie.Type.BLOCKBUSTER);
        cinemaMovie.setOverallRating(0f);
        cinemaMovie.setTicketSales(0f);
        list.addMovie(cinemaMovie);
        System.out.println("Movie added to database!");
    }

    public static void updateMovieListing(MovieList list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter title of movie to update: ");
        String input = sc.nextLine();
        CinemaMovie cinemaMovie = list.searchMovie(input);
        if (cinemaMovie == null)
            return;
        int choice;
        System.out.println("Select attribute to update: ");
        System.out.println("1: Update movie status");
        System.out.println("2: Update movie type");
        System.out.println("3: Update movie End of Showing date");
        choice = sc.nextInt();
        input = sc.nextLine();
        if (choice == 1) {
            System.out.println("Select new movie status: ");
            System.out.println("1: COMING_SOON");
            System.out.println("2: PREVIEW");
            System.out.println("3: NOW_SHOWING");
            choice = sc.nextInt();
            if (choice == 1)
                cinemaMovie.setStatus(CinemaMovie.Status.COMING_SOON);
            else if (choice == 2)
                cinemaMovie.setStatus(CinemaMovie.Status.PREVIEW);
            else if (choice == 3)
                cinemaMovie.setStatus(CinemaMovie.Status.NOW_SHOWING);
            System.out.println("Movie status updated!");
        } else if (choice == 2) {
            System.out.println("Select new movie type:");
            System.out.println("1: Regular");
            System.out.println("2: 3D");
            System.out.println("3: Blockbuster");
            choice = sc.nextInt();
            if (choice == 1)
                cinemaMovie.setType(CinemaMovie.Type.REGULAR);
            else if (choice == 2)
                cinemaMovie.setType(CinemaMovie.Type.THREE_D);
            else if (choice == 3)
                cinemaMovie.setType(CinemaMovie.Type.BLOCKBUSTER);
            System.out.println("Movie type updated!");
        } else if (choice == 3) {
            System.out.println("Enter new End of Showing date (format: dd-mmm-yyyy): ");
            input = sc.nextLine();
            if (!Format.isValidDateFormat(input))
                return;
                
            cinemaMovie.setEndDate(input);
            System.out.println("Movie End of Showing date updated!");
            list.checkEndDate();
        }
    }

    public static void removeMovieListing(MovieList list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter title of movie to remove: ");
        String input = sc.nextLine();
        CinemaMovie cinemaMovie = list.searchMovie(input);
        if (list.getList().remove(cinemaMovie))
            System.out.println("Movie has been removed from database!");
        else
            System.out.println("Error! Failed to remove movie from database.");
    }

    public static void sortTop5List(Top5List t5List) {
        Scanner sc = new Scanner(System.in);
        MenuDisplay.printSortMenu();
        String input = sc.nextLine();
        while (true) {
            if (input.equals("1")) {
                t5List.setSortBy(Top5List.sortBy.RATING);
                System.out.println("Top 5 List is now sorted by Overall Rating!");
                return;
            } else if (input.equals("2")) {
                t5List.setSortBy(Top5List.sortBy.SALES);
                System.out.println("Top 5 List is now sorted by Ticket Sales!");
                return;
            } else {
                MenuDisplay.printSortMenu();
                input = sc.nextLine();
            }
        }
    }
}
