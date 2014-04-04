package chessGame;

import pieces.Piece;

public class MovePiece 
{
	int row,col,tryCol, tryRow;
	public MovePiece(int row, int col,int tryRow, int tryCol)
	{
		this.row=row;
		this.col=col;
		this.tryRow=tryRow;
		this.tryCol=tryCol;
	}

	public int getRow()
	{
		return row;
	}
	
	public int getCol()
	{
		return col;
	}
	public int getTryRow()
	{
		return tryRow;
	}
	
	public int getTryCol()
	{
		return tryCol;
	}
}
