
/**
 *
 * @author Caleb
 */
public class p49 {

    public static void main(String[] args) {

        for (int i = 1000; i < 5000; i++) {

            if (prime(i)) {

                if (prime(i + 3330)) {

                    if (prime(i + 6660) && i + 6660 < 10000) {

                        System.out.println(i);
                        System.out.println(i + 3330);
                        System.out.println(i + 6660);
                    }
                }
            }
        }
    }

    public static boolean prime(int n) {

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
//need to manually sift out permutation
