
import java.util.ArrayList;


/**
 *
 * @author Caleb
 */
public class p23 {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        boolean[] arr = new boolean[28124];
        
        for (int n = 1; n < 28113; n++) {
            
            if (abundant(n)) {
                
                list.add(n);
            }
        }
        
        for (int i = 0; i < list.size(); i++) {
            
            for (int j = 0; j < list.size(); j++) {
                
                if (list.get(i) + list.get(j) < arr.length) {
                    
                    arr[list.get(i) + list.get(j)] = true;
                }
            }
        }
        
        int sum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            
            if (!arr[i]) {
                
                sum += i;
            }
        }
        
        System.out.println(sum);
    }
    
    public static boolean abundant(int n) {
        
        int sum = 1;
        
        for (int div = 2; div < n / 2 + 1; div++) {
            
            if (n % div == 0) {
                
                sum += div;
            }
        }
        
        return (sum > n);
    }
}
//confirmed