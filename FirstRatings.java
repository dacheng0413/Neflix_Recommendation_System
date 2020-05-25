import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;
/**
 * Write a description of FirstRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FirstRatings {
    public ArrayList<Movie> loadMovies(String filename){
        ArrayList<Movie> ans = new ArrayList<Movie>();
        FileResource fr = new FileResource(filename);
        CSVParser parser = fr.getCSVParser();
        for(CSVRecord rc: parser){
            String id = rc.get("id");
            String title = rc.get("title");
            String year = rc.get("year");
            String genre = rc.get("genre");
            String country = rc.get("country");
            String director = rc.get("director");
            int minutes = Integer.parseInt(rc.get("minutes"));
            String poser = rc.get("poster");
            Movie mv = new Movie(id,title,year,genre,director,country,poser,minutes);
            ans.add(mv);
        }
        return ans;
    }
    
    public ArrayList<EfficientRater> loadRaters(String filename){
        ArrayList<EfficientRater> ans = new ArrayList<>();
        ArrayList<String> ids = new ArrayList<String>();
        FileResource fr = new FileResource(filename);
        CSVParser parser = fr.getCSVParser();
        for(CSVRecord rc: parser){
            String id = rc.get("rater_id");
            String movie = rc.get("movie_id");
            double value = Double.parseDouble(rc.get("rating"));
            if(ids.contains(id)){
                ans.get(ids.indexOf(id)).addRating(movie,value);
            }
            else{
                EfficientRater rt = new EfficientRater(id);
                rt.addRating(movie,value);
                ans.add(rt);
                ids.add(id);
            }
        }
        return ans;
    }
    
    
}
