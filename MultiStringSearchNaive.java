//Time Complexity O(bns) | Space Complexity O(n)

// b -> length of big String
//n -> size of the list of small String
//s -> max length of small string among the m=small syting in the list
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		//check given list of strings is contained in given String
		String bigString = "this is a big string";
		String[] smallStrings = new String[]{"this","yo","is","a","bigger","string","kapper"};
		//accordingly return boolean array
		boolean[] result = getSearchResult(bigString,smallStrings);
		System.out.println("Search Result is");

		System.out.println(Arrays.toString(result));
	
	}
	public static boolean[] getSearchResult(String big,String[] smalls)
	{
		//initialize result array
		boolean[] result = new boolean[smalls.length];

		for(int i = 0 ; i < result.length ; i++)
		{
			//populate the result array accordingly if the tsing at inex i in the smalls array
			//is contained in the big String
			result[i] = checkIfContained(big,smalls[i]);
		}
		return result;

	}
	public static boolean checkIfContained(String big,String small)
	{
		//check if the small string is contained in big or not
		for(int i = 0 ; i < big.length() ; i++)
		{
			//check for each position of big as starting position then compare considering all such cases
			//after considerng all cases if the string not found then return false
			if(checkIfContainedStartingAt(i,big,small))
			{
				//if at any case we get the substring is present then return true
				return true;
			}
		}
		return false;
	}

	public static boolean checkIfContainedStartingAt(int startIdx , String big,String small)
	{
		//to iterate big String
		int bigStartIdx = startIdx ;
		int bigEndIdx = startIdx + small.length()-1;
		//to iterate small String
		int smalllStartIdx = 0;
		int smallEndIdx = small.length()-1;

		while(bigStartIdx <= bigEndIdx)
		{
			//if at any point the charcter at the bigstring idx is not equal to char at small string idx then 
			//return false
			//we are comparing by traversing at a time from both left side & right side
			if(big.charAt(bigStartIdx) != small.charAt(smalllStartIdx) ||
				big.charAt(bigEndIdx) != small.charAt(smallEndIdx))
			{
				return false;
			}
			//update the pointer values
			//converge inward in both strings
			bigEndIdx--;
			bigStartIdx++;
			smallEndIdx--;
			smalllStartIdx++;
		}
		//return true if we managed to match chars in both strings for the above range
		return true;
	}


}