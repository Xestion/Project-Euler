
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class p75 {

    public static void main(String[] args) {

        ArrayList<Long> list = new ArrayList();
        Set<Long> repeats = new HashSet();

        long startTime = System.currentTimeMillis();

        for (int m = 2; m <= 880; m++) {

            for (int n = 1; n < m; n++) {

                if (!oddParity(m, n) || !coprime(m, n)) {

                    continue;
                }

                long a = (m * m - n * n);
                long b = 2 * m * n;
                long c = (m * m + n * n);
                long L = a + b + c;

                if (L <= 1500000) {

                    if (!list.contains(L)) {

                        list.add(L);
                    } else {

                        repeats.add(L);
                    }
                }
            }
        }

        Collections.sort(list);

        for (int d = 2; d <= 125000; d++) {

            System.out.println(d);

            for (int i = 0; i < list.size(); i++) {

                long L = list.get(i) * d;

                if (L > 1500000) {

                    break;
                }

                if (!list.contains(L)) {

                    list.add(L);
                } else {

                    repeats.add(L);
                }
            }
        }

        list.removeAll(repeats);
        Collections.sort(list);
        System.out.println(list);
        System.out.println(list.size());

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime + "ms");
    }

    public static boolean coprime(int m, int n) {

        for (int g = 3; g < Math.ceil(m / 2) + 1; g += 2) {

            if (m % g == 0 && n % g == 0) {

                return false;
            }
        }

        if (m % 2 == 0 && n % 2 == 0) {

            return false;
        }

        return true;
    }

    public static boolean oddParity(int m, int n) {

        if ((m + n) % 2 == 0) {

            return false;
        }

        return true;
    }
}
//confirmed

