

/**
 *
 * @author Caleb
 */
public class p4 {
    
    public static void main(String args[]){
        
        int max = 0;
        for(int a = 100; a < 1000; a++){
            
            for(int b = 100; b < 1000; b++){
                
                int value = a * b;
                
                if(isPalindrome(value) && value > max){
                    
                    max = value;
                }
            }
        }
        
        System.out.println(max);
    }
    
    public static boolean isPalindrome(int n){
        
        String str = String.valueOf(n);
        
        for(int i = 0; i < Math.ceil(str.length()/2); i++){
            
            if(str.charAt(i) != str.charAt(str.length() - i - 1)){
                
                return false;
            }
        }
        
        return true;
    }
}
//done.