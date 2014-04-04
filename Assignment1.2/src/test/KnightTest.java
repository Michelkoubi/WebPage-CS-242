package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import pieces.Knight;
import pieces.Piece;
import chessGame.MovePiece;
import chessGame.Square;

public class KnightTest {

	@Test
	public void test() 
	{
		Piece piece= new Piece("w","knight");
		Piece piece1= new Piece("w","pawn");

		ArrayList<Square> arraySquares= new ArrayList<Square>();
		arraySquares.add(new Square(piece1,0,0));
		arraySquares.add(new Square(piece1,3,2));
		arraySquares.add(new Square(piece1,2,2));
		arraySquares.add(new Square(piece1,2,1));
		
		MovePiece mPiece=new MovePiece(1,1,3,2);

		Knight tester= new Knight();
		
		// check if the movements
		assertEquals("the movement has to be possible", false, tester.tryMove(arraySquares, piece, mPiece));
	}

}
