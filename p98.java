
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Caleb
 */
public class p98 {

    public static void main(String[] args) throws FileNotFoundException {
        
        long start = System.currentTimeMillis();

        File file = new File("C:\\Users\\Caleb\\Documents\\NetBeansProjects\\Euler\\src\\main\\java\\txt files for euler\\p098_words.txt");
        Scanner scan = new Scanner(file);

        String[] words = scan.next().split("\",\"");
        words[0] = words[0].substring(1);
        words[words.length - 1] = words[words.length - 1].substring(0, words[words.length - 1].length() - 1);

        //from a String[] of all the words in order, we want to sort the words into lists based on their length,
        //to compare with other words of the same length to potentially be anagrams
        
        ArrayList<String>[] sort = new ArrayList[15];

        for (int i = 0; i < sort.length; i++) {

            sort[i] = new ArrayList<>();
        }

        for (String word : words) {

            sort[word.length()].add(word);
        }

        //start at list of longest words and move to smaller words
        //find any anagrams
        //call function on those anagrams to analyze if there's a corresponding square pair
        //if yes, mark a num
        //iterate through till end of group of same sized words, keeping the max of all corresponding pairs
        
        int temp, max = 0;

        for (int i = sort.length - 1; i >= 0; i--) {

            temp = findMax(sort[i]);

            //break and print the first found max, all others found will be smaller
            if (temp != 0) {

                max = temp;
                break;
            }
        }
        
        System.out.println(max);
        
        long stop = System.currentTimeMillis();
        System.out.println(stop - start + "ms");
    }

    private static int findMax(ArrayList<String> list) {

        int val, max = 0;
        boolean done = false;
        ArrayList<Long> squares = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            for (int j = i + 1; j < list.size(); j++) {

                if (isAnagram(list.get(i), list.get(j))) {

                    if (!done) {

                        squares = setSquares(list.get(0).length());
                        done = true;
                    }

                    val = getMaxSquare(list.get(i), list.get(j), squares);

                    if (val > max) {

                        max = val;
                    }
                }
            }
        }

        return max;
    }

    //sorts the character arrays and compares them
    private static boolean isAnagram(String word1, String word2) {

        char[] arr = word1.toCharArray();
        Arrays.sort(arr);

        char[] arr2 = word2.toCharArray();
        Arrays.sort(arr2);

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != arr2[i]) {

                return false;
            }
        }

        return true;
    }

    private static int getMaxSquare(String one, String two, ArrayList<Long> squares) {

        //set up maps for the frequency of characters
        //one map for the word(s), and one for the numbers
        HashMap<Character, Integer> charfreq = new HashMap<>();
        HashMap<Integer, Integer> numfreq = new HashMap<>();
        
        String num;
        boolean match;
        
        //populate the char hashmap
        for (int i = 0; i < one.length(); i++) {

            charfreq.put(one.charAt(i), charfreq.getOrDefault(one.charAt(i), 0) + 1);
        }

        //populate num hashmap
        for (int i = squares.size() - 1; i >= 0; i--) {

            num = String.valueOf(squares.get(i));
            match = true;
            numfreq.clear();

            //read in num freq data for each tested square and clear if not a match repeatedly
            for (int j = 0; j < num.length(); j++) {

                numfreq.put(Character.getNumericValue(num.charAt(j)), numfreq.getOrDefault(Character.getNumericValue(num.charAt(j)), 0) + 1);
            }

            //compare frequencies
            for (int j = 0; j < num.length(); j++) {

                if (charfreq.size() != numfreq.size() || charfreq.get(one.charAt(j)) != numfreq.get(Character.getNumericValue(num.charAt(j)))) {

                    match = false;
                    break;
                }
            }

            //if the frequencies of the word and numbers work
            //create a new string number based on the "swapped" anagramic character key
            if (match) {

                String num2 = swap(one, two, num);

                //verify the new number by swapping is a valid second member of the pair
                if (noLeadingZeroes(num2) && isSquare(Integer.parseInt(num2))) {

                    return Math.max(Integer.parseInt(num), Integer.parseInt(num2));
                }
            }
        }

        return 0;
    }

    private static ArrayList<Long> setSquares(int length) {

        ArrayList<Long> list = new ArrayList<>();

        long val = (int) Math.floor(Math.sqrt(Math.pow(10, length - 1))) + 1;

        while (val * val < Math.pow(10, length)) {

            list.add(val * val);
            val++;
        }

        return list;
    }

    //creates the second number based on the anagramic swaps
    private static String swap(String one, String two, String num) {

        HashMap<Character, Character> map = new HashMap<>();
        String str = "";

        for (int i = 0; i < one.length(); i++) {

            map.put(one.charAt(i), num.charAt(i));
        }

        for (int i = 0; i < one.length(); i++) {

            str += map.get(two.charAt(i));
        }

        return str;
    }

    //cast to integer, and back to string to get rid of leading 0's
    private static boolean noLeadingZeroes(String num2) {

        String str = String.valueOf(Integer.parseInt(num2));

        return str.length() == num2.length();
    }

    private static boolean isSquare(int n) {

        return Math.sqrt(n) == Math.floor(Math.sqrt(n));
    }
}
