
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Caleb
 */
public class p67 {

    public static void main(String[] args) throws FileNotFoundException {

        final int dim = 100;
        
        int[][] arr = new int[dim][dim];

        File file = new File("C:\\Users\\Caleb\\Documents\\NetBeansProjects\\Euler\\src\\main\\java\\txt files for euler\\p067_triangle.txt");
        Scanner scan = new Scanner(file);

        String str;
        String[] temp;
        int iter = 0;

        while (scan.hasNextLine()) {

            str = String.valueOf(scan.nextLine());
            temp = str.split(" ");
            
            for (int j = 0; j <= iter; j++) {

                arr[iter][j] = Integer.parseInt(temp[j]);
            }
            
            iter++;
        }
        
        for (int row = arr.length - 1; row > 0; row--) {
            
            for (int col = 0; col < row; col++) {
                
                arr[row - 1][col] += max(arr[row][col], arr[row][col + 1]);
            }
        }
        
        System.out.println(arr[0][0]);
    }
    
    public static int max(int a, int b) {
        
        if (a > b) {
            
            return a;
        }
        
        else if (b > a) {
            
            return b;
        }
        
        return a;
        
    }
}
//confirmed
