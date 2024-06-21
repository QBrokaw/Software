use std::io;

fn main() {
    let words = vec!["saint", "simon", "templar"]; // this is my word list
    let mut word_index = 0;

    loop {
        let selected_word = words[word_index];
        word_index = (word_index + 1) % words.len(); // This is how it Cycles through the words

        let mut guessed_letters = vec!['_'; selected_word.len()];
        let mut attempts = 10; // This is the number of guesses you get

        println!("Hangman!"); //this is the begining line of the gane
        println!("Guess the word: {}", guessed_letters.iter().collect::<String>());  //the Correct letters guessed will show up on this line

        while attempts > 0 {  //this is the game loop to let you keep guessing
            println!("Guesses left: {}", attempts);  //This tells you how many guess you have left
            println!("Enter a letter: ");   
            let mut guess = String::new();  //This is the guess or letter input
            io::stdin().read_line(&mut guess).expect("Failed to read line");  //A simple fail safe if something goes wrong
            let guess = guess.trim();

            // this is to check to see if the guessed letter is in the word
            if selected_word.contains(guess) {
                for (i, c) in selected_word.chars().enumerate() {    //simple for loop to search through the word to match the guessed letter
                    if c.to_string() == guess {
                        guessed_letters[i] = c;
                    }
                }
            } else {
                attempts -= 1;  //This is how we iterate the number of guess back words from the total of guesses in line 12
            }

            println!("Correct Guesses: {}", guessed_letters.iter().collect::<String>());  //this is a display of the correct guesses

            if guessed_letters.iter().collect::<String>() == selected_word {
                println!("Nicely Done! You are correct, the word is: {}", selected_word);  //This is the winning screen
                break;
            }
        }

        if attempts == 0 {
            println!("Game over! The word was: {}", selected_word);   //This is the losing screen
        }

        println!("Do you want to play again? (Y/N)"); //This is how we can restart the game after a win or loss.
        let mut play_again = String::new();
        io::stdin().read_line(&mut play_again).expect("Failed to read line");
        if play_again.trim().to_lowercase() != "y" {
            println!("Good Bye!"); //If the player chooses no then this quits the game.
            break;
        }
    }
}