import java.util.ArrayList;
import java.util.Scanner;

public class MovieListApp {
	
	private static ArrayList<Movie> movies = MovieIO.getMovies();
	private static ArrayList<String> tempMovies = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("The Movie List application\n");
		System.out.println("Choose from " + MovieIO.getMovies().size() + " movies");

		System.out.println("Categories: drama | musical | scifi | horror | comedy | animated \n");
		
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {

			String category = ConsoleMovList.getString("Enter a category: ", "drama", "musical", "scifi","horror",
														"comedy","animated");		
			getMoviesOfACategory(category);
	
			choice = ConsoleMovList.getString("Continue? (y/n): ", "y", "n");
			System.out.println();
		}
		
		System.out.println("Bye!");
		sc.close();
	}

	public static void getMoviesOfACategory(String cat) {
		tempMovies.clear();
		System.out.println("\nHere's are all of the movies in the \""
							+cat+ "\" category from the main Movies list:");
		String title ="";
		for(Movie m: movies) {
			if((m.getCategory()).equals(cat)) {
			title = m.getTitle();
			tempMovies.add(title);
			}
		}	
		for (String t: tempMovies) {
			System.out.println(t);
		}
		System.out.println();
	}	
}
