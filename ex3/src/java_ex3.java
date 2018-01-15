/**
 * Created by Matanel on 28/11/2017.
 * This Program reads from a file, and gets an algorithm name, a list of points and a number.
 * The program Classifies the points into clusters using the algorithm specified in the file.
 */
public class java_ex3
{
	private static final String INPUT_FILE = "input3.txt";

	/**
	 * The main function of the program.
	 * @param args none.
	 */
	public static void main(String [ ] args)
	{
		// Read the input from the file.
		Parser parser = new Parser(INPUT_FILE);
		// Run the algorithm.
		parser.getAlgorithm().classify();
	}
}