package battleship;

public class Player {
	private int playerNum;
	private Board board;
	
	public Player(){
		playerNum=0;
		board=new Board();
		
	}
	public void setplayerNum(int a){
		playerNum=a;
	}
	public int getplayerNum(){
		return playerNum;
	}
}
