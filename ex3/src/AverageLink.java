import java.util.ArrayList;

/**
 * Created by Matanel on 15/01/2018.
 */
public class AverageLink extends Classifier
{
	/**
	 * Constructor.
	 * @param pointsList the list of the point to classify.
	 * @param clustersNumber the number of clusters.
	 */
	AverageLink(ArrayList<Point> pointsList, int clustersNumber)
	{
		m_pointsList = pointsList;
		m_clustersNumber = clustersNumber;
		m_clustersList = new ArrayList<Cluster>();
	}

	/**
	 * The distance function of the single link algorithm. Chooses the average locations distance
	 * of all the points in the clusters to be the distance between the clusters.
	 * @param cluster1 the first cluster
	 * @param cluster2 the second cluster
	 * @return the distance between the clusters.
	 */
	@Override
	public double distance(Cluster cluster1, Cluster cluster2)
	{
		double sumXFirst = 0;
		double sumYFirst = 0;
		double averageXFirst;
		double averageYFirst;
		double sumXSecond = 0;
		double sumYSecond = 0;
		double averageXSecond;
		double averageYSecond;

		for (Point point : cluster1.getPointsList())
		{
			sumXFirst += point.getXVal();
			sumYFirst += point.getYVal();
		}
		averageXFirst = sumXFirst / cluster1.getPointsList().size();
		averageYFirst = sumYFirst / cluster1.getPointsList().size();

		for (Point point : cluster2.getPointsList())
		{
			sumXSecond += point.getXVal();
			sumYSecond += point.getYVal();
		}
		averageXSecond = sumXSecond / cluster2.getPointsList().size();
		averageYSecond = sumYSecond / cluster2.getPointsList().size();

		return Math.sqrt((Math.pow(Math.abs(averageXFirst) - Math.abs(averageXSecond), TWO)) +
						  Math.pow(Math.abs(averageYFirst) - Math.abs(averageYSecond), TWO));
	}
}
