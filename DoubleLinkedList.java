//@Sambit
//Double Linked List creation , various insertion operation , deletion ,cheking the presence , traversing

class DoubleyLinkedList
{
	//too keep track of head and tail of the double linked list ,initially null means no list
	Node head = null;
	Node tail = null;

	//For defining node of list
	static  class Node
	{
		int data;  //stores data
		Node next,prev;  //stores pointer to previous and next node from current node
        

        //constructor when called creates a new node with passed data 
		public Node(int d)
		{
			data = d;
			next = null;
			prev = null;
		}
	}
	//Driver function 
	public static void main(String[] args) 
	{
		//creating a new Doubley linked list
		DoubleyLinkedList list = new DoubleyLinkedList();

		//creating a new node
		Node n1 = new Node(5);
		//making this node as head node
		setHead(list,n1);  ////5<=>
	
		insertAfter(list,list.head,new Node(7));//5<=>7<=>
		insertAfter(list,list.head,new Node(9));//5<=>9<=>7<=>
		insertAfter(list,list.head,new Node(11));//5<=>11<=>9<=>7<=>

		insertBefore(list,list.head.next,new Node(10));//5<=>10<=>11<=>9<=>7<=>
		insertAtPosition(list,3,new Node(100)); //5<=>10<=>100<=>11<=>9<=>7<=>
		setTail(list,new Node(50));//5<=>10<=>100<=>11<=>9<=>7<=>50<=> 
		removenodesWithValue(list,100); //5<=>10<=>11<=>9<=>7<=>50<=> 

		System.out.println("100 is present ?"+containsNodeWithValue(list,100)); //100 is present ?false
		System.out.println("9 is present ?"+containsNodeWithValue(list,9)); //9 is present ?true 
	    //it prints the list
		printList(list); //5<=>10<=>11<=>9<=>7<=>50<=> 
	}


    //to print the linkedlist
	//Time Complexit O(n) | Space Complexity O(1)
	public static void printList(DoubleyLinkedList list)
	{ 
		//a pointer to be used ad traverse initialized to head
		Node pointer = list.head;
		while(pointer != null)
		{
			//print the data
			System.out.print(pointer.data+"<=>");
			pointer = pointer.next;
		}
	}


	//to insert a passed node at any given postion
	//Time Complexit O(p) p = postion | Space Complexity O(1)
	public static void insertAtPosition(DoubleyLinkedList list,int position,Node nodeToInsert)
	{
		//if we want to insert at beginning ..it will be the head
		if(position == 1)
		{
			//head of list points to this node
			setHead(list,nodeToInsert);
			return;
		}
		//cretaing a temporary value of head to traverse the list
		Node pointer = list.head;
		//keep track of current position in list
		int currentPostion = 1;

        //till list is non-empty and we not reach the desired position of insertion
		while(pointer != null && currentPostion != position)
		{
			//keep on traversing the list
			pointer = pointer.next;
			//increment the postion in each iteration
			currentPostion = currentPostion+1;
		}

		//if we are not at the end of list
		if(pointer != null)
		{
			//use insertBefore to insert the given node before the pointer
			insertBefore(list,pointer,nodeToInsert);
		}
		else
		{
			//make this nide the last node tail node
			setTail(list,nodeToInsert);
		}
	}

	//make a passed node as head in the list
	//Time Complexit O(1) | Space Complexity O(1)
	public static void setHead(DoubleyLinkedList list,Node node)
	{
		//if no node is present in the begining then make this node as both head & tail
		if(list.head == null)
		{
			//head of list points to this node
			list.head=node;
			//tail of the list points to this node
			list.tail=node;
			return;
		}
		//if already list is there then insert this node before the head 
		insertBefore(list,list.head,node);
	}

	//set the passed node as tail
	//Time Complexit O(1) | Space Complexity O(1)
	public static void setTail(DoubleyLinkedList list,Node node)
	{
		//if no tail is present that is list is empty then set the passed node as head&tail 

		if(list.tail == null)
		{
			//calling setHead makes the node both head and tail
			setHead(list,node);
			return;
		}
		// insert the passed node after  the tail node it will become tail
		insertAfter(list,list.tail,node);
	}

