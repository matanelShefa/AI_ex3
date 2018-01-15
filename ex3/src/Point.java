/**
 * Created by Matanel on 28/11/2017.
 * This class represent the location in the world. The x & y values
 * are the coordinates language of the world.
 */
public class Point
{
	// Members
	private final double m_xVal;
	private final double m_yVal;
	private Cluster m_cluster;

	/**
	 * Constructor
	 * @param xVal The x value.
	 * @param yVal The y value.
	 */
	public Point(double xVal, double yVal, Cluster cluster)
	{
		m_xVal = xVal;
		m_yVal = yVal;
		m_cluster = cluster;
	}

	/**
	 * Override of the toString function.
	 * @return the string to print.
	 */
	@Override
	public String toString() { return "(" + m_xVal + ", " + m_yVal + ", " + m_cluster.getClusterID() + ")"; }

	/**
	 * Setter.
	 * @param newCluster the new cluster to set.
	 */
	public void setCluster(Cluster newCluster) { m_cluster = newCluster; }

	/**
	 * Getter.
	 * @return The x value.
	 */
	public double getXVal() { return m_xVal; }

	/**
	 * Getter.
	 * @return The y value.
	 */
	public double getYVal() { return m_yVal; }

	/**
	 * Getter.
	 * @return The cluster number.
	 */
	public int getClusterID() { return m_cluster.getClusterID(); }
}
