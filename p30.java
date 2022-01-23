

/**
 *
 * @author Caleb
 */
public class p30 {

    public static void main(String[] args) {

        int sum = 0;
        
        for (int n = 2; n < 200000; n++) {
            
            if (n == sumDigits(n)) {
                
                sum += n;
            }
        }
        
        System.out.println(sum);
    }
    
    public static int sumDigits(int n) {
        
        String str = String.valueOf(n);
        int sum = 0;
        
        for (int i = 0; i < str.length(); i++) {
            
            sum += Math.pow(Character.getNumericValue(str.charAt(i)), 5);
        }
        
        return sum;
    }
}
//confirmed