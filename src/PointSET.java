import java.util.Set;
import java.util.TreeSet;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.Stack;

public class PointSET {

	private Set<Point2D> points = null;

	// construct an empty set of points
	public PointSET() {
		points = new TreeSet<>();
	}

	// is the set empty?
	public boolean isEmpty() {
		return points.size() == 0;
	}

	// number of points in the set
	public int size() {
		return points.size();
	}

	// add the point to the set (if it is not already in the set)
	public void insert(Point2D p) {
		if (p == null) {
			throw new IllegalArgumentException();
		}
		points.add(p);

	}

	// does the set contain point p?
	public boolean contains(Point2D p) {
		if (p == null) {
			throw new IllegalArgumentException();
		}
		return points.contains(p);
	}

	// draw all points to standard draw
	public void draw() {
		for (Point2D point : points) {
			point.draw();
		}
	}

	// all points that are inside the rectangle (or on the boundary)
	public Iterable<Point2D> range(RectHV rect) {
		if (rect == null) {
			throw new IllegalArgumentException();
		}
		Stack<Point2D> stk = new Stack<>();
		for (Point2D point : points) {
			if (rect.contains(point)) {
				stk.push(point);
			}
		}
		return stk;
	}

	// a nearest neighbor in the set to point p; null if the set is empty
	public Point2D nearest(Point2D p) {
		if (p == null) {
			throw new IllegalArgumentException();
		}
		double min = Double.MAX_VALUE;
		Point2D retPoint = p;
		for (Point2D that : points) {
			double dist = p.distanceTo(that);
			if (dist < min) {
				min = dist;
				retPoint = that;
			}
		}
		return retPoint;
	}

	// unit testing of the methods (optional)
	public static void main(String[] args) {

	}
}
