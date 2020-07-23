//Time Compelxity O(n^2) | Space Compelxity O(n^2)

//Space Complexity rises to O(n^2) because we are using extra 4 arrays to store the left and right subtree 
//of given bst at any instant.....and it can at max rise to O(n^2) so space complexity is also O(n^2)
//the space used for recusrion i.e O(d) comes well in bound ogO(n^2)

//if we will not use this additional arrays instead we will keep a pointer to the root of left subtree & right subtree
//of both BST in the array itself the sapce compelxity can be reduced to O(d)

//O(d) sapce comes due to recusrion 
//where d is the depth of bst ,, for a balance bst d = O(log n) & for skew bst d rised to n
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		//given to binary search tree
		//the order of elements in array represents the order of insertion of element to bst
		int[] bst1 = new int[]{10,15,8,12,94,81,5,2,11};
		int[] bst2 = new int[]{10,8,5,15,2,12,11,94,81};

		boolean result = isSameBST(bst1,bst2);
		System.out.println("Given 2 bst are same : ? "+result );

		
	}
	public static boolean isSameBST(int[] bst1 , int[] bst2)
	{
		//if the length is not same they cant never be same BST
		if(bst1.length != bst2.length)
		{
			return false;
		}

		//this is to come out of recusrion mainly
		//length of array should be zero ,this is the stopping criteria for recusrion
		if(bst1.length == 0 && bst2.length == 0)
		{
			return true;
		}
        //if the first element of trees is not wqual tha is the root then they can never be same BST
		if(bst1[0] != bst2[0])
		{
			return false;
		}
        
       

        //get the leftsubtree of both bst from array
		int[] leftSubTreeOfBST1 = getSmaller(bst1);
		int[] leftSubTreeOfBST2 = getSmaller(bst2);

		//get the right subtree of both BST from array
		int[] rightSubTreeOfBST1 = getBiggerThanOrEqualTwo(bst1);
		int[] rightSubTreeOfBST2 = getBiggerThanOrEqualTwo(bst2);

		 //recursively call this function on left subtrees of both the bst 
        //also recusrisvely call this function on right subtrees of both BST

		return isSameBST(leftSubTreeOfBST1,leftSubTreeOfBST2) && isSameBST(rightSubTreeOfBST1,rightSubTreeOfBST2);

	}
	public static int[] getSmaller(int[] arr)
	{
		//arr[0] of received array is the root of a tree
		//comapre every other element in the received array with arr[0] i.e root

		//for a left sub tree element .. the element < root
		ArrayList<Integer> left = new ArrayList<Integer>();
		for(int i  = 1; i < arr.length ; i++)
		{
			//any element less than the root must be added to the ArrayList
			if(arr[i]<arr[0])
			{
				left.add(arr[i]);
			}
		}
        
        //convert the ArrayList to array and return it
		return convertToArray(left);
	}
	public static int[] getBiggerThanOrEqualTwo(int[] arr)
	{
		//arr[0] of received array is root of a tree
		ArrayList<Integer> right = new ArrayList<Integer>();
		//comapre every other element in the received array with arr[0] i.e root
		//for a right sub tree element .. the element >= root
		for(int i = 1; i < arr.length ; i++)
		{
			if(arr[i] >= arr[0])
			{
				//any element greater than or equal to root must be added to ArrayList
				right.add(arr[i]);
			}
		}

		//convert the ArratList to array and return it
		return convertToArray(right);
	}

	//this function converts passed ArrayList to array and return it
	public static int[] convertToArray(ArrayList<Integer> al)
	{
		int[] arr = new int[al.size()];
		for(int i = 0 ; i < al.size() ; i++)
		{
			arr[i]=al.get(i);
		}
		return arr;
	}
}