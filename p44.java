
import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p44 {

    public static void main(String[] args) {

        ArrayList<Integer> pentagons = new ArrayList<Integer>();

        int pentagon = 0;
        for (int i = 1; i <= 10000; i += 3) {

            pentagon += i;
            pentagons.add(pentagon);
        }

        System.out.println(pentagons);

        for (int a = 0; a < pentagons.size(); a++) {

            for (int b = 0; b < pentagons.size(); b++) {

                if (pentagons.contains(pentagons.get(a) + pentagons.get(b)) && pentagons.contains(pentagons.get(a) - pentagons.get(b))) {

                    System.out.println(Math.abs(pentagons.get(a) - pentagons.get(b)));
                }
            }
        }
    }
}
//confirmed.

