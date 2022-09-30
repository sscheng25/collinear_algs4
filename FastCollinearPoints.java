/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    private int size;
    private LineSegment[] lines;
    private final ArrayList<LineSegment> ls;

    public FastCollinearPoints(Point[] points) {
        // finds all line segments containing 4 or more points
        // null check
        if (points == null) throw new java.lang.IllegalArgumentException();

        Point[] sortedPs = points.clone();
        Arrays.sort(sortedPs);

        /*
        for (int p = 0; p < points.length; p++) {
            if (points[p] == null) throw new java.lang.IllegalArgumentException();
            double[] sl = new double[];
            for (int i = p + 1; i < points.length; i++) {
                sl[i - p - 1] = points[p].slopeTo(points[i]);
            }
            Arrays.sort(sl);
            for (int n = 0; n < sl.length; n++) {
                if (sl[n] == sl[n + 1] && sl[n] == sl[n + 2]) {
                    ls.add(new LineSegment(points[p], points[s]));
                }
            }
        }*/
    }

    public int numberOfSegments() {
        // the number of line segments
    }

    public LineSegment[] segments() {
        // the line segments
    }

    public static void main(String[] args) {

    }
}
