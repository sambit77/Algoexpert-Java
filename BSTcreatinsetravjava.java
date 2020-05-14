class BST
{
	class Node
	{
		int key;
		Node left,right;

		public Node(int item)
		{
			key = item;
			left = right = null;
		}
	}

	Node root;
	public BST()
	{
		root = null;
	}


	public void doInsertion(int key)
	{
        root = insert(root,key);
	}
	public Node insert(Node root,int key)
	{
		if(root == null)
		{
			root = new Node(key);
			return root;
		}

		if(key < root.key)
		{
			root.left = insert(root.left,key);
		}

		if(key > root.key)
		{
             root.right = insert(root.right,key);
		}
        
        return root;
	}
	public void doInorder()
	{
       inorder(root);
	}
	public void inorder(Node root)
	{
		if(root != null)
		{
		inorder(root.left);
		System.out.println(root.key);
		inorder(root.right);
	    }
	}
	public static void main(String[] args) 
	{
	  	BST tree = new BST();
	    tree.doInsertion(50); 
        tree.doInsertion(60); 
        tree.doInsertion(30); 
        tree.doInsertion(70);  
        tree.doInsertion(40); 
        tree.doInsertion(90); 
        tree.doInsertion(10); 

        tree.doInorder();
	}
}