package pieces;

import java.util.ArrayList;
import java.util.Iterator;

import chessGame.MovePiece;
import chessGame.Square;

public class Bishop extends Piece
{
	boolean isPossible, escape, escape2, escape3, escape4;
	MovePiece mPiece;
	String color;

	ArrayList<Square> arraySquares= new ArrayList<Square>();
	ArrayList<Square> arrayMoves= new ArrayList<Square>();
	Piece piece;
	int stopCheck;

	public boolean tryMove(ArrayList<Square> arraySquares, Piece piece, MovePiece mPiece)
	{
		this.piece=piece;
		this.mPiece=mPiece;
		this.arraySquares=arraySquares;
		isPossible=false;

		//I alternate colors because I use equals to compare them
		if(piece.getColor().equals("w"))
		{
			color="b";
		}
		else
		{
			color="w";
		}
		putEscape(true);

		isPossible=calcMoves();
	
		return isPossible;
	}
	
	public boolean calcMoves()
	{
		boolean correctMove;
		correctMove=false;
		
		do
		{
			for (int i = 0; i < 8; i++) 
			{
				
				for(Object o: arraySquares)
				{
					Square square= (Square) o;
					
					//if occupied and different color
					if(noException(mPiece.getRow()-i,mPiece.getCol()-i) && escape && square.getCol()==mPiece.getCol()-i && square.getRow()==mPiece.getRow()-i)
					{
						escape=false;//when I find a piece I can kill, I stop adding more in that line
						if(square.getPiece().getColor().equals(color))
						arrayMoves.add(new Square(mPiece.getRow()-i,mPiece.getCol()-i));
					}
					if(noException(mPiece.getRow()+i,mPiece.getCol()-i) && escape2 && square.getCol()==mPiece.getCol()+i && square.getRow()==mPiece.getRow()-i)
					{
						 escape2=false;
						 if(square.getPiece().getColor().equals(color))
						 arrayMoves.add(new Square(mPiece.getRow()+i,mPiece.getCol()-i));
				    }
					if(noException(mPiece.getRow()+i,mPiece.getCol()+i) && escape3 && square.getCol()==mPiece.getCol()+i && square.getRow()==mPiece.getRow()+i)
					{
						 escape3=false;
						 if(square.getPiece().getColor().equals(color))
						 arrayMoves.add(new Square(mPiece.getRow()+i,mPiece.getCol()+i));
					}
					if(noException(mPiece.getRow()-i,mPiece.getCol()+i) && escape4 && square.getCol()==mPiece.getCol()-i && square.getRow()==mPiece.getRow()+i)
					{
						escape4=false;
						if(square.getPiece().getColor().equals(color))
						arrayMoves.add(new Square(mPiece.getRow()-i,mPiece.getCol()+i));
					}
					
				}
					//if there is an exception I stop looking
					if(!noException(mPiece.getRow()-i,mPiece.getCol()-i))
						escape=false;
					if(!noException(mPiece.getRow()+i,mPiece.getCol()-i))
						escape2=false;
					if(!noException(mPiece.getRow()+i,mPiece.getCol()+i))
						escape3=false;
					if(!noException(mPiece.getRow()-i,mPiece.getCol()+i))
						escape4=false;
					
					//I add the empty squares where I can move
					if(noException(mPiece.getRow()-i,mPiece.getCol()-i) && escape)
						arrayMoves.add(new Square(mPiece.getRow()-i,mPiece.getCol()-i));
					if(noException(mPiece.getRow()+i,mPiece.getCol()-i) && escape2)
						arrayMoves.add(new Square(mPiece.getRow()+i,mPiece.getCol()-i));
					if(noException(mPiece.getRow()+i,mPiece.getCol()+i) && escape3)
						arrayMoves.add(new Square(mPiece.getRow()+i,mPiece.getCol()+i));
					if(noException(mPiece.getRow()-i,mPiece.getCol()+i) && escape4)
						arrayMoves.add(new Square(mPiece.getRow()-i,mPiece.getCol()+i));
		   }
	}while(escape || escape2 || escape3 || escape4); 
		
		for (int k = 0; k < arrayMoves.size(); k++) 
		{
			if(arrayMoves.get(k).getCol()==mPiece.getTryCol() && arrayMoves.get(k).getRow()==mPiece.getTryRow())
				correctMove=true;
		}
		
		return correctMove;
	}
	
	public void putEscape(boolean putEscape)
	{
		escape=putEscape;
		escape2=putEscape;
		escape3=putEscape;
		escape4=putEscape;
	}
}
