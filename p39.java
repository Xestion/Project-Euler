
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Caleb
 */
public class p39 {

    public static void main(String[] args) {

        int a, b, c, p;

        ArrayList<Integer> list = new ArrayList<Integer>();

        for (p = 3; p <= 1000; p++) {

            for (a = 1; a < 450; a++) {

                for (b = 1; b < 550; b++) {

                    for (c = 1; c < 650; c++) {

                        if (a + b + c == p && Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {

                            list.add(p);
                            //System.out.println("a = " + a + ", b = " + b + ", and c = " + c + ", and p = " + p);   
                        }
                    }
                }
            }
        }

        Collections.sort(list);

        int mode = 0;
        int max = 0;
        for (int i = 0; i < 1000; i++) {

            int count = 0;

            for (int j = 0; j < list.size(); j++) {

                if (list.get(j) == i) {

                    count++;
                }
            }

            if (count > max) {

                max = count;
                mode = i;
            }

        }

        System.out.println(mode);
    }
}
//confirmed.

