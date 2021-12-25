
import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p46 {

    static ArrayList<Integer> listcomp = new ArrayList<Integer>();

    public static void main(String[] args) {

        ArrayList<Integer> listgold = new ArrayList<Integer>();

        double expression = 0;
        int ceiling = 6000;

        //iterating all possible combos
        for (int a = 1; a <= ceiling; a += 2) {

            for (int b = 0; b < Math.ceil(Math.sqrt(a)) + 1; b++) {

                for (int c = 0; c < a; c++) {

                    expression = 2 * Math.pow(b, 2) + c;

                    if (expression == a && !prime(a) && !listgold.contains(a) && prime(c)) {

                        listgold.add(a);
                    }
                }
            }
        }

        for (int i = 2; i <= ceiling; i++) {

            if (!prime(i) && i % 2 != 0) {

                listcomp.add(i);
            }
        }

        System.out.println(listgold);
        System.out.println(listcomp);

        for (int j = 0; j < listcomp.size(); j++) {

            if (!listgold.contains(listcomp.get(j))) {

                System.out.println(listcomp.get(j));
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

        }

        return false;
    }
}
//confirmed.

