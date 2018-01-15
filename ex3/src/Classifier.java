import sun.reflect.generics.tree.ClassTypeSignature;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Matanel on 05/12/2017.
 * This abstract class use to define a search algorithm.
 * Every search algorithm can inherit from this class.
 */
public abstract class Classifier implements Algorithm
{
	// Final
	private static final String OUTPUT_FILE = "output.txt";

	// Members
	protected ArrayList<Point> m_pointsList;
	protected int m_clustersNumber;
	protected ArrayList<Cluster> m_clustersList;

	public void classify()
	{
		double minDistance = Double.MAX_VALUE;
		double distance = 0;
		for (Point point : m_pointsList)
		{
			for (Point otherPoint : m_pointsList)
			{
				if ((point != otherPoint))
				{
					//distance = distance(point, otherPoint); //TODO

					if (distance < minDistance)
					{
						minDistance = distance;
					}
				}
			}
		}
	}
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
