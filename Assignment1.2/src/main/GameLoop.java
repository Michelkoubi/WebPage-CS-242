package main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import chessGame.Board;
import chessGame.Control;
import chessGame.Player;

public class GameLoop 
{
	JLayeredPane layeredPane;
	JFrame frame;
	JPanel myPanel;
	JButton btnUndo, btnRestart;
	public boolean isRunning=true;
	public boolean checkMate=false;
	Player player1, player2;
	String name1,name2;
	public boolean isFirst=false;
	public boolean moveDone=false;
	boolean colorWhite=true;
	boolean colorBlack=false;
	Board board;
	Control control;

	/**
	 * method that is running the game
	 * @param board
	 */
	public void start()
	{
		player1= new Player(name1,colorWhite);
		player2= new Player(name2,colorBlack);
		
		board=new Board();
		myPanel=board.getThePanel();
		control= new Control(board,myPanel);
		
		if(!checkMate)
		{
			while(isRunning)
			{
				//Alternates the players turns
				makeTurn();
				checkMate=control.getCheckMate();
				
				if(checkMate)
				break;
			}
		}
		else
		{
			  control.showGameOver();
		}
	}
	
    public void makeTurn(){
        if(isFirst)
        {
        	moveDone=control.makeMove(player1);
        }
        else
        {
        	moveDone=control.makeMove(player2);
        }
        
        if(moveDone)
        {
            isFirst = !isFirst;
            moveDone=false;
        }

    }
}
