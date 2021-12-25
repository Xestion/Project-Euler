
import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p74 {

    static ArrayList<Long> chain = new ArrayList();
    static ArrayList<Long> empty = new ArrayList();

    public static void main(String[] args) {

        int count = 0;

        for (int n = 1; n <= 1000000; n++) {

            chain.clear();
            getChain(n);
            int length = chain.size();

            if (length == 60) {

                count++;
            }
        }

        System.out.println(count);
    }

    public static ArrayList<Long> getChain(long n) {

        chain.add(n);

        String str = String.valueOf(n);

        long total = 0L;

        for (int i = 0; i < str.length(); i++) {

            total += factorial(Character.getNumericValue(str.charAt(i)));
        }

        if (chain.size() > 62) {

            return chain;
        }

        if (chain.contains(total)) {

            return chain;
        }

        getChain(total);

        return empty;
    }

    public static int factorial(int n) {

        int product = 1;

        while (n > 1) {

            product = product * n;
            n--;
        }

        return product;
    }
}
//confirmed.

