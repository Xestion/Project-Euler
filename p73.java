
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Caleb
 */
public class p73 {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        ArrayList<Double> decimals = new ArrayList();

        for (int d = 2; d <= 12000; d++) {

            //the 2*n < d guarantees i'm not checking 1/2 or above
            for (int n = 1; 2 * n < d; n++) {

                double expression = (double) n / (double) d;

                //add if above 1/3
                if (expression > (double) 1 / (double) 3) {

                    decimals.add(expression);
                }
            }
        }

        //just sort
        Collections.sort(decimals);

        //i do this to remove repeats
        Set<Double> set = new HashSet<>(decimals);
        decimals.clear();
        decimals.addAll(set);
        System.out.println(decimals.size());
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime + "ms");
    }
}
//confirmed.

