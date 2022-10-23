public class Review {
    private String description;
    private float rating;
    private int reviewId;

    public Review(String description, float rating, int reviewId){
        this.description = description;
        this.rating = rating;
        this.reviewId = reviewId;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setRating(float rating){
        this.rating = rating;
    }

    public float getRating(){
        return rating;
    }

    public void setReviewId(int reviewId){
        this.reviewId = reviewId;
    }

    public int getReviewId(){
        return reviewId;
    }
}
