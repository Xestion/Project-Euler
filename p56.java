
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p56 {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        int sum = 0;

        BigInteger expression = BigInteger.valueOf(0);

        for (int a = 1; a < 100; a++) {

            for (int b = 1; b < 100; b++) {

                expression = BigInteger.valueOf(a).pow(b);

                list.add(String.valueOf(expression));
            }
        }

        int max = 0;

        for (int i = 0; i < list.size(); i++) {

            sum = 0;

            for (int j = 0; j < list.get(i).length(); j++) {

                sum += Integer.parseInt(String.valueOf((list.get(i).charAt(j))));

                if (sum > max) {

                    max = sum;
                }
            }
        }

        System.out.println(max);
    }
}

//confirmed.
