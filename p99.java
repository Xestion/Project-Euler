

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Caleb
 */
public class p99 {

    public static void main(String[] args) throws FileNotFoundException {

        long start = System.currentTimeMillis();
        
        File file = new File("C:\\Users\\Caleb\\Documents\\NetBeansProjects\\Euler\\src\\main\\java\\txt files for euler\\p099_base_exp.txt");
        Scanner scan = new Scanner(file);

        String str;
        String[] temp = new String[2];
        int base, pow, bbase = 50000, bpow = 50000, cline = 1, bline = 1;
        double first, second;

        while (scan.hasNextLine()) {

            str = String.valueOf(scan.nextLine());
            temp = str.split(",");

            base = Integer.parseInt(temp[0]);
            pow = Integer.parseInt(temp[1]);

            first = bpow * (Math.log(bbase) / Math.log(bbase));
            second = pow * (Math.log(base) / Math.log(bbase));
            
            if (second > first) {
                
                bbase = base;
                bpow = pow;
                bline = cline;
                
            }

            cline++;
        }
        
        System.out.println(bbase + ", " + bpow + ", " + bline);
        long stop = System.currentTimeMillis() - start;
        System.out.println(stop + "ms");

    }

}
