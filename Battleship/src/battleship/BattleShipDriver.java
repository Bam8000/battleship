package battleship;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
		boardSetup(player2, player1, input);
		
		player1.getBoard().setType(BoardType.HIDDEN);
		player2.getBoard().setType(BoardType.HIDDEN);
		
		while (play){
			
			gamePlay(player1, player2, input);
			if (player2.getBoard().hasLost()) {
				play = false;
				winnerNum = 1;
				break;
			}
			
			gamePlay(player2, player1, input);
			if (player1.getBoard().hasLost()) {
				play = false;
				winnerNum = 2;
				break;
			}
		}
		
		System.out.printf("\nPlayer %d wins the game!", winnerNum);
		
	}
	
	private static void boardSetup(Player setter, Player waiter, Scanner input) {
		String orientation;
		String coordinate;
		int i = 1;
		
		System.out.printf("\nPlayer %d: Board Setup", setter.getPlayerNum());
		System.out.printf("\nPlayer %d: Look away", waiter.getPlayerNum());

		while (i<6) {
			System.out.println("\nWhere would you like to place ship number "+i+":");
			orientation = getOrientation(input);
			coordinate = getCoord(input);
			if (setter.getBoard().checkShip(i,orientation,coordinate)) {
				setter.getBoard().placeShip(i,orientation,coordinate);
				i++;
			} else {
				System.out.println("You can't place a ship there!");
			}
			
			System.out.println(setter.getBoard());
		}
		
		for(int c=0;c<20;c++){
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println("Do not scroll up unless you are a big fat cheater");
		}
	}
	
	
	private static void gamePlay(Player player1, Player player2, Scanner input) {
		String missile;
		
		System.out.println(player2.getBoard());
		System.out.printf("\nPlayer %d please select a coordinate to fire at", player1.getPlayerNum());
		missile = getCoord(input);
		player2.getBoard().hitCell(missile);
		System.out.println(player2.getBoard());
	}
	
	
	private static String getOrientation(Scanner input) {
		boolean validOrientation = false;
		String orientation = "up";
		
		while (!validOrientation) {
			System.out.println("Enter an orientation: up, down, left, right");
			orientation=input.nextLine();
			if (isValidOrientation(orientation)) validOrientation = true;
			else System.out.println("Please give a valid orientation!");
		}
		
		return orientation.toLowerCase();
	}
	
	
	private static String getCoord(Scanner input) {
		boolean validCoord = false;
		String coord = "";
		
		while (!validCoord) {
			System.out.println("\nEnter the coordinate in the form of x-axis first then y. For example A3 or D8");
			coord=input.nextLine();
			if (isValidCoord(coord)) {
				validCoord = true;
				System.out.println("run");
			}
			else System.out.println("Please give a valid coordinate!");
		}
		
		return coord;
	}
	
	
	private static boolean isValidOrientation(String orientation) {
		orientation = orientation.toLowerCase();
		return orientation.equals("up") || orientation.equals("down") || 
				orientation.equals("right") || orientation.equals("left");
	}
	
	
	private static boolean isValidCoord(String coord) {
		Pattern p = Pattern.compile("[A-Ja-j][1-9]");
		Matcher m = p.matcher(coord);
		return m.matches();
	}
	
}