

import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p95 {

    static ArrayList<Integer> primes = new ArrayList();
    static int[] divsums = new int[1000000];
    static int[] pointer = new int[1000000];

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        ArrayList<Integer> chain = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        getPrimes(500000);

        for (int i = 1; i < 1000000; i++) {

            divsums[i] = getDivsum(i);
            //System.out.println(i + ", " + divsums[i]);
        }

        for (int i = 1; i < 15000; i++) {

            temp = findPointer(i);

            if (temp.size() > chain.size()) {

                chain = (ArrayList) temp.clone();
            }
        }

        int min = chain.get(0);
        int ele;
        for (int i = 0; i < chain.size(); i++) {

            ele = chain.get(i);

            if (ele < min) {

                min = ele;
            }
        }
        
        System.out.println(min);

        long stop = System.currentTimeMillis();
        System.out.println(stop - start + "ms");

    }

    public static ArrayList<Integer> findPointer(int n) {

        boolean cycle = false;
        boolean conv = false;
        int point = divsums[n];

        ArrayList<Integer> chain = new ArrayList<>();

        while (!cycle) {
            
            if (point == 1 || point > 1000000) {

                conv = true;
                break;
            }

            else if (chain.contains(point)) {

                cycle = true;
            }
            
            chain.add(point);
            //System.out.println(chain);
            

            point = divsums[point];
        }
        
        if (conv) {
            
            divsums[n] = 1;
            for (int i = 0; i < chain.size(); i++) {
            
                divsums[chain.get(i)] = 1;
            }
            
            chain.clear();
            chain.add(1);
        }
        
        for (int i = 0; i < chain.size(); i++) {
            
            if (chain.get(0) != point) {
                
                chain.remove(0);
            } else {
                
                break;
            }
        }
        
        //chain.remove(chain.size() - 1);
        
        if (chain.size() > 1) {
            
            System.out.println(chain);
        }
        
        return chain;
    }

    public static int getDivsum(int n) {

        if (isPrime(n) || n == 1) {

            return 1;
        }

        int sum = 1;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 2; i < Math.floor(Math.sqrt(n)) + 1; i++) {

            if (n % i == 0) {

                if (!list.contains(i)) {
                    
                    list.add(i);
                }
                
                if (!list.contains(n / i)) {
                    
                    list.add(n / i);
                }
            }
        }
        
        for (int i = 0; i < list.size(); i++) {
            
            sum += list.get(i);
        }

        return sum;
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

    public static ArrayList<Integer> getPrimes(int n) {

        boolean prime[] = new boolean[n + 1];

        //default boolean value is false and we don't want to lose time turning everything to true first, so we will count false as true, false == prime
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
