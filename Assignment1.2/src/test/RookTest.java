package test;


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import pieces.Bishop;
import pieces.Piece;
import pieces.Rook;
import chessGame.MovePiece;
import chessGame.Square;

public class RookTest 
{

	@Test
	public void test() 
	{
		MovePiece mPiece;
		Piece piece= new Piece("w","rook");
		Piece piece1= new Piece("b","pawn");
		Piece piece2= new Piece("w","pawn");

		//I add some pieces
		ArrayList<Square> arraySquares= new ArrayList<Square>();
		
		arraySquares.add(new Square(piece2,0,0));
		arraySquares.add(new Square(piece1,3,2));
		arraySquares.add(new Square(piece1,3,3));
		
		mPiece=new MovePiece(1,1,1,5);
		Rook tester= new Rook();
		
		// check if the horizontal movements of the rook are correct
		assertEquals("the movement has to be possible", true, tester.tryMove(arraySquares, piece, mPiece));
		
		MovePiece mPiece1=new MovePiece(1,1,5,1);
		Rook tester2= new Rook();
		
		// check if the vertical movements of the rook are correct
		assertEquals("the movement has to be possible", true, tester2.tryMove(arraySquares, piece, mPiece1));
	}

}
