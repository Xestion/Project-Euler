



import java.math.BigInteger;
import java.util.ArrayList;

public class p76 {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        ArrayList<Integer> genpents = new ArrayList();
        ArrayList<BigInteger> Partitions = new ArrayList();

        int getNthParts = 100; //enter what number you want the partitions of, preferably less than 1mil
        int ceiling = getNthParts + 1; //how high we check for integer partitions, needs to be 101 if you need 100
        int one;
        int two;   
        
        
        //load up the recurrence terms (not standard pent numbers, they alternate)
        for (int i = 1; i < 1000; i++) {

            one = i * ((3 * i) - 1) / 2;
            two = i * ((3 * i) + 1) / 2;
            genpents.add(one);
            genpents.add(two);
        }

        //add the first partition to get started (including base integer)
        Partitions.add(BigInteger.ONE); //partitions of 1

        for (int n = 2; n <= ceiling; n++) {

            BigInteger partitions = BigInteger.ZERO;
            int i = 0;
            int termDifference = genpents.get(i); //p(n) = p(n-1) + p(n-2) - p(n-5)..., so difference is 1, 2, 5, etc

            while (n - termDifference > 0) {

                //every 2 are ++
                if (i % 4 == 0 || i % 4 == 1) {

                    partitions = partitions.add(Partitions.get(n - termDifference - 1));
                } //the other 2 are --
                else {

                    partitions = partitions.subtract(Partitions.get(n - termDifference - 1));
                }

                i++;
                termDifference = genpents.get(i);
            }

            Partitions.add(partitions);
        }

        Partitions.remove(0); //to get rid of the repeat

        String str = String.valueOf(Partitions.get(getNthParts - 1).subtract(BigInteger.ONE));

        System.out.println(getNthParts + " has " + (Partitions.get(getNthParts - 1).subtract(BigInteger.ONE)) + " partitions, excluding the base integer");
        System.out.println("which has " + str.length() + " digit(s)");

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime + "ms");
    }
}
//confirmed.
