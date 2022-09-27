/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
    private int size;
    private LineSegment[] lines;
    private final ArrayList<LineSegment> ls;

    public BruteCollinearPoints(Point[] points) {
        // finds all line segments containing 4 points
        // null check
        if (points == null) throw new java.lang.IllegalArgumentException();

        // duplicate check
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) throw new java.lang.IllegalArgumentException();
            for (int j = 0; j < points.length; j++) {
                if (points[i].compareTo(points[j]) == 0) {
                    if (points[j] == null) throw new java.lang.IllegalArgumentException();
                    throw new java.lang.IllegalArgumentException();
                }
            }
        }
        Point[] ps = points.clone();
        ls = new ArrayList<>();
        Arrays.sort(ps);
        int len = ps.length;
        for (int p = 0; p < points.length - 3; p++) {
            for (int q = p + 1; q < points.length - 2; q++) {
                for (int r = q + 1; r < points.length - 1; r++) {
                    if (ps[p].slopeTo(ps[q]) == ps[q].slopeTo(ps[r])) {
                        for (int s = r + 1; s < points.length; s++) {
                            if (ps[p].slopeTo(ps[q]) == ps[r].slopeTo(ps[s])) {
                                /*
                                Point[] segs = new Point[4];
                                segs[0] = ps[p];
                                segs[1] = ps[q];
                                segs[2] = ps[r];
                                segs[3] = ps[s];
                                Arrays.sort(segs);
                                 */
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
        size = ls.size();
        return size;
    }

    public LineSegment[] segments() {
        // the line segments
        return ls.toArray(new LineSegment[ls.size()]);
    }

    public static void main(String[] args) {

    }
}
