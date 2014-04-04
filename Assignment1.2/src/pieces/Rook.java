package pieces;

import java.util.ArrayList;
import java.util.Iterator;

import chessGame.MovePiece;
import chessGame.Square;

public class Rook extends Piece
{
	boolean isPossible, escape, escape2, escape3, escape4;
	String color;

	ArrayList<Square> arraySquares= new ArrayList<Square>();
	ArrayList<Square> arrayMoves= new ArrayList<Square>();
	Piece piece;
	MovePiece mPiece;

	
	public boolean tryMove(ArrayList<Square> arraySquares, Piece piece,MovePiece mPiece)
	{
		this.piece=piece;
		this.arraySquares=arraySquares;
		this.mPiece=mPiece;

		putEscape(true);
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
		isPossible=calcMoves();
		return isPossible;
	}
	
	public void putEscape(boolean putEscape)
	{
		escape=putEscape;
		escape2=putEscape;
		escape3=putEscape;
		escape4=putEscape;
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
					if(noException(mPiece.getRow(),mPiece.getCol()-i) && escape && square.getCol()==mPiece.getCol()-i && square.getRow()==mPiece.getRow())
					{
						escape=false;//when I find a piece I can kill, I stop adding more in that line	
						if(square.getPiece().getColor().equals(color))
						arrayMoves.add(new Square(mPiece.getRow(),mPiece.getCol()-i));
					}
					if(noException(mPiece.getRow(),mPiece.getCol()+i) && escape2 && square.getCol()==mPiece.getCol()+i && square.getRow()==mPiece.getRow())
					{
						 escape2=false;
						 if(square.getPiece().getColor().equals(color))
						 arrayMoves.add(new Square(mPiece.getRow(),mPiece.getCol()+i));
				    }
					if(noException(mPiece.getRow()-i,mPiece.getCol()) && escape3 && square.getCol()==mPiece.getCol() && square.getRow()==mPiece.getRow()-i)
					{
						 escape3=false;
						 if(square.getPiece().getColor().equals(color))
						 arrayMoves.add(new Square(mPiece.getRow()-i,mPiece.getCol()));
					}
					if(noException(mPiece.getRow()+i,mPiece.getCol()) && escape4 && square.getCol()==mPiece.getCol() && square.getRow()==mPiece.getRow()+i)
					{
						escape4=false;
						if(square.getPiece().getColor().equals(color))
						arrayMoves.add(new Square(mPiece.getRow()+i,mPiece.getCol()));
					}
				}
					//if there is an exception
					if(!noException(mPiece.getRow(),mPiece.getCol()-i))
						escape=false;
					if(!noException(mPiece.getRow(),mPiece.getCol()+i))
						escape2=false;
					if(!noException(mPiece.getRow()-i,mPiece.getCol()))
						escape3=false;
					if(!noException(mPiece.getRow()+i,mPiece.getCol()))
						escape4=false;
					
					//I add the empty squares where I can move
					if(noException(mPiece.getRow(),mPiece.getCol()-i) && escape)
						arrayMoves.add(new Square(mPiece.getRow(),mPiece.getCol()-i));
					if(noException(mPiece.getRow(),mPiece.getCol()+i) && escape2)
						arrayMoves.add(new Square(mPiece.getRow(),mPiece.getCol()+i));
					if(noException(mPiece.getRow()-i,mPiece.getCol()) && escape3)
						arrayMoves.add(new Square(mPiece.getRow()-i,mPiece.getCol()));
					if(noException(mPiece.getRow()+i,mPiece.getCol()) && escape4)
						arrayMoves.add(new Square(mPiece.getRow()+i,mPiece.getCol()));

			}
		
		}while(escape || escape2 || escape3 || escape4); 
		
		//I create an array with the possible moves
		for (int j = 0; j < arrayMoves.size(); j++) 
		{
			if(arrayMoves.get(j).getCol()==mPiece.getTryCol() && arrayMoves.get(j).getRow()==mPiece.getTryRow())
				correctMove=true;
		}
		return correctMove;
	}
}
