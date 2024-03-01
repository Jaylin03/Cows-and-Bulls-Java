/*
Goal: Create a program that will play the “cows and bulls” game with the user.
The game works like this:
  - Randomly generate a 4-digit number.
  - Ask the user to guess a 4-digit number.
    - For every digit that the user guessed correctly in the correct place, they have a “cow”.
    - For every digit the user guessed correctly in the wrong place is a “bull.”
  - Every time the user makes a guess, tell them how many “cows” and “bulls” they have.
  - Once the user guesses the correct number, the game is over.
  - Keep track of the number of guesses the user makes throughout the game and tell the user at the end.

Breakdown:
  1.) Generate a random 4 digit number
  2.) Ask user for a 4 digit number
      - Check if the number is in fact 4 digit
  3.) Check how close user number is to random number
      - same number AND same location = cow
      - same number BUT wrong location = bull
  4.) Print user's cows and bulls
  5.) Increment guess counter variable
  6.) Repeat steps 2-3 until user number equals random number
  7.) Print number of guesses with proper labeling
*/

import java.util.Scanner;
import java.util.Random;

public class Main {
  public static int newNumber() {
    // Intantiate random object to create a random integer
    Random random = new Random();
    
    // Create computer number, a random 4 digit integer
    int compNumber = random.nextInt (1000 , 10000);

    return compNumber;
  }

  public static int guessCount(int guess) {
    return guess += 1;
  }


  public static int[] cowBullSearch(String userNumber, String compNumber, int[] cowBullCount) { 
    // Search for cows and bulls by iterating through the userNumber and compNumber
    for (int i = 0; i < compNumber.length(); i++) {
      
      // If the 2 digits are at the same index --> cow
      if (userNumber.charAt(i) == compNumber.charAt(i)) {
        cowBullCount[0] += 1;
      }
      // If a digit from the userNumber is in the compNumber but not at the same index --> bull
      else if (compNumber.contains(userNumber.substring(i))) {
        cowBullCount[1] += 1;
      }        
    }
  // Return the number of cows and bulls from this search
  return cowBullCount;
}
  
  public static void main(String[] args) {
    int[] cowBullCount = new int[2];
    int cow = cowBullCount[0];
    int bull = cowBullCount[1];
    int guess = 0;
    String compNumber = String.valueOf(newNumber());
    
    System.out.println("Enter a 4 digit number below: ");
    Scanner userInput = new Scanner(System.in);
    String userNumber = userInput.nextLine();

    while (userNumber != compNumber) {
      guess += 1;
      cowBullCount = cowBullSearch(userNumber, compNumber, cowBullCount);
      System.out.println("cowBull =" + cowBullCount);
      System.out.println("Not quite. Try again.");
      userNumber = userInput.nextLine();
    }
    userInput.close();

    if (userNumber.contentEquals(compNumber)) {
      System.out.println("Correct!");
    }
  }
}