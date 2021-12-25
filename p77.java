
import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p77 {

    static ArrayList<Integer> primes = new ArrayList();
    static ArrayList<Integer> list = new ArrayList();
    static ArrayList<Integer> factors = new ArrayList();
    static ArrayList<Integer> tempfactors = new ArrayList();
    static ArrayList<Integer> sopf = new ArrayList();
    static ArrayList<Long> partitions = new ArrayList();

    public static void main(String args[]) {

        int ceiling = 100000000;
        getPrimes(ceiling);

        sopf.add(0); //sopf of 0
        sopf.add(0); //sopf of 1
        sopf.add(2); //sopf of 2
        sopf.add(3); //sopf of 3
        sopf.add(2); //sopf of 4

        partitions.add(1L); //prime partitions of 0
        partitions.add(0L); //prime partitions of 1
        partitions.add(1L); //prime partitions of 2
        partitions.add(1L); //prime partitions of 3
        partitions.add(1L); //prime partitions of 4

        for (int i = 5; i <= ceiling; i++) {

            long sum = getPrimeSums(i);
            //System.out.println(i + " has " + sum + " prime summation(s)");

            if (sum > 5000) {

                System.out.println(i + " is the first number with over 5000 different prime summations.");
                System.exit(0);
            }
        }
    }

    public static ArrayList<Integer> getPrimes(int n) {

        boolean prime[] = new boolean[n + 1];

        //default boolean value is false and we don't want to lose time turning everything to true first, so we will count false as true, false == prime
        for (long p = 2; p * p <= n; p++) {

            if (!prime[(int) p]) {

                for (long i = p * p; i <= n; i += p) {

                    prime[(int) i] = true;
                }
            }
        }

        for (int i = 2; i <= n; i++) {

            if (!prime[(int) i]) {

                primes.add(i);
            }
        }

        return primes;
    }

    public static boolean isPrime(int n) {

        if (n == 2) {

            return true;
        }

        if (n % 2 == 0) {

            return false;
        }

        for (int i = 3; i < Math.ceil(Math.sqrt(n)); i += 2) {

            if (n % i == 0) {

                return false;
            }
        }

        return true;
    }

    public static long getPrimeSums(int n) {

        factors.clear();
        getPrimeFactors(n);

        long total = 0;
        total += sopf(n);

        long sum = 0;
        for (int j = 1; j < n; j++) {

            sum += sopf(j) * partitions.get(n - j);
        }

        long result = (total + sum) / n;
        partitions.add(result);

        return result;
    }

    public static ArrayList<Integer> getPrimeFactors(int n) {

        int smallest = 2;

        for (int i = 0; i < primes.size(); i++) {

            int prime = primes.get(i);

            if (n % prime == 0) {

                factors.add(prime);
                smallest = factors.get(0);
            }

            if (prime > (double) n / (double) smallest) {

                break;
            }
        }

        if (factors.isEmpty()) {

            factors.add(n);
        }

        return factors;
    }

    public static int sopf(int n) {

        tempfactors.clear();

        if (sopf.size() > n) {

            return sopf.get(n);
        } else {

            int smallest = 2;

            for (int i = 0; i < primes.size(); i++) {

                int prime = primes.get(i);

                if (n % prime == 0) {

                    tempfactors.add(prime);
                    smallest = tempfactors.get(0);
                }

                if (prime > (double) n / (double) smallest) {

                    break;
                }
            }

            if (tempfactors.isEmpty()) {

                tempfactors.add(n);
            }

        }
        int sum = 0;
        for (int i = 0; i < tempfactors.size(); i++) {

            sum += tempfactors.get(i);
        }

        sopf.add(sum);
        return sum;
    }
}
//confirmed.