
import java.math.BigDecimal;
import java.math.MathContext;


/**
 *
 * @author Caleb
 */
public class p26 {
    
    public static void main(String[] args) {
        
        //only need to consider primes, really
        int max = 0;
        int temp;
        int sol = 0;
        
        cycle(983);
        
        for (int n = 1000; n > 950; n--) {
            
            temp = cycle(n);
            
            if (temp > max) {
                
                max = temp;
                sol = n;
            }
        }
        
        System.out.println(sol);
    }
    
    public static int cycle(int n) {
        
        if (!isPrime(n)) {
            
            return 0;
        }
        
        final int prec = 5000;
        MathContext mc = new MathContext(prec);
        BigDecimal dec = new BigDecimal(n);
        
        dec = BigDecimal.ONE.divide(dec, mc);
        String str = dec.toString().substring(2);
        String one, two;
        
        
        for (int len = 2; len < prec/2; len++) {
            
            one = str.substring(0, len);
            two = str.substring(len, 2 * len);
            
            if (one.equals(two)) {
                
                return len;
            }
        }
        
        return 0;
    }
    
    public static boolean isPrime(int n) {

        if (n == 1) {

            return false;
        }

        if (n == 2) {

            return true;
        }

        if (n % 2 == 0) {

            return false;
        }

        for (int i = 3; i < Math.ceil(Math.sqrt(n)) + 1; i += 2) {

            if (n % i == 0) {

                return false;
            }
        }

        return true;
    }
}
//confirmed