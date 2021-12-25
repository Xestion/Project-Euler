
import java.math.BigInteger;


/**
 *
 * @author Caleb
 */
public class p55 {

    public static void main(String[] args) {

        BigInteger i = BigInteger.valueOf(1);

        int sum = 0;

        for (i = BigInteger.valueOf(1); i.compareTo(BigInteger.valueOf(10000)) < 0; i = i.add(BigInteger.valueOf(1))) {

            int m = Integer.parseInt(String.valueOf(i));

            String n = String.valueOf(i);

            BigInteger j = i;

            int count = 0;

            while (count < 55) {

                if (palindrome(String.valueOf(j.add(reverse(n))))) {

                    break;
                }

                if (!palindrome(String.valueOf(j.add(reverse(n))))) {

                    j = j.add(reverse(n));
                    n = String.valueOf(j);
                    count++;
                }

                if (count > 50) {

                    sum += 1;
                    break;
                }
            }
        }

        System.out.println(sum);
    }

    public static BigInteger reverse(String n) {

        String str = String.valueOf(n);

        String revstr = "";

        String[] array = new String[str.length()];

        int m = 0;

        int i = 0;

        for (i = str.length() - 1; i >= 0; i--) {

            array[i] = Character.toString(str.charAt(m));

            m++;
        }

        for (int j = 0; j <= str.length() - 1; j++) {

            revstr = revstr + array[j];

        }

        BigInteger reverse = new BigInteger(revstr);

        return reverse;
    }

    static boolean palindrome(String n) {

        String numstr = n;

        String reversestr = "";

        String[] arr = new String[numstr.length()];

        int m = 0;

        int i = 0;

        for (i = numstr.length() - 1; i >= 0; i--) {

            arr[i] = Character.toString(numstr.charAt(m));

            m++;
        }

        for (int j = 0; j <= numstr.length() - 1; j++) {

            reversestr = reversestr + arr[j];

        }

        if (reversestr.equals(numstr)) {

            return true;
        } else {

            return false;
        }
    }
}
//confirmed.

