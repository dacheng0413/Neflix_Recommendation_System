
/**
 * Write a description of DirectorsFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DirectorsFilter implements Filter{
    String[] directors;
    public DirectorsFilter(String g){
        directors = g.split("\\s*,");
    }
    @Override
    public boolean satisfies(String id) {
        String[] drs = MovieDatabase.getDirector(id).split("\\s*,");
        for(int i = 0; i < drs.length; i++){
            drs[i] = drs[i].trim();
        }
        
        for(int i = 0; i <drs.length; i++){
            for(String s: directors){
                if(s.equals(drs[i])){
                    return true;
                }
            }
        }
        
        
        return false;
    }
}
