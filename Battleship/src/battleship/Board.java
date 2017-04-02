package battleship;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	public void setType(BoardType type) {
		this.type = type;
	}
	
	//May not need to be public!!
	//Needs to be robust.
	public Cell getCellByCoord(String coord) {
		
		//make this a while loop
		if (isValidCoord(coord)) {
			String letter = coord.substring(0, 1).toUpperCase();
			int number = Integer.parseInt(coord.substring(1)); //will it give a logic error?
			int x;
			int y = number;
			
			switch(letter) {
			case "A": x = 0;
			case "B": x = 1;
			case "C": x = 2;
			case "D": x = 3;
			case "E": x = 4;
			case "F": x = 5;
			case "G": x = 6;
			case "H": x = 7;
			case "I": x = 8;
			case "J": x = 9;
			default: x = 0;
			}
			
			return board[x][y];
		}
		return board[0][0]; //REMOVE!!
	}
	
	public void hitCell(String coord) {
		Cell cell = getCellByCoord(coord);
		int i = cell.beHit();
	}
	
	private boolean isValidCoord(String coord) {
		Pattern p = Pattern.compile("[a-jA-J][1-10]");
		Matcher m = p.matcher(coord);
		return m.find();
	}

}
