//Time Complxity O(n^3) 
//Space Complexity O(1)
import java.util.*;
class A
{
	public static void main(String[] args) {
		
		String st = "abaxyzzyxf";
		String result = getLongestPallindrome(st);
		System.out.println("Longest Pallindrome Length "+result.length());
		System.out.println("Pallindrome is "+ result);
	}

	public static String getLongestPallindrome(String st)
	{
		//current ongest pallindrome is null
		String longest = "";

		//generate all possible subStrings
		for(int i = 0 ; i < st.length() ; i++)
		{
			for(int j = i ; j < st.length() ; j++)
			{
				String substring = st.substring(i,j+1);

				//check if received substring is pallindrome or not
				//and if yes then chek if its length is greater that current longest pallindrome
				if(isPallindrome(substring) && substring.length()>longest.length()  )
				{
					longest = substring;
				}
			}
		}
		return longest;

	}
	public static boolean isPallindrome(String str)
	{
		int left = 0;
		int right = str.length()-1;
		while(left<right)
		{
			if(str.charAt(left) != str.charAt(right))
			{
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}