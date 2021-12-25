

import java.util.Random;

public class p84 {

    static Random rand = new Random();

    public static void main(String[] args) {

        int rolls = 100000000;
        int[] board = new int[40];
        int loc = 0;
        int doubles = 0;
        int one;
        int two;
        int chestCard = 0;
        int chanceCard = 0;

        while (rolls > 0) {

            one = rand.nextInt(4) + 1;
            two = rand.nextInt(4) + 1;

            if (one == two) {

                doubles++;

                if (doubles == 3) {

                    loc = 10;
                    board[loc]++;
                    doubles = 0;
                    continue;
                }
            } else {
                
                doubles = 0;
            }

            loc = (loc + one + two) % 40;
            
            labelbreak:

            //lands on cc
            if (loc == 2 || loc == 17 || loc == 33) {

                if (chestCard == 3) {

                    //go to jail
                    loc = 10;
                    board[loc]++;
                    chestCard = (chestCard + 1) % 16;
                    doubles = 0;
                    continue;

                } else if (chestCard == 7) {

                    //advance to go
                    loc = 0;
                    board[loc]++;
                    chestCard = (chestCard + 1) % 16;
                    continue;

                } else {
                    
                    board[loc]++;
                    chestCard = (chestCard + 1) % 16;
                    continue;
                }

                //lands on chance
            } else if (loc == 7 || loc == 22 || loc == 36) {

                if (chanceCard == 1) {
                    
                    //advance to go
                    loc = 0;
                    board[loc]++;
                    chanceCard = (chanceCard + 1) % 16;
                    continue;
                    
                } else if (chanceCard == 2) {
                    
                    //go to jail
                    loc = 10;
                    board[loc]++;
                    chanceCard = (chanceCard + 1) % 16;
                    doubles = 0;
                    continue;
                    
                } else if (chanceCard == 3) {
                    
                    //go to loc = 11
                    loc = 11;
                    board[loc]++;
                    chanceCard = (chanceCard + 1) % 16;
                    continue;
                    
                } else if (chanceCard == 4) {
                    
                    //go to loc = 24
                    loc = 24;
                    board[loc]++;
                    chanceCard = (chanceCard + 1) % 16;
                    continue;
                    
                }  else if (chanceCard == 5) {
                    
                    //go to loc = 39
                    loc = 39;
                    board[loc]++;
                    chanceCard = (chanceCard + 1) % 16;
                    continue;
                    
                } else if (chanceCard == 6) {
                    
                    //go to loc = 5
                    loc = 5;
                    board[loc]++;
                    chanceCard = (chanceCard + 1) % 16;
                    continue;
                    
                } else if (chanceCard == 7 || chanceCard == 8) {
                    
                    //go to next RR
                    
                    
                    if (loc == 7) {
                        
                        loc = 15;
                        board[loc]++;
                        chanceCard = (chanceCard + 1) % 16;
                        continue;
                        
                    } else if (loc == 22) {
                        
                        loc = 25;
                        board[loc]++;
                        chanceCard = (chanceCard + 1) % 16;
                        continue;
                        
                    } else {
                        
                        loc = 5;
                        board[loc]++;
                        chanceCard = (chanceCard + 1) % 16;
                        continue;
                    }
                } else if (chanceCard == 9) {
                    
                    //go to next utility
                    
                    if (loc == 7 || loc == 36) {
                        
                        loc = 12;
                        board[loc]++;
                        chanceCard = (chanceCard + 1) % 16;
                        continue;
                        
                    } else {
                        
                        loc = 29;
                        board[loc]++;
                        chanceCard = (chanceCard + 1) % 16;
                        continue;
                    }
                } else if (chanceCard == 10) {
                    
                    //go back 3 spaces
                    
                    if (loc == 36) {
                        
                        loc = loc - 3;
                        chanceCard = (chanceCard + 1) % 16;
                        break labelbreak;
                        
                    } else if (loc == 7) {
                        
                        loc = loc - 3;
                        board[loc]++;
                        chanceCard = (chanceCard + 1) % 16;
                        continue;
                        
                    } else {
                        
                        loc = loc - 3;
                        board[loc]++;
                        chanceCard = (chanceCard + 1) % 16;
                        continue;
                    }
                } else {
                    
                    board[loc]++;
                    chanceCard = (chanceCard + 1) % 16;
                    continue;
                }
                
                //lands on go to jail
            } else if (loc == 30) {

                loc = 10;
                board[loc]++;
                doubles = 0;
                continue;
            }

            board[loc]++;
            rolls--;
        }
        
        for (int i = 0; i < 40; i++) {
            
            System.out.println(i + ". " + board[i]);
        }
        
        //3 most landed on spaces

    }
}
