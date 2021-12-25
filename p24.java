
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Caleb
 */
public class p24 {

    static ArrayList<String> result = new ArrayList<String>();

    public static void main(String[] args) {

        permutation("", "0123456789");
        Collections.sort(result);
        System.out.println(result.get(999999));
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

