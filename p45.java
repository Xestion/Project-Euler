
import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p45 {

    public static void main(String[] args) {

        ArrayList<Long> trilist = new ArrayList<Long>();
        ArrayList<Long> pentlist = new ArrayList<Long>();

        //triangle numbers, but only take every other for hex
        long trisum = 0;
        for (int a = 1; a < 80000; a++) {

            trisum += a;
            if (a % 2 != 0) {

                trilist.add(trisum);
            }
        }

        //pent numbers
        long pentsum = 0;
        for (int b = 1; b < 160000; b += 3) {

            pentsum += b;
            pentlist.add(pentsum);
        }

        for (int i = 286; i < trilist.size(); i++) {

            if (trilist.contains(pentlist.get(i))) {

                System.out.println(pentlist.get(i));
            }
        }
    }
}
//confirmed.

