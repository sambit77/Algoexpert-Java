//Time Complexity O(m*n* min(m,n)) | Space Compelxity O(m*n* min(m,n))
//m = length of String 1 | n = lenght o String 2
//m*n is due to 2 nested for loops
//min(m*n) is due to String concatentaion operation inside the nested loop 
//we take minimum as a common subsequence will laways be of length minimum of both length

//clearly the String concatenation and storing String in the 2D array is purely not optimal
//we can achieve better time and space complexity  by not storing the string or conactenation operation
// rather to store index from where lcs forks from and the length by this we can get rid of O(min(m,n))
//so time complexity and space complexity will drop to O(m,n)
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		String str1 = "zxvvyzw";
		String str2 = "xkylzpw";
		String result = getLongestSubsequemce(str1,str2);
		System.out.println("Longest Common Subsequence is "+result);
		
	}
	public static String getLongestSubsequemce(String s1 , String s2)
	{
		//lcs array to store Strings
		//by default the array gets initialized with null value

		
		String[][] lcs = new String[s1.length()+1][s2.length()+1];


		// but here we are again initializing it with "" String because if we use null value
		//we cant use length() fuction to get the length of String it will throw NullPointerException
		//also when we concate null with caharcter a : result is --  nulla
		//but when we conact "" with charcater a " result is -- 1"
		for(int i = 0 ; i < s1.length()+1; i++)
		{
			for(int j = 0; j < s2.length()+1 ; j++)
			{
				lcs[i][j]="";
			}
		}
		
	    

	    for(int i = 1; i < s1.length()+1 ; i++)
	    {
	    	for(int j = 1 ; j < s2.length() + 1 ; j++)
	    	{
	    		//string is traverse using i-1 & j-1 because the 0th row & 0th column is for "" String
	    		//given 2 string runs from i+1 and j+1

	    		//if character in the string and equal
	    		if(s1.charAt(i-1)==(s2.charAt(j-1)))
	    		{
	    			//append this character to previosuly stored lcs (it will be in left corner grid)
	    			//currentgrid = cornergrid+currentCharacter
	    			lcs[i][j] = lcs[i-1][j-1]+s1.charAt(i-1);
	    		}

	    		//if the character is not equal
	    		else
	    		{
	    			//check the top & left grids
	    			//and assign the String to current grid whose length os maximum amog top & left grid
	    			//top String length > left String length
                    if(lcs[i-1][j].length()   >  lcs[i][j-1].length())
                    {
                    	//current grid = top grid
                    	lcs[i][j] = lcs[i-1][j];
                    }
                    else
                    {
                    	//left string length >= top String length
                    	//current grid = left grid
                    	lcs[i][j] = lcs[i][j-1];
                    }
	    		}
	    	}
	    }

	    //the lcs for s1 & s2 we will be present in last grid of 2d matrix
		return lcs[s1.length()][s2.length()];
	}
	
	
}