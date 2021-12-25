
/**
 *
 * @author Caleb
 */
public class p9 {

    public static void main(String[] args) {
        int a, b, c;

        for (a = 1; a < 1000; a++) {
            for (b = 1; b < 1000; b++) {
                for (c = 1; c < 1000; c++) {
                    if (a + b + c == 1000 && Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
                        System.out.println("a = " + a + ", b = " + b + ", and c = " + c);
                        System.out.println(a * b * c);
                        System.exit(0);
                    }
                }
            }
        }
    }
}
//confirmed