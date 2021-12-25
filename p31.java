
/**
 *
 * @author Caleb
 */
public class p31 {

    public static void main(String[] args) {

        int counter = 0;

        for (int bigpound = 0; bigpound < 2; bigpound++) {

            for (int pound = 0; pound < 3; pound++) {

                for (int fiftypence = 0; fiftypence < 5; fiftypence++) {

                    for (int twentypence = 0; twentypence < 11; twentypence++) {

                        for (int tenpence = 0; tenpence < 21; tenpence++) {

                            for (int fivepence = 0; fivepence < 41; fivepence++) {

                                for (int twopence = 0; twopence < 101; twopence++) {

                                    for (int onepence = 0; onepence < 201; onepence++) {

                                        int equation = onepence + 2 * twopence + 5 * fivepence + 10 * tenpence + 20 * twentypence + 50 * fiftypence + 100 * pound + 200 * bigpound;

                                        if (equation == 200) {

                                            counter++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(counter);
    }
}
//confirmed.

