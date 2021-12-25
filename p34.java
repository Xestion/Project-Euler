
/**
 *
 * @author Caleb
 */
public class p34 {

    public static void main(String[] args) {

        int firstsum = 0;
        int ceiling = 1000000;

        for (int i = 23; i < ceiling; i++) {

            if (factorialsum(i) == i) {

                firstsum += i;
            }

            if (i == ceiling - 1) {

                System.out.println(firstsum);
            }
        }
    }

    public static int factorialsum(int n) {

        String str = String.valueOf(n);
        int factorial = 1;
        int finalsum = 0;

        for (int i = 0; i < str.length(); i++) {

            factorial = 1;

            for (int j = Integer.parseInt(String.valueOf(str.charAt(i))); j > 1; j--) {

                factorial = factorial * j;
            }

            finalsum += factorial;
        }

        return finalsum;
    }

}
//confirmed.

