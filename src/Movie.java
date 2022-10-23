import java.util.*;

public class Movie{
    enum ShowingStatus{
        COMING_SOON, PREVIEW, NOW_SHOWING; 
    }

    enum MovieType{
        THREE_D, BLOCKBUSTER; // THREE_D = 3D 
    }

    private ShowingStatus status;
    private MovieType type;
    private String movieTitle;
    private String synopsis;
    private String directorName;
    private List<String> castNames;
    private float overallRating;
    private float ticketSales;
    private List <Review> pastReviews;

    public void setStatus(ShowingStatus status){
        this.status = status;
    }

    public ShowingStatus getStatus(){
        return status;
    }

    public void setType(MovieType type){
        this.type = type;
    }

    public MovieType getType(){
        return type;
    }

    public void setTitle(String title){
        this.movieTitle = title;
    }

    public String getTitle(){
        return movieTitle;
    }

    public void setSynopsis(String synopsis){
        this.synopsis = synopsis;
    }

    private String getSynopsis(){
        return synopsis;
    }

    private void setDirectorName(String name){
        this.directorName = name;
    }

    private String getDirectorName(){
        return directorName;
    }

    private void setCastNames(String name){
        castNames.add(name);
    }

    private List <String> getCastNames(){
        return castNames;
    }

    private void setOverallRating(float rating){
        this.overallRating = rating;
    }

    private float getOverallRating(){
        return overallRating;
    }

    private void setTicketSales(float sales){
        this.ticketSales = sales;
    }

    private float getTicketSales(){
        return ticketSales;
    }

    // Main method to test Movie class
    public static void main(String[] args){
        ShowingStatus st = ShowingStatus.PREVIEW;     // creating Enum obj
        MovieType type = MovieType.BLOCKBUSTER;       // creating Enum obj
        Movie m = new Movie();                        // creating Movie obj
        m.castNames = new ArrayList<String>();        // create List of String obj for castName attribute
        m.pastReviews = new ArrayList<Review>();      // create List of Review obj for pastReviews attribute

        m.setStatus(st);                              // initialise attributes
        m.setType(type);
        m.setTitle("Attack on Titan");
        m.setDirectorName("Hajime Isayama");
        m.setCastNames("Kaji Yuuki");
        m.setCastNames("Marina Inoue");
        m.setSynopsis("This is a show where Humanity fight Titans");
        m.setTicketSales(9999999);
        m.setOverallRating(9.9f);
        Review r1 = new Review("Wow AOT is the best anime!", 10, 01);
        Review r2 = new Review("Peak fiction. I love daddy Eren", 9, 02);
        m.pastReviews.add(r1);
        m.pastReviews.add(r2);

        System.out.println(m.getStatus());            // checking attributes
        System.out.println(m.getType());
        System.out.println(m.getTitle());
        System.out.println(m.getDirectorName());
        for (String name: m.getCastNames()){
            System.out.println(name);
        }
        System.out.println(m.getSynopsis());
        System.out.println(m.getTicketSales());
        System.out.println(m.getOverallRating());
        for (Review review: m.pastReviews){
            System.out.printf("%s, %f %d\n", review.getDescription(), review.getRating(), review.getReviewId());
        }

    }
}
