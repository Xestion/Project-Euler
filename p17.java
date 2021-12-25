
/**
 *
 * @author Caleb
 */
public class p17 {

    public static void main(String[] args) {

        int one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen, fourteen, fifteen, sixteen, seventeen, eighteen, nineteen, twenty, thirty, forty, fifty, sixty, seventy, eighty, ninety, hundred, thousand, and;
        one = 3;
        two = 3;
        three = 5;
        four = 4;
        five = 4;
        six = 3;
        seven = 5;
        eight = 5;
        nine = 4;
        ten = 3;
        eleven = 6;
        twelve = 6;
        thirteen = 8;
        fourteen = 8;
        fifteen = 7;
        sixteen = 7;
        seventeen = 9;
        eighteen = 8;
        nineteen = 8;
        twenty = 6;
        thirty = 6;
        forty = 5;
        fifty = 5;
        sixty = 5;
        seventy = 7;
        eighty = 6;
        ninety = 6;
        hundred = 7;
        thousand = 8;
        and = 3;

        int sum = 0;

        //count 11's
        sum = sum + 10 * eleven;

        //count 12's
        sum = sum + 10 * twelve;

        //count 13's
        sum = sum + 10 * thirteen;

        //count 14's
        sum = sum + 10 * fourteen;

        //count 15's
        sum = sum + 10 * fifteen;

        //count 16's
        sum = sum + 10 * sixteen;

        //count 17's
        sum = sum + 10 * seventeen;

        //count 18's
        sum = sum + 10 * eighteen;

        //count 19's
        sum = sum + 10 * nineteen;

        //count 9's 
        sum = sum + 190 * nine;

        //count 8's
        sum = sum + 190 * eight;

        //count 7's
        sum = sum + 190 * seven;

        //count 6's
        sum = sum + 190 * six;

        //count 5's
        sum = sum + 190 * five;

        //count 4's
        sum = sum + 190 * four;

        //count 3's
        sum = sum + 190 * three;

        //count 2's
        sum = sum + 190 * two;

        //count 1's
        sum = sum + 191 * one;

        //count 20's
        sum = sum + 100 * twenty;

        //count 30's
        sum = sum + 100 * thirty;

        //count 40's
        sum = sum + 100 * forty;

        //count 50's
        sum = sum + 100 * fifty;

        //count 60's
        sum = sum + 100 * sixty;

        //count 70's
        sum = sum + 100 * seventy;

        //count 80's
        sum = sum + 100 * eighty;

        //count 90's
        sum = sum + 100 * ninety;

        //count 100's
        sum = sum + 900 * hundred;

        //count thousand
        sum = sum + thousand;

        //count and's
        sum = sum + 99 * 9 * and;

        //count 10's
        sum = sum + 10 * ten;

        System.out.println(sum);
    }
}
//confirmed, fuck that.

