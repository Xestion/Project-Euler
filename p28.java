
/**
 *
 * @author Caleb
 */
public class p28 {

    public static void main(String[] args) {

        int sum = 0;

        for (int n = 3; n <= 1001; n += 2) {

            for (int i = 0; i < 4; i++) {

                sum += Math.pow(n, 2) - (i * (n - 1));
            }
        }

        System.out.println(sum + 1);

    }
}
//confirmed.

