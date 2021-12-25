


import java.math.BigInteger;

/**
 *
 * @author Caleb
 */
public class p10 {

    public static void main(String[] args) {
        int counter = 0;
        BigInteger total = new BigInteger("0");
        int n = 2;
        while (true) {
            if (n == 2000000) {
                System.out.println(total.add(BigInteger.valueOf(10)));
                System.exit(0);
            }

            if (prime(n)) {
                total = total.add(BigInteger.valueOf(n));
            }
            n++;

        }
        
        
    }

    static boolean prime(int n) {
        for (int r = 2; r < Math.floor(Math.sqrt(n)) + 5; r++) {
            if (n % r == 0) {
                return false;
            }
        }
        return true;
    }
}
//confirmed.

