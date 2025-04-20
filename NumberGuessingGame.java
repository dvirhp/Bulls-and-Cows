public class NumberGuessingGame {
    // Constant for the length of the secret number
    protected final int NUMBER_LENGTH = 4;
    
    protected String secretNumber = "";
    protected int attemptsMade;

    // Constructor to initialize the game with a new secret number
    public NumberGuessingGame() {
        this.secretNumber = createSecretNumber();
        this.attemptsMade = 0;
    }
    
    // Getter for the secret number
    public String getSecretNumber() {
        return secretNumber;
    }

    // Getter for the number of attempts made
    public int getAttempts() {
        return attemptsMade;
    }
    
    // Method to generate a new secret number for the game, kept private
    private String createSecretNumber() {
        StringBuilder generatedNumber = new StringBuilder();
        int randomDigit;

        // Generate random digits until the secret number reaches the desired length
        while (generatedNumber.length() < NUMBER_LENGTH) {
            randomDigit = (int) (Math.random() * 10);
            // Add the digit only if it's not already included
            if (generatedNumber.indexOf(String.valueOf(randomDigit)) == -1) {
                generatedNumber.append(randomDigit);
            }
        }
        return generatedNumber.toString();
    }

    // Method to evaluate the player's guess against the secret number
    public String evaluateGuess(String playerGuess) {
        int correctPosition = 0; // Count of digits in the correct position
        int correctDigit = 0;    // Count of correct digits but wrong position
        String resultMessage = "";
        
        // Check if the player's input is valid
        String inputError = validateInput(playerGuess);
        if (!inputError.isEmpty()) {
            return inputError; // Return the error message if input is invalid
        }
        
        attemptsMade++; // Increment the attempt counter
        
        // Loop through each digit of the guess to count bulls and cows
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (this.getSecretNumber().charAt(i) == playerGuess.charAt(i)) {
                correctPosition++;
            } else if (this.getSecretNumber().contains(String.valueOf(playerGuess.charAt(i)))) {
                correctDigit++;
            }
        }

        // Construct the result message based on the counts
        if (correctPosition == NUMBER_LENGTH) {
            resultMessage = "Congratulations! You've guessed the number in " + this.getAttempts() + " attempts. The secret number was " + this.getSecretNumber() + ".";
        } else {
            resultMessage = "Your guess " + playerGuess + " has " + correctPosition + " correct positions and " + correctDigit + " correct digits in the wrong positions.";
        }
        
        return resultMessage;
    }

    // Method to validate the player's input, returning an error message if invalid
    private String validateInput(String playerGuess) {
        String errorMessage = "";
        
        if (playerGuess.length() != NUMBER_LENGTH) {
            return "Invalid input. Please enter exactly 4 digits.";
        }
        if (!playerGuess.matches("\\d+")) {
            return "Input must be numeric.";
        }
        // Check for repeated digits
        for (int i = 0; i < playerGuess.length() - 1; i++) {
            for (int j = i + 1; j < playerGuess.length(); j++) {
                if (playerGuess.charAt(i) == playerGuess.charAt(j)) {
                    return "Input must not contain repeated digits.";
                }
            }
        }
        return errorMessage; // Return an empty string if there are no errors
    }
}
