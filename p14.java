
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Caleb
 */
public class p14 {

    public static void main(String[] args) {

        //create a list to sort
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> listtwo = new ArrayList<Integer>();

        //create a loop counting down from 1 million
        for (int i = 1; i < 1000000; i++) {

            int counter = 1;
            BigInteger n = BigInteger.valueOf(i);
            BigInteger two = new BigInteger("2");
            BigInteger zero = new BigInteger("0");

            //ensure you stop at 1 to not loop infnitely
            while (n.compareTo(BigInteger.ONE) == 1) {

                if (n.mod(two).compareTo(zero) == 0) {
                    n = n.divide(two);

                    //make sure you count on both operations
                    counter++;
                } else {
                    //System.out.println(n);
                    n = BigInteger.valueOf(3).multiply(n);
                    n = n.add(BigInteger.valueOf(1));

                    //counting each operation
                    counter++;
                }

            }

            //by experiementing the highest result I've come across is 395 so I just wanted a smaller array list I guess
            if (counter > 1) {
                list.add(counter);
                listtwo.add(i);

            }

        }

        //I wanted it in descending order
        System.out.println(listtwo.get(list.indexOf(Collections.max(list))));
    }
}
