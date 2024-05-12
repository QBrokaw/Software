package javapractice; 

/*This is my guessing game
 it is very simple, but it works and is a lot of fun.*/

import java.util.Random;
import java.util.Scanner;
//The Scanner utility is used to get user imput.

public class GuessTheNumber {
    /*This is the main function. it creates the varibles
     * sets a the random number in a variable.
     * it then checks the players guess against the random
     * variable.
    */
    public static void main(String[] args) {
        //This is the main 
        Random rando = new Random();
        //This is where the random number we import is stored in a variable.
        int randNum = rando.nextInt(100);
        // this is sets the max number
        int numGuesses = 0;
        // this variable is used to store the number of times the player has guessed.
        Scanner input = new Scanner(System.in);
        /*this is the imput we imported, it is used to be able to move the players input
         * to a variable.
         */
        int guess;
        // this is the varible to store the players guess.
        boolean win = false;
        //  This variable is to store when they have won the game.
        while (win == false) {
                /*This is a while loop, it keeps iterating through the game so you dont 
                 * have to keep calling the function, every time you guess. This loop 
                 * will continue to run as long as the Boolean is false. Once it is changed
                 * to true, the loop stops and the next lines are run.
                 */
            System.out.println("Guess a number between 1 and 100: ");
            // this is the first line of text the player will see.
            guess = input.nextInt();
            //This varible stores the guess the player inputs.
            numGuesses++;
            /*this counts the number of times the player has guessed. every time they guess
             * it adds one to the variable numGuesses.
            */
            if (guess == randNum){
            /*This is how the game is won, if the players guess is the same number that the 
            random number generator pics, then this if statement changes the boolean to true. */    
                win = true;
            
            }
            
            else if (guess < randNum) {
            /*if the players guess is lower than the number the random number generator picked, they are give a prompt
             * that their guss is too low.
             */
                System.out.println("Too low");
            }

            else if (guess > randNum) {
            /*if the players guess is higher than the number the random number generator picked, they are give a prompt
             * that their guss is too High.  
             */
                System.out.println("Too High");
            }
        }
        
        System.out.println("Woo Hoo You Won!");
        /*once the players guess is the same as the random number, the program exits the while loop, and this text 
         * is displayed telling them that they have won.
         */
        System.err.println("It only too you " + numGuesses + " Times" );
        /*once the player know they have won, the number of times they guessed is displayed  */

        System.err.println("Game Over!");
    }
}