import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class Appearance {
	
	public int difficulty;
	public int difficultyTime;
	public static boolean gameStatus;
	public static int score;
	public int oldScore;
	Scanner in = new Scanner (System.in);
	String gameChoice; 
	
	//public boolean inputSuccess;
	
	int nbr = ThreadLocalRandom.current().nextInt(1, 10 + 1);
	String AppearanceForm = "";	
	
//	public static void hey() {
//		System.out.println("hey");
//	}
//	
//	public static void staticStuff() {
////		nbr = ThreadLocalRandom.current().nextInt(1, 10 + 1);	
//	}
	
	public Appearance() {		
		
		difficulty = 3;
		difficultyTime = 5;
		gameStatus = true;
		score = 0;
		oldScore = 0;
		
		//inputSuccess = false;
	}
	
	public void appear() {
		
	//	inputSuccess = false;
		oldScore = score;
		
		if(score == 10) {difficulty++;}//4 //System.out.println("Difficulty being raised to " + difficulty); (didn't add because distracting
		if(score == 20) {difficulty++;}//5
		if(score == 30) {difficulty++; difficultyTime--;}//6 , 4 seconds
		if(score == 40) {difficulty++;}//7
		if(score == 50) {difficulty++;}//8
		if(score == 75) {difficulty++; difficultyTime--;}//9, 3 seconds
		if(score == 100) {difficulty++; difficultyTime--;}//10, 2 seconds

		nbr = ThreadLocalRandom.current().nextInt(1, difficulty + 1);
		//timeStuff();
		//	System.out.println("DEBUG AT TOP oldScore: " + oldScore + " score: " + score);

		myTimer M = new myTimer(difficultyTime);
		M.timeLimit();

		
		
		switch (nbr) {
		
		case 1:
			System.out.println("Dog!");
			
			gameChoice = in.next();
			//This sequence defies all logic, fundamentally at it's core does not make sense
			//saying that "bone" does not equal "bone"
			//lol was doing == not .equals()
			
			
			if (gameChoice.equals("bone")) {
				M.questionAnsweredRight = true;
				score++;
			}
			else {
				gameOver();
			}
			break;
		
		case 2:
			System.out.println("Cat!");
			gameChoice = in.next();
			if (gameChoice.equals("fish")) {
				
				M.questionAnsweredRight = true;
				score++;
			}
			else {
				gameOver();
			}
			break;
		
		case 3:
			System.out.println("Cow!");
			gameChoice = in.next();
			if (gameChoice.equals("grass")) {
				M.questionAnsweredRight = true;
				score++;
			}
			else {
				gameOver();
			}
			break;			
			////////////////////////////Difficulty 3
			
		case 4:
			System.out.println("Chick!");
			gameChoice = in.next();
			
			if (gameChoice.equals("seed")) {
				M.questionAnsweredRight = true;
				score++;
			}
			else {
				gameOver();
			}
			break;
		
		case 5:
			System.out.println("Horse!");
			gameChoice = in.next();
			if (gameChoice.equals("hay")) {
				score++;
			}
			else {
				gameOver();
			}
			break;
		
		case 6:
			System.out.println("Bone!");
			gameChoice = in.next();
			if (gameChoice.equals("dog")) {
				score++;
			}
			else {
				gameOver();
			}
			break;	

		case 7:
			System.out.println("Fish!");
			gameChoice = in.next();
			if (gameChoice.equals("cat")) {
				score++;
			}
			else {
				gameOver();
			}
			break;
			

		case 8:
			System.out.println("Grass!");
			gameChoice = in.next();
			if (gameChoice.equals("cow")) {
				score++;
			}
			else {
				gameOver();
			}
			break;
			

		case 9:
			System.out.println("Seed!");
			gameChoice = in.next();
			if (gameChoice.equals("chick")) {
				score++;
			}
			else {
				gameOver();
			}
			break;
			

		case 10:
			System.out.println("Hay!");
			gameChoice = in.next();
			if (gameChoice.equals("horse")) {
				score++;
			}
			else {
				gameOver();
			}
			break;
					
			
		}
		
	}
	
	public boolean timeLimit() { 
	
		/*
		perhaps something like
		while ( timeIsLeft == false){
		gameOver();
		}
		
		but how do we suppress the time running out when the user answers correctly?
		Set the timer thing to do
		while (score is raised *Somehow check input was successful* ){return *get out*}
		OR 
		at end of countdown and beginning of statement execution
		
		if(inputs successful){suppress game over}
		else {game over}
		
		This methods good, but how do we distinct the old input success from the new?
		At beginning of launch of every appearance, set inputSuccess to false??
		Yes that works but for one problem; The moment the input is correct, appearance relaunches an inputSuccess
		is set to false again. As the old timer runs, it will gameOver in the middle of a new input.
		
		So, do we use oldScore and score style to check that if score has raised, game must have advanced?
	
	*/
		
		return true;
	}
	
	public static void gameOver() {
		if (gameStatus == true) {
		gameStatus = false;
		System.out.println("GAME OVER!");
		System.out.println("You got a score of " + score + " points!");
		}
	}
	
	
	public void timeStuff() {
		int interval = difficultyTime * 1000; //  sec
		   Date timeToRun = new Date(System.currentTimeMillis() + interval);
		   Timer timer = new Timer();
		    
		   timer.schedule(new TimerTask() {
		           public void run() {
		        	   
			   			System.out.println("DEBUG oldScore: " + oldScore + " score: " + score);
		        	   
		        	   if (oldScore == score && gameStatus == true) {
		        		   //Did not score AND game is still running
		        		   //works at slow speed but all bad at faster
		        		   //test shows it works with what's at top, not relative to that one question...
				   			System.out.println("Did not score!");
		        		   	gameOver();
		        	   }
		        	   
		        	   else {
		        	   }	           
		           
		           }
		       }, timeToRun);
	}
	
	
	
//	public void timeStuff() {
//		int interval = difficultyTime * 1000; // 5 sec
//		   Date timeToRun = new Date(System.currentTimeMillis() + interval);
//		   Timer timer = new Timer();
//		    
//		   timer.schedule(new TimerTask() {
//		           public void run() {
//		   			System.out.println("5 seconds!");
//		           }
//		       }, timeToRun);
//	}
	
//	public void timeWindowStuff() {
//		long start = System.currentTimeMillis();
//		long end = start + 3*1000; // 3 seconds * 1000 ms/sec
//		while (System.currentTimeMillis() < end)
//		{
//			System.out.println("Stuff!");
//			//endless, lots of stuff
//		}
//	}
	


}