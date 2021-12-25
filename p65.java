
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p65 {

    static ArrayList<BigInteger> list = new ArrayList();

    public static void main(String[] args) {

        BigInteger k = new BigInteger("2");
        list.add(BigInteger.ZERO);
        list.add(k);
        for (int i = 1; i < 100; i++) {

            if ((i - 2) % 3 == 0) {

                list.add(k);
                k = k.add(BigInteger.valueOf(2));
            } else {

                list.add(BigInteger.ONE);
            }
        }

        System.out.println(list);
        System.out.println(getConvergent(100));

        String str = String.valueOf(getConvergent(100));

        System.out.println(str.length());

        int sum = 0;

        for (int i = 0; i < str.length(); i++) {

            sum += Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        System.out.println(sum);
    }

    public static BigInteger getConvergent(int term) {

        BigInteger num = BigInteger.ONE;
        BigInteger denom = list.get(term);

        BigInteger convergent = BigInteger.ZERO;

        while (term > 0) {

            BigInteger num2 = list.get(term - 1);
            BigInteger denom2 = BigInteger.ONE;

            BigInteger newnum = num2.multiply(denom).add(num);
            BigInteger newdenom = denom;

            BigInteger tempnum = newnum;
            BigInteger tempdenom = newdenom;

            newnum = tempdenom;
            newdenom = tempnum;

            num = newnum;
            denom = newdenom;

            convergent = num;

            term--;
        }

        return convergent;
    }
}
//confirmed.

