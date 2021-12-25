
import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p41 {

    static ArrayList<String> check = new ArrayList<String>();

    public static void main(String[] args) {

        int max = 0;

        for (int i = 1; i < 98000000; i++) {

            if (pandigital(i) && prime(i)) {

                if (i > max) {

                    max = i;
                }
            }
        }

        System.out.println(max);
    }

    public static boolean pandigital(int n) {

        String str = String.valueOf(n);

        for (int i = 0; i < str.length(); i++) {

            if (str.contains(String.valueOf(0))) {

                check.clear();
                return false;
            }

            if (!str.contains(String.valueOf(i + 1))) {

                check.clear();
                return false;
            }
            if (check.contains(String.valueOf(str.charAt(i)))) {

                check.clear();
                return false;
            }

            if (!check.contains(String.valueOf(str.charAt(i)))) {

                check.add(String.valueOf(str.charAt(i)));
            }

            if (i == str.length() - 1) {

                check.clear();
                return true;
            }
        }

        check.clear();
        return false;
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
}
//confirmed.

