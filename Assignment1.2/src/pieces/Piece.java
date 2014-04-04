package pieces;

public class Piece 
{

	String color;
	String type;

	public Piece()
	{}
	public Piece(String color, String type)
	{
		this.color=color;
		this.type=type;	
	}
	public void setColor(String color_)
	{
		color=color_;
	}
	
	public String getColor()
	{
		return color;
	}
	public void setType(String type_)
	{
		type=type_;
	}
	
	public String getType()
	{
		return type;
	}
	public boolean noException(int row, int col)
	{
		if(row>7 || col>7)
		{
			return false;
		}
		else if(row<0 || col<0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
