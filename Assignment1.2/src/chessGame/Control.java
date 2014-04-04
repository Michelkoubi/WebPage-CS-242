package chessGame;

import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pieces.Bishop;
import pieces.CustomPiece1;
import pieces.CustomPiece2;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

public class Control implements MouseListener, MouseMotionListener, ActionListener
{
	JLayeredPane layeredPane;
	JPanel myPanel;
	Board board;
	Dimension boardSize = new Dimension(750,750);
	JButton buttonUndo,buttonRestart;
	int conversion=0;
	float num;
	boolean isPossible,check, canDo, possibleMove;
	MovePiece mPiece;
	Piece piece;
	ArrayList<Square> arraySquares= new ArrayList<Square>();
	Pawn p= new Pawn();
	Knight kn=new Knight();
	King k=new King();
	Queen q=new Queen();
	Rook r= new Rook();
	Bishop b= new Bishop();
	CustomPiece1 cp1;
	CustomPiece2 cp2;
	Player player;
	JLabel pickedPiece;
	Piece chosenMovePiece;
	int colX, rowY, tryColX, tryRowY, colXPressed, rowYPressed;
	int xAdj,yAdj;
	float numPixelPressed=100;//because when I pick a piece it gives me the number in pixels
	float numPixelReleased=114;
	JMenu menu;
	JMenuBar menuBar;
	JMenuItem menuItemUndo,menuItemRestart;
	
