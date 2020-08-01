//Time Complexity  O(ns+bs) | Space Complexity O(ns)
// b -> length of big String
//n -> size of the list of small String
//s -> max length of small string among the small string in the list

import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		//check given list of strings is contained in given String
		String bigString = "this is a big string";
		String[] smallStrings = new String[]{"this","yo","is","a","bigger","string"};
		//accordingly return boolean array
		boolean[] result = getSearchResult(bigString,smallStrings);
		System.out.println("Search Result is");

		System.out.println(Arrays.toString(result));
	
	}
	public static boolean[] getSearchResult(String big,String[] smalls)
	{
		//insert all the small strings in the tree
		//first instanitiate the suffix tree
		suffixTree tree = new suffixTree("");

		//then populate suffix tree with all the small strings
		for(String small : smalls)
		{
			//taking all the small strings one by one and inserting it in suffix tree
			populateSuffixTree(small);
		}
		HashMap<String,Boolean> containedStrings = new HashMap<String,Boolean>();

		for(int i = 0 ; i < big.length() ; i++)
		{
			findSmallStringsIn(big,i,tree,containedStrings);
		}
		System.out.println(containedStrings);
		boolean[] result = new boolean[smalls.length];
		for(int i = 0 ; i < result.length ; i++)
		{
			if(containedStrings.containsKey(smalls[i]))
			{
				result[i] = true;
			}
		}

		return result;
	}
	public static void findSmallStringsIn(String big,int startIdx, suffixTree tree,HashMap<String,Boolean> containedStrings)
	{
		TreeNode current = tree.root;
		
		for(int i = startIdx ; i < big.length() ; i++)
		{

			Character currentchar = big.charAt(i);
			if(!current.children.containsKey(currentchar))
			{
				//System.out.println("--");
				break;
			}
			current = current.children.get(currentchar);
			if(current.children.containsKey(tree.endSymbol))
			{
				TreeNode resultNode = current.children.get(tree.endSymbol);
				String result = resultNode.result;
		
				containedStrings.put(result,true);
			}
		}
	}
	//A node of a suffix tree is a hashmap
	static class TreeNode
	{
		//the map contains maooing from character to another hashmap
		HashMap<Character,TreeNode> children = new HashMap<Character,TreeNode>();
		String result = "";
	}
	static class suffixTree
	{
		//when suffix tree is called i.e its object is created then we instantiate root of suffix tree
		static TreeNode root = new TreeNode();

		//to mark the end of substring / a branch of suffix tree
		static char endSymbol = '*';

		public suffixTree(String str)
		{
			populateSuffixTree(str);
		}
	}

	//Time Complexity O(n^2) | Space Complexity O(n^2)
	//n=input String length
	public static void populateSuffixTree(String str)
	{
		//generate all suffix of the given string and insert it in tree
		for(int i = 0 ; i < str.length() ; i++)
		{
			insertSubstringStartingAt(i,str);
		}
	}
	public static void insertSubstringStartingAt(int i , String str)
	{

		//to insert a substring first get the root
		TreeNode node = suffixTree.root;

		//iterate every charcater in the substring
		for(int j = i ; j < str.length() ; j++)
		{
			//get the character at index j
			char letter = str.charAt(j);

			//if the charcter is not in the map pointed by the root

			if(!node.children.containsKey(letter))
			{
				//create a new node
				TreeNode newNode = new TreeNode();

				//put this character to child of root node 
				//root node has children hashmap ,hence in the hashmap put this child mapping to another hashmap
				node.children.put(letter,newNode);

			}

			//if the node points to a hashmap that contains the letter skip it and increment the node pointer
			node = node.children.get(letter);
		}

		//after inserion of substring node will be pointing to last character of substring
		//then put the endsymobol mapping to null
		TreeNode resultNode = new TreeNode();
		resultNode.result = str;
		node.children.put(suffixTree.endSymbol,resultNode);
	}
	//Time Complexity O(m)  Space Complexity O(1)
	//m = string for which we r performing a check
	public static boolean containsSuffix(String str)
	{
		//get the root
		TreeNode node = suffixTree.root;
		for(int i = 0 ; i < str.length() ; i++)
		{
			char letter = str.charAt(i);
			//hashmap pointed by root must contain the first letter of suffix else its not a suffix
			if(!node.children.containsKey(letter))
			{
				return false;

			}
			//kepp on traversing the branch of tree
			node = node.children.get(letter);
		}
        

        //after reaching here check if it is the ned of branch
        //if its is the ned of branch then given string is a valisd suffix 
        //else it is not a valid suffix rather another substring
		return node.children.containsKey(suffixTree.endSymbol) ? true : false;
	}
}