/*
 * Class: CMSC203 
 * Instructor: Professor Eivazi
 * Description: Plot class creates and provides methods for creating rectangles on flat plane, and checking the plane
 * Due: 10/27/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Martin Pineda
*/

package propertyprj;

public class Plot {
	
	//Attributes
	private int x;
	private int y;
	private int width;
	private int depth; 
	
	
	//Constructors
	public Plot() {
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}
	
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	 public Plot(Plot otherPlot) {
	        this.x = otherPlot.x;
	        this.y = otherPlot.y;
	        this.width = otherPlot.width;
	        this.depth = otherPlot.depth;
	    }
	
	
	//Getter and Setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	//Overlap
	
	public boolean overlaps(Plot other) {
		int thisWidth = this.x + this.width;
		int thisDepth = this.y + this.depth;
		
		int otherWidth = other.x + other.width;
		int otherDepth = other.y + other.depth;
		
		if(this.x >= otherWidth || other.x >= thisWidth) {
			return false;
		} else if(this.y >= otherDepth || other.y >= thisDepth) {
			return false;
		}
		
		
		
		return true;
	}
	
	//Encompass
	public boolean encompasses(Plot other) {
		
		int thisWidth = this.x + this.width;
		int thisDepth = this.y + this.depth;
		
		int otherWidth = other.x + other.width;
		int otherDepth = other.y + other.depth;
		
		
		if(other.x < this.x) {
			//Starts too left
			return false;
		} else if (other.y < this.y) {
			//Starts to high
			return false;
		} else if (otherWidth > thisWidth) {
			//Too wide
			return false;
		} else if (otherDepth > thisDepth) {
			//Too long
			return false;
		}
		
		return true;
		
	}

	@Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
	

	
	
	
	
}
