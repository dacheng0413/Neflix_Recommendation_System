import java.util.*;

/**
 * Write a description of RecommendationRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RecommendationRunner implements Recommender{
    public ArrayList<String> getItemsToRate (){
        ArrayList<String> rst = new ArrayList<String>();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        int movieSize = movies.size();
        Random r = new Random();
        for(int i = 0; i < 20; i++){
            int randomNum = r.nextInt(movieSize-0)+0;
            String mv = movies.get(randomNum);
            if(!rst.contains(mv)){
                rst.add(mv);
            }
            else{
                i--;
            }
        }
        return rst;
    }
    
    public void printRecommendationsFor (String webRaterID){
        FourthRating sr = new FourthRating();
        ArrayList<Rating> rating = sr.getSimilarRatingsByFilter(webRaterID,
        1,1,new TrueFilter());
        int length = 20;
        if(rating.size() < 20){
            length = rating.size();
        }
        if(rating.size() == 0){
            int index = 0;
            ArrayList<String> mv1 = MovieDatabase.filterBy(new TrueFilter());
            Random rand = new Random();
            HashSet <String> titles = new HashSet <String>();
            for(int i =0; i < 20; i++){
                int r = rand.nextInt(mv1.size());
                String title = mv1.get(r);
                if (rating.size()!=0 && !titles.contains(title)) {
                    rating.add(new Rating(title, 5.00));
                    titles.add(title);
                    index++;
                }
                if(index > 10){
                    break;
                }
            }
        }
        System.out.println("<style>");
        System.out.println("h2.error {");
        System.out.println("  background-color: #FFD700;");
        System.out.println("    color: #DC143C;");
        System.out.println("  margin: 5;");
        System.out.println("}");
        System.out.println("</style>");
        System.out.println("<div class=\"content\">");
        System.out.println("  <div class=\"ui-widget\">");
        System.out.println("    <html>");
        System.out.println("<style>");
        System.out.println("  #customers,");
        System.out.println("  h2 {");
        System.out.println("    font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;");
        System.out.println("    border-collapse: collapse;");
        System.out.println("    width: 100%;");
        System.out.println("    text-align: center;");
        System.out.println("  }");
        System.out.println("  #customers td,");
        System.out.println("  #customers th,");
        System.out.println("  h2 {");
        System.out.println("    border: 1px solid #ccc;");
        System.out.println("    padding: 8px;");
        System.out.println("  }");
        System.out.println("  #customers tr:nth-child(even) {");
        System.out.println("    background-color: #f2f2f2;");
        System.out.println("  }");
        System.out.println("  #customers tr:hover {");
        System.out.println("    background-color: #ccc;");
        System.out.println("  }");
        System.out.println("  #customers th {");
        System.out.println("    padding-top: 12px;");
        System.out.println("    padding-bottom: 12px;");
        System.out.println("    text-align: center;");
        System.out.println("    background-color: #4CAF50;");
        System.out.println("    color: white;");
        System.out.println("  }");
        System.out.println("  #customers img {");
        System.out.println("    height: 50%;");
        System.out.println("  }");
        System.out.println("  h2 {");
        System.out.println("    background-color: #4CAF50;");
        System.out.println("  }");
        System.out.println("</style><h2>Shicheng's Select for You.</h2>");
        System.out.println("<table id=\"customers\">");
        System.out.println("  <tr>");
        System.out.println("    <th>#</th>");
        System.out.println("    <th>Poster</th>");
        System.out.println("    <th>Title</th>");
        System.out.println("    <th>Genre</th>");
        System.out.println("    <th>Year</th>");
        System.out.println("    <th>Time</th>");
        System.out.println("  </tr>  <tr>");
        for(int i=0; i< length; i++) {
            int num = i+1;
            System.out.println("    <td>"+num+"</td>");
            System.out.println("    <td><img src=");
            System.out.println(     "\""+MovieDatabase.getPoster(rating.get(i).getItem())+"\"");
            System.out.println(" /> </td>");
            System.out.println("    <td>"+MovieDatabase.getTitle(rating.get(i).getItem())+"</td>");
            System.out.println("    <td>"+MovieDatabase.getCountry(rating.get(i).getItem())+"</td>");
            System.out.println("    <td>"+MovieDatabase.getYear(rating.get(i).getItem())+"</td>");
            System.out.println("    <td>"+MovieDatabase.getMinutes(rating.get(i).getItem())+" Minutes"+"</td>");
            System.out.println("  </tr>  <tr>");
        }       
        
    }
}

