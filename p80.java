
import java.math.BigDecimal;
import java.math.MathContext;

public class p80 {

    public static void main(String args[]) {

        BigDecimal num, root;
        int total = 0;

        for (int i = 2; i < 100; i++) {

            if (i % Math.sqrt(i) != 0) {

                num = BigDecimal.valueOf(i);

                root = num.sqrt(new MathContext(150));

                total += getSum(root);
            }
        }

        System.out.println(total);
    }

    public static int getSum(BigDecimal root) {

        String str = String.valueOf(root);

        int sum = 0;

        for (int i = 0; i < 101; i++) {
            
            if(i != 1){
                
                sum += Integer.parseInt(String.valueOf(str.charAt(i)));
            }
        }

        return sum;
    }
}
//confirmed.
