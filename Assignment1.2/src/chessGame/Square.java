package chessGame;

import pieces.Piece;

public class Square 
{
	int row,col;
	Piece piece;
	public Square(Piece piece, int row, int col)
	{
		this.piece=piece;
		this.row=row;
		this.col=col;
	}
	
	public Square(int row, int col)
	{

		this.row=row;
		this.col=col;
	}

	public Piece getPiece()
	{
		return piece;
	}
	
	public int getRow()
	{
		return row;
	}
	
	public int getCol()
	{
		return col;
	}
	
	//So that I can use the method contains comparing row and column
	public boolean equals(Object o)
	{
		if(o instanceof Square)
		{
			Square p = (Square) o;
			int row2 = p.getRow();
			int col2 =p.getCol();
			if(col==col2 && row==row2)
				return true;
			else
				return false;
		}
		else
			return false;
	}

}
