import java.util.Scanner;
import java.lang.Math;
public class Guess_The_Number {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int ans =(int) (Math.random()*100)+1;
        int no_of_trials = 5;
        boolean right_option = false;
        System.out.println("The computer has selected a number between 1 and 100 ");
        System.out.println("You've got 5 trials to guess the number!!");

        while (no_of_trials>0){
            System.out.println("Enter the number you've guessed");
            int guessed_number = sc.nextInt();
            no_of_trials--;
            if (guessed_number == ans) {
                System.out.println("You've guessed it right, the number is "+ans);
                System.out.println("--YOU WIN--");
                right_option=true;
                break;
            } else if (guessed_number > ans) {
                System.out.println("The number entered is greater than selected number");
                System.out.println("You've got "+no_of_trials+" trials left");
            }
            else {
                System.out.println("The number entered is less than selected number");
                System.out.println("You've got "+no_of_trials+" trials left");
            }
        }

        if (!right_option) {
            System.out.println("You've got no trials anymore");
            System.out.println("Actual number was: "+ans);
            System.out.println("YOU LOSE");

        }
    }
}