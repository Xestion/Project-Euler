
import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p51 {

    public static void main(String[] args) {

        ArrayList<String> primelist = new ArrayList();

        for (int i = 2; i < 130000; i++) {

            if (prime(i)) {

                String str = String.valueOf(i);

                if (Integer.parseInt(Character.toString(str.charAt(str.length() - 1))) == 3 && hasRepeats(i)) {

                    primelist.add(String.valueOf(i));
                }
            }
        }

        //System.out.println(primelist);
        //array for storing digits
        ArrayList<Character> test = new ArrayList<Character>();

        //search each prime, then each character
        for (int i = 0; i < primelist.size(); i++) {

            for (int j = 0; j < 10; j++) {

                int count = 0;

                for (int k = 0; k < 10; k++) {

                    if (prime(Integer.parseInt(primelist.get(i).replace(Integer.toString(j), Integer.toString(k))))) {
                        count++;
                    }
                }

                if (count == 8) {
                    System.out.println(primelist.get(i));
                    System.out.println();
                }
            }
        }
    }

    //prime checker
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

    //repeat checker
    public static boolean hasRepeats(int n) {

        ArrayList<Character> repeatcheck = new ArrayList();

        String str = String.valueOf(n);

        for (int i = 0; i < str.length(); i++) {

            if (repeatcheck.contains(str.charAt(i))) {

                return true;
            }

            if (!repeatcheck.contains(str.charAt(i))) {

                repeatcheck.add(str.charAt(i));
            }

            if (i + 1 == str.length()) {

                return false;
            }
        }

        return false;
    }
}
//confirmed.

