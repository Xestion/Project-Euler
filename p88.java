

import java.util.*;

/**
 *
 * @author Caleb
 */
public class p88 {

    static ArrayList<Integer> primes = new ArrayList();
    static ArrayList<ArrayList<Integer>> factors = new ArrayList();

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        Set<Integer> set = new HashSet<>();

        int min;
        for (int k = 2; k <= 12000; k++) {

            min = getMin(k);
            set.add(min);
            //System.out.println("k = " + k + ", n = " + min);
        }

        Object[] vals = set.toArray();
        int sum = 0;

        for (int i = 0; i < set.size(); i++) {

            sum += Integer.parseInt(vals[i].toString());
        }

        //System.out.println(set);
        long stop = start - System.currentTimeMillis();
        System.out.println(sum);
        System.out.println(-stop + "ms");
    }

    public static int isSolution(ArrayList<ArrayList<Integer>> list, int k) {

        //looking at each sublist, checking to see if sum == prod
        for (int i = 0; i < list.size(); i++) {

            int sum = 0;
            int prod = 1;
            for (int j = 0; j < list.get(i).size(); j++) {

                prod *= list.get(i).get(j);
                sum += list.get(i).get(j);
            }

            //fixes the "append 1's to everything"
            sum += k - list.get(i).size();

            if (prod == sum) {

                return sum;
            }
        }

        return -1;
    }

    public static int getMin(int k) {

        //start at best base case
        int N = k + 2;
        int result;

        while (true) {

            //primes are obviously out
            if (isPrime(N)) {

                N++;
                continue;
            }

            result = doSets(N, k);

            //success
            if (result != -1) {

                return result;

                //failure
            } else {

                N++;
            }
        }
    }

    public static int doSets(int N, int k) {

        //first i grab only the factor couples; that is, two factor sets only
        ArrayList<ArrayList<Integer>> factors = new ArrayList<>();
        factors = getCouples(N);
        //System.out.println("k=" + k + ", n=" + N + " " + factors);

        int outer = 0;
        int result;

        //iterate through the entire list of lists, each list at a time
        while (outer < factors.size()) {

            //this loops through each element in the individual sublists
            for (int i = 0; i < factors.get(outer).size(); i++) {

                //if the element is NOT prime, we need to break it down
                if (!isPrime(factors.get(outer).get(i))) {

                    //this creates a loop that sequentially tests all ways to break down the composite number
                    for (int div = 2; div < Math.ceil(Math.sqrt(factors.get(outer).get(i))) + 1; div++) {

                        //if we find a divisor, add another set to the list of lists for our findings and continue on
                        if (factors.get(outer).get(i) % div == 0) {

                            //make a new copy of the list
                            ArrayList<Integer> subset = new ArrayList<>(factors.get(outer));

                            //remove the non-prime
                            subset.remove(i);

                            //add the divisor of the composite number, then the result of division
                            subset.add(div);
                            subset.add(factors.get(outer).get(i) / div);
                            //System.out.println(subset);

                            //sort, then add if not currently there
                            Collections.sort(subset);

                            if (!factors.contains(subset)) {

                                factors.add(subset);
                                //System.out.println(factors);
                            }
                        }
                    }
                }
            }

            //we gotta transverse the LoL, won't have any errors as we will get all combos before going out of bounds here, pretty nice/cool
            outer++;
        }

        result = isSolution(factors, k);
        return result;
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

    public static ArrayList<ArrayList<Integer>> getCouples(int n) {

        //clear and set up for next call
        //assume smallest divisor is 2, go ahead and find it
        factors.clear();
        int divisor = 2;
        int smallest;

        //grab smallest divisor to set up for next loop
        while (true) {

            if (n % divisor == 0) {

                smallest = divisor;
                break;
            } else {

                divisor++;
            }
        }

        //once smallest is found, iterate through and add each pair of divisors into the set
        for (int i = smallest; i < Math.round(Math.sqrt(n)) + 1; i++) {

            if (n % i == 0) {

                ArrayList<Integer> couple = new ArrayList<>();

                couple.add(i);
                couple.add(n / i);
                factors.add(couple);
            }
        }

        //return the complete set of 2 divisor lists
        return factors;
    }
}
