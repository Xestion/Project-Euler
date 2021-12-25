
import java.math.BigInteger;

/**
 *
 * @author Caleb
 */
public class p48 {

    public static void main(String[] args) {

        BigInteger expression = new BigInteger("0");

        for (int b = 1; b < 1001; b++) {

            expression = expression.add(BigInteger.valueOf(b).pow(b));
        }

        System.out.println(expression);
    }
}
//confirmed.

