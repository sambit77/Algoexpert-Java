//Time Complexity O(log n) | Space Complexity O(log n ) due to recursion
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		//input shoulde be sorted
		int[] arr = new int[]{0,1,21,33,45,45,45,45,45,45,61,71,73};
		//find the ranges of indices in which 45 is present
		int target = 45;
		int[] range = getRange(arr,target);
		System.out.println("Range in which target is present "+Arrays.toString(range));
		
	}
	public static int[] getRange(int[] arr,int target)
	{
		//ranges array to store lower & upper range
		int[] range = new int[2];
		//when the number not found return -1,-1
		range[0]= -1;
		range[1] = -1;
		//first search for left lower range 
        alteredBinarySearch(arr,target,0,arr.length-1,range,true);
        //then search for right upper range
        alteredBinarySearch(arr,target,0,arr.length-1,range,false);
		return range;
	}
	public static void alteredBinarySearch(int[] arr,int target,int left,int right,int[] range,boolean goLeft)
	{
		//Modified Binary Search
		if(left > right)
		{
			return;
		}
		int mid = (left+right)/2;
		if(arr[mid]<target)
		{
			alteredBinarySearch(arr,target,mid+1,right,range,goLeft);
		}
		else if(arr[mid]<target)
		{
			alteredBinarySearch(arr,target,left,mid-1,range,goLeft);
		}
		else
		{
			//go to left sub halve
			if(goLeft)
			{
				//if it is the left most element or its previous element is not equal to target
               if(mid == 0 || arr[mid-1] != target)
               {
               	//then this is the lower range
               	range[0]=mid;
               }
               else
               {
               	//recursively search for lower range in left halve of array
               	alteredBinarySearch(arr,target,left,mid-1,range,goLeft);
               }
			}
			else
			{
				//if it is the right most element or next element to it is not  equal to target
				if(mid == arr.length-1 || arr[mid+1] != target)
				{
					//then this is the upper range
					range[1]=mid;
				}
				else
				{
					//recursively search for upper range in roght halve of array
					alteredBinarySearch(arr,target,mid+1,right,range,goLeft);
				}

			}
		}
	}
}