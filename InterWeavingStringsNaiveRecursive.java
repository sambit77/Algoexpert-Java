//Time Complexity O(2^(n+m)) | Space Complexity O(n+m)
//such large time complexity is due to recursion which can be reduced by the technique of memoization
//Time COmplexity and Space Complexity both can be reduced to O(nm) in memoization
import java.util.*;
class A
{
	public static void main(String[] args) 
	{

		String one = "aaa";
		String two = "aaaf";
		String three = "aaafaaa";
		//check id String one & two can be interwoven to form third String
		boolean result = checkForInterWeaving(one,two,three);
		System.out.println("is thirs String is inter woven string of one & two ?"+result);
	}
	public static boolean checkForInterWeaving(String one ,String two,String three)
	{
		//if length of third String i sgreater than the sum of length of first two Strings 
		//they can never be interwoven to fm third String
		if(three.length()>one.length()+two.length())
		{
			return false;
		}
		return isInterWoven(one,two,three,0,0);
	}

	public static boolean isInterWoven(String one ,String two , String three,int i ,int j)
	{
		//i pointer is used to traverse String 1
		//j pointer is used to traverse String 2

		//k is used to tarverse String 3
		int k = i+j;
		//System.out.print(".");

 		//if with recursion we able to reach end of last String then yest ,it can be interwiven
		if(k==three.length())
		{
			return true;
		}

		//if i is within the limit & char at i in String one is equal to char at k in String 3

		if(i < one.length() && one.charAt(i)== three.charAt(k))
		{
			//then recursively exploe by incrementing i and return true only if the recursion returns true
			//as because we have to also consider the case of starting with second String
			if(isInterWoven(one,two,three,i+1,j))
			{
				return true;
			}
		}

		//if j is within the limit & char at j in String two is equal two char at k in String 3

		if(j < two.length() && two.charAt(j) == three.charAt(k))
		{
			//then recursively explore for all the values of String two by incrementing j
			return isInterWoven(one,two,three,i,j+1);
		}

		return false;
	}
}