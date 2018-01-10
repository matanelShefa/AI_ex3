/**
 * Created by Matanel on 28/11/2017.
 * This Program reads from a file, and gets an algorithm name and a board.
 * The program search for the goal using the algorithm specified in the file.
 */
public class java_ex3
{
	private static final String INPUT_FILE = "ex3/input.txt";

	/**
	 * The main function of the program.
	 * @param args none.
	 */
	public static void main(String [ ] args)
	{
		Parser parser = new Parser(INPUT_FILE);
		/*
		// Create the map from the file.
		Map map = new Map(INPUT_FILE);
		// Search for the goal.
		map.search();
		*/
	}
}