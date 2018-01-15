import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;

/**
 * Created by Matanel on 10/01/2018.
 */
public class SingleLink extends Classifier
{
	/**
	 * Constructor.
	 * @param pointsList the list of the point to classify.
	 * @param clustersNumber the number of clusters.
	 */
	public SingleLink(ArrayList<Point> pointsList, int clustersNumber)
	{
		m_pointsList = pointsList;
		m_clustersNumber = clustersNumber;
		m_clustersList = new ArrayList<Cluster>();
	}

	/**
	 * Classifies the points into 'clusterNumber' number of clusters.
	 * @param clusterNumber the cluster numbers.
	 */
	/*
	@Override
	public void classify(int clusterNumber)
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
	*/

	/**
	 * The distance function of the single link algorithm. Chooses the minimum distance
	 * between any two points in the clusters to be the distance between the clusters.
	 * @param cluster1 the first cluster
	 * @param cluster2 the second cluster
	 * @return the distance between the clusters.
	 */
	@Override
	public double distance(Cluster cluster1, Cluster cluster2)
	{
		double distance = Double.MAX_VALUE;
		double minDistance = Double.MAX_VALUE;

		for (Point point1 : cluster1.getPointsList())
		{
			for (Point point2 : cluster2.getPointsList())
			{
				distance = Math.sqrt((Math.pow(Math.abs(point1.getXVal()) - Math.abs(point2.getXVal()), TWO)) +
									  Math.pow(Math.abs(point1.getYVal()) - Math.abs(point2.getYVal()), TWO));
				if (distance < minDistance)
				{
					minDistance = distance;
				}
			}
		}
		return minDistance;
	}
}
