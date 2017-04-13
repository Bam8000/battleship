package battleship;
import java.util.*;
public class BattleShipDriver {
	
	public static void main(String args[]) {
		String a;
		String b;
		Player player1=new Player();
		Player player2=new Player();
		Scanner input=new Scanner(System.in);
		System.out.println("Player 1 board setup");
		System.out.println("Player 2 look away");
		for (int i=1;i<6;i++){
			System.out.println("Where would u like to place ship "+i);
			System.out.println("Enter an orientation:up,down,left or right");
			a=input.nextLine();
			System.out.println("Enter the coordinate in the from of x-axis first then y. For example A3 or D8");
			b=input.nextLine();
			player1.getBoard().placeShip(i,a,b){
				
			}
			player1.getBoard().checkship(i,a,b){
				
			}
			System.out.println(player1.getboard());

	}
		for(int c=0;c<20;c++){
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println("Do not scroll up unless you are a big fat cheater");
		}
		
		System.out.println("Player 2 board setup");
		System.out.println("Player 1 look away");
		for (int i=1;i<6;i++){
			System.out.println("Where would u like to place ship "+i);
			System.out.println("Enter an orientation:up,down,left or right");
			a=input.nextLine();
			System.out.println("Enter the coordinate in the from of x-axis first then y. For example A3 or D8");
			b=input.nextLine();
			player2.getboard.placeShip(i,a,b){
				
			}
			player2.getboard.checkship(i,a,b){
				
			}
			System.out.println(player2.getboard());
	}
		for(int c=0;c<20;c++){
			System.out.println("-----------------------------------------------------------------------------");
		}
		int e=0;
		int f=0;
		for (int d=1;d<6;d++){
			e=e+player1.getboard.shipCount[d];
			f=f+player2.getboard.shipCount[d];
		}
		while (e>0|| f>0){
			for(int g=1;g<3;g++){
				
			}
		}
}
}