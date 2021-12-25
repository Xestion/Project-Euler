
/**
 *
 * @author Caleb
 */
public class p36 {

    public static void main(String[] args) {

        int sum = 0;

        for (int i = 1; i < 1000000; i++) {

            if (decimalPalindrome(i) && binaryPalindrome(i)) {

                sum += i;
            }
        }

        System.out.println(sum);
    }

    public static boolean decimalPalindrome(int n) {

        String str = String.valueOf(n);
        String revstr = new String("");

        for (int j = str.length() - 1; j > -1; j--) {

            revstr = revstr + String.valueOf(str.charAt(j));
        }

        if (Integer.parseInt(str) == Integer.parseInt(revstr)) {

            return true;
        }
        return false;
    }

    public static boolean binaryPalindrome(int n) {

        String str = Integer.toBinaryString(n);
        String revstr = new String("");

        for (int k = str.length() - 1; k > -1; k--) {

            revstr = revstr + String.valueOf(str.charAt(k));
        }

        if (str.equals(revstr)) {

            return true;
        }
        return false;
    }
}
//confirmed.

