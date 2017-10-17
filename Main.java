import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		/*TODO 
		 * 
		 * Integrate time limit (maybe good)
		 * Make difficulty scale (done)
		 * Make difficulty time scale (perhaps subtract 10 milliseconds)(done)
		 * 
		 * */
		
		int choice;
		final int START = 1;
		final int GUIDE = 2;
		final int QUIT = 3;

		
		String setting = "";
		//public boolean gameStatus = true;
		//Apparently zero possible ways to make a boolean public in Java
		//Can't make it public when main method is in?
				
		Scanner in = new Scanner(System.in);

		do {
			System.out.println("Welcome to Animal Inputs!");
			System.out.println("1: Start the game");
			System.out.println("2: Guide");
			System.out.println("3. Quit");
			System.out.println("Please choose an option");
			
			choice = in.nextInt();
			
			switch (choice) {
			
			case START:					
				Appearance A = new Appearance();
				do {
					
					
				//A.timeStuff();
				A.appear();
				
				}
				while(A.gameStatus == true);

				
			break;
			
			case GUIDE:
				System.out.println("Guide");
				System.out.println("_________________");
				System.out.println("List of appropriate inputs");
				System.out.println("*all inputs are entered in lowercase for speed's sake");
				System.out.println("dog    <--->  bone");
				System.out.println("cat    <--->  fish");
				System.out.println("cow    <--->  grass");
				System.out.println("chick  <--->  seed");
				System.out.println("horse  <--->  hay");
				
				System.out.println("");
				System.out.println("Difficulty");
				System.out.println("At 10, 20, 30, 40, 50, 75, and 100 points, another question is added,");
				System.out.println("At 30 points, the time is shortened from 5 seconds to 4 seconds. At 75 points, the time is shortened to 3 seconds. At 100 points, the time is shortened to 2 seconds");

				System.out.println("");
				System.out.println("Goodluck!");
				System.out.println("_________________");
				System.out.println("");

				
				break;
				
			case QUIT:
				System.out.println("Quitting from program");
				break;
	
				
			default: 	
				System.out.println("Incorrect choice, Please choose again");
				
			}
			
		}
		
		while(choice != QUIT);
	
		
		
		
	}

}
