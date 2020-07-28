//Time Complexity O(log n)
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
		///to store the range of indices
		int[] range = new int[2];
		//if the target not found this is the default value to be returnrd
		range[0] = -1;
		range[1] = -1;
        //search for lower range by going towards left halve
		alteredBinarySearch(arr,target,0,arr.length-1,range,true);
		//search for upper range by going towards right halve
		alteredBinarySearch(arr,target,0,arr.length-1,range,false);
         
		return range;
	}
	public static void alteredBinarySearch(int[] arr,int target,int left,int right,int[] range,boolean goLeft)
	{
		//binary search iterative algorithm modified
		while(left<= right)
		{
			int mid = (left+right)/2;
			if(arr[mid]<target)
			{
				left = mid+1;
			}
			else if(arr[mid]>target)
			{
				right = mid - 1;
			}
			else
			{
				//if going toeards left ,, searching for lower range
				if(goLeft)
				{
					//tf this is the first element (arr[mid]) or its previous element is not equal to target
					///then this is the lower range
                   if(mid == 0 || arr[mid-1] != target)
                   {
                   	range[0]= mid;
                   	//if we will not return we will fall in an infinite loop
                   return;
                   }
                   //else continue searching for lower range by going to left halve
                   else
                   {

                   	right = mid-1;
                   }
				}
				//if going Right
				else
				{
					//if this is the last element or, next element of this element is not equal to target
					//then this is the upper range
                	if(mid == arr.length-1 || arr[mid+1] != target)
                	{
                		range[1]=mid;
                		//if we will not return we will fall in infinite loop
                		return;
                	}
                	//else continue searching for upper range by searching in right halve
                	else
                	{
                		left = mid-1;
                	}
				}
			}
		}
	}
}	
