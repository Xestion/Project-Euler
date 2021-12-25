

import java.math.BigInteger;

/**
 *
 * @author Caleb
 */
public class p94 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        
        int i = 2;
        long sum = 0;
        BigInteger ss, s;
        while (i < 1000000000 / 6) {

            ss = BigInteger.valueOf(3).multiply(BigInteger.valueOf(i)).add(BigInteger.ONE).multiply(BigInteger.valueOf(i).add(BigInteger.ONE));
            s = ss.sqrt();
            if (s.multiply(s).compareTo(ss) == 0) {
                
                sum += 6 * i + 2;
                System.out.println(String.valueOf(2 * i) + ", " + String.valueOf(2 * i + 1) + ", " + String.valueOf(2 * i + 1));
                i = (int) Math.floor(0.95 * i * ( 2 + Math.sqrt(3))) - 3;
                continue;
            }
            
            ss = BigInteger.valueOf(3).multiply(BigInteger.valueOf(i)).subtract(BigInteger.ONE).multiply(BigInteger.valueOf(i).subtract(BigInteger.ONE));
            s = ss.sqrt();
            if (s.multiply(s).compareTo(ss) == 0) {
                
                sum += 6 * i - 2;
                System.out.println(String.valueOf(2 * i) + ", " + String.valueOf(2 * i - 1) + ", " + String.valueOf(2 * i - 1));
                i = (int) Math.floor(0.95 * i * (2 + Math.sqrt(3))) - 3;
            }
            
            i++;
        }

        System.out.println(sum);
        
        long stop = System.currentTimeMillis();
        System.out.println(stop - start + "ms");
    }

}
