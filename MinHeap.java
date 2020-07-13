//Space Complexity O(1) : Explained at End

//Time Complexity
// ShiftDown   O(log n)
//ShiftUp  O(log n)
//buildMaxHeap O(n)  Note :- one might think that bulidMAxHEap has time Complexity O(n log n) as in buildMaxHeap
//maxheapify() (o(log n)) runs under loop so one might think tha it is O(log n) but actually using mathematical 
//caluclation its comes out to be O(n) as every time the maxHEapify runs O(log n ) is not same for all n/2 iterations
import java.util.*;
class MinHeap
{
	ArrayList<Integer> minHeap ;
	public MinHeap(ArrayList<Integer> arr)
	{
		this.minHeap  = new ArrayList<Integer>();
		minHeap = buildMinHeap(arr);
	}
	public  ArrayList<Integer> buildMinHeap(ArrayList<Integer> arr)
	{
		//we need to shift down all non leaf nodes 
		//leafnodes runs from index n/2 to n
		//soonon leaf nodes from 1 to n/2
       for(int i = arr.size()/2 ; i >= 0 ; i--)
       {
       	//shiftdown (n=minheapify) all non leaf nodes
       	shiftDown(i,arr);
       }
       return arr;
	}
	public void shiftDown(int i ,ArrayList<Integer> arr)
	{

       int leftChild =  2*i+1;
       int rightChild = 2*i+2;
       int smallest = 0;
       
       //find the smallest among parents , leftchild , rightcild 
       //and the smallest should be the parent
       if(leftChild < arr.size() && arr.get(leftChild) < arr.get(i))
       {
             smallest = leftChild;
       }
       else
       {
       	smallest = i;
       }
       if(rightChild < arr.size() && arr.get(rightChild) < arr.get(smallest))
       {
       	smallest = rightChild;
       }
        
        //make the smallest one parent
       if(smallest != i)
       {
       	swap(i,smallest,arr);
       	// recursively shift down (check for smallest is the aprent)
       	shiftDown(smallest,arr);
       }


       
	}
	public void shiftUp(int i,ArrayList<Integer> heap)
	{

       int parent = (i-1)/2;
       //continue till parent does not attains minimum value than its childs
       while(i > 0 && heap.get(i)<heap.get(parent))
       {
       	swap(i,parent,heap);
       	i = parent;
       	parent = (i-1)/2;
       }
	}
	public int peek()
	{
		//only return the smallest element in the heap
      return minHeap.get(0);
	}
	public void insert(int value)
	{
		//insert the new element at the end of arraylits
		minHeap.add(value);
		//Shift up till minheao property gets satisfied
		shiftUp(minHeap.size()-1,minHeap);

	}
	public int remove()
	{
		//swap the first element of ArrayList(Smallest Element) with last Element 
       swap(0,minHeap.size()-1,minHeap);
       //Remove the last Element (Smallest one)
       int valueToRemove = minHeap.remove(minHeap.size()-1);

       //now at  index apply shiftDown untill minHEap property gets satisfied
       shiftDown(0,minHeap);
       return valueToRemove;
	}
	public void swap(int i , int j , ArrayList<Integer> heap)
	{
		//swaps the values at indices in ArrayList
        Collections.swap(heap,i,j);
	}
	public static void main(String[] args) 
	{
		ArrayList<Integer> al  = new ArrayList<Integer>();
		//creating an arraylist and adding element to it randomly this will be passed 
		//and will be converted to MinHeap

		//adding elements
		al.add(18);
		al.add(102);
		al.add(44);
		al.add(30);
		al.add(31);
		al.add(17);
		al.add(23);
		al.add(12);
		al.add(8);

		//printing our input ArryList before Min Heapifying it
		System.out.println("Before MinHeapify "+al.toString());

		//Creating the object and passing the ArrayList to be MinHeapifyed
		MinHeap myheap = new MinHeap(al);
		//Printing the Obtained MinHeap 
		//inplace swapping also occurs so space complexity can be reduced to O(1)
		//we can only have a single ArrayList and do all inplace swapping where space Complexity is O(1)

		System.out.println("After MinHEapify "+al.toString());


        //Our ArrayList in class (creating duplicate for better code usablility)
        //Here we are creating another ArrayList apart from input ArrayList for better code Reuse
        //printing the obtained Heap(ArrayList of MinHEap Class) 
		System.out.println("After MinHEapify "+myheap.minHeap.toString());
        
		System.out.println("Smallest element in heap "+myheap.peek());

	    System.out.println("Removing the smallest element "+"that elemnt is "+myheap.remove());
	    System.out.println("Smallest element now "+myheap.peek());
	    System.out.println("Heap Now looks like "+myheap.minHeap.toString());


		
	}
}