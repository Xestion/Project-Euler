
import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p52 {

    static ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 140000; i < 150000; i++) {

            result.clear();

            permutation("", String.valueOf(i));

            if (result.contains(String.valueOf(2 * i)) && result.contains(String.valueOf(3 * i)) && result.contains(String.valueOf(4 * i)) && result.contains(String.valueOf(5 * i)) && result.contains(String.valueOf(6 * i))) {

                System.out.println(i);
                System.exit(0);
            }
        }
    }

    static ArrayList<String> permutation(String f, String u) {

        if (u.length() == 0) {

            result.add(f);

            return result;
        }

        for (int i = 0; i < u.length(); i++) {

            String fixed = f + u.charAt(i);
            String unfixed = u.substring(0, i) + u.substring(i + 1);
            permutation(fixed, unfixed);
        }

        return result;
    }
}
//confirmed.

