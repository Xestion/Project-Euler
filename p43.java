
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Caleb
 */
public class p43 {

    static ArrayList<String> result = new ArrayList<String>();

    public static void main(String[] args) {

        permutation("", "0123456789");
        Collections.sort(result);
        BigInteger sum = new BigInteger("0");
        for (int a = 0; a < result.size(); a++) {

            sum = sum.add(new BigInteger(result.get(a)));
        }

        System.out.println(sum);
    }

    static ArrayList<String> permutation(String f, String u) {

        if (u.length() == 0) {

            if (Integer.parseInt(f.substring(1, 4)) % 2 == 0) {

                if (Integer.parseInt(f.substring(2, 5)) % 3 == 0) {

                    if (Integer.parseInt(f.substring(3, 6)) % 5 == 0) {

                        if (Integer.parseInt(f.substring(4, 7)) % 7 == 0) {

                            if (Integer.parseInt(f.substring(5, 8)) % 11 == 0) {

                                if (Integer.parseInt(f.substring(6, 9)) % 13 == 0) {

                                    if (Integer.parseInt(f.substring(7, 10)) % 17 == 0) {

                                        result.add(f);
                                        return result;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < u.length(); i++) {

            String fixed = f + u.charAt(i);
            String unfixed = u.substring(0, i) + u.substring(i + 1);
            permutation(fixed, unfixed);
        }
        return result;

    }
}
