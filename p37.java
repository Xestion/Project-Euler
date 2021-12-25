
/**
 *
 * @author Caleb
 */
public class p37 {

    public static void main(String[] args) {

        int sum = 0;

        for (int i = 11; i < 1000000; i++) {

            if (prime(i) && truncatable(i)) {

                sum += i;
                System.out.println(i);
            }
        }

        System.out.println(sum);
    }

    public static boolean prime(int n) {

        int count = 0;
        
        if (n == 2) {
            
            return true;
        }

        for (int i = 1; i < Math.ceil(Math.sqrt(n)) + 1; i++) {

            if (n % i == 0) {

                count++;
            }

            if (count > 1) {

                return false;
            }

            if (count == 1 && i + 1 == Math.ceil(Math.sqrt(n)) + 1 && i != 1) {

                return true;
            }

        }

        return false;
    }

    public static boolean truncatable(int n) {

        String str = String.valueOf(n);
        String temp = str;

        for (int i = 1; i < temp.length(); i++) {

            str = String.valueOf(n);
            str = str.substring(i, temp.length());

            if (!prime(Integer.parseInt(str))) {

                return false;
            }

            if (i + 1 == temp.length()) {

                break;
            }
        }

        str = String.valueOf(n);
        temp = str;

        for (int i = temp.length() - 1; i > 0; i--) {

            str = String.valueOf(n);
            str = str.substring(0, i);

            if (!prime(Integer.parseInt(str))) {

                return false;
            }

            if (i == 1) {

                return true;
            }
        }

        return false;
    }
}
//confirmed, add 23 to answer??.

