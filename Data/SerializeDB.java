package Data;
import Model.*;
import Controller.*;
import java.util.*;
import java.io.*;

public class SerializeDB{
    public static UserAccounts readUserAccounts(String filename) {
		UserAccounts pDetails = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			pDetails = (UserAccounts) in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		// print out the size
		//System.out.println(" Details Size: " + pDetails.size());
		//System.out.println();
		return pDetails;
	}

    public static AdminAccounts readAdminAccounts(String filename) {
		AdminAccounts pDetails = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			pDetails = (AdminAccounts) in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		// print out the size
		//System.out.println(" Details Size: " + pDetails.size());
		//System.out.println();
		return pDetails;
	}

    public static CineplexList readCineplexList(String filename) {
		CineplexList pDetails = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			pDetails = (CineplexList) in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		// print out the size
		//System.out.println(" Details Size: " + pDetails.size());
		//System.out.println();
		return pDetails;
	}

    public static MovieList readMovieList(String filename) {
		MovieList pDetails = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			pDetails = (MovieList) in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		// print out the size
		//System.out.println(" Details Size: " + pDetails.size());
		//System.out.println();
		return pDetails;
	}

	public static Top5List readTop5List(String filename) {
		Top5List pDetails = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			pDetails = (Top5List) in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		// print out the size
		//System.out.println(" Details Size: " + pDetails.size());
		//System.out.println();
		return pDetails;
	}

	public static BookingList readBookingList(String filename) {
		BookingList pDetails = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			pDetails = (BookingList) in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		// print out the size
		//System.out.println(" Details Size: " + pDetails.size());
		//System.out.println();
		return pDetails;
	}

	public static PublicHolidayList readPublicHolidayList(String filename) {
		PublicHolidayList pDetails = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			pDetails = (PublicHolidayList) in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		// print out the size
		//System.out.println(" Details Size: " + pDetails.size());
		//System.out.println();
		return pDetails;
	}

	public static TicketPrice readTicketPrice(String filename) {
		TicketPrice pDetails = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			pDetails = (TicketPrice) in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		// print out the size
		//System.out.println(" Details Size: " + pDetails.size());
		//System.out.println();
		return pDetails;
	}

	public static void writeSerializedObject(String filename, UserAccounts db) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(db);
            out.close();
        //	System.out.println("Object Persisted");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}

    public static void writeSerializedObject(String filename, AdminAccounts db) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(db);
            out.close();
        //	System.out.println("Object Persisted");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}

    public static void writeSerializedObject(String filename, CineplexList db) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(db);
            out.close();
        //	System.out.println("Object Persisted");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}

    public static void writeSerializedObject(String filename, MovieList db) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(db);
            out.close();
        //	System.out.println("Object Persisted");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}

	public static void writeSerializedObject(String filename, Top5List db) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(db);
            out.close();
        //	System.out.println("Object Persisted");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}

	public static void writeSerializedObject(String filename, BookingList db) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(db);
            out.close();
        //	System.out.println("Object Persisted");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}

	public static void writeSerializedObject(String filename, PublicHolidayList db) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(db);
            out.close();
        //	System.out.println("Object Persisted");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}

	public static void writeSerializedObject(String filename, TicketPrice db) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(db);
            out.close();
        //	System.out.println("Object Persisted");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}

