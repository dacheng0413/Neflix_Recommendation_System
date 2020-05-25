import java.util.*;
/**
 * Write a description of MovieRunnerSimilarRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovieRunnerSimilarRatings {
    public void printAverageRatings(){
        FourthRating sr = new FourthRating();
        RaterDatabase.initialize("ratings.csv");
        System.out.println("Rater number: " + sr.getRaterSize());
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("Movie number: "+MovieDatabase.size());
        ArrayList<Rating> rt = sr.getAverageRatings(35);
        System.out.println("found "+rt.size()+" movies");
        Collections.sort(rt);
        for(Rating rat:rt){
            System.out.println(rat.getValue()+" "+MovieDatabase.getTitle(rat.getItem()));
        }
        System.out.println(rt.size());
    }
    
    public void printAverageRatingsByYearAndGenre (){
        FourthRating sr = new FourthRating();
        RaterDatabase.initialize("ratings.csv");
        System.out.println("Rater number: " + sr.getRaterSize());
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("Movie number: "+MovieDatabase.size());
        AllFilters f = new AllFilters();
        f.addFilter(new YearAfterFilter(1990));
        f.addFilter(new GenreFilter("Drama"));
        int minimal = 8;
        ArrayList<Rating> rt = sr.getAverageRatingsByFilter(minimal,f);
        System.out.println("found "+rt.size()+" movies");
        Collections.sort(rt);
        for(Rating rat:rt){
            System.out.println(rat.getValue()+" "+MovieDatabase.getYear(rat.getItem())
            +" "+MovieDatabase.getGenres(rat.getItem())
            +" "+MovieDatabase.getTitle(rat.getItem()));
        }
        System.out.println("found "+rt.size()+" movies");
    }
    
    public void printSimilarRatings (){
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");
        FourthRating sr = new FourthRating();
        System.out.println("Rater number: " + sr.getRaterSize());
        System.out.println("Movie number: "+MovieDatabase.size());
        int minimal = 5;
        ArrayList<Rating> rt = sr.getSimilarRatingsByFilter("71",20,minimal,new TrueFilter());
        for(Rating rat:rt){
            System.out.println(rat.getValue()
            +" "+MovieDatabase.getTitle(rat.getItem()));
        }
        System.out.println("found "+rt.size()+" movies");
    }
    
    public void printSimilarRatingsByGenre (){
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");
        FourthRating sr = new FourthRating();
        System.out.println("Rater number: " + sr.getRaterSize());
        System.out.println("Movie number: "+MovieDatabase.size());
        Filter genre = new GenreFilter("Mystery");
        int minimal = 5;
        ArrayList<Rating> rt = sr.getSimilarRatingsByFilter("964",20,minimal,genre);
        for(Rating rat:rt){
            System.out.println(rat.getValue()
            +" "+MovieDatabase.getTitle(rat.getItem()));
        }
        System.out.println("found "+rt.size()+" movies");
    }
    
    public void printSimilarRatingsByDirector (){
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");
        FourthRating sr = new FourthRating();
        System.out.println("Rater number: " + sr.getRaterSize());
        System.out.println("Movie number: "+MovieDatabase.size());
        Filter dir = new DirectorsFilter("Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh");
        int minimal = 2;
        ArrayList<Rating> rt = sr.getSimilarRatingsByFilter("120",10,minimal,dir);
        for(Rating rat:rt){
            System.out.println(rat.getValue()
            +" "+MovieDatabase.getTitle(rat.getItem()));
        }
        System.out.println("found "+rt.size()+" movies");
    }
    
    public void printSimilarRatingsByGenreAndMinutes(){
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");
        FourthRating sr = new FourthRating();
        System.out.println("Rater number: " + sr.getRaterSize());
        System.out.println("Movie number: "+MovieDatabase.size());
        AllFilters f = new AllFilters();
        f.addFilter(new MinutesFilter(80,160));
        f.addFilter(new GenreFilter("Drama"));
        int minimal = 3;
        ArrayList<Rating> rt = sr.getSimilarRatingsByFilter("168",10,minimal,f);
        for(Rating rat:rt){
            System.out.println(rat.getValue()
            +" "+MovieDatabase.getTitle(rat.getItem()));
        }
        System.out.println("found "+rt.size()+" movies");
    }
    
    public void printSimilarRatingsByYearAfterAndMinutes(){
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");
        FourthRating sr = new FourthRating();
        System.out.println("Rater number: " + sr.getRaterSize());
        System.out.println("Movie number: "+MovieDatabase.size());
        AllFilters f = new AllFilters();
        f.addFilter(new MinutesFilter(70,200));
        f.addFilter(new YearAfterFilter(1975));
        int minimal = 5;
        ArrayList<Rating> rt = sr.getSimilarRatingsByFilter("314",10,minimal,f);
        for(Rating rat:rt){
            System.out.println(rat.getValue()
            +" "+MovieDatabase.getTitle(rat.getItem()));
        }
        System.out.println("found "+rt.size()+" movies");
    }
}
