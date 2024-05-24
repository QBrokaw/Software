import java.io.File

fun main() {
    val filePath = "data.txt"  //The file that stores all the notes entered in Note Pad

    val lines = mutableListOf<String>()  

    do {
        print("Enter Text ... or type 'quit' to end, 'show' to display the Notepad, 'delete' to remove line): ")  // This is the main interaction with the user
        val userInput = readLine() ?: ""   // Variable to store the string entered

        when (userInput.lowercase()) {     //My do while loop to keep it going so the user can keep entering text
            "quit" -> break    // The program will keep going untill quit is entered. this breaks the loop.
            "show" -> {   // This is how we show the whole note pad to the user.
                if (lines.isEmpty()) {    //If the file is empty it will show the next line.
                    println("The NotePad is empty.")
                } else {
                    println("NotePad:")     //If the note pad is not empty this is the Header atop of the user data.
                    lines.forEach { println(it) }
                }
            }
            "delete" -> {    //If the user wants to remove a line this is the function to remove it.
                try {
                    if (lines.isEmpty()) {   //If the NotePad is empty this is warning to the user the notepad is blank
                        println("NotePad is Blank, nothing to delete.")
                    } else {
                        print("Enter line number to delete (1-${lines.size}): ")    //If there is data it will ask which line of the NotePad to delete.
                        val lineIndex = readLine()?.toIntOrNull() ?: -1
                        if (lineIndex in 1..lines.size) {
                            lines.removeAt(lineIndex - 1)  //Most people dont count 0 as the first number this make 1 as the first line number
                            println("Line deleted.")
                            rewriteToFile(filePath, lines)  
                        } else {
                            println("Invalid line number.")    //you can only delete the number of saved lines
                        }
                    }
                } catch (e: Exception) {
                    println("Error reading/deleting line: ${e.message}")  //This an error if there is a problem deleting a line.
                }
            }
            else -> {
                lines.add(userInput)  //After each time the user adds to the NotePad this rewites the data file.
                rewriteToFile(filePath, lines)  
                println("Added to the NotePad")  //This is to let the user know the note was added to the NotePad
            }
        }
    } while (true)   // the While loop as long as its true it will keep asking you to add to the Notepad

    println("Exiting...")   //the texted displayed when you type "quit"
}


fun rewriteToFile(filePath: String, lines: List<String>) {   //Function to rewrite the file
    try {
        val file = File(filePath)
        file.writeText(lines.joinToString("\n") + "\n")  //This keeps each note on a new line
    } catch (e: Exception) {
        println("Error writing to file: ${e.message}")    //Error message if there is a problem writing to the file.
    }
}
