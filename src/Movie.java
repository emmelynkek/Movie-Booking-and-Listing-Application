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

    public Movie(){
        castNames = new ArrayList<String>();
        pastReviews = new ArrayList<Review>(); 
    }

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

    public String getSynopsis(){
        return synopsis;
    }

    public void setDirectorName(String name){
        this.directorName = name;
    }

    public String getDirectorName(){
        return directorName;
    }

    public void setCastNames(String name){
        castNames.add(name);
    }

    public List <String> getCastNames(){
        return castNames;
    }

    public void setOverallRating(float rating){
        this.overallRating = rating;
    }

    public float getOverallRating(){
        return overallRating;
    }

    public void setTicketSales(float sales){
        this.ticketSales = sales;
    }

    public float getTicketSales(){
        return ticketSales;
    }

    public void setPastReviews(Review review){
        pastReviews.add(review);
    }

    public List<Review> getPastReviews(){
        return pastReviews;
    }
    
    public static void main(String[] args){
        ShowingStatus st = ShowingStatus.PREVIEW;     //creating Enum obj
        MovieType type = MovieType.BLOCKBUSTER;       //creating Enum obj
        Movie m = new Movie();                        //creating Movie obj

        m.setStatus(st);                              // testing set methods
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
        m.setPastReviews(r1);
        m.setPastReviews(r2);

        System.out.println(m.getStatus());            // testing get methods
        System.out.println(m.getType());
        System.out.println(m.getTitle());
        System.out.println(m.getDirectorName());
        for (String name: m.getCastNames()){
            System.out.println(name);
        }
        System.out.println(m.getSynopsis());
        System.out.println(m.getTicketSales());
        System.out.println(m.getOverallRating());
        for (Review review: m.getPastReviews()){
            System.out.printf("%s, %f %d\n", review.getDescription(), review.getRating(), review.getReviewId());
        }

    }
}