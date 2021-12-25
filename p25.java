
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p25 {

    public static void main(String[] args) {

        //start an array with initial conditions
        ArrayList<String> list = new ArrayList<String>();
        list.add(0, String.valueOf(1));
        list.add(1, String.valueOf(1));

        for (int i = 2; i < 50000; i++) {

            //create strings for each term to be added
            String prevstr = list.get(i - 1);
            String secprevstr = list.get(i - 2);

            //convert each to bigint's
            BigInteger previous = new BigInteger(prevstr);
            BigInteger secprevious = new BigInteger(secprevstr);

            //add each new term to a list
            list.add((secprevious.add(previous)).toString());

            //exit condition
            if (list.get(i).length() == 1000) {

                //add one to i since the array is started at (1, 1, ....), not (0, 1, 1, ....)
                System.out.println(i + 1);
                break;

            }
        }
    }
}
//confirmed.

