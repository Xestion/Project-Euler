

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Caleb
 */
public class p96 {

    static int[][] grid = new int[9][9];
    static ArrayList<ArrayList<Integer>> chunklists = new ArrayList<>();
    static int[][][] chunks = new int[9][3][3];
    static int[] totaldigits = new int[10];

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\Caleb\\Documents\\NetBeansProjects\\Euler\\src\\main\\java\\txt files for euler\\p096_sudoku.txt");
        Scanner scan = new Scanner(file);

        String str;
        char c;
        int sum = 0;

        for (int line = 0; line < 500; line++) {

            str = String.valueOf(scan.nextLine());

            if (line % 10 != 0) {

                for (int i = 0; i < 9; i++) {

                    c = str.charAt(i);
                    grid[(line % 10) - 1][i] = Character.getNumericValue(c);
                }
            }

            if (line > 1 && line % 10 == 0 || line == 499) {

                //printGrid();
                //genChunks();
                //System.exit(0);
                solve();
                printGrid();
                System.out.println();
                sum += getSum();
            }
        }

        System.out.println(sum);
    }

    public static void printChunks() {

        for (int chunk = 0; chunk < 9; chunk++) {

            for (int row = 0; row < 3; row++) {

                for (int col = 0; col < 3; col++) {

                    System.out.print(chunks[chunk][row][col] + " ");
                }

                System.out.println();
            }

            System.out.println();
        }

    }

    public static boolean solve() {

        findTotalDigits();
        boolean solved = totaldigits[0] == 0;

        if (solved) {
            
            return true;
        } else {

            ArrayList<Integer> ncell = nextCell();
            
            int nrow = ncell.get(0);
            int ncol = ncell.get(1);

            for (int i = 1; i < 10; i++) {

                if (isSafe(i, nrow, ncol)) {

                    grid[nrow][ncol] = i;

                    if (solve()) {

                        return true;
                    }
                    
                    grid[nrow][ncol] = 0;
                }
            }
        }

        return false;
    }

    public static boolean isSafe(int i, int row, int col) {

        return safeCol(i, row, col) && safeRow(i, row, col) && safeChunk(i, row - (row % 3), col - (col % 3));
    }

    public static boolean safeCol(int i, int row, int col) {

        for (int j = 0; j < 9; j++) {

            if (grid[row][j] == i) {

                return false;
            }
        }

        return true;
    }

    public static boolean safeRow(int i, int row, int col) {

        for (int j = 0; j < 9; j++) {

            if (grid[j][col] == i) {

                return false;
            }
        }

        return true;
    }

    public static boolean safeChunk(int i, int row, int col) {

        for (int j = 0; j < 3; j++) {

            for (int k = 0; k < 3; k++) {

                if (grid[j + row][k + col] == i) {

                    return false;
                }
            }

        }

        return true;
    }

    public static ArrayList<Integer> nextCell() {

        ArrayList<Integer> list = new ArrayList<>();

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                if (grid[row][col] == 0) {

                    list.add(row);
                    list.add(col);
                    return list;
                }
            }
        }
        
        return list;
    }

    public static void findTotalDigits() {

        Arrays.fill(totaldigits, 0);
        
        int digit;
        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                digit = grid[row][col];
                totaldigits[digit]++;
            }
        }
    }

    public static int getSum() {

        String a, b, c;
        a = String.valueOf(grid[0][0]);
        b = String.valueOf(grid[0][1]);
        c = String.valueOf(grid[0][2]);

        return Integer.parseInt(a + b + c);
    }

    public static void checkNaked() {

    }

    public static void genChunks() {

        chunklists.clear();

        // 0  1  2
        // 3  4  5
        // 6  7  8
        ArrayList<Integer> digits = new ArrayList<>();
        ArrayList<Integer> temp;
        int digit, i = 0, j = 0, counter = 0;

        while (i < 9) {

            while (j < 9) {

                for (int row = i; row < i + 3; row++) {

                    for (int col = j; col < j + 3; col++) {

                        digit = grid[row][col];
                        chunks[counter][row % 3][col % 3] = digit;

                        if (digit != 0) {

                            digits.add(digit);
                        }
                    }
                }

                temp = (ArrayList) digits.clone();
                chunklists.add(temp);

                j += 3;
                counter++;

                digits.clear();
            }

            i += 3;
            j = 0;
        }
    }

    public static void printGrid() {

        int digit;

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                digit = grid[i][j];
                if (digit != 0) {

                    System.out.print(grid[i][j] + " ");
                } else {

                    System.out.print("  ");
                }

                if (j == 2 || j == 5) {

                    System.out.print("| ");
                }

            }

            System.out.println("");

            if (i == 2 || i == 5) {

                System.out.println("---------------------");
            }
        }
    }
}
