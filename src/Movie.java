/**
 * Project #1
 * CS2334
 * 2/5/16
 * @version 1.0
 * 
 * This class stores all of the relevant data for a movie.
 */
import java.util.ArrayList;

public class Movie {
	/**
	 * The title of the movie stored as a string.
	 */
	private String title;
	
	/**
	 * The year of release of the movie.
	 */
	private int date;
	/**
	 * The type of release the movie had.
	 */
	private String releaseFormat;
	/**
	 * An ArrayList of type Movie that stores the list of movies.
	 */
	private ArrayList<Movie> listOfMovies;
	
	/**
	 * Default constructor
	 */
	public Movie() {
		title = ("No Data");
		date = 0;
		releaseFormat = ("No data");
		listOfMovies = new ArrayList<Movie>();
	}

	/**
	 * Method which will return the title of the movie.
	 * @return Returns the title of the movie of type String.
	 */
	public String getTitle(){
		//TODO fixme
	}
	
	/**
	 * Method which will return the date of release of the movie.
	 * @return Returns the year of release of the movie in the format "YYYY" as an integer.
	 */
	public int getDate() {
		//TODO fixme
	}
	
	/**
	 * Method which will return the release format of the movie.
	 * @return Returns the release format of the movie as type String.
	 */
	public String getReleaseFormat() {
		//TODO fixme
	}
}
