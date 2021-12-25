

import java.util.*;
import java.io.*;

/**
 *
 * @author Caleb
 */
public class p82 {

    static int[][] arr = new int[80][80];
    static String[] temp = new String[80];

    public static void main(String[] args) throws FileNotFoundException {

        long startTime = System.currentTimeMillis();

        File file = new File("C:\\Users\\Caleb\\Documents\\NetBeansProjects\\Euler\\src\\main\\java\\txt files for euler\\p082_matrix.txt");
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

        int dim = 80;

        ArrayList<Integer> updates = new ArrayList<>();

        for (int col = 1; col < dim; col++) {

            updates.clear();

            for (int row = 0; row < dim; row++) {

                updates.add(getVertPathMin(row, col, dim));
            }

            for (int i = 0; i < dim; i++) {

                arr[i][col] = updates.get(i);
            }
        }

        int min = arr[0][dim - 1];
        for (int i = 0; i < dim; i++) {

            if (arr[i][dim - 1] < min) {

                min = arr[i][dim - 1];
            }
        }

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime + "ms");

        System.out.println(min);
    }

    static int getTwoMin(int a, int b) {

        int min;

        if (a >= b) {

            min = b;
        } else {
            min = a;
        }

        return min;
    }

    static int getThreeMin(int a, int b, int c) {

        int min;

        min = getTwoMin(a, b);
        min = getTwoMin(min, c);
        return min;
    }

    static int getVertPathMin(int row, int col, int dim) {
        int min = arr[row][col] + arr[row][col - 1];

        for (int i = 0; i < dim; i++) {

            if (getPathSum(row, col, dim, i) < min) {

                min = getPathSum(row, col, dim, i);
            }
        }
        return min;
    }

    static int getPathSum(int row, int col, int dim, int i) {

        int sum = arr[i][col - 1] + arr[row][col];

        while (i < row) {

            sum += arr[i][col];
            i++;
        }

        while (i > row) {

            sum += arr[i][col];
            i--;
        }

        return sum;

    }
}
