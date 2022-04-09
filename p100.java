
public class p100 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        
        long num = 5, denom = 7, factor = num;
        long fnum, fdenom, temp;
        boolean fix = true;

        //generate continued fraction [0;1,2,2,2,2,2...] and so on
        //need to double num, then take reciprocal on odd # of 2's in the cont. frac.
        //after that, you need to "unsimplify" the fraction to get back the true number of discs in the event by some recursive relation
        //using the previous numerator as a factor to multiply the current fraction by
        
        long[] frac;

        while (true) {

            frac = getNextFrac(num, denom);

            num = frac[0];
            denom = frac[1];

            //every other fraction needs to be fixed
            if (fix) {

                temp = 2 * num;
                fnum = denom;
                fdenom = temp;

                //checking if total discs exceeds the threshold with a "fixed" fraction
                if (fdenom * factor >= Math.pow(10, 12)) {

                    System.out.println(fnum * factor + " blue discs");
                    long stop = System.currentTimeMillis();
                    System.out.println(stop - start + "ms");
                    System.exit(0);
                }

                factor = fnum;
            }
            
            else {

                //a different check for exceeding the threshold for "non-fixed" fractions
                if (denom * factor >= Math.pow(10, 12)) {

                    System.out.println(num * factor + " blue discs");
                    long stop = System.currentTimeMillis();
                    System.out.println(stop - start + "ms");
                    System.exit(0);
                }

                factor = num;
            }

            fix = !fix;
        }
    }

    private static long[] getNextFrac(long num, long denom) {

        long[] arr = new long[2];
        arr[0] = num + denom;
        arr[1] = 2 * num + denom;

        return arr;
    }
}
