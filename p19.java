
/**
 *
 * @author Caleb
 */
public class p19 {

    public static void main(String[] args) {

        int day = 3;
        int count = 0;
        //january
        for (int i = 1; i <= 100;) {

            if (day == 1) {
                count++;
            }

            if ((i) % 4 == 0) {
                day += 2;
            } else {
                day++;
            }
            i++;
            while (day > 7) {
                day -= 7;

            }
        }
        //february
        day = 6;
        for (int i = 1; i <= 100;) {

            if (day == 1) {
                count++;
            }

            if ((i) % 4 == 0) {
                day += 2;
            } else {
                day++;
            }
            i++;
            while (day > 7) {
                day -= 7;

            }
        }
        //march
        day = 6;

        for (int i = 1; i <= 100;) {

            if (day == 1) {
                count++;
            }
            i++;
            if ((i) % 4 == 0) {
                day += 2;
            } else {
                day++;
            }

            while (day > 7) {
                day -= 7;

            }
        }
        //april
        day = 2;
        for (int i = 1; i <= 100;) {

            if (day == 1) {
                count++;
            }
            i++;
            if ((i) % 4 == 0) {
                day += 2;
            } else {
                day++;
            }

            while (day > 7) {
                day -= 7;

            }
        }
        //may
        day = 4;
        for (int i = 1; i <= 100;) {

            if (day == 1) {
                count++;
            }
            i++;
            if ((i) % 4 == 0) {
                day += 2;
            } else {
                day++;
            }

            while (day > 7) {
                day -= 7;

            }
        }
        //june
        day = 7;

        for (int i = 1; i <= 100;) {

            if (day == 1) {
                count++;
            }
            i++;
            if ((i) % 4 == 0) {
                day += 2;
            } else {
                day++;
            }

            while (day > 7) {
                day -= 7;

            }
        }

        //july
        day = 2;
        for (int i = 1; i <= 100;) {

            if (day == 1) {
                count++;
            }
            i++;
            if ((i) % 4 == 0) {
                day += 2;
            } else {
                day++;
            }

            while (day > 7) {
                day -= 7;

            }
        }
        //august
        day = 5;
        for (int i = 1; i <= 100;) {

            if (day == 1) {
                count++;
            }
            i++;
            if ((i) % 4 == 0) {
                day += 2;
            } else {
                day++;
            }

            while (day > 7) {
                day -= 7;

            }
        }
        //september
        day = 1;
        for (int i = 1; i <= 100;) {

            if (day == 1) {
                count++;
            }
            i++;
            if ((i) % 4 == 0) {
                day += 2;
            } else {
                day++;
            }

            while (day > 7) {
                day -= 7;

            }
        }
        //october
        day = 3;
        for (int i = 1; i <= 100;) {

            if (day == 1) {
                count++;
            }
            i++;
            if ((i) % 4 == 0) {
                day += 2;
            } else {
                day++;
            }

            while (day > 7) {
                day -= 7;

            }
        }
        //november
        day = 6;
        for (int i = 1; i <= 100;) {

            if (day == 1) {

                count++;
            }

            i++;

            if ((i) % 4 == 0) {

                day += 2;
            } else {
                day++;
            }

            while (day > 7) {
                day -= 7;

            }
        }
        //december
        day = 1;
        for (int i = 1; i <= 100;) {

            if (day == 1) {
                count++;
            }

            i++;

            if ((i) % 4 == 0) {
                day += 2;
            } else {
                day++;
            }

            while (day > 7) {
                day -= 7;

            }
        }

        System.out.println(count);
    }

}
//confirmed.

