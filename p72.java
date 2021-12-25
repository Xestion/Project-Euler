
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p72 {

    public static void main(String[] args) {

        ArrayList<Integer> primelist = new ArrayList();
        ArrayList<Integer> factors = new ArrayList();

        int ceiling = 1000000;

        for (int p = 2; p < ceiling; p++) {

            if (prime(p)) {

                primelist.add(p);
            }
        }

        BigInteger total = BigInteger.ZERO;

        for (int n = 2; n <= ceiling; n++) {

            factors.clear();
            int smallestfact = 2;

            for (int i = 0; i < primelist.size(); i++) {

                if (n % primelist.get(i) == 0) {

                    factors.add(primelist.get(i));
                    continue;
                }

                if (factors.size() == 1) {

                    smallestfact = factors.get(0);
                }

                if (primelist.get(i) > Math.floor(n / smallestfact)) {

                    int phiValue = getPhi(n, factors);

                    if (n % 100000 == 0) {

                        System.out.println("n = " + n + ", phi = " + phiValue);
                    }

                    total = total.add(BigInteger.valueOf(phiValue));
                    break;
                }
            }
        }

        System.out.println(total);

    }

    public static int getPhi(int n, ArrayList<Integer> factors) {

        if (prime(n)) {

            return n - 1;
        }

        double phi = n;

        for (int i = 0; i < factors.size(); i++) {

            phi = phi * (1d - 1d / ((double) factors.get(i)));
        }

        int phiValue = (int) Math.floor(phi);

        return phiValue;
    }

    public static boolean prime(int n) {

        int count = 0;

        for (int i = 1; i < Math.ceil(Math.sqrt(n)) + 1; i++) {

            if (n % i == 0) {

                count++;
            }

            if (count > 1) {

                return false;
            }

            if (count == 1 && i + 1 == Math.ceil(Math.sqrt(n)) + 1) {

                return true;
            }

            if (n == 2) {

                return true;
            }
        }

        return false;
    }

}
//confirmed.