    public static void main(String[] args) throws Exception{ // run main method to create .txt files containing dummy data

		AdminAccounts adminDb = new AdminAccounts();
		UserAccounts userDb = new UserAccounts();
		CineplexList cList = new CineplexList();
		MovieList mList = new MovieList();
		Top5List t5List = new Top5List();
		BookingList bList = new BookingList();
		PublicHolidayList pList = new PublicHolidayList();
		TicketPrice ticketPrice = new TicketPrice();

        adminDb.setAccount("admin", "admin");
		User user = new User("user", "81234567", "user@gmail.com");
		userDb.setAccount(user, "user");

		Cineplex cineplex1 = new Cineplex("Jurong Point");
        Cineplex cineplex2 = new Cineplex("Suntec City");
        cList.addCineplex(cineplex1);
        cList.addCineplex(cineplex2);

		CinemaMovie m1 = new CinemaMovie();
        m1.setMovie(new Movie());                        //creating Movie obj
        m1.setStatus(CinemaMovie.Status.COMING_SOON);    // initialise attributes
        m1.setType(CinemaMovie.Type.BLOCKBUSTER);
        m1.getMovie().setTitle("Spy x Family");
        m1.getMovie().setDirectorName("Tatsuya Endo");
        m1.getMovie().setCastNames("Tanezaki Atsumi");
        m1.getMovie().setCastNames("Hayami Saori");
        m1.getMovie().setCastNames("Eguchi Takuya");
        m1.getMovie().setSynopsis("The story follows a spy who has to \"build a family\" to execute a mission, not realizing that the girl he adopts as his daughter is a telepath, and the woman he agrees to be in a marriage with is a skilled assassin.");
        m1.setTicketSales(777777d);
		m1.setEndDate("01-Jan-2023");
        Review r1 = new Review("User 1", "Spy x Family is an oddball tonal mashup that blends the action-packed and high-stakes world of spies with a heartwarming, family-friendly comedy.", 10);
        Review r2 = new Review("User 2", "Spy x Family is an anime of the year candidate.", 5);
        m1.setReviews(r1);
        m1.setReviews(r2);
        mList.addMovie(m1);

		CinemaMovie m2 = new CinemaMovie();
        m2.setMovie(new Movie());                        //creating Movie obj
        m2.setStatus(CinemaMovie.Status.NOW_SHOWING);    // initialise attributes
        m2.setType(CinemaMovie.Type.BLOCKBUSTER);
        m2.getMovie().setTitle("Black Adam");
        m2.getMovie().setDirectorName("Jaume Collet-Serra");
        m2.getMovie().setCastNames("Dwayne Johnson");
        m2.getMovie().setCastNames("Aldis Hodge");
        m2.getMovie().setCastNames("Noah Centineo");
        m2.getMovie().setSynopsis("Nearly 5,000 years after he was bestowed with the almighty powers of the Egyptian gods -- and imprisoned just as quickly -- Black Adam is freed from his earthly tomb, ready to unleash his unique form of justice on the modern world.");
        m2.setTicketSales(0d);
		m2.setEndDate("02-Jan-2023");
        Review r3 = new Review("User 3", "watchable but not great.", 8);
        Review r4 = new Review("User 4", "good movie, lots of action and always good to see the Rock kicking butt", 9);
        m2.setReviews(r3);
        m2.setReviews(r4);
        mList.addMovie(m2);

		CinemaMovie m3 = new CinemaMovie();
        m3.setMovie(new Movie());                        //creating Movie obj
        m3.setStatus(CinemaMovie.Status.PREVIEW);    // initialise attributes
        m3.setType(CinemaMovie.Type.BLOCKBUSTER);
        m3.getMovie().setTitle("Marvel Studios' Black Panther: Wakanda Forever");
        m3.getMovie().setDirectorName("Ryan Coogler");
        m3.getMovie().setCastNames("Letitia Wright");
        m3.getMovie().setCastNames("Tenoch Huerta");
        m3.getMovie().setCastNames("Martin Freeman");
        m3.getMovie().setSynopsis("In Marvel Studios' \"Black Panther: Wakanda Forever,\" Queen Ramonda, Shuri, M'Baku, Okoye and the Dora Milaje, fight to protect their nation from intervening world powers in the wake of King T'Challa's death."+
                                  " As the Wakandans strive to embrace their next chapter, the heroes must band together with the help of War Dog Nakia and Everett Ross, and forge a new path for the kingdom of Wakanda.");
        m3.setTicketSales(999999d);
		m3.setEndDate("03-Jan-2023");
        Review r5 = new Review("User 5", "Wakanda forever!", 7);
        Review r6 = new Review("User 6", "Rip Chadwick Boseman", 9);
        m3.setReviews(r5);
        m3.setReviews(r6);
        mList.addMovie(m3);

		t5List.setSortBy(Top5List.sortBy.RATING);
		t5List.sortList(mList);

		ShowTime showTime = new ShowTime();
		showTime.setCinemaCode("R1");
		showTime.setCineplexName("Jurong Point");
		showTime.setDate("03-Jan-2023");
		showTime.setStartTime("1400");
		showTime.setEndTime("1600");
		m2.setShowTimes(showTime);

		Booking booking = new Booking();
		booking.setMovieTitle(m2.getMovie().getTitle());
		booking.setShowTime(showTime);
		showTime.getSeatLayout().setSeatavailability(5, 5, false);
		booking.setTransactionID("R1");
		booking.setTotalPrice(10.5d);
		booking.setUser(user);
		booking.setSeatID("R5C5");
		bList.addBooking(booking);

		PublicHoliday pubHol = new PublicHoliday("Christmas", PublicHoliday.stringToDate("25-Dec-2022"));
		pList.addPublicHoliday(pubHol);

		SerializeDB.writeSerializedObject("Data/AdminAccounts.txt", adminDb);
        SerializeDB.writeSerializedObject("Data/UserAccounts.txt", userDb);
        SerializeDB.writeSerializedObject("Data/CineplexList.txt", cList);
        SerializeDB.writeSerializedObject("Data/MovieList.txt", mList);
        SerializeDB.writeSerializedObject("Data/Top5List.txt", t5List);
		SerializeDB.writeSerializedObject("Data/BookingList.txt", bList);
		SerializeDB.writeSerializedObject("Data/PublicHolidayList.txt", pList);
		SerializeDB.writeSerializedObject("Data/TicketPrice.txt", ticketPrice);

    } 
}
