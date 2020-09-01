package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
        System.out.println("House Cards: " + game.getHouseCards());
        System.out.println("Your Cards: " + game.getYourCards());
        System.out.println("-------------------------------");
    }

  @Override
    public boolean hitMe() {
	  int playerScore;
  	playerScore = game.score(game.getYourCards());
	  if(playerScore>21){
  		return false;
  	}
	  String ans ="";
        	System.out.println("Would you like another Card? Type 'Yes' if you would");
        	ans = user.nextLine();

        	if(ans.equals("Yes") || ans.equals("yes")){
          return true;
        	}
        	
	  
        return false;
    }

  @Override
    public void gameOver() {
        this.display();
	  int playerScore, houseScore;
	  houseScore = game.score(game.getHouseCards());
	  playerScore = game.score(game.getYourCards());
	  System.out.println("The game is over.");
	  System.out.println("House Score: " + houseScore + " Player Score : " + playerScore);
	  if(playerScore>21){
		  System.out.println("The House wins!");
	  }
	  else if(playerScore==houseScore){
		  System.out.println("The House wins!");
	  }
	  else if(houseScore>21){
		  System.out.println("You win!");
	  }
	  else if(playerScore>houseScore){
		  System.out.println("You win!");
	  }
	  else if(houseScore>playerScore){
		  System.out.println("The house wins!");
	  }
	  
    }

}