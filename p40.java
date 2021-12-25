
/**
 *
 * @author Caleb
 */
public class p40 {

    public static void main(String[] args) {

        String str = ("");

        int i = 1;

        while (str.length() < 1000004) {

            str = str + Integer.toString(i);

            i++;
        }

        int product = 0;

        product = Integer.parseInt(String.valueOf(str.charAt(0))) * Integer.parseInt(String.valueOf(str.charAt(9))) * Integer.parseInt(String.valueOf(str.charAt(99))) * Integer.parseInt(String.valueOf(str.charAt(999))) * Integer.parseInt(String.valueOf(str.charAt(9999))) * Integer.parseInt(String.valueOf(str.charAt(99999))) * Integer.parseInt(String.valueOf(str.charAt(999999)));

        System.out.println(product);
    }
}
//confirmed.