	public Control(Board board, JPanel myPanel)
	{
		this.board=board;
		this.myPanel=myPanel;
		arraySquares=board.getTheArrayList();

		initializeMenuBar();
		initBoard();
		layeredPane = initializeLayeredPane();
	    layeredPane.addMouseListener(this);  
	    layeredPane.addMouseMotionListener(this);
	    
		myPanel=board.getThePanel();
		layeredPane.add(myPanel, JLayeredPane.DEFAULT_LAYER); 
		board.initializePanel();
		
		buttonUndo.addActionListener(this);
		buttonRestart.addActionListener(this);

		board.pack();
		board.setVisible(true);	
		board.setResizable(false);
	}
	public void initBoard()
	{
		board.setSize(boardSize);
		board.setJMenuBar(menuBar);
		board.setTitle("CHESS GAME");
		board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * I create a layeredPane to be able to get the effect of dragging pieces
	 */
	public JLayeredPane initializeLayeredPane()
	{
		JLayeredPane layeredPane = new JLayeredPane(); 
        board.getContentPane().add(layeredPane);  
        layeredPane.setPreferredSize(boardSize);  
        return layeredPane;
	}
	/**
	 * I create a menu to add the restart and undo options
	 */
	public void initializeMenuBar()
	{
		menuBar = new JMenuBar();
		menu = new JMenu("Options Menu");
		menuBar.add(menu);
		
		buttonUndo = new JButton("Undo");
		buttonRestart = new JButton("Restart");
		menu.add(buttonUndo);
		menu.add(buttonRestart);
		
	}
	/**
	 * Controller in order to obtain the movements of the piece
	 * that the user is moving.
	 * @param arraySquares
	 * @param piece
	 * @param mPiece
	 * @return boolean
	 */
	public boolean tryMove(ArrayList<Square> arraySquares, Piece piece, MovePiece mPiece)
	{
		System.out.println("u");
		this.arraySquares=arraySquares;
		this.mPiece=mPiece;
		this.piece=piece;
		canDo=false;
		String type=piece.getType();
		
		//I try the possible moves
		if(type.equals("pawn"))
			canDo=p.tryMove(arraySquares, piece, mPiece);
		if(type.equals("bishop"))
			canDo=b.tryMove(arraySquares, piece, mPiece);
		if(type.equals("rook"))
			canDo=r.tryMove(arraySquares, piece, mPiece);
		if(type.equals("knight"))
			canDo=kn.tryMove(arraySquares, piece, mPiece);
		if(type.equals("king"))
			canDo=k.tryMove(arraySquares, piece, mPiece);
		if(type.equals("queen"))
			canDo=q.tryMove(arraySquares, piece, mPiece);
		if(type.equals("custom1"))
			canDo=cp1.tryMove(arraySquares, piece, mPiece);
		if(type.equals("custom2"))
			canDo=cp2.tryMove(arraySquares, piece, mPiece);
		
		return canDo;
	}
	/**
	 * I set the action listeners in the buttons to handle the events
	 * from the controller
	 * @param buttonUndo
	 * @param buttonRestart
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == buttonUndo)
		{
			System.out.println("undo");
			
		}
		// TODO Auto-generated method stub
		if(e.getSource() == buttonRestart)
		{
			//update the arrayList
			arraySquares.clear();
			board.addSquares();
			arraySquares=board.getTheArrayList();
			JPanel Square[][]=board.getSquare();
			
			//I clear the Jpanel to bring the pieces to the same place

			board.createLabelsAdd(Square);
			
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * I implement the functionality to detect
	 * where I get the piece
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		 pickedPiece = null;
		 Component c =  myPanel.findComponentAt(e.getX(), e.getY());
		 
		 //I change the row and col from pixels to int
		 colX=validate((e.getX()/numPixelPressed));
		 rowY=validate((e.getY()/numPixelPressed));
		 
		 System.out.println("rowPressed"+e.getY()/numPixelPressed+"colPressed"+e.getX()/numPixelPressed);
		 //System.out.println("rowPressed"+e.getY()+"colPressed"+e.getX());
		 
		 //So that I can go back in the movement in Mouse release
		 colXPressed=e.getX();
		 rowYPressed=e.getY();
		 
		 
		  if (c instanceof JPanel) 
			  return;
		  
			  Point parentLocation = c.getParent().getLocation();
			  xAdj = parentLocation.x - e.getX();
			  yAdj = parentLocation.y - e.getY();
			  pickedPiece = (JLabel)c;

			  pickedPiece.setLocation(e.getX() + xAdj, e.getY() + yAdj);
			  pickedPiece.setSize(pickedPiece.getWidth(), pickedPiece.getHeight());
			  layeredPane.add(pickedPiece,JLayeredPane.DRAG_LAYER);	
		
	}
	/**
	 * I implement the functionality to detect
	 * where I release the piece
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		possibleMove=false;
		
		  if(pickedPiece == null) 
			  return;
		  
		  pickedPiece.setVisible(false);
		  Component c =  myPanel.findComponentAt(e.getX(), e.getY());
		  
		  //I change the Tryrow and Trycol from pixels to int  
		  tryColX=validate(((e.getX()+xAdj)/numPixelReleased));
		  tryRowY=validate(((e.getY()+yAdj)/numPixelReleased)); 
		  
		  	System.out.println("rowReleased"+(e.getY()+yAdj)/numPixelReleased+"colReleased"+(e.getX()+xAdj)/numPixelReleased);
		  	//System.out.println("rowReleased"+(e.getY()+yAdj)+"colReleased"+(e.getX()+xAdj));
		  
		  possibleMove=sendMove();
		  
		  //If the move is possible I permit the move
		  if(possibleMove)
		  {
			  permitMove(c);
			  pickedPiece.setVisible(true);
			  //METODO PARA EL CONTROL
		   }
		  else //get Piece back where it was, because that move is not possible
		  {
			  Component c1 =  myPanel.findComponentAt(colXPressed,rowYPressed);
			  permitMove(c1);
			  pickedPiece.setVisible(true);
			  /*
			  JOptionPane.showMessageDialog(frame,
					    "You can't move this piece there",
					    "Movement Error",
					    JOptionPane.ERROR_MESSAGE);*/
		  }
		
	}
	/**
	 * I implement the functionality to drag the pieces through the board
	 */
	@Override
	public void mouseDragged(MouseEvent mde) {
		// TODO Auto-generated method stub
		
		  if (pickedPiece == null) 
			  return;
		  
			  pickedPiece.setLocation(mde.getX() + xAdj, mde.getY() + yAdj);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * I move the piece to the new square,
	 * or back to the same
	 * @param c
	 */
	public void permitMove(Component c)
	{
		  if (c instanceof JLabel)
		  {
			  Container parent = c.getParent();
			  parent.remove(0);
			  parent.add( pickedPiece );
		  }
		  else 
		  {
			  
			  Container parent = (Container)c;
			  parent.add( pickedPiece );
		  }
	}
	/**
	 * I send the move to the control in order to see
	 * if it is possible
	 * @return
	 */
	public boolean sendMove()
	{
		  isPossible=false;
		  chosenMovePiece=null;
		  
		  //I get the piece that the user is trying to move
		  for(int i=0; i < arraySquares.size(); i++)
		  {
			  if(arraySquares.get(i).getRow()==rowY && arraySquares.get(i).getCol()==colX)
				  chosenMovePiece =arraySquares.get(i).getPiece();
		  }

		  
		  //Piece for where do I want to move
		  MovePiece mPiece= new MovePiece(rowY,colX,tryRowY,tryColX);
		  System.out.println("move piece"+ mPiece.getRow()+ mPiece.getCol() +mPiece.getTryRow()+mPiece.getTryCol());
		  
		  //I see if the movement is possible for the chosenMovePiece
		  if(chosenMovePiece!=null)
			  	isPossible=tryMove(arraySquares, chosenMovePiece, mPiece);
		  
		 if(isPossible) 
		 {
			
			 System.out.println("movimiento posible");
			//I update the labels
			 board.doActionBoard(mPiece,chosenMovePiece);
			 
			//I update the arrayList if it has eaten a piece
			if(arraySquares.contains(new Square(tryRowY,tryColX)))
				arraySquares.remove(new Square(tryRowY,tryColX));
			
			//I update the arrayList of moving a piece
			 arraySquares.remove(new Square(chosenMovePiece,rowY,colX));
			 arraySquares.add(new Square(chosenMovePiece,tryRowY,tryColX));

		 	return true;
		 }
		 else
		 {
			 return false;//invalid move
		 }
	}
	
	//To change from pixels to positions correctly
	public int validate(float num)
	{
		this.num=num;
		if(-1<num && num<0.5)	
			conversion=0;
		if(0.5<num && num<1.5)
			conversion=1;
		if(1.5<num && num<2.5)
			conversion=2;
		if(2.5<num && num<3.5)
			conversion=3;
		if(3.5<num && num<4.5)
			conversion=4;
		if(4.5<num && num<5.5)
			conversion=5;
		if(5.5<num && num<6.5)
			conversion=6;
		if(6.5<num && num<7.5)
			conversion=7;
		if(num>7.5)
			conversion=7;
		
		return conversion;
	}

	public void showGameOver()
	{
		JOptionPane.showMessageDialog(board,
			    "GAME OVER",
			    "END",
			    JOptionPane.PLAIN_MESSAGE);
	}
	public boolean getCheckMate()
	{
		return check;	
	}
	public boolean makeMove(Player player)
	{
		boolean color;
		this.player=player;
		
		color=player.getColor();
		
		if(color)//white=true
		{
			//makeWhiteMove();
		}
		else
		{
			////makeBlackMove();
		}
		return check;
		
	}
}
