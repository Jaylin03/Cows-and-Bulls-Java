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

  public static int bullCount(int bull) {
    return bull += 1;
  }

  public static int cowCount(int cow) {
    return cow += 1;
  }
  
  public static void main(String[] args) {

    System.out.println(newNumber());
    System.out.println(bullCount(5));
    System.out.println(cowCount(3));

    
  }
}