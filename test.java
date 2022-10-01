/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        Point ps[] = new Point[4];
        ps[0] = new Point(1, 2);
        ps[1] = new Point(2, 4);
        ps[2] = new Point(3, 2);
        ps[3] = new Point(4, 4);

        Point[] sortedPs = ps.clone();
        /*
        Arrays.sort(sortedPs, ps[0].slopeOrder());
        Arrays.sort(sortedPs);
        */
        Arrays.sort(sortedPs, ps[3].slopeOrder());

        for (int i = 0; i < 4; i++) {
            StdOut.println(sortedPs[i].toString());
            StdOut.println('\n');
        }
    }
}
