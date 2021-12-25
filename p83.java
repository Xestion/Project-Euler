
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author Caleb
 */
public class p83 {

    static final int dim = 80;
    static int[][] arr = new int[dim][dim];
    static String[] temp = new String[dim];
    static PriorityQueue<Node> pq = new PriorityQueue<Node>();
    static boolean[][] visited = new boolean[dim][dim];
    static boolean[][] seen = new boolean[dim][dim];
    static int[][] totalcost = new int[dim][dim];

    public static void main(String[] args) throws FileNotFoundException {

        long start = System.currentTimeMillis();
        
        File file = new File("C:/Users/Caleb/Desktop/p082.txt");
        Scanner scan = new Scanner(file);

        String str;
        int iter = 0;

        while (scan.hasNextLine()) {

            str = String.valueOf(scan.nextLine());
            temp = str.split(",");

            labelbreak:
            for (int row = iter; row < dim; row++) {

                for (int column = 0; column < dim; column++) {

                    arr[row][column] = Integer.parseInt(temp[column]);

                    if (column == dim - 1) {

                        iter++;
                        break labelbreak;
                    }
                }
            }
        }

        Node node = new Node();
        node.setRow(0);
        node.setCol(0);
        node.setVal(0);
        pq.add(node);
        int cr;
        int cc;
        
        while (!pq.isEmpty()) {

            cr = pq.peek().getRow();
            cc = pq.poll().getCol();

            visited[cr][cc] = true;

            //if row + 1
            if (cr + 1 < dim) {

                if (!visited[cr + 1][cc]) {

                    //hasn't been visited yet
                    if (!seen[cr + 1][cc]) {

                        //never encountered before
                        seen[cr + 1][cc] = true;
                        totalcost[cr + 1][cc] = totalcost[cr][cc] + arr[cr + 1][cc];

                        Node temp = new Node();
                        temp.setRow(cr + 1);
                        temp.setCol(cc);
                        temp.setVal(totalcost[cr + 1][cc]);
                        pq.add(temp);

                    } else {

                        if (totalcost[cr + 1][cc] > totalcost[cr][cc] + arr[cr + 1][cc]) {

                            //encountered as neighbor before
                            //update to lower path sum
                            totalcost[cr + 1][cc] = totalcost[cr][cc] + arr[cr + 1][cc];
                        }
                    }

                }
            }

            //if col + 1
            if (cc + 1 < dim) {

                if (!visited[cr][cc + 1]) {

                    //hasn't been visited yet
                    if (!seen[cr][cc + 1]) {

                        //never encountered before
                        seen[cr][cc + 1] = true;
                        totalcost[cr][cc + 1] = totalcost[cr][cc] + arr[cr][cc + 1];

                        Node temp = new Node();
                        temp.setRow(cr);
                        temp.setCol(cc + 1);
                        temp.setVal(totalcost[cr][cc + 1]);
                        pq.add(temp);

                    } else {

                        if (totalcost[cr][cc + 1] > totalcost[cr][cc] + arr[cr][cc + 1]) {

                            //encountered as neighbor before
                            //update to lower path sum
                            totalcost[cr][cc + 1] = totalcost[cr][cc] + arr[cr][cc + 1];
                        }
                    }

                }
            }

            //if row - 1
            if (cr > 0) {

                if (!visited[cr - 1][cc]) {

                    //hasn't been visited yet
                    if (!seen[cr - 1][cc]) {

                        //never encountered before
                        seen[cr - 1][cc] = true;
                        totalcost[cr - 1][cc] = totalcost[cr][cc] + arr[cr - 1][cc];

                        Node temp = new Node();
                        temp.setRow(cr - 1);
                        temp.setCol(cc);
                        temp.setVal(totalcost[cr - 1][cc]);
                        pq.add(temp);

                    } else {

                        if (totalcost[cr - 1][cc] > totalcost[cr][cc] + arr[cr - 1][cc]) {

                            //encountered as neighbor before
                            //update to lower path sum
                            totalcost[cr - 1][cc] = totalcost[cr][cc] + arr[cr - 1][cc];
                        }
                    }

                }
            }

            //if col - 1
            if (cc > 0) {

                if (!visited[cr][cc - 1]) {

                    //hasn't been visited yet
                    if (!seen[cr][cc - 1]) {

                        //never encountered before
                        seen[cr][cc - 1] = true;
                        totalcost[cr][cc - 1] = totalcost[cr][cc] + arr[cr][cc - 1];

                        Node temp = new Node();
                        temp.setRow(cr);
                        temp.setCol(cc - 1);
                        temp.setVal(totalcost[cr][cc - 1]);
                        pq.add(temp);
                    } else {

                        if (totalcost[cr][cc - 1] > totalcost[cr][cc] + arr[cr][cc - 1]) {

                            //encountered as neighbor before
                            //update to lower path sum
                            totalcost[cr][cc - 1] = totalcost[cr][cc] + arr[cr][cc - 1];
                        }
                    }

                }
            }
        }

        long stop = System.currentTimeMillis();
        long time = stop - start;
        //printArr();
        System.out.println(totalcost[dim - 1][dim - 1] + arr[0][0] + " / " + time + "ms");

    }

    static void printArr() {

        for (int i = 0; i < dim; i++) {

            for (int j = 0; j < dim; j++) {

                System.out.print(totalcost[i][j] + " ");
            }
            
            System.out.println("");
        }
    }

}

class Node implements Comparable<Node> {

    public int row = 0;
    public int col = 0;
    public int val = 0;

    public void setRow(int n) {

        this.row = n;
    }

    public void setCol(int n) {

        this.col = n;
    }

    public void setVal(int n) {

        this.val = n;
    }

    public int getRow() {

        return row;
    }

    public int getCol() {

        return col;
    }

    public int getVal() {

        return val;
    }

    @Override
    public int compareTo(Node temp) {

        if (getVal() > temp.getVal()) {

            return 1;

        } else if (getVal() == temp.getVal()) {

            return 0;

        } else {

            return -1;
        }

    }

}
