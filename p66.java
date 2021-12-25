


import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p66 {

    static ArrayList<Double> period = new ArrayList();
    static ArrayList<BigInteger> xy = new ArrayList();
    static ArrayList<BigInteger> maxlist = new ArrayList();
    static ArrayList<Integer> maxdlist = new ArrayList();

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        BigInteger max = BigInteger.ZERO;
        BigInteger x = BigInteger.ONE;

        for (int d = 2; d <= 1000; d++) {

            if (d % Math.sqrt(d) == 0) {

                continue;
            }

            period.clear();

            getPeriod(d);
            x = testConvergents(d, period);

            if (x.compareTo(max) == 1) {

                max = x;
                maxlist.add(x);
                maxdlist.add(d);
            }
        }

        System.out.println("x = " + maxlist.get(maxlist.size() - 1));
        System.out.println("d = " + maxdlist.get(maxdlist.size() - 1));
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime + "ms");
    }

    public static ArrayList<Double> getPeriod(int d) {

        BigDecimal a = BigDecimal.valueOf(d);
        double floor = Math.floor(Double.valueOf(String.valueOf(a.sqrt(new MathContext(100)))));
        BigDecimal expression = a.sqrt(new MathContext(600)).subtract(BigDecimal.valueOf(floor));

        test(expression, floor);

        return period;
    }

    public static ArrayList<Double> test(BigDecimal exp, double floor) {

        BigDecimal one = new BigDecimal("1");
        BigDecimal frac = one.divide(exp, new MathContext(600));
        exp = frac.subtract(BigDecimal.valueOf(Math.floor(Double.valueOf(String.valueOf(frac)))));
        period.add(Math.floor(Double.valueOf(String.valueOf(frac))));
        BigDecimal two = new BigDecimal("2");
        if (Math.floor(Double.valueOf(String.valueOf(frac))) == floor * 2) {

            return (period);
        }

        return (test(exp, floor));
    }

    public static BigInteger testConvergents(int d, ArrayList<Double> period) {

        double initial = Math.floor(Math.sqrt(d));

        int j = 1;
        while (j < 4) {

            period.addAll(period.size(), period);
            j++;
        }

        period.add(0, initial);
        period.add(0, 0d);

        for (int i = 1; i < period.size(); i++) {

            if (isSolution(getConvergent(i), d)) {

                BigInteger x = xy.get(0);

                return x;
            }
        }

        return BigInteger.ZERO;
    }

    public static ArrayList<BigInteger> getConvergent(int i) {

        BigInteger num = BigInteger.ONE;
        BigInteger denom = BigDecimal.valueOf(period.get(i)).toBigInteger();

        BigInteger convergentnum = BigInteger.ZERO;
        BigInteger convergentdenom = BigInteger.ZERO;

        while (i > 0) {

            BigInteger num2 = BigDecimal.valueOf(period.get(i - 1)).toBigInteger();
            BigInteger denom2 = BigInteger.ONE;

            BigInteger newnum = num2.multiply(denom).add(num);
            BigInteger newdenom = denom;

            BigInteger tempnum = newnum;
            BigInteger tempdenom = newdenom;

            newnum = tempdenom;
            newdenom = tempnum;

            num = newnum;
            denom = newdenom;

            convergentnum = num;
            convergentdenom = denom;

            i--;
        }

        xy.clear();
        xy.add(convergentnum);
        xy.add(convergentdenom);
        return xy;
    }

    public static boolean isSolution(ArrayList<BigInteger> xy, int d) {

        if ((xy.get(0).pow(2).subtract(BigInteger.valueOf(d).multiply(xy.get(1).pow(2)))).compareTo(BigInteger.ONE) == 0) {

            return true;
        }

        return false;
    }
}
//confirmed.

