package battleship;

public class Cell {
	private ShipState ship;
	private CellState state;
	private int x;
	private int y;
	
	public Cell() {
		ship = ShipState.ZERO;
		state = CellState.EMPTY;
		x = 0;
		y = 0;
	}
	
	/*
	 * @param ShipState ship, an enum that determines what type of ship it is.
	 * Sets the ship state of the cell to ShipState ship.
	 */
	public void setShip(ShipState ship) {
		this.ship = ship;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	/*
	 * @return ShipState ship.
	 */
	public ShipState getShip() {
		return ship;
	}
	
	/*
	 * @return CellState state
	 */
	public CellState getState() {
		return state;
	}
	
	/*
	 * As if the cell is hit by a missile. Sets state to HIT or MISS depending on if there is a ship
	 * and returns the corresponding integer to the value of enum ship.
	 * @return int equivalent of enum value of ship.
	 */
	public int beHit() {
		if (ship != ShipState.ZERO) {
			state = CellState.HIT;
			System.out.println("A ship has been hit!");
		} else {
			state = CellState.MISS;
			System.out.println("Miss!");
		}
		
		switch (ship) {
		case ZERO: return 0;
		case ONE: return 1;
		case TWO: return 2;
		case THREE: return 3;
		case FOUR: return 4;
		case FIVE: return 5;
		default: return -1; //Need to address this number, which could cause errors.
		}
		
	}
}
