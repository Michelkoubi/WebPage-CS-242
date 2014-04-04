package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import pieces.King;
import pieces.Knight;
import pieces.Piece;
import chessGame.MovePiece;
import chessGame.Square;

public class KingTest {

	@Test
	public void test() 
	{
		Piece piece= new Piece("w","king");
		Piece piece1= new Piece("w","pawn");

		ArrayList<Square> arraySquares= new ArrayList<Square>();
		arraySquares.add(new Square(piece1,0,0));
		arraySquares.add(new Square(piece1,0,2));
		arraySquares.add(new Square(piece1,1,2));
		arraySquares.add(new Square(piece1,2,2));
		
		MovePiece mPiece=new MovePiece(1,1,2,1);
		King tester= new King();
		
		// check if the movements 
		assertEquals("the movement has to be possible", true, tester.tryMove(arraySquares, piece,mPiece));
		
		MovePiece mPiece1=new MovePiece(1,1,0,1);
		King tester1= new King();
		
		// check if the movements 
		assertEquals("the movement has to be possible", true, tester1.tryMove(arraySquares, piece, mPiece1));
		
		MovePiece mPiece2=new MovePiece(1,1,0,0);
		King tester2= new King();
		
		// check if the movements 
		assertEquals("the movement should not be possible", false, tester2.tryMove(arraySquares, piece, mPiece2));
		
		MovePiece mPiece3=new MovePiece(1,1,2,2);
		King tester3= new King();
		
		// check if the movements 
		assertEquals("the movement should not be possible", false, tester3.tryMove(arraySquares, piece, mPiece3));
		
	}

}
