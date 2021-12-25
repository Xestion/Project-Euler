
import java.util.ArrayList;

/**
 *
 * @author Caleb
 */
public class p61 {

    static ArrayList<String> result = new ArrayList<>();
    static ArrayList<Integer> empty = new ArrayList<>();
    static ArrayList<Integer> trilist = new ArrayList<>();
    static ArrayList<Integer> squarelist = new ArrayList<>();
    static ArrayList<Integer> pentlist = new ArrayList<>();
    static ArrayList<Integer> hexlist = new ArrayList<>();
    static ArrayList<Integer> heptlist = new ArrayList<>();
    static ArrayList<Integer> octlist = new ArrayList<>();

    public static void main(String[] args) {

        //triangle generator, 4 digits and under
        int tri = 0;
        for (int i = 1; i < 141; i++) {

            tri += i;
            if (tri > 999) {

                trilist.add(tri);
            }
        }

        //square generator, 4 digits and under
        int square = 0;
        for (int i = 1; i < 199; i += 2) {

            square += i;
            if (square > 999) {

                squarelist.add(square);
            }
        }

        //pentagon generator, 4 digits and under
        int pent = 0;
        for (int i = 1; i < 244; i += 3) {

            pent += i;
            if (pent > 999) {

                pentlist.add(pent);
            }
        }

        //hexagon generator, 4 digits and under
        int hex = 0;
        for (int i = 1; i < 281; i += 4) {

            hex += i;
            if (hex > 999) {

                hexlist.add(hex);
            }
        }

        //heptagon generator, 4 digits and under
        int hept = 0;
        for (int i = 1; i < 315; i += 5) {

            hept += i;
            if (hept > 999) {

                heptlist.add(hept);
            }
        }

        //octagon generator, 4 digits and under
        int oct = 0;
        for (int i = 1; i < 348; i += 6) {

            oct += i;
            if (oct > 999) {

                octlist.add(oct);
            }
        }

        //System.out.println(trilist);
        //System.out.println(squarelist);
        //System.out.println(pentlist);
        permutation("", "345678");

        for (int i = 0; i < result.size(); i++) {

            for (int a = 0; a < getlist(Character.getNumericValue(result.get(i).charAt(0))).size(); a++) {

                String startOne = String.valueOf(getlist(Character.getNumericValue(result.get(i).charAt(0))).get(a)).substring(0, 2);
                String endOne = String.valueOf(getlist(Character.getNumericValue(result.get(i).charAt(0))).get(a)).substring(2, 4);

                for (int b = 0; b < getlist(Character.getNumericValue(result.get(i).charAt(1))).size(); b++) {

                    String startTwo = String.valueOf(getlist(Character.getNumericValue(result.get(i).charAt(1))).get(b)).substring(0, 2);
                    String endTwo = String.valueOf(getlist(Character.getNumericValue(result.get(i).charAt(1))).get(b)).substring(2, 4);

                    if (endOne.equals(startTwo)) {

                        //System.out.println(startOne + endOne + ", " + startTwo + endTwo);
                        for (int c = 0; c < getlist(Character.getNumericValue(result.get(i).charAt(2))).size(); c++) {

                            String startThree = String.valueOf(getlist(Character.getNumericValue(result.get(i).charAt(2))).get(c)).substring(0, 2);
                            String endThree = String.valueOf(getlist(Character.getNumericValue(result.get(i).charAt(2))).get(c)).substring(2, 4);
                            if (endTwo.equals(startThree)) {

                                //System.out.println(startOne + endOne + ", " + startTwo + endTwo + ", " + startThree + endThree);
                                for (int d = 0; d < getlist(Character.getNumericValue(result.get(i).charAt(3))).size(); d++) {

                                    String startFour = String.valueOf(getlist(Character.getNumericValue(result.get(i).charAt(3))).get(d)).substring(0, 2);
                                    String endFour = String.valueOf(getlist(Character.getNumericValue(result.get(i).charAt(3))).get(d)).substring(2, 4);
                                    if (endThree.equals(startFour)) {

                                        //System.out.println(startOne + endOne + ", " + startTwo + endTwo + ", " + startThree + endThree + ", " + startFour + endFour);
                                        for (int e = 0; e < getlist(Character.getNumericValue(result.get(i).charAt(4))).size(); e++) {

                                            String startFive = String.valueOf(getlist(Character.getNumericValue(result.get(i).charAt(4))).get(e)).substring(0, 2);
                                            String endFive = String.valueOf(getlist(Character.getNumericValue(result.get(i).charAt(4))).get(e)).substring(2, 4);
                                            if (endFour.equals(startFive)) {

                                                //System.out.println(startOne + endOne + ", " + startTwo + endTwo + ", " + startThree + endThree + ", " + startFour + endFour + ", " + startFive + endFive);
                                                for (int f = 0; f < getlist(Character.getNumericValue(result.get(i).charAt(5))).size(); f++) {

                                                    String startSix = String.valueOf(getlist(Character.getNumericValue(result.get(i).charAt(5))).get(f)).substring(0, 2);
                                                    String endSix = String.valueOf(getlist(Character.getNumericValue(result.get(i).charAt(5))).get(f)).substring(2, 4);
                                                    if (endFive.equals(startSix) && endSix.equals(startOne)) {

                                                        System.out.println(startOne + endOne + ", " + startTwo + endTwo + ", " + startThree + endThree + ", " + startFour + endFour + ", " + startFive + endFive + ", " + startSix + endSix);
                                                        int sum = Integer.parseInt(startOne + endOne) + Integer.parseInt(startTwo + endTwo) + Integer.parseInt(startThree + endThree) + Integer.parseInt(startFour + endFour) + Integer.parseInt(startFive + endFive) + Integer.parseInt(startSix + endSix);
                                                        System.out.println(sum);
                                                        System.out.println(Character.getNumericValue(result.get(i).charAt(0)) + ", " + Character.getNumericValue(result.get(i).charAt(1)) + ", " + Character.getNumericValue(result.get(i).charAt(2)) + ", " + Character.getNumericValue(result.get(i).charAt(3)) + ", " + Character.getNumericValue(result.get(i).charAt(4)) + ", " + Character.getNumericValue(result.get(i).charAt(5)));
                                                        System.exit(0);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static ArrayList<String> permutation(String f, String u) {

        if (u.length() == 0) {

            result.add(f);

            return result;
        }

        for (int i = 0; i < u.length(); i++) {

            String fixed = f + u.charAt(i);
            String unfixed = u.substring(0, i) + u.substring(i + 1);
            permutation(fixed, unfixed);
        }

        return result;
    }

    static ArrayList<Integer> getlist(int n) {

        if (n == 3) {

            return trilist;
        }

        if (n == 4) {

            return squarelist;
        }

        if (n == 5) {

            return pentlist;
        }

        if (n == 6) {

            return hexlist;
        }

        if (n == 7) {

            return heptlist;
        }

        if (n == 8) {

            return octlist;
        }

        return empty;
    }
}
//confirmed.

