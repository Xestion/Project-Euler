

import java.util.*;

/**
 *
 * @author Caleb
 */
public class p90 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        
        ArrayList<Integer> one = new ArrayList<>(Arrays.asList(0));
        ArrayList<Integer> two = new ArrayList<>(Arrays.asList(1));
        ArrayList<Integer> alist = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        ArrayList<Integer> blist = new ArrayList<>(Arrays.asList(0, 2, 3, 4, 5, 6, 7, 8, 9));
        ArrayList<Integer> append = new ArrayList<>();
        ArrayList<Integer> rev = new ArrayList<>();
        Set<ArrayList<Integer>> set = new HashSet<>();

        for (int a = 0; a < 9; a++) {

            //System.out.println(a);
            if (!one.contains(alist.get(a))) {

                one.add(alist.get(a));
            } else {

                continue;
            }

            for (int b = 0; b < 9; b++) {

                //System.out.println(b);
                if (!one.contains(alist.get(b))) {

                    one.add(alist.get(b));
                } else {

                    continue;
                }

                for (int c = 0; c < 9; c++) {

                    if (!one.contains(alist.get(c))) {

                        one.add(alist.get(c));
                    } else {

                        continue;
                    }

                    for (int d = 0; d < 9; d++) {

                        if (!one.contains(alist.get(d))) {

                            one.add(alist.get(d));
                        } else {

                            continue;
                        }

                        for (int e = 0; e < 9; e++) {

                            if (!one.contains(alist.get(e))) {

                                one.add(alist.get(e));
                            } else {

                                continue;
                            }

                            for (int f = 0; f < 9; f++) {

                                if (!two.contains(blist.get(f))) {

                                    two.add(blist.get(f));
                                } else {

                                    continue;
                                }

                                for (int g = 0; g < 9; g++) {

                                    if (!two.contains(blist.get(g))) {

                                        two.add(blist.get(g));
                                    } else {

                                        continue;
                                    }

                                    for (int h = 0; h < 9; h++) {

                                        if (!two.contains(blist.get(h))) {

                                            two.add(blist.get(h));
                                        } else {

                                            continue;
                                        }

                                        for (int i = 0; i < 9; i++) {

                                            if (!two.contains(blist.get(i))) {

                                                two.add(blist.get(i));
                                            } else {

                                                continue;
                                            }

                                            for (int j = 0; j < 9; j++) {

                                                if (!two.contains(blist.get(j))) {

                                                    two.add(blist.get(j));
                                                } else {

                                                    continue;
                                                }

                                                ArrayList<Integer> temp1 = (ArrayList<Integer>) one.clone();
                                                ArrayList<Integer> temp2 = (ArrayList<Integer>) two.clone();

                                                append = combine(temp1, temp2);
                                                rev = combine(temp2, temp1);
                                                

                                                if (isSolution(temp1, temp2)) {

                                                    if (!set.contains(append) && !set.contains(rev)) {

                                                        set.add(append);
                                                        //System.out.println(append);
                                                    }
                                                }

                                                two.remove(two.size() - 1);
                                            }

                                            two.remove(two.size() - 1);
                                        }

                                        two.remove(two.size() - 1);
                                    }

                                    two.remove(two.size() - 1);
                                }

                                two.remove(two.size() - 1);
                            }

                            one.remove(one.size() - 1);
                        }

                        one.remove(one.size() - 1);
                    }

                    one.remove(one.size() - 1);
                }

                one.remove(one.size() - 1);
            }

            one.remove(one.size() - 1);
        }
        
        long end = System.currentTimeMillis() - start;
        System.out.println(end + "ms");
        System.out.println(set.size());
        

    }

    public static ArrayList<Integer> combine(ArrayList<Integer> a, ArrayList<Integer> b) {

        ArrayList<Integer> combined = new ArrayList<>();

        Collections.sort(a);
        Collections.sort(b);

        //System.out.println(a + " " + b);
        for (int i = 0; i < 6; i++) {

            combined.add(a.get(i));
        }

        for (int i = 0; i < 6; i++) {

            combined.add(b.get(i));
        }

        return combined;
    }

    public static boolean isSolution(ArrayList<Integer> one, ArrayList<Integer> two) {

        boolean first = false;
        boolean four = false;
        boolean nine = false;
        boolean sixteen = false;
        boolean twentyfive = false;
        boolean thirtysix = false;
        boolean fortynine = false;
        boolean sixtyfour = false;
        boolean eightyone = false;

        //if we have 01
        if ((one.contains(0) && two.contains(1)) || (two.contains(0) && one.contains(1))) {

            first = true;
        } else {
            return false;
        }

        //if we have 04
        if ((one.contains(0) && two.contains(4)) || (two.contains(0) && one.contains(4))) {

            four = true;
        } else {
            return false;
        }

        //if we have 09
        if ((one.contains(0) && (two.contains(6) || two.contains(9))) || (two.contains(0) && (one.contains(6) || one.contains(9)))) {

            nine = true;
        } else {
            return false;
        }

        //if we have 16
        if ((one.contains(1) && (two.contains(6) || two.contains(9))) || (two.contains(1) && (one.contains(6) || one.contains(9)))) {

            sixteen = true;
        } else {
            return false;
        }

        //if we have 25
        if ((one.contains(2) && two.contains(5)) || (two.contains(2) && one.contains(5))) {

            twentyfive = true;
        } else {
            return false;
        }

        //if we have 36
        if ((one.contains(3) && (two.contains(6) || two.contains(9))) || (two.contains(3) && (one.contains(6) || one.contains(9)))) {

            thirtysix = true;
        } else {
            return false;
        }

        //if we have 49
        if ((one.contains(4) && (two.contains(6) || two.contains(9))) || (two.contains(4) && (one.contains(6) || one.contains(9)))) {

            fortynine = true;
            sixtyfour = true;
        } else {
            return false;
        }

        //if we have 49, we already have 64
        //if we have 81
        if ((one.contains(8) && two.contains(1)) || (two.contains(8) && one.contains(1))) {

            eightyone = true;
        } else {
            return false;
        }

        return first && four && nine && sixteen && twentyfive && thirtysix && fortynine && sixtyfour && eightyone;
    }
}
