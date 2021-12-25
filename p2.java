
import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p2 {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList();

        list.add(1);
        list.add(2);
        int sum = 0;
        int i = 2;
        while (list.get(i - 1) + list.get(i - 2) < 4000000) {

            list.add(list.get(i - 1) + list.get(i - 2));

            int term = list.get(i);

            if (term % 2 == 0) {

                sum += term;
            }

            i++;
        }

        System.out.println(list);
        System.out.println(sum + 2);
    }
}
//done.
