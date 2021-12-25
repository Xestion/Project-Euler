
import java.math.BigInteger;

/**
 *
 * @author Caleb
 */
public class p57 {

    public static void main(String[] args) {

        BigInteger numerator = BigInteger.valueOf(0);

        BigInteger denominator = BigInteger.valueOf(0);

        BigInteger a = BigInteger.valueOf(3);

        BigInteger b = BigInteger.valueOf(2);

        int count = 0;

        for (int i = 1; i <= 1000; i++) {

            numerator = a.add(b.multiply(BigInteger.valueOf(2)));

            denominator = a.add(b);

            a = numerator;

            b = denominator;

            if (numerator.toString().length() > denominator.toString().length()) {
                count++;
            }
        }

        System.out.println(count);
    }
}
//confirmed.
