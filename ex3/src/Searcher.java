import java.io.*;

/**
 * Created by Matanel on 05/12/2017.
 * This abstract class use to define a search algorithm.
 * Every search algorithm can inherit from this class.
 */
public abstract class Searcher implements Algorithm
{
	// Finals
	protected static final String NO_PATH = "no path";
	private static final String OUTPUT_FILE = "output.txt";

	/**
	 * Print the solution string to the output file.
	 * @param stringToPrint The solution string to print.
	 */
	public void printToOutput(String stringToPrint)
	{
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(OUTPUT_FILE), "utf-8"))) {
			writer.write(stringToPrint);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
