

/**
 *
 * @author Caleb
 */
public class p21 {

    public static void main(String[] args) {

        int sum = 0;
        
        for (int n = 1; n < 10000; n++) {
            
            if (amicable(n)) {
                
                sum += n;
            }
        }
        
        System.out.println(sum);
    }
    
    public static boolean amicable(int n) {
        
        int sum = 1;
        
        for (int div = 2; div < n / 2 + 1; div++) {
            
            if (n % div == 0) {
                
                sum += div;
            }
        }
        
        int sum2 = 1;
        
        for (int div = 2; div < sum / 2 + 1; div++) {
            
            if (sum % div == 0) {
                
                sum2 += div;
            }
        }
        
        return (n == sum2 && n != sum);
    }
}
//confirmed