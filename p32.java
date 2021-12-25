
import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p32 {

    static ArrayList<Integer> list = new ArrayList<Integer>();
    static ArrayList<String> check = new ArrayList<String>();

    public static void main(String[] args) {

        int expression = 0;

        for (int a = 1; a < 10000; a++) {

            for (int b = 1; b < 10000; b++) {

                expression = a * b;

                if (pandigital(a, b, expression)) {

                    if (!list.contains(expression)) {

                        list.add(expression);
                    }
                }
            }
        }

        int sum = 0;
        for (int f = 0; f < list.size(); f++) {

            sum += list.get(f);
        }

        System.out.println(sum);
    }

    public static boolean pandigital(int n, int m, int o) {

        String str = (String.valueOf(n) + String.valueOf(m) + String.valueOf(o));

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

