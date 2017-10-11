import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {
	// private int numberOfSegments = 0;
	private List<LineSegment> lineSegments = new ArrayList<>();

	// finds all line segments containing 4 points
	public BruteCollinearPoints(Point[] points) {
		if (points == null) {
			throw new IllegalArgumentException();
		}

		for(int i = 0; i < points.length; i++){
			if(null == points[i]){
				throw new IllegalArgumentException();
			}
		}
		
		Arrays.sort(points);

		for (int i = 1; i < points.length; i++) {
			if (points[i].compareTo(points[i - 1]) == 0) {
				throw new IllegalArgumentException();
			}
		}

		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				for (int k = j + 1; k < points.length; k++) {
					for (int l = k + 1; l < points.length; l++) {
						if ((points[i].slopeTo(points[j]) == points[i].slopeTo(points[k]))
								&& (points[i].slopeTo(points[j]) == points[i].slopeTo(points[l]))) {

							lineSegments.add(new LineSegment(points[i], points[l]));
						}
					}
				}
			}
		}

	}

	// the number of line segments
	public int numberOfSegments() {
		return lineSegments.size();
	}

	// the line segments
	public LineSegment[] segments() {
		LineSegment[] segments = new LineSegment[lineSegments.size()];
		return lineSegments.toArray(segments);
	}
}
