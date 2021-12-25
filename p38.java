
import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p38 {

    static ArrayList<String> check = new ArrayList<String>();

    public static void main(String[] args) {

        int count = 0;
        int max = 0;
        int prod = 0;

        for (int a = 1; a < 10000; a++) {

            String str = "";

            int b = 1;

            count = 1;

            while (str.length() < 9) {

                prod = a * b;
                str += Integer.toString(prod);
                b++;
            }

            if (str.length() > 9) {

                continue;
            }

            if (!pandigital(Integer.parseInt(str))) {

                continue;
            }

            if (Integer.parseInt(str) > max) {

                max = Integer.parseInt(str);
            }
        }

        System.out.println(max);
    }

    public static boolean pandigital(int n) {

        String str = String.valueOf(n);

        for (int i = 0; i < str.length(); i++) {

            if (str.contains(String.valueOf(0))) {

                return false;
            }

            if (check.contains(String.valueOf(str.charAt(i)))) {

                check.clear();
                return false;
            }

            if (!check.contains(String.valueOf(str.charAt(i)))) {

                check.add(String.valueOf(str.charAt(i)));
            }

            if (i == str.length() - 1 && str.length() == 9) {

                check.clear();
                return true;
            }
        }

        check.clear();
        return false;
    }
}
//confirmed.

