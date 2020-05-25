import java.util.*;
/**
 * Write a description of FourthRating here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FourthRating {
    
    private double getAverageByID(String movieId, int minimalRater){
        double avg = 0.0;
        int count = 0;
        for(Rater rt: RaterDatabase.getRaters()){
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
        return RaterDatabase.size();
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
    
    private double dotProduct(Rater me, Rater r){
        double ans = 0;
        ArrayList<String> myItem = me.getItemsRated();

        for(String str: myItem){
            if(r.hasRating(str)){
                double myScore = me.getRating(str) - 5;
                double rScore = r.getRating(str) - 5;
                ans += myScore*rScore;
            }
        }
        return ans;
    }
    
    private ArrayList<Rating> getSimilarities(String id){
        ArrayList<Rater> rater = RaterDatabase.getRaters();
        ArrayList<Rating> rating = new ArrayList<>();
        for(Rater rt:rater){
            double similarities = 0.0;
            if(!rt.getID().equals(id)){
                similarities = dotProduct(RaterDatabase.getRater(id),rt);
            }
            
            rating.add(new Rating(rt.getID(),similarities));
            
        }
        Collections.sort(rating, Collections.reverseOrder());
        return rating;
    }
    
    public ArrayList<Rating> getSimilarRatingsByFilter(String id, int numSimilarRaters,
    int minimalRaters, Filter f){
        ArrayList<Rating> idSimilar = getSimilarities(id);
        ArrayList<String> movies = MovieDatabase.filterBy(f);
        ArrayList<Rating> ans = new ArrayList<>();
        
        for(String mv:movies){
            int count = 0;
            double sum = 0.0;
            for(int i = 0; i < numSimilarRaters; i++){
                Rating r = idSimilar.get(i);
                double weight = r.getValue();
                String raterID = r.getItem();
                Rater myRater = RaterDatabase.getRater(raterID);
                if(myRater.hasRating(mv)){
                    count++;
                    sum += weight*myRater.getRating(mv);
                }
            }
            if(count >= minimalRaters){
                ans.add(new Rating(mv,sum/count));
            }
        }
        Collections.sort(ans,Collections.reverseOrder());
        return ans;
    }
    
}
