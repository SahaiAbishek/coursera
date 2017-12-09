import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

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

	private boolean contains(Node root, Point2D p, boolean vert) {
		if (root == null) {
			return false;
		}
		if (root.point.equals(p)) {
			return true;
		}

		int cmp = 0;
		if (vert) {
			cmp = Point2D.X_ORDER.compare(root.point, p);
		} else {
			cmp = Point2D.Y_ORDER.compare(root.point, p);
		}
		if (cmp > 0)
			return contains(root.left, p, !vert);
		else
			return contains(root.right, p, !vert);
	}

	// does the set contain point p?
	public boolean contains(Point2D p) {

		return contains(root,p,true);
	}

	 private void draw(Node x, boolean vert) {
	        if (x.left != null)     draw(x.left, !vert);
	        if (x.right != null)    draw(x.right, !vert);

	        // draw the point first
	        StdDraw.setPenColor(StdDraw.BLACK);
	            StdDraw.setPenRadius(.01);
	            StdDraw.point(x.point.x(), x.point.y());

	            // draw the line
	            double xmin, ymin, xmax, ymax;
	            if (vert) {
	                StdDraw.setPenColor(StdDraw.RED);
	                xmin = x.point.x();
	                xmax = x.point.x();
	                ymin = x.rect.ymin();
	                ymax = x.rect.ymax();
	            } else {
	                StdDraw.setPenColor(StdDraw.BLUE);
	                ymin = x.point.y();
	                ymax = x.point.y();
	                xmin = x.rect.xmin();
	                xmax = x.rect.xmax();
	            }
	            StdDraw.setPenRadius();
	            StdDraw.line(xmin, ymin, xmax, ymax);
	    }

	    // draw all of the points to standard draw
	    public void draw() {
	        // draw the rectangle
	        StdDraw.rectangle(0.5, 0.5, 0.5, 0.5);
	        if (isEmpty()) return;
	        draw(root, true);
	    }


	private void range(Node x, RectHV rect, Queue<Point2D> q) {
        if (x == null)
            return;
        if (rect.contains(x.point))
            q.enqueue(x.point);
        if (x.left != null && rect.intersects(x.left.rect))
            range(x.left, rect, q);
        if (x.right != null && rect.intersects(x.right.rect))
            range(x.right, rect, q);
    }

    // all points in the set that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect) {
        Queue<Point2D> q = new Queue<Point2D>();
        range(root, rect, q);
        return q;
    }
	

    private Point2D nearest(Node x, Point2D p, Point2D mp, boolean vert) {
        Point2D min = mp;

        if (x == null)    return min;
        if (p.distanceSquaredTo(x.point) < p.distanceSquaredTo(min))
            min = x.point;

        // choose the side that contains the query point first
        if (vert) {
            if (x.point.x() < p.x()) {
                min = nearest(x.right, p, min, !vert);
                if (x.left != null
                        && (min.distanceSquaredTo(p)
                            > x.left.rect.distanceSquaredTo(p)))
                    min = nearest(x.left, p, min, !vert);
            } else {
                min = nearest(x.left, p, min, !vert);
                if (x.right != null
                        && (min.distanceSquaredTo(p)
                         > x.right.rect.distanceSquaredTo(p)))
                    min = nearest(x.right, p, min, !vert);
            }
        } else {
            if (x.point.y() < p.y()) {
                min = nearest(x.right, p, min, !vert);
                if (x.left != null
                        && (min.distanceSquaredTo(p)
                            > x.left.rect.distanceSquaredTo(p)))
                    min = nearest(x.left, p, min, !vert);
            } else {
                min = nearest(x.left, p, min, !vert);
                if (x.right != null
                        && (min.distanceSquaredTo(p)
                            > x.right.rect.distanceSquaredTo(p)))
                    min = nearest(x.right, p, min, !vert);
            }
        }
        return min;
    }

    // a nearest neighbor in the set to p: null if set is empty
    public Point2D nearest(Point2D p) {
        if (isEmpty()) return null;
        return nearest(root, p, root.point, true);
    }

	// unit testing of the methods (optional)
	public static void main(String[] args) {

	}
}
