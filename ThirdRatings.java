
import java.util.*;
/**
 * Write a description of ThirdRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThirdRatings {
    private ArrayList<EfficientRater> myRaters;
    
    public ThirdRatings(){
        this("ratings.csv");
    }
    
    public ThirdRatings(String ratingsfile){
        FirstRatings fr = new FirstRatings();
        myRaters = fr.loadRaters(ratingsfile);
    }
    
    private double getAverageByID(String movieId, int minimalRater){
        double avg = 0.0;
        int count = 0;
        for(EfficientRater rt: myRaters){
            if(rt.getRating(movieId) != -1){
                count++;
                avg += rt.getRating(movieId);
            }
        }
        if(count >= minimalRater){
            return avg/count;
        }
        return 0.0;
    }
    
    public ArrayList<Rating> getAverageRatings(int minimalRater){
        ArrayList<Rating> ans = new ArrayList<Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        for(String str: movies){
            double rate = getAverageByID(str,minimalRater);
            if(rate != 0.0){
                Rating rating = new Rating(str,rate);
                ans.add(rating);
            }
        }
        return ans;
    }
    
    public int getRaterSize(){
        return myRaters.size();
    }

    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRater, Filter f){
        ArrayList<Rating> ans = new ArrayList<Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        for(String str: movies){
            if(f.satisfies(str)){
            double rate = getAverageByID(str,minimalRater);
            if(rate != 0.0){
                Rating rating = new Rating(str,rate);
                ans.add(rating);
            }
        }
        }
        return ans;
    }
    
    
}
