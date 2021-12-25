
import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p12 {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        //create a list to store data
        ArrayList<Integer> listtriangles = new ArrayList<Integer>();

        //create a loop to generate triangular numbers
        int triangle = 0;
        for (int i = 1; i < 20000; i++) {
            triangle = triangle + i;
            listtriangles.add(triangle);
        }

        //testing each triangle's congruencies and counts them
        for (int place = 1; place < 20000; place++) {

            //takes a triangle from the list and starts checking it
            int num = listtriangles.get(place - 1);
            int counter = 0;

            for (int mod = 1; mod <= Math.sqrt(num) + 1; mod++) {

                //checks for congruence, increasing the counter when found, resets it after all possible modulos have been checked
                if (num % mod == 0) {
                    counter++;
                    if (counter >= 252) {
                        System.out.println(num);
                        break;
                    }
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
//confirmed.

