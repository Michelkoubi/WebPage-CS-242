package pieces;

import java.util.ArrayList;
import java.util.Iterator;

import chessGame.MovePiece;
import chessGame.Square;
import pieces.Bishop;
import pieces.Rook;

public class Queen extends Piece
{
	boolean isPossible, isPossibleRook, isPossibleBishop;
	String color;

	ArrayList<Square> arraySquares= new ArrayList<Square>();

	Piece piece;
	MovePiece mPiece;
	Bishop bishop=new Bishop();
	Rook rook=new Rook();

	
	public boolean tryMove(ArrayList<Square> arraySquares, Piece piece, MovePiece mPiece)
	{
		this.piece=piece;
		this.arraySquares=arraySquares;
		this.mPiece=mPiece;
		
		isPossibleBishop=bishop.tryMove(arraySquares, piece, mPiece);
		isPossibleRook=rook.tryMove(arraySquares, piece, mPiece);
		
	if (isPossibleBishop || isPossibleRook )
	{
		isPossible=true;
	} 
	
		return isPossible;
	}
}
