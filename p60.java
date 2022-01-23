
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author Caleb
 */
public class p60 {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> primes = getPrimes(10000);
        //List<Integer> primes = Arrays.asList(2, 13, 5197, 5701, 6733, 8389);
        
        
        for (int i = 1; i < primes.size(); i++) {
            
            list.add(primes.get(i));
            
            for (int j = 1; j < primes.size(); j++) {
                
                if (i == j) {
                    
                    continue;
                }
                
                list.add(primes.get(j));
                
                if (!valid(list)) {
                    
                    list.remove(list.size() - 1);
                }
                
                if (list.size() == 5) {
                    
                    System.out.println(list);
                    
                    int sum = 0;
                    for (int k = 0; k < list.size(); k++) {
                        
                        sum += list.get(k);
                    }
                    
                    System.out.println(sum);
                    System.exit(0);
                }
            }
            
            list.clear();
        }
    }
    
    public static boolean valid(ArrayList<Integer> list) {
        
        String str;
        
        for (int i = 0; i < list.size(); i++) {
            
            for (int j = 0; j < list.size(); j++) {
                
                if (i == j) {
                    
                    continue;
                }
                
                str = list.get(i).toString() + list.get(j).toString();
                
                if (!isPrime(Integer.parseInt(str))) {
                    
                    return false;
                }
            }
        }
        
        return true;
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
}
//confirmed