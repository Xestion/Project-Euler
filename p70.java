
import java.util.ArrayList;




/**
 *
 * @author Caleb
 */
public class p70 {

    public static void main(String[] args) {
        
        int val, sol = 0;
        double dec;
        double min = Integer.MAX_VALUE;
        ArrayList<Integer> primes = getPrimes((int)Math.pow(10, 7) / 2 + 1);
        
        for (int n = 2; n < Math.pow(10, 7); n++) {
            
            val = phi(n, primes);
            
            if (isPermute(n, val)) {
                
                dec = (double) n / val;
                
                if (dec < min) {
                    
                    min = dec;
                    sol = n;
                }
            }
        }
        
        System.out.println(sol);
    }
    
    public static boolean isPermute(Integer n, Integer val) {
        
        int[] one = new int[10];
        int[] two = new int[10];
        
        for (int i = 0; i < n.toString().length(); i++) {
            
            one[Character.getNumericValue(n.toString().charAt(i))]++;
        }
        
        for (int i = 0; i < val.toString().length(); i++) {
            
            two[Character.getNumericValue(val.toString().charAt(i))]++;
        }
        
        for (int i = 0; i < one.length; i++) {
            
            if (one[i] != two[i]) {
                
                return false;
            }
        }
        
        return true;
    }
    
    public static int phi(int n, ArrayList<Integer> primes) {
        
        ArrayList<Integer> factors = new ArrayList<>();
        int temp = n;
        
        if (isPrime(n)) {
            
            return n - 1;
        }
        
        int i = 0;
        
        while (temp != 1) {
            
            if (temp % primes.get(i) == 0) {
                
                temp /= primes.get(i);
                factors.add(primes.get(i));
            }
            
            else if (isPrime(temp)) {
                
                factors.add(temp);
                temp = 1;
            }
            
            else {
                
                i++;
            }
        }
        
        for (int j = 0; j < factors.size(); j++) {
            
            n *= (1 - (double) 1 / factors.get(j));
        }

        return n;
    }
    
    public static ArrayList<Integer> getPrimes(int n) {

        ArrayList<Integer> primes = new ArrayList<>();
        boolean prime[] = new boolean[n + 1];

        for (int p = 2; p * p <= n; p++) {

            if (!prime[(int) p]) {

                for (int i = p * p; i <= n; i += p) {

                    prime[i] = true;
                }
            }
        }

        for (int i = 2; i <= n; i++) {

            if (!prime[i]) {

                primes.add(i);
            }
        }

        return primes;
    }
    
    public static boolean isPrime(int n) {

        if (n == 2) {

            return true;
        }
        
        if (n == 1 || n % 2 == 0) {

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
//runs in 90sec hmmm
//confirmed, regardless