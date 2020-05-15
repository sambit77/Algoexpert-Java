//Given a binary search tree and a target value find the vaue closet to the target value
//here first will construct a binary search Tree 

//then write code for findClosest(Node root,int target) to find the closest value in BST 
//for given target
//Time Complexity for this algorithm that is only for finding closest value in bst only
// average case Time Complexity O(log n) || Space Complexity O(log n)
//worst case Time Complexity O(n) || Space Complexity O(n)
class BinarySearchTree
{
	class Node
	{
		int key;
		Node left,right;

		public Node(int item)
		{
			key = item;
			left = null;
			right = null;
		}
	}
	Node root;
	public BinarySearchTree()
	{
		root= null;
	}

	public void insert(int item)
	{
		root =  insertion(root,item);
	}
	public Node insertion(Node root, int item)
	{
		if(root == null)
		{
			root = new Node(item);
			return root;
		}
		if(root.key < item)
		{
			root.right =  insertion(root.right,item);
		}
		if(root.key > item)
		{
			root.left =  insertion(root.left,item);
		}
		return root;
	}
	public void inOrder()
	{
		doinOrder(root);
	}
	public void doinOrder(Node root)
	{
		if(root != null)
		{
			doinOrder(root.left);
			System.out.println(root.key);
			doinOrder(root.right);
		}

	}
	public static int closest = Integer.MAX_VALUE;
	public static void main(String[] args) 
	{
		BinarySearchTree tree = new BinarySearchTree(); 
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(2);
		tree.insert(5);
		tree.insert(13);
		tree.insert(22);
		tree.insert(1);
		tree.insert(14);

		tree.inOrder();


		//finding closest value for given target 12 ,, the answer should be 13

		int result = findClosest(tree.root,12);
		System.out.println("Clsoest value to 12 in given BST is "+result);
	}
	public static int findClosest(Node root,int target)
	{
		return findClosestHelper(root,target,closest);
	}
	public static int findClosestHelper(Node root,int target,int closest)
	{
		if(root == null)
		{
			return closest;
		}
	    if(Math.abs(target-closest) > Math.abs(target-root.key))
	    {
	    	closest = root.key;
	    }
	    if(target > root.key)
	    {
	    	return findClosestHelper(root.right,target,closest);
	    }
	    else if(target < root.key)
	    {
	    	return findClosestHelper(root.left,target,closest);
	    }
	    else
	    {
	    	return closest;
	    }
	   


		
	}
}