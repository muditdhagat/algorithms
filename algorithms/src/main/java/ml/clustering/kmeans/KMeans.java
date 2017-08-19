package ml.clustering.kmeans;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class KMeans {
	
	public static int MAX_ITERATIONS = 256;
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		KMeans kmeans = new KMeans();
		// Generate a test set of Points
		int totalDataPoints = 1500;
		List<Point> points = generateRandomPoints(totalDataPoints);
		System.out.println("## Initial Points ##");
		kmeans.printPoints(points);
		// Run the Clustering Algorithm specifying the number of Clusters needed.
		int numOfClusters = 5;
		List<Cluster> clusters = kmeans.doClustering(numOfClusters, points);
		// Print my points along with clusters
		printLine();
		System.out.println("## Cluster Details ## Total time taken " + (System.currentTimeMillis() - start) + " ms");
		printLine();
		int i = 0;
		for(Cluster cluster : clusters) {
			System.out.format("Cluster# %d  ", i++);
			System.out.print("Centroid: " + cluster.getCentroid().toString());
			System.out.println("Total# of Points in the cluster " + cluster.getPoints().size());
//			kmeans.printPoints(cluster.getPoints());
		}
	}
	
	private static List<Point> generateRandomPoints(int totalDataPoints) {
		List<Point> points = new ArrayList<>(totalDataPoints);
		for(int i = 0; i < totalDataPoints; i++) {
			double x = ThreadLocalRandom.current().nextDouble(100) + 1; // Qty
			double y = ThreadLocalRandom.current().nextDouble(2000) + 1; // Price 
			Point point = new Point(i, x, y);
			points.add(point);
		}
		return points;
	}
	
	private static List<Point> selectRandomPoints(int totalDataPoints) {
		List<Point> points = new ArrayList<>(totalDataPoints);
		for(int i = 0; i < totalDataPoints; i++) {
			double x = ThreadLocalRandom.current().nextInt(100) + 1; // Qty
			double y = ThreadLocalRandom.current().nextInt(2000) + 1; // Price 
			Point point = new Point(i, x, y);
			points.add(point);
		}
		return points;
	}

	public void printPoints(List<Point> points) {
		printLine();
		for(Point point : points) {
			System.out.println(point.toString());
		}
		printLine();
	}
	
	public void printClusters(List<Cluster> clusters) {
		printLine();
		int i = 0;
		for(Cluster cluster : clusters) {
			System.out.format("ClusterId %d ", i++);
			System.out.println(cluster.getCentroid().toString());
		}
		printLine();
	}
	
	List<Cluster> doClustering(int numClusters, List<Point> points) {
		// Create n clusters and assign random values for the means
		List<Cluster> clusters = new ArrayList<>(numClusters);
		for(int i = 0; i < numClusters; i++) {
			// Choose a random point from the points and assign
			int randomNum = ThreadLocalRandom.current().nextInt(0, points.size());
			Point point = points.get(randomNum);
			// Create a new Cluster 
			Cluster cluster = new Cluster(i, new Point(i, point.getX(), point.getY()), null);
			clusters.add(cluster);
		}
		
		System.out.println("## Initial Clusters ##");
		printClusters(clusters);
		
		
		boolean finish = false;
		int iterations = 0;
		List<Point> oldCentroids = new ArrayList<>(numClusters);
		
		while(!finish) {
			iterations++;
			printLine();
			System.out.println("Iteration# " + iterations);
			printLine();
			// Remove the current points assoc with clusters 
			for(Cluster cluster : clusters) {
				cluster.getPoints().clear();
			}
			// Clear OldCentroid list 
			oldCentroids.clear();
			for(Cluster cluster : clusters) {
				oldCentroids.add(new Point(cluster.getCentroid().getId(), cluster.getCentroid().getX(), cluster.getCentroid().getY()));
			}
			
			// Try to fit each of the data point in the groups
			int clusterId = 0;
			for(Point point : points) {
				double min = Double.MAX_VALUE;
				for(int i = 0; i < numClusters; i++) {
					Cluster cluster = clusters.get(i);
					double distance = cluster.distance(point, cluster.getCentroid());
					if(distance < min) {
						min = distance;
						clusterId = i;
					}
				}
				clusters.get(clusterId).addPoint(point);
				System.out.println("Added Point# " + point.getId() + " to Cluster# " + clusterId + " Distance: " + min);
			}
			
			printLine();
			System.out.println("## Updated Cluster Centroid Means ##");
			printLine();
			// Re Calculate the Centroids now for each Clusters
			int k = 0;
			for(Cluster cluster : clusters) {
				double sumX = 0;
				double sumY = 0;
				List<Point> clusterPoints = cluster.getPoints();
				
				for(Point point : clusterPoints) {
					sumX += point.getX();
					sumY += point.getY();
				}
				cluster.getCentroid().setX(sumX / clusterPoints.size());
				cluster.getCentroid().setY(sumY / clusterPoints.size());
				System.out.format("Cluster# %d New Mean Values: %f %f Old Mean Values: %f %f %n", k, cluster.getCentroid().getX(), cluster.getCentroid().getY(), oldCentroids.get(k).getX(), oldCentroids.get(k).getY());
				k++;
			}
			
			// Check the number of iterations and change in the mean values. 
			double distance = 0;
			if(iterations > MAX_ITERATIONS) {
				finish = true;
				break;
			}
			for(int i = 0; i < oldCentroids.size(); i++) {
				Point oldCentroid = oldCentroids.get(i);
				Point currentCentroid = clusters.get(i).getCentroid();
				distance += Math.sqrt(Math.pow(oldCentroid.getX() - currentCentroid.getX(), 2) + Math.pow(oldCentroid.getY() - currentCentroid.getY(), 2));
				
			}
			if(distance == 0) finish = true;
		}
		
		System.out.println("Total # of Iterations " + iterations);
		return clusters;
		
	}
	
	public static void printLine() {
		System.out.println("------------------------------------------------------------------------------");
	}

}
