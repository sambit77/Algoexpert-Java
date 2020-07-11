import java.util.*;
class Tree
{

	//Runs in O(V+E) time and O(V) Space
   public static ArrayList<Character> breadthFirstSearch(Node root)
	{
       Queue<Character> q = new LinkedList<Character>();
       q.add(root);
       ArrayList<Character> LOTraversal = new ArrayList<Character>();
       while(!q.isEmpty())
       {
         Node current = q.poll();
         LOTraversal.add(root.data);
         //add the all childs of current node to queue
         // q.add(all childs of current node)
       }
       return LOTraversal;
	}










	class Node
	{
		public Node(char data)
		{
			char data;
			ArrayList<Character> childs = new ArrayList<Character>();
		}
	}
	Node root;
	public static void add(Node root,Node addingPosition,char value)
	{
		if(root == null)
		{
			root = new Node(value);
			return;
		}



	}
	public static void main(String[] args) 
	{
		//pass a graph/tree as argument where nodes are named as charcters
		ArrayList<Character> al = breadthFirstSearch(root);
		System.out.println(al.toString()); //PRints the array List Level order traversal
	}
	
}