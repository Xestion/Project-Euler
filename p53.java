
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p53 {

    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {

        BigInteger expression;

        for (int n = 0; n <= 100; n++) {

            for (int r = 0; r <= n; r++) {

                expression = factorial(n).divide(factorial(r).multiply(factorial(n - r)));

                if (expression.compareTo(BigInteger.valueOf(1000000)) == 1) {

                    list.add(String.valueOf(expression));
                }
            }
        }

        System.out.println(list);
        System.out.println(list.size());

    }

    static BigInteger factorial(int n) {

        if (n == 0) {

            return BigInteger.ONE;
        }

        BigInteger num = BigInteger.valueOf(n);

        for (int i = n - 1; i > 0; i--) {

            num = num.multiply(BigInteger.valueOf(i));
        }

        return num;
    }
}
//confirmed.
