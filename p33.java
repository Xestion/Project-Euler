
/**
 *
 * @author Caleb
 */
public class p33 {

    public static void main(String[] args) {

        double truevalue = 0;

        for (double a = 1; a < 10; a++) {

            for (double b = 1; b < 10; b++) {

                for (double c = 1; c < 10; c++) {

                    for (double d = 1; d < 10; d++) {

                        truevalue = (10.0 * a + b) / (10.0 * c + d);

                        if (truevalue == a / d && b == c && truevalue < 1) {

                            System.out.println("a = " + a + ", b = " + b + ", c = " + c + ", d = " + d);
                        }
                    }
                }
            }
        }
    }
}
//confirmed.

