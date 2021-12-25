
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p64 {

    static ArrayList<Double> list = new ArrayList<>();

    public static void main(String[] args) {
        int count = 0;
        for (int n = 2; n <= 10000; n++) {
            list.clear();
            if (n % Math.sqrt(n) == 0) {
                continue;

            }
            //System.out.println(n);
            BigDecimal a = BigDecimal.valueOf(n);
            //System.out.println(n);
            double floor = Math.floor(Double.valueOf(String.valueOf(a.sqrt(new MathContext(100)))));
            //System.out.println(floor);
            BigDecimal expression = a.sqrt(new MathContext(600)).subtract(BigDecimal.valueOf(floor));
            //System.out.println(expression);
            //double test = Double.valueOf(String.valueOf((expression)));
            //System.out.println(test);
            if (test(expression, floor).size() % 2 == 1) {
                //System.out.println(list);
                count++;
            }

        }

        System.out.println(count);

    }

    static ArrayList<Double> test(BigDecimal exp, double floor) {
        BigDecimal one = new BigDecimal("1");
        //System.out.println(one);
        BigDecimal frac = one.divide(exp, new MathContext(600));
        //System.out.println(frac);

        exp = frac.subtract(BigDecimal.valueOf(Math.floor(Double.valueOf(String.valueOf(frac)))));
        //System.out.println(1/exp);
        list.add(Math.floor(Double.valueOf(String.valueOf(frac))));
        BigDecimal two = new BigDecimal("2");
        if (Math.floor(Double.valueOf(String.valueOf(frac))) == floor * 2) {

            return (list);

        }
        return (test(exp, floor));
    }
}
//confirmed, thank god.

