package battleship;

public class Board {
	private BoardType type;
	private Cell[][] board;
	private int[] shipCount;
	
	public Board() {
		type = type.DISPLAYED;
		board = new Cell[10][10];
		shipCount = new int[6];
		
		shipCount[0] = 85; //The number of empty cells on the board (no ships)
		for (int i=1; i<shipCount.length; i++) {
			shipCount[i] = i; //each index > 0 corresponds to # of pieces of each ship.
		}
	}
	
	@Override
	public String toString() {
		//TODO
	}
	
	//May not need to be public!!
	//Needs to be robust.
	public Cell getCellByCoord(String coord) {
		
	}

}
