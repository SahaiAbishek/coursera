import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {

	private List<LineSegment> lineSegments = new ArrayList<>();

	// finds all line segments containing 4 or more points
	public FastCollinearPoints(Point[] points) {
		if (points == null) {
			throw new IllegalArgumentException();
		}

		Arrays.sort(points);
		for (int i = 1; i < points.length; i++) {
			if (points[i].compareTo(points[i - 1]) == 0) {
				throw new IllegalArgumentException();
			}
		}

		Point[] aux  = Arrays.copyOf(points, points.length);
		for (int i = 0; i < points.length-1; i++) {
			Point p = aux[i];
			if (null == p) {
				throw new IllegalArgumentException();
			}
			Arrays.sort(points);
			Arrays.sort(points,i+1,points.length, p.slopeOrder());

			// calculate slope with next point
			int consecutivecount = 1;
			int j=i;
			double currentSlope = p.slopeTo(points[j]);
			for (j = j+1; j < points.length; j++) {
				double nextSlope = p.slopeTo(points[j]);
				if (currentSlope == nextSlope) {
					consecutivecount++;
				} else {
//					if(consecutivecount>=3){
//						break;
//					}
					currentSlope = nextSlope;
					consecutivecount = 1;
				}
				if (consecutivecount >= 3) {
					lineSegments.add(new LineSegment(p, points[j]));
					break;
				}
			}
			
		}
		
	/*	
		  // finds all line segments containing 4 or more points
        if (points == null) throw new NullPointerException();
        Point[] aux = Arrays.copyOf(points, points.length);
        for (int i = 0; i < points.length; i++) {
            Point p = points[i];
            Arrays.sort(aux);
            Arrays.sort(aux, p.slopeOrder());

            int min = 0;
            while (min < aux.length && p.slopeTo(aux[min]) == Double.NEGATIVE_INFINITY) min++;
            if (min != 1) throw new IllegalArgumentException();// check duplicate points
            int max = min;
            while (min < aux.length) {
                while (max < aux.length && p.slopeTo(aux[max]) == p.slopeTo(aux[min])) max++;
                if (max - min >= 3) {
                    Point pMin = aux[min].compareTo(p) < 0 ? aux[min] : p;
                    Point pMax = aux[max - 1].compareTo(p) > 0 ? aux[max - 1] : p;
                    if (p == pMin)
                    	lineSegments.add(new LineSegment(pMin, pMax));
                }
                min = max;
            }
        }*/

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
