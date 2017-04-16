package battleship;


public class Board {
	private BoardType type;
	private Cell[][] board;
	private int[] shipCount;
	
	
	public Board() {
		type = BoardType.DISPLAYED;
		board = new Cell[10][10];
		shipCount = new int[6];
		
		shipCount[0] = 85; //The number of empty cells on the board (no ships)
		for (int i=1; i<shipCount.length; i++) {
			shipCount[i] = i; //each index > 0 corresponds to # of pieces of each ship.
		}
		
		for (int r=0; r<10; r++) {
			for (int c=0; c<10; c++) {
				board[r][c] = new Cell();
				board[r][c].setX(r);
				board[r][c].setY(c);
			}
		}
	}
	
	
	@Override
	public String toString() {
		String img = "    A  B  C  D  E  F  G  H  I  J \n";
		if (type.equals(BoardType.DISPLAYED)) {
			for (int r=0; r<10; r++) {
				int num = r+1;
				img += " " + num + " ";
				for (int c=0; c<10; c++) {
					if (board[r][c].getShip().equals(ShipState.ZERO)) img += " - ";
					else img += " " + shipStateToInt(board[r][c].getShip()) + " ";
				}
				img += "\n";
			}
			return img;
		} else {
			for (int r=0; r<10; r++) {
				int num = r+1;
				img += " " + num + " ";
				for (int c=0; c<10; c++) {
					if (board[r][c].getState().equals(CellState.EMPTY)) img += " - ";
					else if (board[r][c].getState().equals(CellState.MISS)) img += " o ";
					else img += " X ";
				}
				img += "\n";
			}
			return img;
		}
	}
	
	
	public void setType(BoardType type) {
		this.type = type;
	}
	
	
	public void hitCell(String coord) {
		Cell cell = getCellByCoord(coord);
		
		if (cell.getState().equals(CellState.EMPTY)) {
			int i = cell.beHit();
			shipCount[i] -= 1;
			
			if (shipCount[i] == 0) {
				System.out.println("A ship has been sunk!");
			}
		} else {
			System.out.println("You already shot at that cell!");
		}
	}
	
	
	public boolean hasLost() {
		int count = 0;
		for (int i=1; i<6; i++) {
			count += shipCount[i];
		}
		return count == 0;
	}
	
	
	public boolean checkShip(int ship, String orientation, String coord) {
		Cell cell = getCellByCoord(coord);
		orientation = orientation.toLowerCase();
		
		switch(orientation) {
		case "up":
			for (int r=cell.getX(); r>(cell.getX()-ship); r--) {
				if (r < 0 || board[r][cell.getY()].getShip() != ShipState.ZERO) {
					return false;
				}
			} return true;
		case "down":
			for (int r=cell.getX(); r<(ship+cell.getX()); r++) {
				if (r > 9 || board[r][cell.getY()].getShip() != ShipState.ZERO) {
					return false;
				}
			} return true;
		case "right":
			for (int c=cell.getY(); c<(ship+cell.getY()); c++) {
				if (c > 9 || board[cell.getX()][c].getShip() != ShipState.ZERO) {
					return false;
				}
			} return true;
		case "left":
			for (int c=cell.getY(); c>(cell.getY()-ship); c--) {
				if (c < 0 || board[cell.getX()][c].getShip() != ShipState.ZERO) {
					return false;
				}
			} return true;
		default: return true;
		}
	}
	
	
	public void placeShip(int ship, String orientation, String coord) {
		Cell cell = getCellByCoord(coord);
		ShipState type = intToShipState(ship);
			
		switch(orientation) {
		case "up":
			for (int r=cell.getX(); r>(cell.getX()-ship); r--) board[r][cell.getY()].setShip(type);
			break;
		case "down":
			for (int r=cell.getX(); r<(ship+cell.getX()); r++) board[r][cell.getY()].setShip(type);
			break;
		case "right":
			for (int c=cell.getY(); c<(ship+cell.getY()); c++) board[cell.getX()][c].setShip(type);
			break;
		case "left":
			for (int c=cell.getY(); c>(cell.getY()-ship); c--) board[cell.getX()][c].setShip(type);
			break;
		}
	}
	
	
	private int shipStateToInt(ShipState ss) {
		switch(ss) {
		case ONE: return 1;
		case TWO: return 2;
		case THREE: return 3;
		case FOUR: return 4;
		case FIVE: return 5;
		default: return 0;
		}
	}
	
	
	private ShipState intToShipState(int i) {
		switch(i) {
		case 1: return ShipState.ONE;
		case 2: return ShipState.TWO;
		case 3: return ShipState.THREE;
		case 4: return ShipState.FOUR;
		case 5: return ShipState.FIVE;
		default: return ShipState.ZERO;
		}
	}
	
	
	private Cell getCellByCoord(String coord) {
		return board[getYOfCoord(coord)][getXOfCoord(coord)];
	}
	
	
	private int getXOfCoord(String coord) {
		String letter = coord.substring(0, 1).toUpperCase();
		
		switch(letter) {
		case "A": return 0;
		case "B": return 1;
		case "C": return 2;
		case "D": return 3;
		case "E": return 4;
		case "F": return 5;
		case "G": return 6;
		case "H": return 7;
		case "I": return 8;
		case "J": return 9;
		default: return 0;
		}
	}
	
	
	private int getYOfCoord(String coord) {
		int number = Integer.parseInt(coord.substring(1)); //will it give a logic error?
		return number - 1;
	}

}
