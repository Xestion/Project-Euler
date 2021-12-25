

/**
 *
 * @author Caleb
 */
public class p86 {

    public static void main(String[] args) {

        int count = 0;
        double one;
        double two;
        boolean oneint;
        boolean twoint;

        for (int a = 1; a <= 10000; a++) {

            
            if (count > 1000000) {
                
                System.out.println(count + ", " + (a - 1));
                break;
            }
            
            for (int b = 1; b <= a; b++) {

                for (int c = 1; c <= b; c++) {

                    oneint = false;
                    twoint = false;

                    one = Math.sqrt(Math.pow(a, 2) + Math.pow((b + c), 2));
                    two = Math.sqrt(Math.pow(b, 2) + Math.pow((a + c), 2));

                    //if it's an int
                    if (one == (int) one) {

                        oneint = true;
                    }

                    //if it's an int
                    if (two == (int) two) {

                        twoint = true;
                    }

                    //both ints
                    if (oneint && twoint) {

                        count++;

                        //make sure int is smallest
                    } else if (oneint && !twoint && one < two) {

                        count++;

                        //make sure int is smallest
                    } else if (!oneint && twoint && two < one) {

                        count++;
                    }
                }
            }
        }
    }
}
