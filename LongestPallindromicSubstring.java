//Time Complexity O(n^2)
//Space Complexity O(1)
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		String st = "abaxyzzyxf";
		String result = getLongestPallindrome(st);
		System.out.println("Longest Pallindrome Length "+result.length());
		System.out.println("Pallindrome is "+ result);
		
	}
	public static String getLongestPallindrome(String st)
	{
	    int[] currrentLongest = new int[2]; 
	    currrentLongest[0] = 0; //left index of current longest Pallndrome
	    currrentLongest[1] = 1; //right index - 1 of current longest Pallindrome (excluded)
		for(int i = 1 ; i < st.length() ; i++)
		{
			//start expansion towards left and right keeping  character at this index as middle element
			int[] odd = getLongestPallindromeFrom(st,i-1,i+1);
			//start expansion towards left and right for even length pallindrome keeping charcter
			//at this index in th right halve
			int[] even = getLongestPallindromeFrom(st,i-1,i);

			//get the longest between both the possibilities at this given index
			//length of pallindrome = right idx - left odx
			int[] longest = odd[1]-odd[0] > even[1]-even[0] ? odd : even; 
            
            //compare the result with previously stored pallindrome length by 
            //subtracting the left idx from right idx
			currrentLongest = currrentLongest[1]-currrentLongest[0] > longest[1]-longest[0] ?  currrentLongest : longest;
		}
        
        //the left idx & right idx of longestPallindrome is stored in currentLongest
        //return the substring accordingly
		return st.substring(currrentLongest[0],currrentLongest[1]);
	}
	public static int[] getLongestPallindromeFrom(String st , int left , int right)
	{
		while(left >= 0 & right < st.length())
		{
			if(st.charAt(left) != st.charAt(right))
			{
				break;
			}
			left--;
			right++;
		}

		//left + 1 is passed as the break would have resulted in additional left-- operation which 
		//is outside of the pallindrome index

		//additional right++ have also occured ,but we are not passing right - 1 because the substring()
		//function takes excluded value for right idx 

		//tha is substring(leftidx,rightidx) returns a substring starting from index left idx 

		//and ending at right idx-1
		return new int[]{left+1,right};
	}
}