


/**
 *
 * @author Caleb
 */
public class p3 {

    public static void main(String args[]) {

        long value = 600851475143L;

        for (int i = (int) Math.ceil(Math.sqrt(value)); i > 3; i -= 2) {

            if (value % i == 0 && prime(i)) {

                System.out.println(i);
                System.exit(0);
            }
        }
    }

    public static boolean prime(int n) {

        if (n == 2) {

            return true;
        }

        if (n % 2 == 0) {

            return false;
        }

        for (int i = 3; i < Math.ceil(Math.sqrt(n)); i += 2) {

            if (n % i == 0) {

                return false;
            }
        }

        return true;
    }
}
//done.
