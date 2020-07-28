import java.util.*;

class A
{
	public static void main(String[] args) 
	{
		char[][] board = new char[][]{{'t','h','i','s','i','s','a'},
									{'s','i','m','p','l','e','x'},
									{'b','x','x','x','x','e','b'},
									{'x','o','g','g','l','x','o'},
									{'x','x','x','d','t','r','a'},
									{'R','E','P','E','A','d','x'},
									{'x','x','x','x','x','x','x'},
									{'N','O','T','R','E','-','P'},
									{'x','x','D','E','T','A','E'}};

		ArrayList<String> words = new ArrayList<String>();
		words.add("this");
		words.add("is");
		words.add("not");
		words.add("a");
		words.add("simple");
		words.add("boggle");
		words.add("board");
		words.add("test");
		words.add("REPEATED");
		words.add("NOT-REPATED");

       ArrayList<String> matchingWords = getMatchedWord(board,words);
       System.out.println("matchingWords are ");
       System.out.println(matchingWords.toString());
		
	}
	public static ArrayList<String> getMatchedWord(char[][] board,ArrayList<String> words)
	{
         //add all the words in suffix tree
	     TreeNode suffixTree = new TreeNode();
	     for(String word : words)
	     {
	     	suffixTree.insertSubstringStartingAt(word);
	     }
	     HashMap<String,Boolean> finalwods = new HashMap<String,Boolean>();

	     boolean[][] visited = new boolean[board.length][board[0].length];

	     for(int i = 0 ; i < board.length ; i++)
	     {
	     	for(int j = 0 ; j < board[i].length ; j++)
	     	{
	     		explore(i,j,board,suffixTree.root,visited,finalwods);
	     	}
	     }

	     ArrayList<String> matchingWords = new ArrayList<String>();

	     for(String key : finalwods.keySet())
	     {
	     	matchingWords.add(key);
	     }
	     return matchingWords;
	}
	public static void explore(int i , int j ,char[][] board,TreeNode treenode,boolean[][] visited,HashMap<String,Boolean> finalwods)
	{
		if(visited[i][j])
		{
			return;
		}
		char letter = board[i][j];
		if(!treenode.children.containsKey(letter))
		{
			return;
		}
		visited[i][j] = true;
		treenode = treenode.get(letter);
		//reached the end of a word in suffix tree
		if(treenode.children.containsKey('*'))
		{
			//get that word and put it in final words HashMap
			//FinalWords.put()


		}
		ArrayList<int[]> neighbors = getNeighbors(i,j,board);
		for(int[] neighbor : neighbors)
		{
			explore(neighbor[0],neighbor[1],board,treenode,visited,finalwods);
		}
		visited[i][j] = false;
	}
	public static ArrayList<int[]> getNeighbors(int i , int j ,char[][] board)

	{
		ArrayList<int[]> neighbors = new ArrayList<int[]>();
		if(i>0 && j >0)
		{
			neighbors.add(new int[]{i-1,j-1});
		}
		if(i > 0 && j < board[0].length - 1)
		{
		    neighbors.add(new int[]{i-1,j+1});	
		}
		if(i < board.length - 1 && j < board[0].length - 1)
		{
			neighbors.add(new int[]{i+1,j+1});
		}
		if(i < board.length && j > 0)
		{
			neighbors.add(new int[]{i+1,j-1});
		}
		if( i > 0)
		{
			neighbors.add(new int[]{i-1,j});
		}
		if( i < board.length - 1)
		{
			neighbors.add(new int[]{i+1,j});
		}
		if( j > 0)
		{
			neighbors.add(new int[]{i,j-1});
		}
		if( j < board[0].length-1)
		{
			neighbors.add(new int[]{i,j+1});
		}
		return neighbors;

	}
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

		public suffixTree()
		{
			
		}
	public static void insertSubstringStartingAt( String str)
	{

		//to insert a substring first get the root
		TreeNode node = suffixTree.root;

		//iterate every charcater in the substring
		for(int j = 0 ; j < str.length() ; j++)
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
		node.children.put(suffixTree.endSymbol,str);
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
}
