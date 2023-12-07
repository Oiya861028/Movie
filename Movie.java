public class Movie {
    private String Title;
    private String Director;
    private String[] Actors = {};
    private double rating = 0.0;
    private String[] reviews = {};
    public Movie(String Title, String Director){
        this.Title = Title;
        this.Director = Director;
    }
    public String getTitle(){
        return Title;
    }
    public String getDirector() {
        return Director;
    }
    public double getRating(){
        return rating;
    }
    public String getActors(){
        String actor = "";
        for(String people: Actors){
            actor += people+", ";
        }
        return actor;
    }
    public String getReviews(){
        String review = "";
        for(String quote: reviews){
            review += quote+"; ";
        }
        return review;
    }

    public void setActors(String[] actors){
        Actors = actors;
    }
    public void setRating(double rating){
        this.rating = rating;
    }
    public void setReviews(String[] reviews){
        this.reviews = reviews;
    }
}
