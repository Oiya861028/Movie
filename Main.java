import java.util.Scanner;
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Movie[] movies = new Movie[5];
    public static boolean validTitleOrDirector(String text){
        for(Movie i: movies){
            if(i.getTitle().equals(text)) return true;
            if(i.getDirector().equals(text)) return true;
        }
        return false;
    }
    //Finds the movie the user want to manipulate
    public static Movie getMovie(){
        sc.nextLine();
        System.out.println("What is the movie name?");
        String movieName = sc.nextLine();
        boolean valid = validTitleOrDirector(movieName);
        while(!valid){
            System.out.println("Movie not found. Try again:");
            movieName = sc.nextLine();
            valid = validTitleOrDirector(movieName);
        }
        for(Movie i: movies){
            if(i.getTitle().equals(movieName)) return i;
            else if(i.getDirector().equals(movieName)) return i;
        }
        return movies[0];
    }

    public static void main(String[] args){
        //Add movie
        movies[0] = new Movie("Aquaman and the Lost Kingdom", "James Wan");
        movies[1] = new Movie("The Boy and the Heron", "Hayao Miyazaki");
        movies[2] = new Movie("Godzilla Minus", "Takashi Yamazaki");
        movies[3] = new Movie("The Hunger Games: The Ballad of Songbirds and Snakes", "Francis Lawrence");
        movies[4] = new Movie("Dr. Seuss' The Grinch", "Scott Mosier, Yarrow Cheney");


        Movie movie = movies[0];
        boolean valid;
        boolean cont = true;
        while(cont){
            System.out.println("Press a key to perform the following command:");
            System.out.println("" +
                    "1. Search a movie by Title\n" +
                    "2. Search a movie by Director\n" +
                    "3. Add actors to a movie\n" +
                    "4. Enter rating to a movie\n" +
                    "5. Add reviews to a movie\n" +
                    "6. Print all of the movies with titles, directors, actors, ratings, and reviews.\n" +
                    "Any other keys to quit.");
            int choice = sc.nextInt();
            switch (choice){
                case 1: //find movie by title
                    movie = getMovie();

                    System.out.println("The director of the movie is " + movie.getDirector());
                    break;

                case 2: //find movie by director
                    sc.nextLine();
                    System.out.println("Enter the director's name:");
                    String inputDirector = sc.nextLine();
                    valid = validTitleOrDirector(inputDirector); //check validity
                    while(!valid){
                        System.out.println("Name not found x_x");
                        System.out.println("Try again:");
                        inputDirector = sc.nextLine();
                        valid = validTitleOrDirector(inputDirector);
                    }
                    for(Movie i: movies){
                        if (i.getDirector().equals(inputDirector)) movie = i;
                    }


                    System.out.println("The Name of movie directed by "+ inputDirector+" is: "+movie.getTitle());
                    break;

                case 3: //Add actors to movie
                    movie = getMovie();

                    boolean moreActors = true;
                    String actorNames = "";
                    while(moreActors){
                        System.out.println("Enter actor name(You can enter multiple names separated by ','. Press 1 if you have no more names):");
                        String actorName = sc.nextLine();
                        if(actorName.equals("1")) moreActors = false;
                        else {
                            actorNames += actorName+ ",";

                        }
                    }
                    int actorCount =0;
                    for(int i=0;i<actorNames.length();i++){
                        if(actorNames.charAt(i)==',') actorCount++;
                    }
                    String[] actors = new String[actorCount];
                    actorCount = 0;
                    String individualNames = "";
                    for(int i=0;i<actorNames.length()-1;i++){
                        if(actorNames.charAt(i)!=',') individualNames+= actorNames.charAt(i);
                        else {
                            actors[actorCount] = individualNames;
                            individualNames = "";
                            actorCount++;
                        }
                    }
                    actors[actors.length-1] = individualNames;
                    movie.setActors(actors);
                    break;

                case 4://Enter rating to a movie
                    movie = getMovie();
                    System.out.println("Enter your rating for this movie: ");
                    double rating = sc.nextDouble();
                    movie.setRating(rating);
                    break;
                case 5://Add reviews to a movie
                    movie = getMovie();
                    System.out.println("How many reviews do you want put? ");
                    int numReviews = sc.nextInt();
                    String[] reviews = new String[numReviews];
                    sc.nextLine();
                    for(int i=0;i<numReviews;i++){
                        System.out.println("Please enter your review("+i+"):");
                        reviews[i]= sc.nextLine();
                    }
                    movie.setReviews(reviews);
                    break;
                case 6: //Print all of the movies with titles, directors, actors, ratings, and reviews.
                    for(Movie i: movies){
                        System.out.println("Title: "+ i.getTitle()+
                                "\nDirector: "+ i.getDirector()+
                                "\nActors: "+i.getActors()+
                                "\nRatings: "+i.getRating()+
                                "\nReviews:"+i.getReviews());
                        System.out.println("----------------------------");
                    }
                    break;
                default:
                    cont = false;
            }
        }

    }



}
