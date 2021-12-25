
import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p50 {

    static ArrayList<Integer> primelist = new ArrayList();

    public static void main(String[] args) {

        ArrayList<Integer> maxlist = new ArrayList();
        ArrayList<Integer> streaklist = new ArrayList();

        for (int i = 2; i < 10000; i++) {

            if (prime(i)) {

                primelist.add(i);
            }
        }

        int sum = 0;
        int max = 0;
        int count = 0;

        for (int j = 0; j < primelist.size(); j++) {

            count = 0;
            sum = 0;

            for (int k = 0; k < primelist.size() - j; k++) {

                sum += primelist.get(j + k);

                if (prime(sum)) {

                    count = k + 1;
                }

                if (count > max && sum < 1000000) {

                    max = count;
                    maxlist.clear();
                    streaklist.clear();
                    maxlist.add(sum);
                    streaklist.add(max);
                }
            }
        }

        System.out.println(maxlist);
        System.out.println(streaklist);
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

