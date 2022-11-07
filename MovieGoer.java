import java.io.Serializable;

public class MovieGoer implements Serializable{
    private String username;
    private int mobileNumber;
    private String email;
    public BookingHistory history;

    public MovieGoer(String name, int num, String emailAddress) {
        this.username = name;
        this.mobileNumber = num;
        this.email = emailAddress;
        this.history = new BookingHistory();
    }

    public String getName() {
        return this.username;
    }

    public int getNum() {
        return this.mobileNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public BookingHistory getHistory() {
        return this.history;
    }

    public void setHistory(BookingHistory historyList) {
        this.history = historyList;
    }
    
}
