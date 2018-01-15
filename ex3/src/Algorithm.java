/**
 * Created by Matanel on 05/12/2017.
 * This interface use to define an algorithm.
 * Every algorithm that claim to fit for this program - has to implement this interface.
 */
public interface Algorithm
{
	/**
	 * The classify method. Classifies the points into 'clusterNumber' number of clusters.
	 * @param clusterNumber the cluster numebers.
	 */
	void classify(int clusterNumber);

	/**
	 * The distance method. Finds the distance between the clusters.
	 * @param cluster1 the first cluster
	 * @param cluster2 the second cluster
	 * @return the distance between the clusters.
	 */
	double distance(Cluster cluster1, Cluster cluster2);

	/**
	 * Print the solution string to the output file.
	 * @param stringToPrint The solution string to print.
	 */
	void printToOutput(String stringToPrint);
}
