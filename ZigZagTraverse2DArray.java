//Time Compelxity O(n) | Space Compexity O(n) (actually space is order of n beacuse we hav been asked to return array)
//Space Compelxity is O(1) if instead of returning array we just print the elements
//program to traverse an 2D array in zigzag order
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		int[][] arr = new int[][]{{1,3,4,10},{2,5,9,11},{6,8,12,15},{7,13,14,16}};
		ArrayList<Integer> zigzag = getZigZagTraverseArray(arr);
		System.out.println("Zigzag traverse of given 2d array is");
		System.out.println(zigzag.toString());
		
	}
	public static ArrayList<Integer> getZigZagTraverseArray(int[][] arr)
	{
		//to store the zigzag traversal in 1D ArrayList
		ArrayList<Integer> result = new ArrayList<Integer>();
        int height = arr.length-1;
        int width = arr[0].length-1;
        int row = 0;
        int col = 0;
        //to keep track if we r moving down or not
        //it is initialized to true because the first step is goingDown in 2D array
        boolean goingDown = true;

        //continue looping untill index go outOfBound 
        while(! isOutOfBound(row,col,height,width))
        {
        	//add the current(row,col) element to ArrayList
        	result.add(arr[row][col]);

        	//check if we are going  down
        	if(goingDown)
        	{
        		//while goig down check if index falls in perimeter of the 2D array
        		//the preimeter can be last row or first column
                if( row == height || col == 0)
                {
                	//if its in perimeter change the direction	
                	goingDown=false;

                	//if its in last row of 2D array
                	//then shift towards right as we cant go further down
                	if(row == height)
                	{
                		//shifting towards right
                		col = col+1;
                	}
                	else
                	{
                		//continue going down(not diagonally left down) (as we are in first column)
                		row = row+1;
                	}
                }
                //if we are not in perimeter of matrix
                else
                {
                	//traverse in diagonally left down direction
                	row = row+1;
                	col = col-1;
                }
        	}

        	//if we r goingUp i.e goingDown = False
        	else
        	{
                //check if index falls in perimeter of matrix
        		if(row==0 || col == width)
        		{
        			//change the direction as we r in perimetr 
        			goingDown=true;
        			//if we are in last column we cant go further up/diagonally up right
        			//so shift direction to down 
        			if(col==width)
        			{
        				//shifting to down
                         row = row+1;
        			}
        			//else go to right(not diagonally right up)
        			else
        			{
        				//shifting towards right
        				col = col+1;
        			}
        		}
        		//els eif we are not in perimeter of matrix
        		else
        		{
        			//continue moving diagonally up right
        			row = row-1;
        			col = col+1;
        		}

        	}

        }

        //return the result array where zigzag traverse of 2D matrix is stored
        return result;
	}
	public static boolean isOutOfBound(int row,int col , int height , int width)
	{
		//return true if index is out of Bound else false
		return  row < 0 || row > height || col < 0 || col > width;
	}
}