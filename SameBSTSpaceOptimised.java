//Time Compelxity O(n^2) | Space Compelxity O(d)
//Space compelxity is of order O(d) due to fuction call during recursion
//d is the depth of the bst
//for a balanced bst d is log n
//for skew bst d is n
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
		return isSameBSTHelper(bst1,bst2,0,0,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	public static boolean isSameBSTHelper(int[] bst1 , int[] bst2 , int rootIdxOne, int rootIdxTwo,int min , int max)
	{

		//if the length is not same they cant never be same BST
		if(bst1.length != bst2.length)
		{
			return false;
		}

		//this is to come out of recusrion mainly
		//index should be beyond zero ,this is the stopping criteria for recusrion
		if(rootIdxOne == -1  || rootIdxTwo == -1)
		{
			//if any of them is -1 then chcek if both are equal 
			//if both are equal then return true else return false
			return rootIdxOne == rootIdxTwo;
		}
        //if the first element of trees is not wqual tha is the root then they can never be same BST
		if(bst1[rootIdxOne] != bst2[rootIdxTwo])
		{
			return false;
		}

		//now get leftsubtree and rightsubtree of both bst and apply isSameBst on both using recusrion

		//previously to store the subtrees we are forming anither array and passing recursiveky which is not optimised
		//here to optimise space usage we only keep track of indices and numbers inplace so no extra space is used
        
        //min represent the min value that can a node have in the tree
        //max represent the max value that can a node have in the tree
		int leftSubtreeIdxBST1 = getIdxOfSmaller(bst1,rootIdxOne,min);
		int leftSubtreeIdxBST2   = getIdxOfSmaller(bst2,rootIdxTwo,min);
		int rightSubtreeIdxBST1 = getIdxOfBiggerThanOrEqualTo(bst1,rootIdxOne,max);
		int rightSubtreeIdxBST2 = getIdxOfBiggerThanOrEqualTo(bst2,rootIdxTwo,max);
        int currentval = bst1[rootIdxOne];
		boolean leftIsSame = isSameBSTHelper(bst1,bst2,leftSubtreeIdxBST1,leftSubtreeIdxBST2,min,currentval);
		boolean rightIsSame = isSameBSTHelper(bst1,bst2,rightSubtreeIdxBST1,rightSubtreeIdxBST2,currentval,max);
        

        // bst are same if their left and right subtree are same
        return leftIsSame && rightIsSame;
       
	}
	public static int getIdxSmaller(int[] bst , int rootIdx,int min)
	{
		//loop starting from rootIdx+1 because we have to skip the root
		for(int i = rootIdx+1 ;i < bst.length ; i++)
		{
			//criteria for a node to be oart of left subtree
			if(bst[i]<bst[rootIdx] && bst[i] >= min)
			{
				return i;
			}
		}
		return -1;
	}
	public static int getBiggerThanOrEqualTo(int[] bst , int rootIdx , int max)
	{
		//loop starting from rootIdx+1 because we have to skip the root
		for(int i = rootIdx+1 ; i < bst.length ; i++ )
		{
			//criteria for a node to be part of right subtree
			if(bst[rootIdx] <= bst[i] && bst[i] < max)
			{
				return i;
			}
		}
		return -1;
	}
}

