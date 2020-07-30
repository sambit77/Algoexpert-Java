//Time Complexity O(n) n = length of input String
//Space Compelxity O(min(n,m)) 
//where n = no of characters in String, m= set of unique characters in c
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		String st = "clementisacap";
		String result = getLongestSubstringWithoutDuplication(st);
		System.out.println("Longest Substring without duplication in given substring is "+result );
		
	}
	public static String getLongestSubstringWithoutDuplication(String st)
	{
		//to store the last occurance index of a character in the String
		HashMap<Character,Integer> lastSeen = new HashMap<Character,Integer>();
		//to keep track of indices o current largest substring without duplication
		//its initialized t0 (0,1) becayse at least longest substring without duplication in s String 
		//is a single letter itself
		//largest[0] stores the startIdx of the subString
		//largest[1] stores the endIdx+1 of the String
		int[] largest = new int[]{0,1};
		//initiall start = 0;
		int startIdx = 0;

		for(int i = 0 ; i < st.length() ; i++)
		{
			//iterate every charcter in the string
			Character c = st.charAt(i);
			//if the charcter is already present in the String
			if(lastSeen.containsKey(c))
			{
				//then update the startIdx as follows

				startIdx = Math.max(startIdx,lastSeen.get(c)+1);
			}
			//check if current substring is greater than largest or not
			if(largest[1]-largest[0] < i+1 - startIdx)
			{
				//update the largest to current 
				//to store the start IDx and endIdx +!
				largest[0]=startIdx;
				largest[1]=i+1;
			}
			//put the character in the map woth respect to its index
			//for the first time a new ley value paor will be stored for a character
			//for next time onwards if achar is already there then its index will be updated only
			lastSeen.put(c,i);
		}

		//generate the substring from string with stored substring index value in the largest array
		return st.substring(largest[0],largest[1]);


	}
}