	//insert a node before a given node in the list
	//Time Complexit O(1) | Space Complexity O(1)
     public static void insertBefore(DoubleyLinkedList list,Node node,Node nodeToInsert)
     //to remove a node havinhg given value
     {
     	if (nodeToInsert == list.head && nodeToInsert == list.tail)
     	{
     		return;
     	}
         //remove if the node we are inserting is already present
     	remove(list,nodeToInsert);

     	//the prev of nodeToInsert should point to the element pointed by prev pointer of node
     	nodeToInsert.prev = node.prev;
     	//the next pointer of nodeToInsert should point to the given node
     	nodeToInsert.next = node;

        //if the node(before which we wish to insert) `s prev pointer is null we move the head 
        //to nodeToInsert as this will be the new head
     	if(node.prev == null)
     	{
     		//head will point to nodeToInsert
     		list.head = nodeToInsert;
     	}
     	else
     	{   //the prev pointer of original previous element to node(before which we wish to insert) 
     		//should point to the nodeToInsert
     		 
     		node.prev.next = nodeToInsert;
     	}
     	//the prev pointer of node(before which we wish to insert) shold point to nodeToInsert
     	node.prev = nodeToInsert;
     }

	
      //insert a node after a given node in the list
	//Time Complexit O(1) | Space Complexity O(1)
     public static void insertAfter(DoubleyLinkedList list,Node node,Node nodeToInsert)
     {	
     	if (nodeToInsert == list.head && nodeToInsert == list.tail)
     	{
     		return;
     	}
        
        //remove if the node we are inserting is already present
     	remove(list,nodeToInsert);

     	nodeToInsert.prev = node;
     	nodeToInsert.next = node.next;

     	if(node.next == null)
     	{
     		list.tail = nodeToInsert;
     	}
     	else
     	{
     		node.next.prev = nodeToInsert;
     	}
     	node.next = nodeToInsert;


     }

     //remove a node with given value from list
	//Time Complexity O(n) | Space Complexity O(1)
	public static void removenodesWithValue(DoubleyLinkedList list , int value)
	{
		//make copy of head pointer to traverse the list
       Node pointer = list.head;

       //iterating the list
       while(pointer != null)
       {

       	//storing the current pointer in temporary variabke so dat we can increment the pointer
       	//and after incrementiom we can check the potenial node to be removed matches our criteria
       	Node  nodeToRemove = pointer;
       	pointer = pointer.next;

       	//check if the potenial node to be removed value matches with value to be removed
       	if(nodeToRemove.data == value)
       	{
       		//if matches remove the node
       		remove(list,nodeToRemove);
       	}

       }
	}

	//removing a given node from list
	//Time Complexity O(1) | Space Complexity O(1)
	public static void remove(DoubleyLinkedList list,Node node)
	{
		//to remove a first node simply point the head to second node next  to first
		if(node == list.head)
		{
			list.head = list.head.next;
		}
		//to remove the last node simply point the tail to 2nd last node
		if(node == list.tail)
		{
			list.tail = list.tail.prev;
		}
		// remove the bindings of  a node that is left & right pointers of node will be null
		removeBindingsNode(list,node);
	}
	
	//remove intermediates 
	//Time Complexity O(1) | Space Complexity O(1)
	public static void removeBindingsNode(DoubleyLinkedList list,Node node)
	{
		//before making prev pointer null make sure the previous node to the node to be
		//removed points to the next node to the node to be removed
		if(node.prev != null)
		{
			node.prev.next = node.next;
		}
		//before making next pointer null make sure the next node to the node to be 
		//removed points to the previous node of node to be removed
		if(node.next != null)
		{
			node.next.prev  = node.prev; 
		}
		//finally the next and prev of node to be removed is made null
		node.next = null;
		node.prev = null;
	}

	//to check if the passed list contains a node with passed value
	//Time Complexity O(n) | Space Complexity O(1)
	public static boolean containsNodeWithValue(DoubleyLinkedList list,int value)
	{
		//taking a pointer and running it all thw way from head to end of list
		Node pointer = list.head;
		//iterate the list
		while(pointer != null)
		{
			//checking the condition
			if(pointer.data == value)
			{
				//yes the list contains node with given value
				return true;
			}
			//increment the pointer to next node in the list
			pointer = pointer.next;
		}

		//else node is not present
		return false;
	}

}
