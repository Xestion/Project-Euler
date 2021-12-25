
import java.math.BigInteger;

/**
 *
 * @author Caleb
 */
public class p16 {

    public static void main(String[] args) {

        BigInteger base;
        base = BigInteger.valueOf(2);
        int power = 1000;

        String str = String.valueOf(base.pow(power));
        int sum = 0;

        for (int i = 0; i < 302; i++) {
            sum = sum + Character.getNumericValue(str.charAt(i));
        }
        System.out.println(sum);
        System.out.println(str.length());
        System.out.println(str);
    }
}
//confirmed.

