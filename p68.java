
import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p68 {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        ArrayList<Integer> list = new ArrayList();

        int a, b, c, d, e, f, g, h, i;

        for (a = 1; a < 10; a++) {

            for (b = 1; b < 10; b++) {

                if (b == a) {

                    continue;
                }

                for (c = 1; c < 10; c++) {

                    if (c == b || c == a) {

                        continue;
                    }

                    for (d = 1; d < 10; d++) {

                        if (d == c || d == b || d == a) {

                            continue;
                        }

                        for (e = 1; e < 10; e++) {

                            if (e == d || e == c || e == b || e == a) {

                                continue;
                            }

                            for (f = 1; f < 10; f++) {

                                if (f == e || f == d || f == c || f == b || f == a) {

                                    continue;
                                }

                                for (g = 1; g < 10; g++) {

                                    if (g == f || g == e || g == d || g == c || g == b || g == a) {

                                        continue;
                                    }

                                    for (h = 1; h < 10; h++) {

                                        if (h == g || h == f || h == e || h == d || h == c || h == b || h == a) {

                                            continue;
                                        }

                                        for (i = 1; i < 10; i++) {

                                            if (i == h || i == g || i == f || i == e || i == d || i == c || i == b || i == a) {

                                                continue;
                                            }

                                            int one = 10 + a + b;
                                            int two = c + b + d;
                                            int three = e + d + f;
                                            int four = g + f + h;
                                            int five = i + h + a;

                                            if (one == two && one == three && one == four && one == five) {

                                                String strone = String.valueOf(10) + String.valueOf(a) + String.valueOf(b);
                                                String strtwo = String.valueOf(c) + String.valueOf(b) + String.valueOf(d);
                                                String strthree = String.valueOf(e) + String.valueOf(d) + String.valueOf(f);
                                                String strfour = String.valueOf(g) + String.valueOf(f) + String.valueOf(h);
                                                String strfive = String.valueOf(i) + String.valueOf(h) + String.valueOf(a);

                                                System.out.println(strone + ", " + strtwo + ", " + strthree + ", " + strfour + ", " + strfive);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime + "ms");
    }
}
//confirmed.

