/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
    private final ArrayList<LineSegment> ls;

    public BruteCollinearPoints(Point[] points) {
        // finds all line segments containing 4 points
        // null check
        if (points == null) throw new java.lang.IllegalArgumentException();

        // duplicate check
        /*
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) throw new java.lang.IllegalArgumentException();
            for (int j = 0; j < points.length; j++) {
                if (points[i].compareTo(points[j]) == 0) {
                    if (points[j] == null) throw new java.lang.IllegalArgumentException();
                    throw new java.lang.IllegalArgumentException();
                }
            }
        }
        */

        Point[] ps = points.clone();
        ls = new ArrayList<>();
        Arrays.sort(ps);

        for (int p = 0; p < points.length - 3; p++) {
            for (int q = p + 1; q < points.length - 2; q++) {
                for (int r = q + 1; r < points.length - 1; r++) {
                    if (ps[p].slopeTo(ps[q]) == ps[p].slopeTo(ps[r])) {
                        for (int s = r + 1; s < points.length; s++) {
                            if (ps[p].slopeTo(ps[q]) == ps[p].slopeTo(ps[s])) {
                                ls.add(new LineSegment(ps[p], ps[s]));
                            }
                        }

                    }
                }
            }
        }

    }

    public int numberOfSegments() {
        // the number of line segments
        return ls.size();
    }

    public LineSegment[] segments() {
        // the line segments
        return ls.toArray(new LineSegment[ls.size()]);
    }

    public static void main(String[] args) {

    }
}
