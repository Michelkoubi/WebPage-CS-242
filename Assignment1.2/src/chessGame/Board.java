package chessGame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pieces.Piece;

/**
 * 
 * @author miguel
 * GUI
 */
public class Board extends JFrame 
{
	Control control;
	JButton buttonUndo,buttonRestart;
	JPanel Square[][]=new JPanel[8][8];;
	MovePiece mPiece;
	boolean isPossible;
	boolean possibleMove=false;
	JFrame frame;
	JLayeredPane layeredPane;
	JPanel myPanel;
	int xAdj,yAdj;
	Dimension boardSize = new Dimension(760,760);
	Dimension pieceSize = new Dimension(10,10);
	JLabel pickedPiece;
	Piece chosenMovePiece;
	int colX, rowY, tryColX, tryRowY, colXPressed, rowYPressed;
	ArrayList<Square> arraySquares= new ArrayList<Square>();
	ArrayList<JLabel> arraybPawns;
	ArrayList<JLabel> arraywPawns;
	JLabel bBishop;
	JLabel b1Bishop;
	JLabel wBishop;
	JLabel w1Bishop;
	JLabel bRook;
	JLabel b1Rook;
	JLabel wRook;
	JLabel w1Rook;
	JLabel bKnight;
	JLabel b1Knight;
	JLabel wKnight;
	JLabel w1Knight;
	JLabel bKing;
	JLabel wKing;
	JLabel bQueen;
	JLabel wQueen;;
	
		public Board()
		{
		  	myPanel = new JPanel();

			//I paint all the squares in the board
			  for (int i = 0; i < 8; i++) 
			  {
			        for (int j = 0; j < 8; j++) 
			        {
			            Square[i][j] = new JPanel(new BorderLayout());

			            if ((i + j) % 2 == 0) {
			                Square[i][j].setBackground(Color.lightGray);
			            } else {
			                Square[i][j].setBackground(Color.white);
			            }
			            myPanel.add(Square[i][j]);
			        }
			   }

			//I create the labels and add the images
			createLabelsAdd(Square);
			createPawnLabelsAdd(Square);
			
			//I create the arrayList with which squares are occupied
			addSquares();
		}
		/**
		 * Creates the JPanel were I'm going to add the pieces
		 */
		public void initializePanel() 
		{
			myPanel.setLayout( new GridLayout(8, 8) );  
			myPanel.setPreferredSize( boardSize );  
			myPanel.setBounds(0, 0, boardSize.width, boardSize.height); 
	    }
	
