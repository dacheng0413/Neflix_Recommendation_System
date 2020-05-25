
/**
 * Write a description of GenreFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GenreFilter implements Filter{
    String genre;
    public GenreFilter(String g){
        genre = g;
    }
    @Override
    public boolean satisfies(String id) {
	return MovieDatabase.getGenres(id).indexOf(genre)!= -1;
    }
}
