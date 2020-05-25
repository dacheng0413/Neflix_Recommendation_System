import java.util.*;
/**
 * Write a description of MovieRunnerWithFilters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovieRunnerWithFilters {
    public void printAverageRatings(){
        ThirdRatings sr = new ThirdRatings("data/ratings.csv");
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
    
    public void printAverageRatingsByYear (){
        ThirdRatings sr = new ThirdRatings("data/ratings.csv");
        System.out.println("Rater number: " + sr.getRaterSize());
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("Movie number: "+MovieDatabase.size());
        Filter f = new YearAfterFilter(2000);
        ArrayList<Rating> rt = sr.getAverageRatingsByFilter(20,f);
        System.out.println("found "+rt.size()+" movies");
        Collections.sort(rt);
        for(Rating rat:rt){
            System.out.println(rat.getValue()+" "+MovieDatabase.getYear(rat.getItem())
            +" "+MovieDatabase.getTitle(rat.getItem()));
        }
        System.out.println(rt.size());
    }
    
    public void printAverageRatingsByGenre (){
        ThirdRatings sr = new ThirdRatings("data/ratings.csv");
        System.out.println("Rater number: " + sr.getRaterSize());
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("Movie number: "+MovieDatabase.size());
        Filter f = new GenreFilter("Comedy");
        ArrayList<Rating> rt = sr.getAverageRatingsByFilter(20,f);
        System.out.println("found "+rt.size()+" movies");
        Collections.sort(rt);
        for(Rating rat:rt){
            System.out.println(rat.getValue()+" "+MovieDatabase.getGenres(rat.getItem())
            +" "+MovieDatabase.getTitle(rat.getItem()));
        }
        System.out.println(rt.size());
    }
    
    public void printAverageRatingsByMinutes (){
        ThirdRatings sr = new ThirdRatings("data/ratings.csv");
        System.out.println("Rater number: " + sr.getRaterSize());
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("Movie number: "+MovieDatabase.size());
        Filter f = new MinutesFilter(105,135);
        ArrayList<Rating> rt = sr.getAverageRatingsByFilter(5,f);
        System.out.println("found "+rt.size()+" movies");
        Collections.sort(rt);
        for(Rating rat:rt){
            System.out.println(rat.getValue()+" "+MovieDatabase.getMinutes(rat.getItem())
            +" "+MovieDatabase.getTitle(rat.getItem()));
        }
        System.out.println(rt.size());
    }
    
    public void printAverageRatingsByDirector (){
        ThirdRatings sr = new ThirdRatings("data/ratings.csv");
        System.out.println("Rater number: " + sr.getRaterSize());
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("Movie number: "+MovieDatabase.size());
        Filter f = new DirectorsFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack");
        ArrayList<Rating> rt = sr.getAverageRatingsByFilter(4,f);
        System.out.println("found "+rt.size()+" movies");
        Collections.sort(rt);
        for(Rating rat:rt){
            System.out.println(rat.getValue()+" "+MovieDatabase.getDirector(rat.getItem())
            +" "+MovieDatabase.getTitle(rat.getItem()));
        }
        System.out.println("found "+rt.size()+" movies");
    }
    
    public void printAverageRatingsByYearAndGenre (){
        ThirdRatings sr = new ThirdRatings("data/ratings.csv");
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
    
    public void printAverageRatingsByMinutesandDirector (){
        ThirdRatings sr = new ThirdRatings("data/ratings.csv");
        System.out.println("Rater number: " + sr.getRaterSize());
        MovieDatabase.initialize("ratedmoviesfull.csv");
        System.out.println("Movie number: "+MovieDatabase.size());
        AllFilters f = new AllFilters();
        f.addFilter(new MinutesFilter(90,180));
        f.addFilter(new DirectorsFilter("Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack"));
        int minimal = 3;
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
}
