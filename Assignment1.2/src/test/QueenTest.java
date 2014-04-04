package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import pieces.Bishop;
import pieces.Queen;
import pieces.Piece;
import chessGame.MovePiece;
import chessGame.Square;

public class QueenTest {

	@Test
	public void test() 
	{
		MovePiece mPiece;
		Piece piece= new Piece("w","queen");
		Piece piece1= new Piece("b","pawn");
		Piece piece2= new Piece("w","pawn");

		//I add some pieces
		ArrayList<Square> arraySquares= new ArrayList<Square>();
		arraySquares.add(new Square(piece2,0,0));
		arraySquares.add(new Square(piece1,3,3));
		
		mPiece=new MovePiece(1,1,3,3);
		Queen tester= new Queen();
		
		// check diagonal move
		assertEquals("the movement has to be possible", true, tester.tryMove(arraySquares, piece, mPiece));
		
		mPiece=new MovePiece(1,1,1,5);
		Queen tester2= new Queen();
		
		// check forward move
		assertEquals("the movement has to be possible", true, tester2.tryMove(arraySquares, piece, mPiece));
	}

}
