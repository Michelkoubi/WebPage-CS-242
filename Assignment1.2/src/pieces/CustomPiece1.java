package pieces;

import java.util.ArrayList;

import chessGame.MovePiece;
import chessGame.Square;

/**
 * 
 * @author miguel
 * CustomPiece1 has the movements of a rook but can only move from one square to one square at a time
 *
 */
public class CustomPiece1 extends Piece
{
	boolean isPossible,occupied;
	String color;

	ArrayList<Square> arraySquares= new ArrayList<Square>();
	ArrayList<Square> arrayMoves= new ArrayList<Square>();
	Piece piece;
	MovePiece mPiece;
	int[][] cMoves;

	
	public boolean tryMove(ArrayList<Square> arraySquares, Piece piece, MovePiece mPiece)
	{
		isPossible=false;
		this.piece=piece;
		this.arraySquares=arraySquares;
		this.mPiece=mPiece;
		
		//I create an array with the possible custom1 moves
		cMoves=initMoves();
    
        //I alternate colors because I use equals to compare them
		if(piece.getColor().equals("w"))
		{
			color="b";
		}
		else
		{
			color="w";
		}
		isPossible=calcMoves();
	
		return isPossible;
	}
	public boolean calcMoves()
	{
		boolean correctMove;
		correctMove=false;
		
		for(Object o: arraySquares)
		{
			Square square= (Square) o;
			for (int i = 0; i < 4; i++ )//rows
			{
			     int j=0;//columns
				//if occupied and different color
				if(noException(mPiece.getRow()+cMoves[i][j],mPiece.getCol()+cMoves[i][j+1]) && contain(i,j))
				{
					if(square.getPiece().getColor().equals(color))
						arrayMoves.add(new Square(mPiece.getRow()+cMoves[i][j],mPiece.getCol()+cMoves[i][j+1]));
				}
				else
				{
					//if not occupied
					if(noException(mPiece.getRow()+cMoves[i][j],mPiece.getCol()+cMoves[i][j+1]) && !contain(i,j))
						 arrayMoves.add(new Square(mPiece.getRow()+cMoves[i][j],mPiece.getCol()+cMoves[i][j+1]));
				}
			 }
		}
		
		for (int k = 0; k < arrayMoves.size(); k++) 
		{
			if(arrayMoves.get(k).getCol()==mPiece.getTryCol() && arrayMoves.get(k).getRow()==mPiece.getTryRow())
				correctMove=true;
		}
		return correctMove;
	}

	public int[][] initMoves()
	{
        int[][] Moves = {
                {0, -1},
                {1, 0},
                {0, 1},
                {-1, 0}
            };
        return Moves;
	}
	public boolean contain(int i_, int j_)
	{
		int i,j;
		i=i_;
		j=j_;
		boolean contain1;
		contain1=false;
		
		if(arraySquares.contains(new Square(mPiece.getRow()+cMoves[i][j],mPiece.getCol()+cMoves[i][j+1])))
			contain1=true;

		return contain1;
	}
}