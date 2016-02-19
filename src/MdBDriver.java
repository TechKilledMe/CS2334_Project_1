
/**
 * Project #1
 * CS2334
 * 2/5/16
 * @version 1.0
 * 
 * The main class of the project which will parse the data given in the .txt file and store the movies in an ArrayList.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class MdBDriver {

	/**
	 * User defined string of what movie they are searching for.
	 */
	private static String userTitle;

	/**
	 * User defined integer of the year of release of the movie they are
	 * searching for.
	 */
	private int userYear;

	/**
	 * ArrayList in which each element is a new line in the file storing the
	 * movies.
	 */
	public static ArrayList<String> fileData = new ArrayList<String>();

	/**
	 * A list containing the movie objects.
	 */
	public static List<Movie> movieList = new ArrayList<Movie>();

	/**
	 * Default constructor
	 * 
	 */
	public MdBDriver() {
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
	 *         found or -1 if it wasn't found.
	 */
	public static int findMovieWithTitle(String userTitle, ArrayList<String> fileData) {
		int returnIndex = Collections.binarySearch(fileData, userTitle);
		if (returnIndex >= 0) {
			return returnIndex;
		} else
			return -1;

	}

	public static void main(String[] args) throws IOException, FileNotFoundException {

		String file = args[0];

		Scanner input = new Scanner(System.in);

		String userEntry;

		FileReader fr = new FileReader(file);

		BufferedReader br = new BufferedReader(fr);

		// Always reads first line of the file into the first index of fileData
		// TODO: Change to try-catch
		String nextLine = br.readLine();

		while (br.readLine() != null) {
			fileData.add(nextLine);
			nextLine = br.readLine();
		}

		Collections.sort(fileData);

		br.close();

		ArrayList<String[]> parsedFileData = new ArrayList<String[]>();

		for (int i = 0; i < fileData.size(); i++) {

			parsedFileData.add(parseData(i));
			String[] tempArray = parseData(i);

			// i is the line where the movie is found in the file.
			Movie movie = new Movie(tempArray[0], tempArray[1], tempArray[2], i);
			movieList.add(movie);
		}

		System.out.println("Welcome to the MdB Database!");

		System.out.println("Would you like to search for a movie? Y or N:");
		userEntry = input.nextLine();

		while (userEntry.equalsIgnoreCase("Y")) {
			System.out.println("What movie are you searching for?");
			System.out.println("Title of Movie: ");

			userTitle = input.nextLine();
			int movieLocation = findMovieWithTitle(userTitle, fileData);
			if (movieLocation >= 0) {
				Movie requestedMovie = movieList.get(movieLocation);
				System.out.println("Title: " + requestedMovie.getTitle());
				System.out.println("Date: " + requestedMovie.getDate());
				System.out.println("Release Format: " + requestedMovie.getReleaseFormat());
			} else {
				System.out.println("Movie not found.");
			}

			System.out.println("Would you like to search for a movie? Y or N:");
			userEntry = input.next();

			if (userEntry.equalsIgnoreCase("N")) {
				System.out.println("Goodbye!");
				System.exit(0);

			}

		}

	}

	private static String[] parseData(int i) throws FileNotFoundException, IOException {

		String[] parsedData = new String[3];

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
		if (splitData.length < 3) {
			parsedData[2] = "No Format Given";
		} else {
			String releaseFormat = splitData[2];
			parsedData[2] = releaseFormat.replaceAll("\\).*", "").trim();
		}

		return parsedData;
	}
}
