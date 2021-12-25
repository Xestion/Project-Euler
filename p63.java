
import java.math.BigInteger;

/**
 *
 * @author Caleb
 */
public class p63 {

    public static void main(String[] args) {

        int count = 0;

        BigInteger expression = BigInteger.ZERO;

        for (int power = 1; power < 22; power++) {

            for (int base = 1; base < 10; base++) {

                expression = BigInteger.valueOf(base).pow(power);

                String str = String.valueOf(expression);

                if (str.length() == power) {

                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
