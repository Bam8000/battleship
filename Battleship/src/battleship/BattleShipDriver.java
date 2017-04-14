package battleship;
import java.util.*;
public class BattleShipDriver {
	
	public static void main(String args[]){
		Player player1=new Player();
		Player player2=new Player();
		Scanner input=new Scanner(System.in);
		boolean play = true;
		int winnerNum = 0;
		
		player1.setPlayerNum(1);
		player2.setPlayerNum(2);
		
		boardSetup(player1, player2, input);
		boardSetup(player1, player2, input);
		
		while (play){
			
			gamePlay(player1, input);
			if (player1.getBoard().hasLost()) {
				play = false;
				winnerNum = 1;
				break;
			}
			
			gamePlay(player2, input);
			if (player2.getBoard().hasLost()) {
				play = false;
				winnerNum = 2;
				break;
			}
		}
		
		System.out.println("Player %d wins the game!");
		
	}
	
	
	private boolean isValidOrientation(String orientation) {
		return orientation.equals("up") || orientation.equals("down") || 
				orientation.equals("right") || orientation.equals("left");
	}
	
	private static void boardSetup(Player setter, Player waiter, Scanner input) {
		String orientation;
		String coordinate;
		
		System.out.printf("\nPlayer %d: Board Setup", setter.getPlayerNum());
		System.out.printf("\nPlayer %d: Look away", waiter.getPlayerNum());

		for (int i=1;i<6;i++){
			System.out.println("Where would you like to place a ship "+i);
			System.out.println("Enter an orientation: up, down, left, right"); //NOTE: MAKE ROBUST
			orientation=input.nextLine();
			System.out.println("Enter the coordinate in the form of x-axis first then y. For example A3 or D8");
			coordinate=input.nextLine();
			setter.getBoard().placeShip(i,orientation,coordinate);
			
			System.out.println(setter.getBoard());
		}
		
		for(int c=0;c<20;c++){
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println("Do not scroll up unless you are a big fat cheater");
		}
	}
	
	private static void gamePlay(Player player, Scanner input) {
		String missile;
		
		System.out.printf("\nPlayer %d please select a coordinate to fire at", player.getPlayerNum());
		System.out.println("Enter the coordinate in the form of x-axis first then y. For example A3 or D8"); //MAKE ROBUST!!
		missile = input.nextLine();
		player.getBoard().hitCell(missile);
	}
	
}