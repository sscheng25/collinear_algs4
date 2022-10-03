/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    private final ArrayList<LineSegment> ls = new ArrayList<>();
    private Point[] sortedPs;

    public FastCollinearPoints(Point[] points) {
        // finds all line segments containing 4 or more points
        // null check
        if (points == null) throw new java.lang.IllegalArgumentException();
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) throw new java.lang.IllegalArgumentException();
        }
        // duplicate check
        Point[] dc = points.clone();
        Arrays.sort(dc);
        for (int i = 0; i < points.length - 1; i++) {
            if (dc[i].compareTo(dc[i + 1]) == 0) {
                throw new java.lang.IllegalArgumentException();
            }
        }

        // length check
        int len = points.length;
        if (len < 4) {
            return;
        }

        for (Point p : points) {
            sortedPs = points.clone();
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
                    if (i + 1 < len - 1) {
                        continue;
                    }
                }

                if (num >= 4) {
                    // add new segment
                    addSegments(p, start, end);
                }
                num = 2;
                start = i + 1;
            }
        }

    }

    private void addSegments(Point cur, int start, int end) {
        if (cur.compareTo(sortedPs[start]) > 0) {
            return;
        }
        ls.add(new LineSegment(cur, sortedPs[end]));
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
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
