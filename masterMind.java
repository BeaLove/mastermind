import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
	
class Game	{
	//new game with instance variables code (random code to guess), 
	//guess (players guess) and hints (returned to player to indicate how correct the guess is)
	int[] code = new int[4];
	int[] guess = new int[4];
	String[] hints = new String[4];
	
	public void makeCode() {
		Random r = new Random(); //initialize Random
		//int myRand = r.nextInt(10);
		//System.out.println(myRand);
		for (int i = 0; i < 4; i++) {
			int rand = r.nextInt(5); // generates a random number between 0-4 (inclusive)
			System.out.println(rand);
			this.code[i] = rand; //inserts the random number in array gameSeq
		}
		System.out.println(Arrays.toString(this.code));			
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void guess(){
		//gets the guess from the user, check against the code, return Array of hints
		System.out.println("Guess a sequence of 4 integers between 0-4: ");
		Scanner in = new Scanner(System.in);
		int digit;
		for (int i = 0; i < 4; i++) {
			digit = in.nextInt(); //takes each number of the guess and stores in the array	
			this.guess[i] = digit;		
		}
		for (int number: this.guess) {
			//make sure user chooses only numbers 0-4
			if (number < 0 || number > 4) {
				System.out.println("The numbers have to be between 0-4, try again");
				guess();
			}
		}
		//in.close();
		for (int i = 0; i == this.guess.length; i++) {
			if (this.guess[i] == this.code[i]) { //checks if correct digit, correct place - how to access code variable within the class?
				this.hints[i] = "green";
				System.out.println(this.hints[i]); //debugging
			}
			else if (Arrays.asList(this.code).contains(this.guess[i])) { // checks if correct digit, wrong place
				this.hints[i] = "yellow";
				System.out.println(this.hints[i]); //debugging
			}
			else {
				this.hints[i] = "red"; //wrong digit
				System.out.println(this.hints[i]); //debugging
			}
		}
		if (this.guess == this.code) {
			System.out.println("You guessed the right code! Game over");
		}
		else {
			System.out.println("Hints: " + Arrays.toString(this.hints));
			System.out.println("Guess again!");
			guess();
		}
		}
}

public class masterMind {
	//main class
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game newGame = new Game();
		System.out.println("created instance game");
		newGame.makeCode();
		System.out.println("successfully made game code");
		newGame.guess();
		System.out.println("code " + Arrays.toString(newGame.code));
		System.out.println("guess " + Arrays.toString(newGame.guess));
	}
}
	

