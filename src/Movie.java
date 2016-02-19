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
	private String date;
	/**
	 * The type of release the movie had.
	 */
	private String releaseFormat;
	
	/**
	 * Where the movie is located in the listOfMovies array.
	 */
	public int index;
	
	
	
	/**
	 * Default constructor
	 */
	public Movie() {
		title = ("No Data");
		date = "No Date";
		releaseFormat = ("No data");
		index = -1; 
		
	}
	/**
	 * Constructor that takes date from the file reader in MdBDriver
	 * @param titleParameter Title of the movie.
	 * @param dateParameter Date of production of movie.
	 * @param releaseFormatParameter Release format of movie.
	 */
	public Movie(String titleParameter, String dateParameter, String releaseFormatParameter, int arrayIndex) {
		title = titleParameter;
		date = dateParameter;
		releaseFormat = releaseFormatParameter;
		index = arrayIndex;

	}

	/**
	 * Method which will return the title of the movie.
	 * @return Returns the title of the movie of type String.
	 */
	public String getTitle(){
		return title;
	}
	
	/**
	 * Method which will return the date of release of the movie.
	 * @return Returns the year of release of the movie in the format "YYYY" as an integer.
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * Method which will return the release format of the movie.
	 * @return Returns the release format of the movie as type String.
	 */
	public String getReleaseFormat() {
		return releaseFormat;
	}
	
	/**
	 * Method which returns the index of where the movie is located in the list. 
	 * @return Returns the index of where the movie is located in the list.
	 */
	public int getIndex() {
		return index;
	}
}
