

import java.math.BigInteger;

/**
 *
 * @author Caleb
 */
public class p97 {
    
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        BigInteger brute = new BigInteger("2");
        BigInteger mod = new BigInteger("10000000000");
        
        brute = brute.pow(7830457).multiply(BigInteger.valueOf(28433)).add(BigInteger.ONE).mod(mod);
        long end = System.currentTimeMillis() - start;
        System.out.println(brute);
        System.out.println(end + "ms");
        
        
    }
}
