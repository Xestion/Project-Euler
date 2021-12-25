

import java.io.*;
import java.util.*;

public class p89 {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\Caleb\\Documents\\NetBeansProjects\\Euler\\src\\main\\java\\txt files for euler\\p089_roman.txt");
        Scanner scan = new Scanner(file);

        String str;
        int difference;
        int val;
        int sum = 0;
        String minlenstr;

        while (scan.hasNextLine()) {

            str = String.valueOf(scan.nextLine());

            val = getStrVal(str);
            minlenstr = getBest(val);

            difference = str.length() - minlenstr.length();

            if (difference > 0) {

                sum += difference;
            }
        }

        System.out.println(sum);
    }

    public static int getStrVal(String str) {

        char curr;
        char next;
        int num = 0;

        for (int i = 0; i < str.length(); i++) {

            curr = str.charAt(i);

            //sum up all characters in str
            switch (curr) {
                case 'M' ->
                    num += 1000;
                case 'D' ->
                    num += 500;
                case 'C' ->
                    num += 100;
                case 'L' ->
                    num += 50;
                case 'X' ->
                    num += 10;
                case 'V' ->
                    num += 5;
                case 'I' ->
                    num += 1;
                default -> {
                }
            }

            //subtract out negations
            //make sure no out of bounds shit, looking at i + 1
            if (i != str.length() - 1) {

                next = str.charAt(i + 1);

                //compare elements at i and i + 1
                if ((curr == 'I' && next == 'V') || (curr == 'I' && next == 'X')) {

                    num -= 2;
                } else if ((curr == 'X' && next == 'L') || (curr == 'X' && next == 'C')) {

                    num -= 20;
                } else if ((curr == 'C' && next == 'D') || (curr == 'C' && next == 'M')) {

                    num -= 200;
                }
            }
        }

        return num;
    }

    public static String getBest(int val) {

        char[] numerals = {'I', 'V', 'X', 'L', 'C', 'D', 'M', ' '};
        String minstr = "";
        int index = 0; //from last index
        int temp;

        while (val > 0) {

            temp = val % (int) Math.pow(10, index + 1) / (int) Math.pow(10, index);

            //do the 1/2/3 cases
            if (temp > 0 && temp < 4) {

                for (int i = 0; i < temp; i++) {

                    //skip 2 in numerals even when iterating index once to keep ties
                    minstr = numerals[2 * index] + minstr;
                }
            } //do the 5 - 1 subtraction case of 4
            else if (temp == 4) {

                if (val % 1000 != 0) {

                    minstr = numerals[2 * (index + 1)] + minstr;
                    minstr = numerals[2 * index] + minstr;
                } else {

                    for (int i = 0; i < val / 1000; i++) {

                        minstr = numerals[6] + minstr;
                    }
                }

            } //do the 5+1/2/3 cases
            else if (temp > 4 && temp < 9) {

                for (int i = 0; i < temp % 5; i++) {

                    minstr = numerals[2 * index] + minstr;
                }

                minstr = numerals[(2 * index) + 1] + minstr;

            } //do the 10 - 1 subtraction case of 9
            else if (temp == 9) {

                minstr = numerals[(2 * index) + 2] + minstr;
                minstr = numerals[2 * index] + minstr;
            }

            val -= temp * Math.pow(10, index);

            index++;
        }

        return minstr;
    }

}
