package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import pieces.Pawn;
import pieces.Piece;
import chessGame.MovePiece;
import chessGame.Square;

public class PawnTest {

	@Test
	public void test() 
	{
		int row,col,tryCol, tryRow;
		Piece piece= new Piece("black","pawn");
		Piece piece1= new Piece("white","pawn");
		Piece piece2= new Piece("black","pawn");

		//I add some pieces
		ArrayList<Square> arraySquares= new ArrayList<Square>();
		arraySquares.add(new Square(piece1,2,5));
		arraySquares.add(new Square(piece2,2,0));
		arraySquares.add(new Square(piece1,2,2));
		arraySquares.add(new Square(piece1,3,3));
		arraySquares.add(new Square(piece1,3,4));
		arraySquares.add(new Square(piece1,1,2));
		
		Pawn tester= new Pawn();
		//values for a forward move
		MovePiece mPiece=new MovePiece(1,1,2,1);

		assertEquals("the movement has to be possible", true, tester.tryMove(arraySquares, piece, mPiece));
		
		//values for a 2 step forward move
		MovePiece  mPiece1=new MovePiece(1,1,3,1);
		Pawn tester1= new Pawn();

		assertEquals("the movement has to be possible", true, tester1.tryMove(arraySquares, piece, mPiece1));
		
		//values for a diagonal move
		MovePiece mPiece2=new MovePiece(1,1,2,2);
		Pawn tester2= new Pawn();
		
		assertEquals("the movement has to be possible", true, tester2.tryMove(arraySquares, piece, mPiece2));
		
		//values for a diagonal move
		MovePiece mPiece3=new MovePiece(1,1,2,0);
		Pawn tester3= new Pawn();
		
		assertEquals("the movement has to be possible", false, tester3.tryMove(arraySquares, piece, mPiece3));
		
		//values for forward move
		MovePiece mPiece4=new MovePiece(0,0,1,0);
		Pawn tester4= new Pawn();
		
		assertEquals("the movement has to be possible", true, tester4.tryMove(arraySquares, piece, mPiece4));
		
		//values for a diagonal move
		MovePiece mPiece5=new MovePiece(5,3,4,3);
		Pawn tester5= new Pawn();
		
		assertEquals("the movement has to be possible", true, tester5.tryMove(arraySquares, piece1, mPiece5));
	}
}
