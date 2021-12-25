
import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p58 {

    public static void main(String[] args) {

        ArrayList<Double> primes = new ArrayList();
        ArrayList<Double> terms = new ArrayList();

        double middle = 1;
        terms.add(middle);

        double expression = 0.0;

        for (int n = 3; n <= 100001; n += 2) {

            for (int i = 0; i < 4; i++) {

                expression = Math.pow(n, 2) - (i * (n - 1));
                terms.add(expression);

                if (prime(expression)) {

                    primes.add(expression);
                }

                double ratio = (double) primes.size() / terms.size();

                if (ratio < 0.1 && n > 13) {

                    System.out.println(n);
                    System.exit(0);
                }
            }
        }
    }

    public static boolean prime(double n) {

        int count = 0;

        for (int i = 1; i < Math.ceil(Math.sqrt(n)) + 1; i++) {

            if (n % i == 0) {

                count++;
            }

            if (count == 1 && i + 1 == Math.ceil(Math.sqrt(n)) + 1) {

                return true;
            }

            if (n == 1) {

                return false;
            }

            if (n == 2) {

                return true;
            }
        }

        return false;
    }
}
//confirmed.

