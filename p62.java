
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Caleb
 */
public class p62 {

    public static void main(String[] args) {

        ArrayList<Long> cubes = new ArrayList<>();
        ArrayList<Long> candidates = new ArrayList<>();
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();

        long cube;

        for (int i = 1; i < 10000; i++) {

            cube = (long) Math.pow(i, 3);
            cubes.add(cube);
        }

        for (int j = 0; j < cubes.size(); j++) {
            
            candidates.add(cubes.get(j));

            for (int k = j + 1; k < cubes.size(); k++) {

                String str1 = String.valueOf(cubes.get(j));
                String str2 = String.valueOf(cubes.get(k));
                one.clear();
                two.clear();

                for (int character = 0; character < str1.length(); character++) {

                    one.add(Character.getNumericValue((str1.charAt(character))));
                    two.add(Character.getNumericValue((str2.charAt(character))));
                }

                //System.out.println(one);
                //System.out.println(two);
                int count = 0;

                for (int digit = 0; digit < 10; digit++) {

                    if (Collections.frequency(one, digit) == Collections.frequency(two, digit)) {

                        count++;
                    }

                    if (count == 10 && !candidates.contains(cubes.get(5)) && str1.length() == str2.length()) {

                        candidates.add(cubes.get(k));
                        
                        if (candidates.size() == 5) {

                            System.out.println(candidates);
                            System.exit(0);

                        }
                    }
                }
            }
            candidates.clear();
        }
    }
}
//confirmed.

