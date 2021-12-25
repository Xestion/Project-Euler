

import java.util.*;

/**
 *
 * @author Caleb
 */
public class p93 {

    static Set<ArrayList<Integer>> set = new HashSet();
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<String> ops = new ArrayList<>();
    static int[] arr = new int[210];
    static String[] sarr = new String[210];
    static boolean[] runbool = new boolean[3500];
    static ArrayList<ArrayList<Integer>> permutes = new ArrayList<>();

    public static void main(String[] args) {

        makeOperators();
        ArrayList<Integer> best = new ArrayList<>();

        int run, max = 0, index = -1;

        for (int one = 0; one < 10; one++) {

            for (int two = 1; two < 10; two++) {

                if (two != one) {

                    for (int three = 2; three < 10; three++) {

                        if (three != two && three != one) {

                            for (int four = 3; four < 10; four++) {

                                if (four != one && four != two && four != three) {

                                    list.clear();
                                    Collections.addAll(list, one, two, three, four);
                                    Collections.sort(list);

                                    if (!set.contains(list)) {

                                        ArrayList temp = (ArrayList) list.clone();
                                        set.add(temp);
                                        index++;
                                        zero(runbool);
                                        permutes.clear();

                                        run = getRun(temp);

                                        arr[index] = run;
                                        sarr[index] = putString(temp);

                                        if (run > max) {

                                            max = run;
                                            best = (ArrayList) list.clone();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println("max run = " + max);
        //System.out.println(set);
        System.out.println(best);
        for (int i = 0; i < 210; i++) {
            
            //System.out.print("[ " +arr[i] + ", " + sarr[i] + " ], ");
        }
        
    }

    public static String putString(ArrayList<Integer> list) {

        String str = "";
        for (int i = 0; i < list.size(); i++) {

            str += String.valueOf(list.get(i));
        }

        return str;
    }

    public static int getRun(ArrayList<Integer> list) {

        //permute all digits in set
        permute(list, 0);
        
        //blend all permutes with operators
        ArrayList<String> blended = blend();
        
        //apply all groupings to blended sets
        ArrayList<String> infix = group(blended);
        
        //convert all sets to postfix
        ArrayList<String> post = postfix(infix);
        
        //find run of this set of digits using all expressions
        int run = eval(post);

        return run;
    }

    public static void zero(boolean[] arr) {

        for (int i = 0; i < arr.length; i++) {

            arr[i] = false;
        }
    }

    public static void permute(ArrayList<Integer> base, int pos) {

        ArrayList<Integer> list = (ArrayList) base.clone();

        if (pos == 3) {

            permutes.add(list);
            return;
        }

        for (int i = pos; i < list.size(); i++) {

            Collections.swap(list, i, pos);
            permute(list, pos + 1);
            Collections.swap(list, i, pos);
        }
    }

    public static void makeOperators() {

        String one, two, three, whole;
        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                for (int k = 0; k < 4; k++) {

                    switch (i) {
                        case 0 -> {
                            one = "+";
                        }
                        case 1 -> {
                            one = "-";
                        }
                        case 2 -> {
                            one = "/";
                        }
                        default -> {
                            one = "*";
                        }
                    }

                    switch (j) {
                        case 0 -> {
                            two = "+";
                        }
                        case 1 -> {
                            two = "-";
                        }
                        case 2 -> {
                            two = "/";
                        }
                        default -> {
                            two = "*";
                        }
                    }

                    switch (k) {
                        case 0 -> {
                            three = "+";
                        }
                        case 1 -> {
                            three = "-";
                        }
                        case 2 -> {
                            three = "/";
                        }
                        default -> {
                            three = "*";
                        }
                    }

                    whole = one + two + three;
                    ops.add(whole);
                }
            }
        }
    }

    public static ArrayList<String> blend() {

        String str;
        ArrayList<String> blended = new ArrayList<>();
        for (int diglist = 0; diglist < permutes.size(); diglist++) {

            for (int oplist = 0; oplist < ops.size(); oplist++) {

                str = "";
                for (int it = 0; it < 4; it++) {

                    str += String.valueOf(permutes.get(diglist).get(it));
                    if (it == 3) {

                        continue;
                    }
                    str += String.valueOf(ops.get(oplist).charAt(it));
                }

                if (!blended.contains(str)) {

                    blended.add(str);
                }
            }
        }

        return blended;
    }

    public static ArrayList<String> group(ArrayList<String> list) {

        ArrayList<String> grouped = new ArrayList<>();
        String temp, curr;
        for (int i = 0; i < list.size(); i++) {

            curr = list.get(i);

            //abcd
            grouped.add(curr);

            //(ab)cd
            temp = "(" + curr.substring(0, 3) + ")" + curr.substring(3);
            grouped.add(temp);

            //a(bc)d
            temp = curr.substring(0, 2) + "(" + curr.substring(2, 5) + ")" + curr.substring(5);
            grouped.add(temp);

            //ab(cd)
            temp = curr.substring(0, 4) + "(" + curr.substring(4) + ")";
            grouped.add(temp);

            //(ab)(cd)
            temp = "(" + curr.substring(0, 3) + ")" + curr.substring(3, 4) + "(" + curr.substring(4) + ")";
            grouped.add(temp);

            //(abc)d
            temp = "(" + curr.substring(0, 5) + ")" + curr.substring(5);
            grouped.add(temp);

            //a(bcd)
            temp = curr.substring(0, 2) + "(" + curr.substring(2) + ")";
            grouped.add(temp);

            //((ab)c)d
            temp = "((" + curr.substring(0, 3) + ")" + curr.substring(3, 5) + ")" + curr.substring(5);
            grouped.add(temp);

            //(a(bc))d
            temp = "(" + curr.substring(0, 2) + "(" + curr.substring(2, 5) + "))" + curr.substring(5);
            grouped.add(temp);

            //a((bc)d)
            temp = curr.substring(0, 2) + "((" + curr.substring(2, 5) + ")" + curr.substring(5);
            grouped.add(temp);

            //a(b(cd))
            temp = curr.substring(0, 2) + "(" + curr.substring(2, 4) + "(" + curr.substring(4, 7) + "))" + curr.substring(7);
            grouped.add(temp);
        }

        return grouped;
    }

    public static ArrayList<String> postfix(ArrayList<String> base) {

        String result;
        Stack<Character> stack = new Stack<>();
        ArrayList<String> fixed = new ArrayList<>();

        for (int exp = 0; exp < base.size(); exp++) {

            result = "";

            if (nested(base.get(exp))) {

                base.set(exp, "(" + base.get(exp) + ")");
            }

            for (int i = 0; i < base.get(exp).length(); i++) {

                char curr = base.get(exp).charAt(i);

                if (Character.isLetterOrDigit(curr)) {

                    result += curr;
                } else if (curr == '(') {

                    stack.push(curr);
                } else if (curr == ')') {

                    while (!stack.isEmpty() && stack.peek() != '(') {

                        if (stack.peek() != '(') {

                            result += stack.pop();
                        }
                    }

                    stack.pop();
                } else {

                    while (!stack.isEmpty() && priority(curr) <= priority(stack.peek())) {

                        result += stack.pop();
                    }

                    stack.push(curr);
                }
            }

            while (!stack.isEmpty()) {

                if (stack.peek() == '(') {

                    stack.pop();
                    break;
                }

                result += stack.pop();
            }

            fixed.add(result);
        }

        return fixed;
    }

    static int priority(char ch) {

        switch (ch) {

            case '+', '-' -> {
                return 1;
            }
            case '*', '/' -> {
                return 2;
            }
        }
        
        return -1;
    }

    public static boolean nested(String str) {

        char curr;
        int count = 0;
        for (int i = 1; i < str.length(); i++) {

            curr = str.charAt(i);
            if (curr == '(') {

                count++;
            }

            if (count > 1) {

                return true;
            }
        }

        return false;
    }
    
    public static int eval(ArrayList<String> list) {
        
        Stack<Float> stack = new Stack<>();
        char curr;
        float op1, op2, val = 0;
        
        for (int exp = 12; exp < list.size(); exp++) {
            
            OUTER:
            for (int index = 0; index < list.get(exp).length(); index++) {
                
                curr = list.get(exp).charAt(index);
                if (Character.isLetterOrDigit(curr)) {
                    
                    stack.push((float)Character.getNumericValue(curr));
                    
                } else {
                    
                    op2 = stack.pop();
                    op1 = stack.pop();
                    
                    switch (curr) {
                        
                        case '+' -> {
                            
                            val = op1 + op2;
                            stack.push(val);
                        }
                        case '-' -> {
                            
                            val = op1 - op2;
                            stack.push(val);
                        }
                        case '*' -> {
                            
                            val = op1 * op2;
                            stack.push(val);
                        }

                        default -> {
                            
                            //div by 0
                            if (op2 == 0) {
                                //System.out.println(list.get(exp));
                                break OUTER;
                            }
                            
                            val = (float) op1 / (float) op2;
                            stack.push(val);
                        }
                    }
                } 
            }
            
            if (val == (int) val && val > 0) {
                
                runbool[ (int) val] = true;
            }
            
            if (!stack.isEmpty()) {
            
                stack.pop();
            }
        }
        
        int run = run();
        return run;
        
    }
    
    public static int run() {
        
        int count = 0;
        
        for (int i = 1; i < runbool.length; i++) {
            //System.out.println(runbool[i]);
            if (runbool[i]) {
                
                count++;
            } else {
                
                break;
            }
        }
        
        return count;
    }
}
