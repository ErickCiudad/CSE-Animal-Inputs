import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class myTimer {
	
	int difficultyTime;
	boolean questionAnsweredRight;
	
	public myTimer (int difficultyTime) {
		this.difficultyTime = difficultyTime;
//		questionAnsweredRight = null;
		
		
	}
	

	public boolean timeLimit() {
		
		int interval = difficultyTime * 1000; // seconds
		   Date timeToRun = new Date(System.currentTimeMillis() + interval);
		   Timer timer = new Timer();
		    
		   timer.schedule(new TimerTask() {
		           public void run() {
		        	   //
		        	   
		        	   if (questionAnsweredRight && Appearance.gameStatus == true) {
				   			//System.out.println("Got it right!");
		   			//System.out.println(""+ interval + " Seconds");
		        	   }
		        	   
		        	   else if (Appearance.gameStatus == false) {
				   			//System.out.println("Timer ends, but game over already happened");
		        	   }
		        	   else {
		        		   //Timer ends, gameOver hasn't happened yet
		        		   Appearance.gameOver();
				   			System.out.println("Enter anything to start again");
		        	   }
		        	   
		        	   //
		           }
		       }, timeToRun);
		
		///
		return true;
	}
	
}
