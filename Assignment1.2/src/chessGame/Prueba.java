package chessGame;

import java.util.ArrayList;

import pieces.Piece;

public class Prueba 
{
	int y,x;
	ArrayList<Square> arraySquares= new ArrayList<Square>();
	
	public void hacer()
	{
		y=7;
		x=5;
		arraySquares.add(new Square(new Piece("white", "pawn"),y,x));
		arraySquares.add(new Square(new Piece("black", "pawn"),x,y));
		
		  for(int i=0; i < arraySquares.size(); i++)
		  {
			  System.out.println("col"+arraySquares.get(i).getRow()+ "row"+arraySquares.get(i).getRow());
		  }
		//I update the arrayList if it has eaten a piece
		if(arraySquares.contains(new Square(y,x)))
			arraySquares.remove(new Square(y,x));
		
		  for(int i=0; i < arraySquares.size(); i++)
		  {
			  System.out.println("col"+arraySquares.get(i).getRow()+ "row"+arraySquares.get(i).getRow());
		  }
		
		
	}
}
