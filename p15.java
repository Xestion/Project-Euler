
import java.math.BigInteger;


/**
 *
 * @author Caleb
 */
public class p15 {
    
    public static void main(String[] args) {
        
        //result is simply 40 choose 20
        BigInteger result = choose(40, 20);
        System.out.println(result);
    }

    public static BigInteger choose(int m, int n) {
        
        return fact(m).divide(fact(m - n).multiply(fact(n)));
    }
    
    public static BigInteger fact(int n) {
        
        BigInteger prod = BigInteger.ONE;
        
        while (n > 0) {
            
            prod = prod.multiply(BigInteger.valueOf(n));
            n--;
        }
        
        return prod;
    }
}
