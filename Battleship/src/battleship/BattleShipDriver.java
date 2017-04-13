package battleship;
import java.util.*;
public class BattleShipDriver {
	public static void main(String args[]){
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
			player1.getBoard().placeShip(i,a,b);
				
			
			player1.getBoard().checkShip(i,a,b);
			
			
			System.out.println(player1.getBoard());

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
			player2.getBoard().placeShip(i,a,b);
				
			
			player2.getBoard().checkShip(i,a,b);
				
			
			System.out.println(player2.getBoard());
	}
		for(int c=0;c<20;c++){
			System.out.println("-----------------------------------------------------------------------------");
		}
		
		
		int e=1;
		int f=1;
		while (e>0|| f>0){
			for(int g=1;g<3;g++){
				if (g==1){
					System.out.println("Player 1 please select a coordinate to fire");
					System.out.println("Enter the coordinate in the from of x-axis first then y. For example A3 or D8");
					String missile=input.nextLine();
					player2.getBoard().hitCell(missile);
				}
				else{
					System.out.println("Player 2 please select a coordinate to fire");
					System.out.println("Enter the coordinate in the from of x-axis first then y. For example A3 or D8");
					String missile=input.nextLine();
					player1.getBoard().hitCell(missile);
				}
				e=0;
				f=0;
				for (int d=1;d<6;d++){
					e=e+player1.getBoard().shipCount[d];
					f=f+player2.getBoard().shipCount[d];
			}
			}
		}
		
}
	private boolean isValidOrientation(String orientation) {
		return orientation.equals("up") || orientation.equals("down") || 
				orientation.equals("right") || orientation.equals("left");
	}
	
}