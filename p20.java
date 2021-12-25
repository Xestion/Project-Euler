
import java.math.BigInteger;

/**
 *
 * @author Caleb
 */
public class p20 {

    public static void main(String[] args) {

        String str = new String("0");
        BigInteger factorial = BigInteger.ONE;

        //the factorial you want to use
        int totalFactorial = 100;

        //create loop for multiplying 1 through 100 together
        for (int i = 1; i < totalFactorial + 1; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));

            //once the loop is done, set str = factorial
            if (i == totalFactorial) {
                str = String.valueOf(factorial);
            }
        }

        //summing together the digits of the factorial
        int sum = 0;
        for (int j = 0; j < str.length(); j++) {
            sum += Character.getNumericValue(str.charAt(j));

            //print only the final sum
            if (j == str.length() - 1) {
                System.out.println(sum);
            }
        }
    }
}
//confirmed.

