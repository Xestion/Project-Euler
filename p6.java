
/**
 *
 * @author Caleb
 */
public class p6 {

    public static void main(String[] args) {
        double sum = 101 * 50;
        double squareofsum = Math.pow(sum, 2);
        double sumofsquare = 0;
        for (double i = 0; i < 101; i++) {
            sumofsquare = sumofsquare + Math.pow(i, 2);
        }
        double difference = squareofsum - sumofsquare;
        int trueDiff = (int) difference;
        System.out.println(trueDiff);
    }
}
//confirmed.

