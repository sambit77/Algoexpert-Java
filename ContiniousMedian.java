//ContinousMedian class is responsible for keeping track of current median at that instant while we adding number
//one by one using current median class we can get the median at that instant

//Time Complexity O(log n) (insert functionn of Heap Class)
//Space Compleixty O(n)   (the fact that we are storing all the numbers in 2 heaps)
import java.util.*;
class Main
{
	public static void main(String[] args) 
	{
		//just to demonstarte how to define a min heap & a max heap
		       /* Heap minheap = new Heap("minheap",new ArrayList<Integer>());
		        minheap.insert(90);
		        minheap.insert(80);		
		        minheap.insert(10);
		        minheap.insert(60);
		        minheap.insert(50);
		        Heap maxheap = new Heap("maxheap",new ArrayList<Integer>());
		        maxheap.insert(80);
		        maxheap.insert(90);
		        maxheap.insert(100);
		        maxheap.insert(8);
		        maxheap.insert(0);
		        System.out.println(maxheap.removeTop());
		        System.out.println(minheap.removeTop());*/

		 //Our Problem Begins From Here
		        //intanitiang the object of continous median class and using its insert method we are inserting element
		        //one by one internally the class inserts this elements to two kinds of heaps to keep track of current
		        //median
		        //the two kind of heaps are maxhaep & minheap
		        //maxheap stores the lower halve numbers at any instant
		        //min heap stores the upper halve numbers at any instant
		        //the two heaps should be balanced i.e
		        //at any instant the size of heap shoulde be lesser than 2
		        //then the median at any instant is given by
		        //if the size of heaps are same then median is 
		        //max of lowerhalve (maxheap root value)+min of upper halve(minheap root value) / 2
		        //if the size of minheap is greater :- median = minheap root value
		        //if the size of maxheap is greater :- median = maxheap root value

		   ContiniousMedian cm = new ContiniousMedian();
		   System.out.println("Current median is "+cm.getCurrentMedian());
		   cm.insert(5);
		   System.out.println("Current median is "+cm.getCurrentMedian());
		   cm.insert(10);
		   System.out.println("Current median is "+cm.getCurrentMedian());
		   cm.insert(100);
		   System.out.println("Current median is "+cm.getCurrentMedian());
		   cm.insert(200);
		   System.out.println("Current median is "+cm.getCurrentMedian());
		   cm.insert(6);
		   System.out.println("Current median is "+cm.getCurrentMedian());
		   cm.insert(13);
		   System.out.println("Current median is "+cm.getCurrentMedian());
		   cm.insert(14);
		   System.out.println("Current median is "+cm.getCurrentMedian());

	}
}
class ContiniousMedian
{
	//2 kinds of heap
	Heap lower,higher;
	float median = -1.0f;


	public ContiniousMedian()
	{
		//upon instantiation two kinds of heaps are created min & max
		this.lower = new Heap("maxheap",new ArrayList<Integer>());
		this.higher = new Heap("minheap",new ArrayList<Integer>());
	
	}
	//inserting a number to heaps
	public  void insert(int number)
	{
		//if lower is empty or the ccurrent number falls in lower halve i.e falls lower heap peek value 
       if(lower.length() == 0 || number < lower.peek())
       {
       	//insert this number to the maxheap (i.e lower)
       	lower.insert(number);
       }
       //else insert it to minheap (i,e upper)
       else
       {
       	higher.insert(number);
       }
       
       //balance yhe heaps if needed
       reBalanceHeaps();
       //after insreting one element update the current median accordingly
       updateMedian();
	}
	public void reBalanceHeaps()
	{
		//check if balancing is necessary

		//if lower (maxheap) length is greater than by 2 from upper (minheap)

		if(lower.length()-higher.length() == 2)
		{
			//then peek the top value if lower(maxheap) and insert it to upper (minheap)
			higher.insert(lower.removeTop());
		}
		//if upper (minheap) length is greater than by 2 from lower(maxheap)
		else if(higher.length()-lower.length() == 2)
		{
			//then peek the top value of upper (minheap) and insert it to lower (minheap)
			lower.insert(higher.removeTop());
		}
		else
		{
			//for any other circumstances rebalancing is  not necessary
			return;
		}

	}
	public void updateMedian()
	{
		//this formula is discussed above
		//peek() returns the top elemnt of any heap
		//to peek the max of lower halves ..as we used maxheap the peek vlaue store maximum among lower halve values

		if(lower.length()==higher.length())
		{
			median = (float)(lower.peek()+higher.peek())/(float)2;
		}
		else if(lower.length()> higher.length())
		{
           median = lower.peek();
		}
		else
		{
			median = higher.peek();
		}
	}
	
	public float getCurrentMedian()
	{
		return median;
	}

	

}
//GEneral Heap Class Refer MinHEap.java in ths repository

//modified the heap class shfitUp , SHiftDown method 
//as we take the type of heap as argument then accordingly modify the shiftup , shift down method
//to built minheap or maxheap according to the argument passed
class Heap
{
	ArrayList<Integer> list = null;
	String type;

	public Heap(String type,ArrayList<Integer> list)
	{
        this.list = list;
        this.type = type;
        if(list.size() !=0)
        {
        	buildHeap();
        }
        
	}
	public void buildHeap()
	{
		for(int i = list.size()/2 ; i>= 0 ; i--)
		{
			shiftDown(list,i);
		}
	}
	public int length()
	{
		return list.size();
	}
	public  void shiftDown(ArrayList<Integer> list,int idx)
	{
		if(type.equalsIgnoreCase("minheap"))
		{
		int left = 2*idx + 1;
		int right = 2*idx + 2;
		int min = idx;

		if(left < list.size() && list.get(left)<list.get(idx))
		{
			min = left;
		}
		if(right < list.size() && list.get(right)<list.get(min))
		{
			min = right;
		}
		if(min != idx)
		{
			Collections.swap(list,idx,min);
			shiftDown(list,min);
		}
		}
		else
		{
        int left = 2*idx + 1;
		int right = 2*idx + 2;
		int max = idx;

		if(left < list.size() && list.get(left)>list.get(idx))
		{
			max = left;
		}
		if(right < list.size() && list.get(right)>list.get(max))
		{
			max = right;
		}
		if(max != idx)
		{
			Collections.swap(list,idx,max);
			shiftDown(list,max);
		}
		}
		
	}
	public  void shiftUp(ArrayList<Integer> list,int i)
	{
       if(type.equalsIgnoreCase("minheap"))
       {
          int parent = (i-1)/2;
         while(i>0 && list.get(i)<list.get(parent))
         {
       		Collections.swap(list,i,parent);
       		i = parent;
       		parent = (i-1)/2;
         }
       }
       else
       {
       		 int parent = (i-1)/2;
         while(i>0 && list.get(i)>list.get(parent))
         {
       		Collections.swap(list,i,parent);
       		i = parent;
       		parent = (i-1)/2;
         }

       }
	}
	public  int peek()
	{
		return list.get(0);
	}
	public int removeTop()
	{
		Collections.swap(list,0,list.size()-1);
		int valueToRemove = list.remove(list.size()-1);
		shiftDown(list,0);
		return valueToRemove;

	}
	public void insert(int value)
	{
		list.add(value);
		shiftUp(list,list.size()-1);
	}
}