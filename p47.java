
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Caleb
 */
public class p47 {

    public static void main(String[] args) {

        ArrayList<Integer> primecheck = new ArrayList<Integer>();
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        ArrayList<Integer> list4 = new ArrayList<Integer>();
        Set<Integer> set1 = new HashSet<Integer>(list1);
        Set<Integer> set2 = new HashSet<Integer>(list2);
        Set<Integer> set3 = new HashSet<Integer>(list3);
        Set<Integer> set4 = new HashSet<Integer>(list4);

        int ceiling = 200000;
        double sqrt = Math.ceil(Math.sqrt(ceiling)) + 1;
        for (int i = 12; i < ceiling; i++) {

            list4.clear();
            list4.addAll(list3);
            set4.clear();
            set4.addAll(list4);
            //System.out.println(set4);
            list3.clear();
            list3.addAll(list2);
            set3.clear();
            set3.addAll(list3);
            //System.out.println(list3);
            list2.clear();
            list2.addAll(list1);
            set2.clear();
            set2.addAll(list2);
            //System.out.println(list2);
            list1.clear();
            list1.addAll(primecheck);
            set1.clear();
            set1.addAll(list1);
            //System.out.println(list1);
            primecheck.clear();

            int count = 0;

            if (set4.size() == 4 && set3.size() == 4 && set2.size() == 4 && set1.size() == 4) {

                System.out.println(i - 4);
            }

            int k = i;
            int j = 2;
            while (j <= k) {

                if (k % j == 0) {

                    if (prime(j)) {

                        primecheck.add(j);
                        k = k / j;

                        if (k == 1) {

                            //System.out.println(primecheck);
                        }

                        j = 2;
                        continue;
                    }
                }

                j++;
            }

        }
    }

    public static boolean prime(int n) {

        int count = 0;

        for (int i = 1; i < Math.ceil(Math.sqrt(n)) + 1; i++) {

            if (n % i == 0) {

                count++;
            }

            if (count == 1 && i + 1 == Math.ceil(Math.sqrt(n)) + 1) {

                return true;
            }

            if (n == 1) {

                return false;
            }

            if (n == 2) {

                return true;
            }

        }

        return false;
    }
}
//confirmed.

