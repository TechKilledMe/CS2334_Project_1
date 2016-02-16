
/**
 * Project #1
 * CS2334
 * 2/5/16
 * @version 1.0
 * 
 * The main class of the project which will parse the data given in the .txt file and store the movies in an ArrayList.
 */
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MdBDriver {
	/**
	 * Name of the file storing the list of movies.
	 */
	private static String filename;

	/**
	 * User defined string of what movie they are searching for.
	 */
	private String userTitle;

	/**
	 * User defined integer of the year of release of the movie they are
	 * searching for.
	 */
	private int userYear;

	/**
	 * ArrayList in which each element is a new line in the file storing the
	 * movies.
	 */
	public static ArrayList<String> fileData;

	/**
	 * Default constructor
	 */
	public MdBDriver() {
		// TODO Change filename to args[0] so it is not hardcoded.
		filename = ("StarTrekMovies.txt");
		userTitle = ("No Data");
		userYear = 0;
		fileData = new ArrayList<String>();

	}

	/**
	 * Will search for a movie in the database with the same name given in the
	 * parameter.
	 * 
	 * @param userTitle
	 *            of type String which is the movie the user is searching for.
	 * @return The index of the location in the array in which the movie was
	 *         found.
	 */
	public int findMovieWithTitle(String userTitle) {
		// TODO Fixme
	}

	/**
	 * Will search for a movie in the database with the same name and year given
	 * in the parameters.
	 * 
	 * @param userTitle
	 *            String which is the movie the user is searching for.
	 * @param userYear
	 *            The year the movie was released of type int.
	 * @return The index of the location in the array in which the movie was
	 *         found.
	 */
	public int findMovieWithTitleAndDate(String userTitle, int userYear) {
		// TODO Fixme
	}

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		
		//Always reads first line of the file into the first index of fileData
		//TODO: Change to try-catch
		String nextLine = br.readLine();
		while (nextLine != null){
			fileData.add(nextLine);
		}
		
		//Use string split to parse fileData
		for (int i = 0; i < fileData.size(); i++) {
			
		}
		//Test 3
	}

}
