
/**
 * Project #1
 * CS2334
 * 2/5/16
 * @version 1.0
 * 
 * The main class of the project which will parse the data given in the .txt file and store the movies in an ArrayList.
 */
import java.util.ArrayList;
import java.util.List;
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

	/**
	 * An ArrayList of type Movie that stores the list of movies.
	 */
	public static ArrayList<String> fileData;
	
	public static List<Movie> movieList;

	/**
	 * Default constructor
	 */
	public MdBDriver() {
		// TODO Change filename to args[0] so it is not hardcoded.
		filename = ("StarTrekMovies.txt");
		userTitle = ("No Data");
		userYear = 0;
		fileData = new ArrayList<String>();
		movieList = new ArrayList<Movie>();
		

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

	public static void main(String[] args) throws IOException, FileNotFoundException {
		// FIXME DO not hardcode
		String file = "StarTrekMovies.txt";

		FileReader fr = new FileReader(file);

		BufferedReader br = new BufferedReader(fr);
		
		

		// Always reads first line of the file into the first index of fileData
		// TODO: Change to try-catch
		String nextLine = br.readLine();

		while (nextLine != null) {
			fileData.add(nextLine);
		}

		ArrayList<String[]> parsedFileData = new ArrayList<String[]>();

		for (int i = 0; i < fileData.size(); i++) {

			parsedFileData.add(parseData(i));
			String[] tempArray = (String[]) parsedFileData.toArray();
			
			//i is the line where the movie is found in the file.
			Movie movie = new Movie(tempArray[0], tempArray[1], tempArray[2], i);
			movieList.add(movie);
		}
		
		
		
		

	}

	private static String[] parseData(int i) throws FileNotFoundException, IOException {

		String[] parsedData = new String[2];

		// Use string split to parse fileData

		String tempString = fileData.get(i);

		// Splits at an opening parenthesis
		String pattern = "\\(";
		String[] splitData = tempString.split(pattern);

		// Sets the first index of the split array as the title
		parsedData[0] = splitData[0];

		// Removes the closing parenthesis from the date.
		String movieDate = splitData[1];
		parsedData[1] = movieDate.replaceAll("\\)", "").trim();

		// Removes closing parenthesis and anything after.
		String releaseFormat = splitData[2];
		parsedData[2] = releaseFormat.replaceAll("\\).*", "").trim();

		

		return parsedData;
	}
}
