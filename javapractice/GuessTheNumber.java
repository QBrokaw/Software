package javapractice;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {

        Random rando = new Random();
        int randNum = rando.nextInt(100);
        int numGuesses = 0;
        Scanner input = new Scanner(System.in);
        int guess;
        boolean win = false;

        while (win == false) {

            System.out.println("Guess a number between 1 and 100: ");
            guess = input.nextInt();
            numGuesses++;

            if (guess == randNum){
                win = true;
            }
            else if (guess < randNum) {
            System.out.println("Too low");
            }
            else if (guess > randNum) {
                System.out.println("Too High");
            }
        }
        System.out.println("Woo Hoo You Won!");
        System.err.println("It only too you " + numGuesses + " Times" );
    
    }
}