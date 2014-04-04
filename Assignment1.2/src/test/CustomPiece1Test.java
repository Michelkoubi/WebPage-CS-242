package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import pieces.Bishop;
import pieces.CustomPiece1;
import pieces.Piece;
import chessGame.MovePiece;
import chessGame.Square;

public class CustomPiece1Test {

	@Test
	public void test() 
	{
		MovePiece mPiece;
		Piece piece= new Piece("w","custom1");
		Piece piece1= new Piece("b","pawn");
		Piece piece2= new Piece("w","pawn");

		//I add some pieces
		ArrayList<Square> arraySquares= new ArrayList<Square>();
		arraySquares.add(new Square(piece2,1,2));
		arraySquares.add(new Square(piece1,2,1));
		
		mPiece=new MovePiece(1,1,2,1);
		CustomPiece1 tester= new CustomPiece1();
		
		// check if the movements of the bishop are correct
		assertEquals("the movement has to be possible", true, tester.tryMove(arraySquares, piece, mPiece));
		
		MovePiece mPiece1=new MovePiece(1,1,1,2);
		CustomPiece1 tester1= new CustomPiece1();
		
		// check if the movements of the bishop are correct
		assertEquals("the movement shouldn't be possible", false, tester1.tryMove(arraySquares, piece, mPiece1));
	}

}
