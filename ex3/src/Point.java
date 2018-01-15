/**
 * Created by Matanel on 28/11/2017.
 * This class represent the location in the world. The x & y values
 * are the coordinates language of the world.
 */
public class Point
{
	// Members
	private final int m_xVal;
	private final int m_yVal;
	private int m_clusterID;

	/**
	 * Constructor
	 * @param xVal The x value.
	 * @param yVal The y value.
	 */
	public Point(int xVal, int yVal, int cluster)
	{
		m_xVal = xVal;
		m_yVal = yVal;
		m_clusterID = cluster;
	}

	/**
	 * Override of the toString function.
	 * @return the string to print.
	 */
	@Override
	public String toString() { return "(" + m_xVal + ", " + m_yVal + ", " + m_clusterID + ")"; }

	/**
	 * Setter.
	 * @param newCluster the new cluster to set.
	 */
	public void setCluster(int newCluster) { m_clusterID = newCluster; }

	/**
	 * Getter.
	 * @return The x value.
	 */
	public int getXVal() { return m_xVal; }

	/**
	 * Getter.
	 * @return The y value.
	 */
	public int getYVal() { return m_yVal; }

	/**
	 * Getter.
	 * @return The cluster number.
	 */
	public int getCluster() { return m_clusterID; }
}
