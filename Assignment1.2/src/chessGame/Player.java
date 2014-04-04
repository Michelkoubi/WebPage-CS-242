package chessGame;

import pieces.Piece;

public class Player 
{
	String name;
	boolean color;
	
	public Player(String name,boolean color)
	{
		this.name=name;
		this.color=color;
	}

	public String getName()
	{
		return name;
	}
	public boolean getColor()
	{
		return color;
	}

}
