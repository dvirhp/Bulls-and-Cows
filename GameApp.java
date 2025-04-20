import javax.swing.JOptionPane;

public class GameApp {
    public static void main(String[] args) {
        boolean isGameActive = true;
        String currentMessage = "";
        NumberGuessingGame gameSession = new NumberGuessingGame();
        String previousGuesses = "";

        while (isGameActive) {
            // Prompt the user to enter their guess
            String userGuess = JOptionPane.showInputDialog("Enter your 4-digit guess:");

            // Check the user's guess and show the result
            currentMessage = gameSession.evaluateGuess(userGuess);
            JOptionPane.showMessageDialog(null, currentMessage + "\nPrevious guesses: " + previousGuesses);

            // Save the previous guesses if they are valid
            if (currentMessage.startsWith("Your")) {
                previousGuesses += "\n" + currentMessage;
            }

            // Check if the user has won
            if (currentMessage.startsWith("Congratulations!")) {
                String playAgain = JOptionPane.showInputDialog("Would you like to play again? (Y/N)");
                if (playAgain.equalsIgnoreCase("Y")) {
                    gameSession = new NumberGuessingGame(); // Create a new game session
                    previousGuesses = ""; // Reset previous guesses
                } else {
                    JOptionPane.showMessageDialog(null, "Thank you for playing! Goodbye!");
                    isGameActive = false; // Exit the loop
                }
            }
        }
    }
}
