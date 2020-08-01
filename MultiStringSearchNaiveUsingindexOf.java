//Time Complexity O(bns) | Space Complexity O(n)
// predefined method indexOf(String str)
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
		//it returns the index of first occurance of small string in big String
		//if small string is not present in big it returns -1
		int idx = big.indexOf(small);

		//according to idx value return true or false;

		return idx == -1 ? false : true;
	}


}