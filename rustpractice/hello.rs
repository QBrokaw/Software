use std::io;

fn main() {
    let words = vec!["apple", "banana", "cherry", "date", "fig"]; // Add more words here
    let mut rng = rand::thread_rng();
    let random_word = words[rng.gen_range(0..words.len())];

    let mut guessed_letters = vec!['_'; random_word.len()];
    let mut attempts = 6;

    println!("Welcome to Hangman!");
    println!("Guess the word: {}", guessed_letters.iter().collect::<String>());

    while attempts > 0 {
        println!("Attempts left: {}", attempts);
        println!("Enter a letter: ");
        let mut guess = String::new();
        io::stdin().read_line(&mut guess).expect("Failed to read line");
        let guess = guess.trim();

        if !random_word.contains(guess) {
            attempts -= 1;
        } else {
            for (i, c) in random_word.chars().enumerate() {
                if c.to_string() == guess {
                    guessed_letters[i] = c;
                }
            }
        }

        println!("Current progress: {}", guessed_letters.iter().collect::<String>());

        if guessed_letters.iter().collect::<String>() == random_word {
            println!("Congratulations! You guessed the word: {}", random_word);
            break;
        }
    }

    if attempts == 0 {
        println!("Game over! The word was: {}", random_word);
    }
}
