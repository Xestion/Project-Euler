

import java.util.*;

/**
 *
 * @author Caleb
 */
public class p91 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        int count = 0;
        
        Set<ArrayList<Integer>> set = new HashSet<>();
        
        for (int x1 = 0; x1 <= 50; x1++) {

            for (int y1 = 0; y1 <= 50; y1++) {

                for (int x2 = 0; x2 <= 50; x2++) {

                    for (int y2 = 0; y2 <= 50; y2++) {

                        if (isLine(x1, y1, x2, y2)) {

                            continue;
                        }

                        if (isSolution(x1, y1, x2, y2)) {
                            
                            ArrayList<Integer> coords = new ArrayList<>(Arrays.asList(x1, y1, x2, y2));
                            ArrayList<Integer> revcoords = new ArrayList<>(Arrays.asList(x2, y2, x1, y1));
                            
                            if (!set.contains(coords) && !set.contains(revcoords)) {
                                
                                //System.out.println("(" + x1 + ", " + y1 + "), " + "(" + x2 + ", " + y2 + ")");
                                set.add(coords);
                                count++;
                            }
                            
                        }
                    }
                }
            }
        }
        
        long end = System.currentTimeMillis() - start;
        System.out.println(end + "ms\n" + count);
        

    }

    public static boolean isLine(double x1, double y1, double x2, double y2) {

        double slope1 = y1 / x1;
        double slope2 = y2 / x2;
        
        if ((x1 == 0 && y1 == 0) || (x2 == 0 && y2 == 0)) {
            
            return true;
        }

        return slope1 == slope2;
    }

    public static boolean isSolution(double x1, double y1, double x2, double y2) {
        
        double Cx = x1 - x2;
        double Cy = y1 - y2;
        
        
        
        double dot1 = (x1 * x2) + (y1 * y2);
        double dot2 = (x1 * Cx) + (y1 * Cy);
        double dot3 = (x2 * Cx) + (y2 * Cy);
        
        //if any right angles
        if (dot1 == 0 || dot2 == 0 || dot3 == 0) {
            
            return true;
        }
        
        return false;
    }
}
