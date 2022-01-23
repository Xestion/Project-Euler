
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Caleb
 */
public class p79 {
    
    public static void main(String args[]) throws FileNotFoundException{
        
        File file = new File("C:\\Users\\Caleb\\Documents\\NetBeansProjects\\Euler\\src\\main\\java\\txt files for euler\\p079_keylog.txt");
        Scanner scan = new Scanner(file);
        
        String[] arr = new String[50];
        int i = 0;
        
        while (scan.hasNextLine()) {
            
            arr[i] = scan.nextLine();
            i++;
        }
        
        System.out.println(construct(arr));
    }
    
    public static String construct(String[] arr) {
        
        String str = "";
        ArrayList<Integer> code = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            
            for (int j = 0; j < 3; j++) {
                
                if (!code.contains(Character.getNumericValue(arr[i].charAt(j)))) {
                    
                    code.add(Character.getNumericValue(arr[i].charAt(j)));
                }
            }
            
            code = verify(code, arr[i]);
        }
        
        for (int i = 0; i < code.size(); i++) {
            
            str += code.get(i);
        }
        
        return str;
    }
    
    public static ArrayList<Integer> verify(ArrayList<Integer> list, String str) {
        
        int one, two, three;
        
        one = list.indexOf(Character.getNumericValue(str.charAt(0)));
        two = list.indexOf(Character.getNumericValue(str.charAt(1)));
        three = list.indexOf(Character.getNumericValue(str.charAt(2)));
        
        
        if (one < two && two < three) {
            
            return list;
        }
        
        if (two > three) {
            
            list.add(three, list.get(two));
            list.remove(two + 1);
        }
        
        one = list.indexOf(Character.getNumericValue(str.charAt(0)));
        two = list.indexOf(Character.getNumericValue(str.charAt(1)));
        
        if (one > two) {
            
            list.add(two, list.get(one));
            list.remove(one + 1);
        }
        
        return list;
    }
}
//confirmed