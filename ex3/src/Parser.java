import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Matanel on 29/11/2017.
 * The Parser that read the input file and pass all the parameters
 * of the world to the map.
 */
public class Parser
{
	// Finals
	private static final String SINGLE_LINK = "single link";
	private static final String AVERAGE_LINK = "average link";

	// Members
	private int m_clustersNumber;
	private String m_classifier;
	private ArrayList<Point> m_pointsList;

	/**
	 * Constructor.
	 * @param inputFile The name of the input file.
	 */
	Parser(String inputFile)
	{
		// Create the reader.
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile)))
		{
			Point point;
			String fileCurrentLine;
			int clusterNumber = 0;
			m_pointsList = new ArrayList<>();
			m_classifier = reader.readLine();
			m_clustersNumber = Integer.parseInt(reader.readLine());

			// Generate the type string.
			while ((fileCurrentLine = reader.readLine()) != null)
			{
				clusterNumber++;
				String[] values = fileCurrentLine.split(",");
				point = new Point(Integer.parseInt(values[0]), Integer.parseInt(values[1]), clusterNumber);
				m_pointsList.add(point);
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Getter.
	 * @return The type string
	 */
	public ArrayList<Point> getPointsList() { return m_pointsList; }

	/**
	 * Getter.
	 * @return The algorithm.
	 */
	public Classifier getAlgorithm()
	{
		if (m_classifier.equals(SINGLE_LINK))
		{
			return new SingleLink(m_pointsList, m_clustersNumber);
		}
		if (m_classifier.equals(AVERAGE_LINK))
		{
			//TODO
			//return new AverageLink(m_pointsList, m_clustersNumber);
		}
		return null;
	}

	/**
	 * Getter.
	 * @return The clusters number.
	 */
	public int getClustersNumber() { return m_clustersNumber; }
}
