// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Tyler Loede
// RESOURCES: None

import java.util.Random;

/**
 *  
 * Class for a simple, randomized guessing game. Five integer values between 1 and MAX_VALUE (inclusive) will be
 * generated. Only the first and last will be shown to the player. The player must then guess if the sum
 * of all of the numbers is greater than the possible average or not.
 *
 * @author tloede
 */

public class RandGuessGame
{
	//Declare data members
	/**
	 * Max value of the randomly generated numbers.
	 */
	private static int maxValue = 100;
	
	/**
	 * Sets array size to 5.
	 */
	private static int arrSize = 5;
	
	/**
	 * Variable for the sum of the array.
	 */	
	private int arraySum;
	
	/**
	 * Variable for the user's guess.
	 */	
	private char guess;
	
	/**
	 * Number for the player to guess against.
	 */	
	private int guessTarget;
	
	/**
	 * Whether or not to hide middle values.
	 */
	private boolean hideMiddleVals;
	
	/**
	 * Stores randomly generated numbers.
	 */
	private int[] numbers;
	
	/**
	 * Variable for random number.
	 */
	private Random rand;
	
	
	//Create Constructor
	/**
	 * Constructor for the game.
	 * @param randIn Random number for the guessing game.
	 */
	public RandGuessGame(Random randIn)
	{
		this.rand = randIn;
		this.numbers = new int[arrSize];
		arraySum = 0;
		this.guessTarget = numbers.length * (maxValue / 2);
		hideMiddleVals = true;
	}
	
	//Write member methods
	
	/**
	 * Retrieves the numbers array. Used for testing, do not change.
	 * @return The numbers array.
	 */
	public int[] getNumbers()
	{
		return numbers;
	}
	
	/**
	 * Retrieves the sum of the numbers in the array. Used for testing, do not change.
	 * @return The value of arraySum.
	 */
	public int getArraySum()
	{
		return arraySum;
	}
	
	/**
	 * Checks to see if player's guess was correct and returns result.
	 * @return A String reporting the results of the game.
	 */
	public String getResult()
	{
		for (int i = 0; i < numbers.length; i++)
		{
			arraySum += numbers[i];
		}
		
		if ((arraySum > guessTarget && guess == 'Y') || arraySum <= guessTarget && guess == 'N')
		{
			return "You guessed correctly! The sum was " + arraySum + "!";
		}
		else
		{
			return "You guessed wrong! The sum was " + arraySum + "!";
		}
	}
	
	/**
	 * Populates the array to be used in the game.
	 */
	public void populateArray()
	{
		for (int i = 0; i < numbers.length; i++)
		{
			numbers[i] = rand.nextInt(maxValue) + 1;
		}
	}
	
	/**
	 * Toggles boolean value for hideMiddleVals.
	 */
	public void toggleHidden()
	{
		if (hideMiddleVals)
		{
			hideMiddleVals = false;
		}
		else
		{
			hideMiddleVals = true;
		}
		
	}
	
	/**
	 * Constructs the array into a string.
	 * @return A String with the values of the numbers array. Middle values are hidden if hideMiddleValue is true
	 */
	public String toString()
	{
		if (hideMiddleVals)
		{
			return numbers[0] + " " + "X X X " + numbers[4] + " ";
		}
		else
		{
			return numbers[0] + " " + numbers[1] + " " 
					+ numbers[2] + " " + numbers[3] + " " + numbers[4] + " ";
		}
	}
	
	/**
	 * Validates that the player's guess is Y or N.
	 * @param guessIn Char to be validated.
	 * @return Returns true if char is Y or N. Returns false if char is something else.
	 */
	public boolean validatePlayerGuess(char guessIn)
	{
		switch (guessIn)
		{
			case 'Y' : case 'N' :
				guess = guessIn;
				return true;
			default:
				return false;
		}
	}
}
