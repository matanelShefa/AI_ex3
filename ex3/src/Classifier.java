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
	// Finals
	private static final String OUTPUT_FILE = "output.txt";
	protected static final int TWO = 2;

	// Members
	protected ArrayList<Point> m_pointsList;
	protected int m_clustersNumber;
	protected ArrayList<Cluster> m_clustersList;

	public void classify()
	{
		Cluster cluster1ToUnify = null;
		Cluster cluster2ToUnify = null;
		double distance;
		double minDistance;

		int i = 0;
		for (Point point : m_pointsList)
		{
			Cluster cluster = new Cluster(++i);
			cluster.addPoint(point);
			m_clustersList.add(cluster);
		}

		while(m_clustersList.size() > m_clustersNumber)
		{
			distance = Double.MAX_VALUE;
			minDistance = Double.MAX_VALUE;

			for (Cluster cluster1 : m_clustersList)
			{
				for (Cluster cluster2 : m_clustersList)
				{
					if (cluster1.getClusterID() != cluster2.getClusterID())
					{
						distance = distance(cluster1, cluster2);
						System.out.println("distace between cluster " + cluster1.getClusterID() + "& cluster " + cluster2.getClusterID() + " is: " + distance);
						System.out.println("mindistace is: " + minDistance);
						if (distance < minDistance)
						{
							minDistance = distance;
							cluster1ToUnify = cluster1;
							cluster2ToUnify = cluster2;
						}
					}
				}
			}

			System.out.println(distance);
			for (Point point : cluster2ToUnify.getPointsList())
			{
				cluster1ToUnify.addPoint(point);
			}

			m_clustersList.remove(cluster2ToUnify);

			System.out.println(m_pointsList);
		}

		String result = new String();
		for (Point point : m_pointsList)
		{
			result += point.getCluster() + "\n";
		}
		printToOutput(result);
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
