
/**
 *
 * @author Caleb
 */
public class p35 {

    public static void main(String[] args) {

        int counter = 0;

        for (int i = 2; i < 1000000; i++) {

            if (circular(i)) {

                counter++;
            }
        }

        System.out.println(counter + 1);
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

        }

        return false;
    }

    public static boolean circular(int n) {

        String str = String.valueOf(n);

        for (int index = 0; index < str.length(); index++) {

            str = str.substring(1, str.length()) + str.substring(0, 1);

            if (!prime(Integer.parseInt(str))) {

                return false;
            }

            if (Integer.parseInt(str) == n) {

                return true;
            }
        }

        return false;
    }
}
