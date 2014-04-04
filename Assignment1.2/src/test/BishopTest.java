package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import chessGame.MovePiece;
import chessGame.Square;

import pieces.Bishop;
import pieces.Piece;

public class BishopTest 
{

	@Test
	public void test() 
	{
		MovePiece mPiece;
		Piece piece= new Piece("w","bishop");
		Piece piece1= new Piece("b","pawn");
		Piece piece2= new Piece("w","pawn");

		//I add some pieces
		ArrayList<Square> arraySquares= new ArrayList<Square>();
		arraySquares.add(new Square(piece2,0,0));
		arraySquares.add(new Square(piece1,2,1));
		arraySquares.add(new Square(piece1,3,3));
		arraySquares.add(new Square(piece1,2,1));
		
		mPiece=new MovePiece(1,1,4,4);
		Bishop tester= new Bishop();
		
		// check if the movements of the bishop are correct
		assertEquals("the movement has to be possible", false, tester.tryMove(arraySquares, piece, mPiece));
	}

}
