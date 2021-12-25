

/**
 *
 * @author Caleb
 */

import java.util.*;


public class p87 {
    
    static ArrayList<Integer> primes = new ArrayList<>();
    static ArrayList<Integer> squares = new ArrayList<>();
    static ArrayList<Integer> cubes = new ArrayList<>();
    static ArrayList<Integer> fourths = new ArrayList<>();
    
    public static void main(String[] args){
        
        //create primes to use
        primes((int)(Math.floor(Math.sqrt(50000000)) + 1));
        getPowers();
        
        int count = 0;
        
        ArrayList<Integer> test = new ArrayList<>();
        
        for (int i = 0; i < squares.size(); i++){
            
            for (int j = 0; j < cubes.size(); j++){
                
                for (int k = 0; k < fourths.size(); k++){
                    
                    if (!(squares.get(i) + cubes.get(j) + fourths.get(k) > 50000000)){
                        
                        test.add(squares.get(i) + cubes.get(j) + fourths.get(k));
                    }
                }
            }
        }
        
        Set<Integer> set = new HashSet<>(test);
        System.out.println(set.size());
    }
    
    
    
    static ArrayList primes(int n){
        
        primes.add(2);
        primes.add(3);
        
        for (int i = 5; i <= n; i += 2){
            
            boolean prime = true;
            
            for (int j = 3; j < Math.floor(Math.sqrt(i)) + 1; j += 2){
                
                if (i % j == 0){
                    
                    prime = false;
                }
            }
            
            if (prime){
                
                primes.add(i);
            }
        }
        
        return primes;
    }
    
    static void getPowers(){
        
        //fix squares
        for (int i = 0; i < primes.size(); i++){
            
            squares.add( (int)Math.pow(primes.get(i), 2));
        }
        
        //fix cubes
        for (int i = 0; i < primes.size(); i++){
            
            if (Math.pow(primes.get(i), 3) > 50000000){
                
                break;
            }
            
            cubes.add( (int)Math.pow(primes.get(i), 3));
        }
        
        //fix fourths
        for (int i = 0; i < primes.size(); i++){
            
            if (Math.pow(primes.get(i), 4) > 50000000){
                
                break;
            }
            
            fourths.add( (int)Math.pow(primes.get(i), 4));
        }
    }
}
