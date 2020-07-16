import java.util.*;
class A
{
	//A node of a suffix tree is a hashmap
	static class TreeNode
	{
		//the map contains maooing from character to another hashmap
		HashMap<Character,TreeNode> children = new HashMap<Character,TreeNode>();
	}
	static class suffixTree
	{
		//when suffix tree is called i.e its object is created then we instantiate root of suffix tree
		static TreeNode root = new TreeNode();

		//to mark the end of substring / a branch of suffix tree
		static char endSymbol = '*';

		public suffixTree(String str)
		{
			populateSuffuxTree(str);
		}
	}

	//Time Complexity O(n^2) | Space Complexity O(n^2)
	//n=input String length
	public static void populateSuffuxTree(String str)
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
		node.children.put(suffixTree.endSymbol,null);
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
	public static void main(String[] args) 
	{
          String st = "babc";
          suffixTree tree = new suffixTree(st);
          System.out.println("Given String "+st);
          System.out.println("is abc is a suffix "+ containsSuffix("abc"));
          System.out.println("is bab is a suffix "+ containsSuffix("bab"));
		
	}
}