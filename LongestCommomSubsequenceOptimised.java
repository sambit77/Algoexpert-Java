//Time Complexity O(mn) | Space Complexity O(mn)
//Before trying out this first try out the non optimised way
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
		//it is a 2D array storing String array(of constant size = 4) thus a 3D array
		String[][][] lcs = new String[s1.length()+1][s2.length()+1][4];
		//lcs[i][j][k] represents a  String at the kth index of a String[] array
		//lcs [i][j] represents a String[] array of zize = 4;

		//here in the String array we store following 4 information as String
		//String array 0th index :- Common charcter between 2 Strings (at certain index instant)
		//String array 1th index :- length of lcs 
		//String array  3rd & 4th index :- coordinates of from where we came from to that grid
		//if we are at i,j grid 
		//if we come from top left corner 3rd String is i-1,4th String is j-1 in String Array
		//if we come from top 3rd String is i-1,4th String is j in String Array
		//if we come from left 3rd String is i,4th String is j-1 in String Array

		//initailize the String array to 
		//0th index = "" //no common charcter 
		//1th index = "0" //current length of lcs is 0
		//3rd index = "" & 4th index = ""

		for(int i = 0 ; i < lcs.length ; i++)
		{
			for(int j = 0; j < lcs[i].length ; j++)
			{
				lcs[i][j] = new String[]{"","0","",""};
			}
		}

		//traverse to 2 dgree of 3D matrix and store the information in the String[] array at each such postions
		for(int i = 1 ;i < lcs.length ; i++ )
		{
			for(int j = 1 ; j < lcs[i].length ; j++)
			{
				//if there is common character in the String
                 if(s1.charAt(i-1)==s2.charAt(j-1))
                 {
                 	//char at this index is the common letter 
                 	//convert this to String to store it in String[] array's 0th index
                 	String commonLetter = String.valueOf(s1.charAt(i-1));

                 	//get the lcs length from top corner value (it will be in String) convert it to int
                 	//incerement it by 1
                 	//convert it back to String to store it in String[] array's 1st index
                 	String updatedLcsLength = Integer.toString(Integer.parseInt(lcs[i-1][j-1][1])+1);

                 	//convert the top left corner y corordinate to String to be store it in String[] array 3rd index
                 	String yDirection = Integer.toString(i-1);
                 	//convert the top left corner x corordinate to String to be store it in String[] array 4th index
                 	String xDirection = Integer.toString(j-1);

                 	//update the information of String[] array at (i,j) postion

                 	//i.e create a new String[] Array of size 4 ,with above 4 Strings

                 	lcs[i][j] = new String[]{commonLetter,updatedLcsLength,yDirection,xDirection};
                 }
                 //if character is not eaqual at ceratin index for input String
                 else
                 {
                 	//we have to store the maximum length among top & left grid
                 	//length will be obtained from String[] array's 1st index ,the 2 String[] array is stored 
                 	//in top (i-1,j) & left(i,j-1) respectively

                 	//compare the length by parsing them (int to int comparison)

                 	//if top length is greater than the left length

                 	if(Integer.parseInt(lcs[i-1][j][1]) > Integer.parseInt(lcs[i][j-1][1]))
                 	{
                 		//common letter is null to be Store in String[] array 0th index
                 		String commonLetter = "";

                 		//new lcs length will be length (String[] array 1st index) of top as this is the maximum
                 		///it will be already in String ,store it in String[] array 1st index

                 		String updatedLcsLength = lcs[i-1][j][1];

                 		//top grid y cordinate is i-1 conver it to String to Store it in String[] array 3rd index
                 		String yDirection = Integer.toString(i-1);
                 		//top grid x cordinate is j conver it to String to Store it in String[] array 4th index
                 		String xDirection = Integer.toString(j);
                 		//update the information of String[] array at (i,j) postion

                 	    //i.e create a new String[] Array of size 4 ,with above 4 Strings
                 		lcs[i][j]=new String[]{commonLetter,updatedLcsLength,yDirection,xDirection};
                 	}
                 	//we have to store the maximum length among top & left grid
                 	//length will be obtained from String[] array's 1st index ,the 2 String[] array is stored 
                 	//in top (i-1,j) & left(i,j-1) respectively

                 	//compare the length by parsing them (int to int comparison)

                 	//if top length is not greater than the left length
                 	else
                 	{
                 		//common letter is null to be Store in String[] array 0th index
                 		String commonLetter = "";
                 		//new lcs length will be length (String[] array 1st index) of left as this is the maximum
                 		///it will be already in String ,store it in String[] array 1st index
                 		String updatedLcsLength = lcs[i][j-1][1];
                 		//left grid y cordinate is i conver it to String to Store it in String[] array 3rd index
                 		String yDirection = Integer.toString(i);
                 		//left grid x cordinate is j-1 conver it to String to Store it in String[] array 4th index
                 		String xDirection = Integer.toString(j-1);

                 		//update the information of String[] array at (i,j) postion

                 	    //i.e create a new String[] Array of size 4 ,with above 4 Strings
                 		lcs[i][j]=new String[]{commonLetter,updatedLcsLength,yDirection,xDirection};

                 	}
                 }
			}
		}
		
		//pass the lcs 3d String array to a function that wil create a sequence and return a String
		return buildSequece(lcs);
		
	}
	public static String buildSequece(String[][][] lcs)
	{
		//we will go on appending common letters to this StringBuffer one by one in reverse order
		StringBuffer commonSequence = new StringBuffer();;

		//start traversing the lcs as 2D array from last String[] array
		//the very last String[] array has following cooordinates
		int i = lcs.length-1;
		int j = lcs[0].length-1;
		
        
        //keep traversing and appending common character from very last String[] array 
        //till we reach very first String[] array at (0,0) position
 		while(i != 0 & j != 0)
		{
			//get the String[] array at i,j grid
			String[] currentEntry = lcs[i][j];

			//if charcter to append is not null
			//i,e there is a common ncharacter this must be appended
			//information about common character is present at String[] array 0th index
			if(currentEntry[0] != "")
			{
				//append this character to the String buffer
				commonSequence.append(currentEntry[0]);
				

			}
			//update the coordinates to previous coordinates (from where we came here)


			//information regarding this is present in String[] array 3rd & 4th index
			i = Integer.parseInt(currentEntry[2]);
			j=Integer.parseInt(currentEntry[3]);
		}
		
		//before returning the common sequence we need to reverse it
		//as we have traversed the 2D array from last String[] array 
		//so we need to reverse it
		//and this is a StringBuffer so convert it to String before returing it
		 return commonSequence.reverse().toString();
	}
}
