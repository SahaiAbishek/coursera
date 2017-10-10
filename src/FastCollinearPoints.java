import java.util.Arrays;

public class FastCollinearPoints {

	private LineSegment[] lineSegments = null;
	private int numberOfSegments = 0;

	// finds all line segments containing 4 or more points
	public FastCollinearPoints(Point[] points) {
		if (points == null) {
			throw new IllegalArgumentException();
		}

		lineSegments = new LineSegment[points.length];

		// check for overlapping points
		for (int i = 0; i < points.length; i++) {
			Point p = points[i];
			if (null == p) {
				throw new IllegalArgumentException();
			}
			Arrays.sort(points, i + 1, points.length, p.slopeOrder());

			//check duplicates
			for(int m = 0;m<points.length;m++){
				if(p.slopeTo(points[m])== Double.NEGATIVE_INFINITY){
					throw new IllegalArgumentException();
				}
			}
			
			// calculate slope with next point
			int consecutivecount = 0;
			double currentSlope = p.slopeTo(points[i + 1]);
			for (int j = i + 2; j < points.length; j++) {
				double nextSlope = p.slopeTo(points[j]);
				if (currentSlope == nextSlope) {
					consecutivecount++;
				} else {
					currentSlope = nextSlope;
					consecutivecount = 0;
				}
				if (consecutivecount >= 3) {
					lineSegments[numberOfSegments++] = new LineSegment(p, points[j]);
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
