
public class Dice {
	
	/*
	 * Fields for the Dice class
	 */	
	//A field that stores the number of sides the dice contains
	private int sides;
	//A field that stores the current number the dice is on.
	private int currentNumber;
	
	/*
	 * Constructors for objects of the Dice class
	 */
	public Dice() {
		sides = 6;
		currentNumber = 1;
	}
	
	public Dice(int sides) {
		this.sides = sides;
		currentNumber = 1;
	}
	
	/*
	 * Accessor methods for fields of the Dice class
	 */
	public int getSides() {
		return sides;
	}
	
	public int getCurrentNumber() {
		return currentNumber;
	}
	
	/*
	 * Mutator methods for fields of the Dice class
	 */
	public void setCurrentNumber(int newNumber) {
		currentNumber = newNumber;
	}
	
	/*
	 * A method that allows you to role the dice
	 */
	public void rollDice() {
		currentNumber = (int) (Math.random() * sides + 1);
	}
	
	
	//A method used to test the output of the dice rolling
	/*
	public static void main(String[] args) {
		Dice dice = new Dice();
		for(int i = 0; i < 30; i++) {
			dice.rollDice();
			System.out.println(dice.currentNumber);
		}
	}
	*/
	
	
	
	
}
