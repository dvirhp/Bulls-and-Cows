# Bulls and Cows Game 🎮

A Java implementation of the classic "Bulls and Cows" number guessing game.

## 🔍 Game Overview

In Bulls and Cows, the computer selects a random number (typically 4 digits), and the player must guess it. After each guess, the player receives feedback:
- "Bulls": Digits that are correct and in the correct position
- "Cows": Digits that appear in the number but in a different position

For example, if the target number is 1307 and the guess is 1201:
- There is 1 Bull (the digit 1 in the correct position)
- There are 0 Cows (no other matching digits in different positions)

## ⚙️ Implementation Details

The game consists of several components:
- A game logic class that manages the target number, validates guesses, and calculates Bulls and Cows
- A main program that handles user interaction, processes input, and displays results
- String utility functions for input validation and processing

## 💻 How to Play

1. The game will select a random number
2. Enter your guess when prompted
3. The game will display the number of Bulls and Cows for your guess
4. Continue guessing until you find the correct number
5. After each game, you'll be asked if you want to play again

## 🛠️ Technical Implementation

- The project is structured with separation of concerns in mind
- User input is processed through String utilities to ensure valid input
- The game provides appropriate error messages for invalid inputs
- Results of each guess are displayed after processing

## 📝 Building and Running

Compile the Java files:
```bash
javac *.java
```

Run the game:
```bash
java BullsCowsGame
```

## 📚 Project Structure

- `BullsCowsGame.java` - Main game class and entry point
- `GameLogic.java` - Game logic implementation
- `InputProcessor.java` - Input handling and validation

## 🎯 Game Rules

- The target number consists of 4 digits (configurable)
- Players continue guessing until they find the exact number
- After each guess, feedback is provided to help refine subsequent guesses
