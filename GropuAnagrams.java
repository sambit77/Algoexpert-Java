//Time Complexity O(w * n * log(n)) | Space Complexity O(w*n)
//w = no of words in initial String  n = no of letters in largest word of the String
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
      String[] arr = new String[]{"yo","act","flop","tac","cat","oy","olfp"};
      HashMap<String,ArrayList<String>> map = groupAnagarms(arr);		
      //Printing the grouped anagrams

      for(String key : map.keySet())
      {
      	ArrayList<String> anagrams = map.get(key);
      	System.out.print("[");
      	for(String word : anagrams)
      	{
      		System.out.print(word+" ");
      	}
      	System.out.print("]");
      	System.out.println();
      }

	}
	public static HashMap<String,ArrayList<String>> groupAnagarms(String[] words)
	{
		HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
		for(int i = 0 ; i < words.length ; i++)
		{
			String sortedWord = getSortedWord(words[i]);
			if(map.containsKey(sortedWord))
			{
				ArrayList<String> list = map.get(sortedWord);
				list.add(words[i]);
				map.put(sortedWord,list);
			}
			else
			{
				ArrayList<String> list = new ArrayList<String>();
				list.add(words[i]);
				map.put(sortedWord,list);
			}
		}

		return map;
	}
	public static String getSortedWord(String word)
	{
		char[] crr = word.toCharArray();
		Arrays.sort(crr);
		return String.valueOf(crr);
	}
}