		/**
		 * I create the JLabels to add the images, and then add
		 * them to the board
		 */
		public void createLabelsAdd(JPanel Square[][])
		{
			bBishop = new JLabel( new ImageIcon("BlackBishop.png") );
			b1Bishop = new JLabel( new ImageIcon("BlackBishop.png") );
			wBishop = new JLabel( new ImageIcon("WhiteBishop.png") );
			w1Bishop = new JLabel( new ImageIcon("WhiteBishop.png") );
			 
			bRook = new JLabel( new ImageIcon("BlackRook.png") );
			wRook = new JLabel( new ImageIcon("WhiteRook.png") );
			b1Rook = new JLabel( new ImageIcon("BlackRook.png") );
			w1Rook = new JLabel( new ImageIcon("WhiteRook.png") );
			 
			 
			bKnight = new JLabel( new ImageIcon("BlackKnight.png") );
			wKnight = new JLabel( new ImageIcon("WhiteKnight.png") );
			b1Knight = new JLabel( new ImageIcon("BlackKnight.png") );
			w1Knight = new JLabel( new ImageIcon("WhiteKnight.png") );
			 
			bKing = new JLabel( new ImageIcon("BlackKing.png") );
			wKing = new JLabel( new ImageIcon("WhiteKing.png") );
			bQueen = new JLabel( new ImageIcon("BlackQueen.png") );
			wQueen = new JLabel( new ImageIcon("WhiteQueen.png") );
			 
			//I add rest of the pieces
			  Square[0][0].add(bRook);
			  Square[0][7].add(b1Rook);
			  Square[7][0].add(wRook);
			  Square[7][7].add(w1Rook);
			  
			  Square[0][1].add(bKnight);
			  Square[0][6].add(b1Knight);
			  Square[7][1].add(wKnight);
			  Square[7][6].add(w1Knight);
			  
			  Square[0][2].add(bBishop);
			  Square[0][5].add(b1Bishop);
			  Square[7][2].add(wBishop);
			  Square[7][5].add(w1Bishop);
			  
			  Square[0][4].add(bKing);
			  Square[0][3].add(bQueen);
			  
			  Square[7][4].add(wKing);
			  Square[7][3].add(wQueen);
		}
		/**
		 * I create the Pawns JLabels to add the images, and then add
		 * them to the board
		 */
		public void createPawnLabelsAdd(JPanel Square[][])
		{
			arraybPawns= new ArrayList<JLabel>();
			arraywPawns= new ArrayList<JLabel>();
			  //I create the labels for every the pawns
			  for (int i = 0; i < 8; i++) 
			  {
				  arraybPawns.add(new JLabel( new ImageIcon("pawn.png") ));
			  }

			  for (int i = 0; i < 8; i++) 
			  {
				  arraywPawns.add(new JLabel( new ImageIcon("WhitePawn.png") ));
			  }
			  
			  //I add the black pawns to the board
			  for (int i = 0; i < 8; i++) 
			  {
			     Square[1][i].add(arraybPawns.get(i));
			  }
			  
			  //I add the white pawns to the board
			  for (int i = 0; i < 8; i++) 
			  {
			     Square[6][i].add(arraywPawns.get(i));
			  }
		}
		/**
		 * I create an array with the positions
		 * of all the pieces, and update it
		 */
		public void addSquares()
		{
			//I add the pawns
			  for (int i = 0; i < 8; i++) 
			  {
				  arraySquares.add(new Square(new Piece("white","pawn"),6,i));
			  }
			  for (int i = 0; i < 8; i++) 
			  {
				  arraySquares.add(new Square(new Piece("black","pawn"),1,i));
			  }
			  //black pieces
			  addSquaresRestPieces(0,"black");
			  //white pieces
			  addSquaresRestPieces(7,"white");

		}
		public void addSquaresRestPieces(int col_, String color_)
		{
			String color=color_;
			int col=col_;
			  arraySquares.add(new Square(new Piece(color,"rook"),col,0));
			  arraySquares.add(new Square(new Piece(color,"knight"),col,1));
			  arraySquares.add(new Square(new Piece(color,"bishop"),col,2));
			  arraySquares.add(new Square(new Piece(color,"rook"),col,7));
			  arraySquares.add(new Square(new Piece(color,"knight"),col,6));
			  arraySquares.add(new Square(new Piece(color,"bishop"),col,5));
			  arraySquares.add(new Square(new Piece(color,"queen"),col,3));
			  arraySquares.add(new Square(new Piece(color,"king"),col,4));
		}
		public void doActionBoard(MovePiece mPiece, Piece chosenMovePiece)
		{
			//I update the labels
			this.chosenMovePiece=chosenMovePiece;
			this.mPiece=mPiece;
			JLabel jAddLabel=getLabel();
			if(jAddLabel!=null)
			{
				Square[mPiece.getTryRow()][mPiece.getTryCol()].add(jAddLabel);
				System.out.println("change done");
			}
			
		}
		public JLabel getLabel()
		{
			String type,color;
			JLabel jAddLabel=null;
			type=chosenMovePiece.getType();
			color=chosenMovePiece.getType();
			
			if(type.equals("pawn")&& color.equals("white"))
				jAddLabel=arraywPawns.get(0);
			if(type.equals("pawn")&& color.equals("black"))
				jAddLabel=arraybPawns.get(0);
			if(type.equals("rook")&& color.equals("white"))
				jAddLabel=wRook;
			if(type.equals("rook")&& color.equals("black"))
				jAddLabel=bRook;
			if(type.equals("bishop")&& color.equals("white"))
				jAddLabel=wBishop;
			if(type.equals("bishop")&& color.equals("black"))
				jAddLabel=bBishop;
			if(type.equals("knight")&& color.equals("white"))
				jAddLabel=wKnight;
			if(type.equals("knight")&& color.equals("black"))
				jAddLabel=bKnight;
			if(type.equals("king")&& color.equals("white"))
				jAddLabel=wKing;
			if(type.equals("king")&& color.equals("black"))
				jAddLabel=bKing;
			if(type.equals("queen")&& color.equals("white"))
				jAddLabel=wQueen;
			if(type.equals("queen")&& color.equals("black"))
				jAddLabel=bQueen;

			return jAddLabel;
		}
		public JPanel getThePanel()
		{
			return myPanel;
		}
		public ArrayList<Square> getTheArrayList()
		{
			return arraySquares;
		}
		public JPanel[][] getSquare()
		{
			return Square;
		}
		/*
		//taken from Stack overflow
		 public Image getScaledImage(Image srcImg, int w, int h){
			    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
			    Graphics2D g2 = resizedImg.createGraphics();
			    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			    g2.drawImage(srcImg, 0, 0, w, h, null);
			    g2.dispose();
			    return resizedImg;
			}
		*/

}
