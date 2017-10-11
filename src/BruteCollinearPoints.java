public class BruteCollinearPoints {
	private int numberOfSegments = 0;
	private LineSegment[] lineSegments = null;

	// finds all line segments containing 4 points
	public BruteCollinearPoints(Point[] points) {
		if (points == null) {
			throw new IllegalArgumentException();
		}

		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				if (points[i].compareTo(points[j]) == 0) {
					throw new IllegalArgumentException("Duplicated entries in given points.");
				}
			}
		}

		lineSegments = new LineSegment[points.length];
		numberOfSegments = 0;
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				for (int k = j + 1; k < points.length; k++) {
					for (int l = k + 1; l < points.length; l++) {
						if ((points[i].slopeTo(points[j]) == points[i].slopeTo(points[k]))
								&& (points[i].slopeTo(points[j]) == points[i].slopeTo(points[l]))) {

							numberOfSegments++;
							lineSegments[numberOfSegments] = new LineSegment(points[i], points[l]);
							lineSegments[numberOfSegments].draw();
						}
					}
				}
			}
		}

	}

	// the number of line segments
	public int numberOfSegments() {
		return numberOfSegments;
	}

	// the line segments
	public LineSegment[] segments() {
		return lineSegments;
	}
}
