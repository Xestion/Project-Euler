


/**
 *
 * @author Caleb
 */
public class p7 {

    public static void main(String[] args) {
        int counter = 0;
        int n = 2;
        while (true) {
            if (prime(n)) {
                //System.out.println(n);
                counter++;
            }
            if (counter == 10001) {
                System.out.println("The 10001st prime is " + n);
                System.exit(0);
            }
            n++;
        }
    }

    static boolean prime(int n) {
        for (int r = 2; r < Math.floor(Math.sqrt(n)) + 1; r++) {
            if (n % r == 0) {
                return false;
            }
        }
        return true;
    }
}
//confirmed.

