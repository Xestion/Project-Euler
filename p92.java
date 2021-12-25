

/**
 *
 * @author Caleb
 */
public class p92 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        int count = 0;
        for (int n = 2; n < 10000001; n++) {

            if (getChainEnd(n) == 89) {

                count++;
            }
        }

        long end = System.currentTimeMillis() - start;
        System.out.println(end + "ms\n" + count);
    }

    public static int getChainEnd(int n) {

        String str = String.valueOf(n);
        int sum = 0;
        int square;

        for (int i = 0; i < str.length(); i++) {

            square = (int) Math.pow(Character.getNumericValue(str.charAt(i)), 2);
            sum += square;
        }

        while (sum != 1 && sum != 89) {

            str = String.valueOf(sum);
            sum = 0;
            
            for (int i = 0; i < str.length(); i++) {

                square = (int) Math.pow(Character.getNumericValue(str.charAt(i)), 2);
                sum += square;
            }
        }

        return sum;
    }

}
