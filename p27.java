
import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p27 {

    public static void main(String[] args) {

        ArrayList<Integer> liststreak = new ArrayList<Integer>();
        ArrayList<Integer> lista = new ArrayList<Integer>();
        ArrayList<Integer> listb = new ArrayList<Integer>();
        int max = 0;
        // System.out.println(prime(61));
        for (int b = 999; b > 1; b--) {

            for (int a = 999; a > -1000; a--) {

                int counter = 0;

                for (int n = 0; n < 1000; n++) {

                    double expression = 0;

                    expression = Math.pow(n, 2) + a * n + b;

                    if (prime(expression)) {

                        counter++;

                    } else {

                        break;
                    }

                }

                if (counter > max) {

                    liststreak.add(counter);
                    lista.add(a);
                    listb.add(b);
                    max = counter;
                    //System.out.println(counter);

                }
            }
        }

        System.out.println("max streak = " + max + " , a = " + lista.get(liststreak.indexOf(max)) + " , b = " + listb.get(liststreak.indexOf(max)));
        System.out.println(lista.get(liststreak.indexOf(max)) * listb.get(liststreak.indexOf(max)));
    }

    public static boolean prime(double m) {

        int count = 0;
        if (m == 2) {
            return true;

        }
        if (m == 1) {
            return false;

        }
        for (int i = 1; i < Math.sqrt(m) + 1; i++) {
            // System.out.println(17%i);
            if (m % i == 0) {

                count++;
            }

            if (count > 1) {

                return false;
            }
            //System.out.println(Math.sqrt(m) +" " + i);
            if (i == Math.ceil(Math.sqrt(m)) && count == 1) {

                return true;
            }
        }

        return false;
    }
}
