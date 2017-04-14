package battleship;

public class Player {
	private int playerNum;
	private Board board;
	
	public Player(){
		playerNum=0;
		board=new Board();
	}
	
	public void setPlayerNum(int a){
		playerNum=a;
	}
	
	public int getPlayerNum(){
		return playerNum;
	}
	
	public Board getBoard(){
		return board;
	}
}
