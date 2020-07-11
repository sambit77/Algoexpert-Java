//Program for Binary Search Tree Construction
//insertion , seraching and deleting element in BST
//validating a BST
//Inverting a BST



//insertion searching and deletion takes following time in a BST
//Average case O(log n ) time | O(1) space (Non recursive way)
//worst case O(n) time | O(1) sapce(Non recursive)

//if we use recursion the space complexity will be in order of O(log n) due to call Stack

//-------------------------------------------------------------------------------------
//for validateBST algorithm
//Time Complexity O(n) - no of nodes in the binary tree
//Space complexity O(d) = depth of tree and in worst case depth = n (no of nodes)

//-----------------------------------------------------------------------------------------
//for invertBSTRecursive algorithm
//Time complexity O(n)  | Space Complexity O(d) d = depth = log(n)

//for invertBSTIterative Algorithm 
//Time Complexity O(n)  | Space Compelxity O(n)

//-----------------------------------------------------------------------------------------

//Traversals .. all traversals take O(n) time and O(log n) Space (Inorder , preorder , postorder)
import java.util.*;
class BST
{
	class Node
	{
		int data;
		Node left;
		Node right;

		public Node(int data)
		{
			this.data = data;
			this.right = this.left = null;
		}
	}
	Node root;
	public BST()
	{
		root= null;
	}
	public void doInsertion(int data)
	{
		root = insert(root,data);
	}
	public Node insert(Node root,int data)
	{

       if(root == null)
       {
       	root = new Node(data);
       	return root;
       }
       if(root.data > data)
       {
          root.left = insert(root.left,data);       
       }
       if(root.data <= data)
       {
       	  root.right = insert(root.right,data);
       }
       


       return root;

	}
	public void doInorder()
	{
		inOrder(root);
	}
	public void inOrder(Node root)
	{
		if(root!= null)
		{
		inOrder(root.left);
		System.out.print(root.data+",");
		inOrder(root.right);
		}
		
	}
	public void doPreorder()
	{
		preOrder(root);
	}
	public void preOrder(Node root)
	{
		if(root!= null)
		{
	    System.out.print(root.data+",");
		preOrder(root.left);
		preOrder(root.right);
		}
		
	}
	public void doPostorder()
	{
		postOrder(root);
	}
	public void postOrder(Node root)
	{
		if(root!= null)
		{
	    postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+",");
		}
		
	}
	public  boolean containsKey(int data)
	{
		boolean status = false;
    Node pointer = root;
     while(pointer != null)
     {
     	 if(data<pointer.data)
         {
     	 pointer = pointer.left;
         }
         else if( data > pointer.data)
         {
         	pointer = pointer.right;
         }
         else
         {
         	status = true;
         	break;
         }

     }
     return status;
    
	}

	//deleting node in BST
	/*public static void removeNode(int data)
	{
		remove(root,data,null);
	}
	
	public static void remove(Node root,int data , Node parent)
	{
		Node current  = root;
		while(current != null)
		{
			if(data < current.data)
			{
				parent = current;
				current = current.left;
			}
			else if( data > current.data)
			{
				parent = current;
				current = current.right;
			}
			else
			{
				if(current.left != null && current.right != null)
				{
					current.data = current.right.getMinValue();
					remove
				}
			}
		}
	} */
	public static boolean validateBST(Node root)
	{
		return validateBSTHelper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
         
	}
	public static boolean validateBSTHelper(Node root, int min , int max)
	{
		if(root == null)
		{
			return true;
		}
		if(root.data < min || root.data >= max)
		{
			return false;
		}
		boolean leftIsValid = validateBSTHelper(root.left,min,root.data);
		return leftIsValid && validateBSTHelper(root.right,root.data,max);


	}
	//invert BST Recursive Solution
	//Same logic can be used to invert a binary tree also
	public static void invertBSTRecursive(Node root)
	{
		if(root == null)
		{
			return;
		}
		swapLeftRightNodes(root);
		invertBSTRecursive(root.left);
		invertBSTRecursive(root.right);

	}

	//invertBST Iterative Solution
	public static void invertBSTIterartive(Node root)
	{
      Queue<Node> q = new LinkedList<Node>();
      q.add(root);

      while(!q.isEmpty())
      {
      	Node c = q.poll();
      	if(c == null)
      	{
      		continue;
      	}
      	swapLeftRightNodes(c);
      	q.add(c.left);
      	q.add(c.right);
      }
	}

	public static void swapLeftRightNodes(Node root)
	{
      Node temp = root.left;
      root.left = root.right;
      root.right = temp;
	}
	public static void main(String[] args) 
	{
		//instantiating a BST
		BST tree = new BST();
		//adding values  to BST
		tree.doInsertion(4);
		tree.doInsertion(1);
		tree.doInsertion(7);
		tree.doInsertion(8);
		tree.doInsertion(3);
		System.out.println("does contain 8 ? "+tree.containsKey(8));
		System.out.println();
		System.out.println("Inorder traversal of the tree is");
		tree.doInorder(); // does inorder traversal of tree and prints it
		
		System.out.println("Root of the tree is "+tree.root.data); //prints root
		System.out.println("is a valid BST ? "+validateBST(tree.root));
		System.out.println("After inverting once using Recursion");
		System.out.println("its inorder tarversal");
		invertBSTRecursive(tree.root);
		tree.doInorder();
		invertBSTIterartive(tree.root);
		System.out.println("After inverting the inverted tree initerartive way we get back original tree");
		System.out.println("inveting the original tree two times");
		System.out.println("its inorder is");
		tree.doInorder();

	}
}
