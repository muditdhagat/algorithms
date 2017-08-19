package ml.clustering.kmeans;

import java.util.ArrayList;
import java.util.List;

public class Cluster {
	
	int id;
	Point centroid;
	List<Point> points;
	
	public Cluster(int id, Point centroid, List<Point> points) {
		super();
		this.id = id;
		this.centroid = centroid;
		if(points == null) {
			this.points = new ArrayList<>();
		}
		else {
			this.points = points;			
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Point getCentroid() {
		return centroid;
	}
	
	public void addPoint(Point point) {
		points.add(point);
	}

	public void setCentroid(Point centroid) {
		this.centroid = centroid;
	}

	public double distance(Point pointA, Point pointB) {
		return Math.sqrt(Math.pow(pointA.getX() - pointB.getX(), 2) + Math.pow(pointA.getY() - pointB.getY(), 2));
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}
	
	
}
