

import java.util.*;

public class p85 {

    static ArrayList<Integer> tri = new ArrayList<>();
    
    public static void main(String[] args) {

        genTri(220000);
        
        int min = 2200000;
        int diff;
        int l = 0;
        int w = 0;
        
        for (int i = 0; i < tri.size(); i++) {
            
            for (int j = 0; j < tri.size(); j++) {
                
                if (tri.get(i) * tri.get(j) > 2200000) {
                    
                    continue;
                }
                
                diff = Math.abs(tri.get(i) * tri.get(j) - 2000000);
                
                if (diff < min) {
                    
                    min = diff;
                    l = i + 1;
                    w = j + 1;
                }
            }
        }
        
        System.out.println(l * w);
    }
    
    public static void genTri(int max){
        
        tri.add(1);
        
        int tris = 0;
        
        for(int i = 1; tris <= max; i++){
            
            tris = i * (i + 1)/2;
            tri.add(tris);
        }
        
        tri.remove(0);
        tri.remove(tri.size() - 1);
    }

    
}
