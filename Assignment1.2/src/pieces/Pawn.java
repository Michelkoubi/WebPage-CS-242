package pieces;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import chessGame.MovePiece;
import chessGame.Square;


public class Pawn extends Piece
{
	boolean isPossible;
	int varOne, varTwo;
	String color;
	
	//need variable from loop of game telling me if it is the fist move of pawn
	ArrayList<Square> arraySquares= new ArrayList<Square>();
	ArrayList<Square> arrayMoves= new ArrayList<Square>();
	Piece piece;
	MovePiece mPiece;

	
	public boolean tryMove(ArrayList<Square> arraySquares, Piece piece, MovePiece mPiece)
	{
		this.piece=piece;
		this.arraySquares=arraySquares;
		this.mPiece=mPiece;
		
		isPossible=false;
		//arrayMoves=null;
		
		//I alternate colors because I use equals to compare them
		if(piece.getColor().equals("white"))//Can only move up
		{
			varTwo=2;
			varOne=1;
			isPossible=calcMoves("black");	
		}
		else
		{
			varTwo=-2;
			varOne=-1;
			isPossible=calcMoves("white");
		}
		
		return isPossible;
	}

	public boolean calcMoves(String color)
	{
		ArrayList<Square> arrayMoves= new ArrayList<Square>();
		boolean correctMove;
		correctMove=false;
		this.color=color;

		//check for forward moves
			 if((!arraySquares.contains(new Square(mPiece.getTryRow(),mPiece.getTryCol()))) && mPiece.getCol()==mPiece.getTryCol() && mPiece.getRow()-varOne==mPiece.getTryRow())
			 {
				 if(noException(mPiece.getRow()-varOne,mPiece.getCol()))//check if the point is out of the board
				 {
					 arrayMoves.add(new Square(mPiece.getTryRow(),mPiece.getTryCol()));
				 }
			 }
			 
			 //check for 2 step forward move
			 if((!arraySquares.contains(new Square(mPiece.getTryRow(),mPiece.getTryCol()))) && (!arraySquares.contains(new Square(mPiece.getTryRow()-varOne,mPiece.getTryCol()))) && mPiece.getCol()==mPiece.getTryCol() && mPiece.getRow()-varTwo==mPiece.getTryRow())
			 {
				 if(noException(mPiece.getRow()-varTwo,mPiece.getCol()))//check if the point is out of the board
				 {
					 arrayMoves.add(new Square(mPiece.getRow()-varTwo,mPiece.getCol()));
				 }
			 }
			 
		//check for diagonal moves	 
			 for(Object o: arraySquares)
			{
				Square square= (Square) o;
				 if(square.getCol()==mPiece.getTryCol() && square.getRow()==mPiece.getTryRow()&& mPiece.getCol()-varOne==mPiece.getTryCol() && mPiece.getRow()-varOne==mPiece.getTryRow() && (square.getPiece().getColor().equals(color)))
				 {
					 if(noException(mPiece.getRow()-varOne,mPiece.getCol()-varOne))
					 arrayMoves.add(new Square(mPiece.getRow()-varOne,mPiece.getCol()-varOne));
					 
				 }
				 if(square.getCol()==mPiece.getTryCol() && square.getRow()==mPiece.getTryRow() && mPiece.getCol()+varOne==mPiece.getTryCol() && mPiece.getRow()-varOne==mPiece.getTryRow() && (square.getPiece().getColor().equals(color)))
				 {
					 if(noException(mPiece.getRow()-varOne,mPiece.getCol()+varOne))
					 arrayMoves.add(new Square(mPiece.getRow()-varOne,mPiece.getCol()+varOne));
				 }
			 }

		for (int k = 0; k < arrayMoves.size(); k++) 
		{
			if(arrayMoves.get(k).getCol()==mPiece.getTryCol() && arrayMoves.get(k).getRow()==mPiece.getTryRow())
				correctMove=true;
		}
		return correctMove;
	}
}

