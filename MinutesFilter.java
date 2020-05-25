
/**
 * Write a description of MinuteFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinutesFilter implements Filter {
    int min;
    int max;
    public MinutesFilter(int in, int ax){
        min = in;
        max = ax;
    }
    
    @Override
    public boolean satisfies(String id) {
	if(MovieDatabase.getMinutes(id) >= min && MovieDatabase.getMinutes(id) <=max)
	   return true;
	return false;
    }
}
