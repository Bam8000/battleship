package battleship;

public class Cell {
	private ShipState ship;
	private CellState state;
	
	public Cell() {
		ship = ShipState.ZERO;
		state = CellState.EMPTY;
	}
	
	/*
	 * @param ShipState ship, an enum that determines what type of ship it is.
	 * Sets the ship state of the cell to ShipState ship.
	 */
	public void setShip(ShipState ship) {
		this.ship = ship;
	}
	
	/*
	 * @return ShipState ship.
	 */
	public ShipState getShip() {
		return ship;
	}
	
	/*
	 * As if the cell is hit by a missile. Sets state to HIT or MISS depending on if there is a ship
	 * and returns the corresponding integer to the value of enum ship.
	 * @return int equivalent of enum value of ship.
	 */
	public int beHit() {
		if (ship != ShipState.ZERO) state = CellState.HIT;
		else state = CellState.MISS;
		
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
