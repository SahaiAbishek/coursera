import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

public class KdTree {

	private class Node {
		private Point2D point;
		private RectHV rect;
		private Node left, right;

		public Node(Point2D point, RectHV rect) {
			if (rect == null) {
				rect = new RectHV(0, 0, 1, 1);
			}
			this.point = point;
			this.rect = rect;
		}
	}

	private Node root;
	private int size;

	// construct an empty set of points
	public KdTree() {
		root = null;
		size = 0;
	}

	// is the set empty?
	public boolean isEmpty() {
		return size == 0;
	}

	// number of points in the set
	public int size() {
		return size;
	}

	private Node insertVerticle(Node node, Point2D p, RectHV r) {
		if (node == null) {
			size++;
			return new Node(p, r);
		}

		if (node.point.equals(p)) {
			return node;
		}

		RectHV rect;
		int compare = Point2D.X_ORDER.compare(node.point, p);
		if (compare > 0) {
			if (node.left == null) {
				rect = new RectHV(r.xmin(), r.ymin(), r.xmax(), r.ymax());
			} else {
				rect = node.left.rect;
				node.left = insertHorizontal(node.left, p, rect);
			}

		} else {
			if (node.right == null) {
				rect = new RectHV(r.xmin(), r.ymin(), r.xmax(), r.ymax());
			} else {
				rect = node.right.rect;
				node.right = insertHorizontal(node.right, p, rect);
			}
		}

		return node;
	}

	private Node insertHorizontal(Node node, Point2D p, RectHV r) {
		if (node == null) {
			size++;
			return new Node(p, r);
		}

		if (p.equals(node.point)) {
			return node;
		}

		int comp = Point2D.Y_ORDER.compare(node.point, p);
		RectHV rect;
		if (comp > 0) {
			if (node.left == null) {
				rect = new RectHV(r.xmin(), r.ymin(), r.xmax(), r.ymax());
			} else {
				rect = node.left.rect;
				node.left = insertVerticle(node.left, p, rect);
			}
		} else {
			if (node.right == null) {
				rect = new RectHV(r.xmin(), r.ymin(), r.xmax(), r.ymax());
			} else {
				rect = node.right.rect;
				node.right = insertVerticle(node.right, p, rect);
			}
		}

		return node;
	}

	// add the point to the set (if it is not already in the set)
	public void insert(Point2D p) {
		if (isEmpty()) {
			root = insertVerticle(root, p, null);
		} else {
			root = insertVerticle(root, p, root.rect);
		}
		return;

	}

	// does the set contain point p?
	public boolean contains(Point2D p) {

		return false;
	}

	// draw all points to standard draw
	public void draw() {

	}

	// all points that are inside the rectangle (or on the boundary)
	public Iterable<Point2D> range(RectHV rect) {

		return null;
	}

	// a nearest neighbor in the set to point p; null if the set is empty
	public Point2D nearest(Point2D p) {
		return null;
	}

	// unit testing of the methods (optional)
	public static void main(String[] args) {

	}
}
