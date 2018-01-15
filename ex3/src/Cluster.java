import java.util.ArrayList;

/**
 * Created by Matanel on 14/01/2018.
 */
public class Cluster
{
	// Members
	private ArrayList<Point> m_pointsList;
	private int m_clusterID;

	/**
	 * Constructor.
	 * @param clusterID the cluster ID.
	 */
	Cluster(int clusterID)
	{
		m_pointsList = new ArrayList<Point>();
		m_clusterID = clusterID;
	}

	/**
	 * Add a new point to the cluster.
	 * @param point the point to add to the cluster.
	 */
	public void addPoint(Point point)
	{
		m_pointsList.add(point);
		point.setCluster(m_clusterID);
	}

	/**
	 * Remove point from the cluster.
	 * @param point the point to remove from the cluster.
	 */
	public void removePoint(Point point) { m_pointsList.remove(point); }

	/**
	 *
	 * @param other
	 * @return
	 */

	/**
	 * Getter.
	 * @return the points list of the cluster.
	 */
	public ArrayList<Point> getPointsList() { return m_pointsList; }

	/**
	 * Getter.
 	 * @return the cluster ID
	 */
	public int getClusterID() { return m_clusterID; }
}
