
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p29 {

    public static void main(String[] args) {

        ArrayList<BigInteger> list = new ArrayList<BigInteger>();
        ArrayList<BigInteger> finallist = new ArrayList<BigInteger>();

        for (int a = 2; a < 101; a++) {

            for (int b = 2; b < 101; b++) {

                list.add(BigInteger.valueOf(a).pow(b));
            }
        }

        for (int j = 0; j < list.size(); j++) {

            if (!finallist.contains(list.get(j))) {

                finallist.add(list.get(j));
            }
        }
        System.out.println(finallist.size());
    }

}
//confirmed.

