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
	// Members
	private int m_clustersNumber;
	private String m_algorithm;
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
			m_pointsList = new ArrayList<>();
			m_algorithm = reader.readLine();
			m_clustersNumber = Integer.parseInt(reader.readLine());

			// Generate the type string.
			while ((fileCurrentLine = reader.readLine()) != null)
			{
				String[] values = fileCurrentLine.split(",");
				point = new Point(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
				m_pointsList.add(point);
			}

			System.out.println("Points list:\n" + m_pointsList);
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
	public String getAlgorithm() { return m_algorithm; }

	/**
	 * Getter.
	 * @return The clusters number.
	 */
	public int getClustersNumber() { return m_clustersNumber; }
}
