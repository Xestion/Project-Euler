
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Caleb
 */
public class p81 {

    static String[] temp = new String[80];
    static int[][] arr = new int[80][80];

    public static void main(String args[]) throws FileNotFoundException {
        
        long startTime = System.currentTimeMillis();

        File file = new File("C:\\Users\\Caleb\\Documents\\NetBeansProjects\\Euler\\src\\main\\java\\txt files for euler\\p081_matrix.txt");
        Scanner scan = new Scanner(file);

        String str;
        int iter = 0;

        while (scan.hasNextLine()) {

            str = String.valueOf(scan.nextLine());
            temp = str.split(",");

            labelbreak:
            for (int row = iter; row < 80; row++) {

                for (int column = 0; column < 80; column++) {

                    arr[row][column] = Integer.parseInt(temp[column]);

                    if (column == 79) {

                        iter++;
                        break labelbreak;
                    }
                }
            }
        }

        for (int row = 0; row < 80; row++) {

            for (int column = 0; column < 80; column++) {

                if (row != 0 && column != 0) {

                    arr[row][column] = arr[row][column] + getMin(row - 1, column, row, column - 1);
                } else if (row == 0 && column != 0) {

                    arr[row][column] = arr[row][column] + arr[row][column - 1];
                } else if (row != 0 && column == 0) {

                    arr[row][column] = arr[row][column] + arr[row - 1][column];
                }
            }
        }

        System.out.println(arr[79][79]);
        
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime + "ms");
    }

    public static int getMin(int row1, int column1, int row2, int column2) {

        if (arr[row1][column1] > arr[row2][column2]) {

            return arr[row2][column2];
        } else {

            return arr[row1][column1];
        }
    }
}
