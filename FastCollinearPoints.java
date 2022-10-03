/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    private final ArrayList<LineSegment> ls = new ArrayList<>();

    public FastCollinearPoints(Point[] points) {
        // finds all line segments containing 4 or more points
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
        
        int len = points.length;

        for (Point p : points) {
            Point[] sortedPs = points.clone();
            Arrays.sort(sortedPs, p.slopeOrder());
            int start = 1;
            int end = 1;
            int num = 2;
            double slopeA;
            double slopeB = p.slopeTo(sortedPs[1]);

            for (int i = 1; i < len - 1; i++) {
                slopeA = slopeB;
                slopeB = p.slopeTo(sortedPs[i + 1]);

                if (Double.compare(slopeA, slopeB) == 0) {
                    num++;
                    end = i + 1;
                    if (i - 1 < len - 1) {
                        continue;
                    }
                }

                if (num >= 4) {
                    // add new segment
                    ls.add(new LineSegment(sortedPs[start], sortedPs[end]));
                }
                num = 2;
                start = i + 1;
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
