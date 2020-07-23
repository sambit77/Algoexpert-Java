//find smallest sub-array which when sorted makes the entire giver array sorted
//Time Complexity O(n) | Space Compelxity O(1)
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		int[] arr = new int[]{1,2,4,7,10,11,7,12,6,7,16,18,19};
		int[] index = subArraySort(arr); //index[0] left index of subarray index[1] right index of subarray
		System.out.println("left and right index of min subarray to be sorted is");
		System.out.println(Arrays.toString(index));
		System.out.println("left index "+index[0]);
		System.out.println("right index is "+index[1]);
		
	}
	public static int[] subArraySort(int[] arr)
	{
		//to store the left and right index of subarray to be sorted
		int[] subarray = new int[2];
		//subarray[0] -> left index of subarray
		//subarray[1] -> right index of subarray

		//To keep track of minimu and maximum of all elemnts that are out of order
		int minOutOfOrder = Integer.MAX_VALUE;
		int maxOutOfOrder = Integer.MIN_VALUE;

        //for all elemnts in array firs determine which all are outOfOrder
        //and among them find minOutOfOrder and maxOutOfOrder
		for(int i = 0 ; i < arr.length ; i++)
		{
			if(isOutOfOrder(i,arr[i],arr)) //true = out of order ,false = not out of order
			{
				minOutOfOrder = Math.min(minOutOfOrder,arr[i]);
				maxOutOfOrder = Math.max(maxOutOfOrder,arr[i]);
			}
		}
		//System.out.println(minOutOfOrder);
		//System.out.println(maxOutOfOrder);
		int left = 0;
		int right = arr.length-1;
        
        //find the correct postion of both in the array
        //and that will be the subarray to be sorted
		while(minOutOfOrder>=arr[left])
		{
          left++;
		}
		while(maxOutOfOrder<=arr[right])
		{
			right--;
		}
		return new int[]{left,right};
	}
	public static boolean isOutOfOrder(int idx , int num , int[] arr)
	{
		//if it is the first element check if it is greater than the 2nd element 
		//if true -> it is out of order
		if( idx== 0)
		{
			return num > arr[idx+1];
		}
		//if it is the last element in the array check if it is smaller than the 2nd last element in the array
		//if truw -> it is out of order
		if(idx==arr.length-1)
		{
			return num < arr[idx-1];
		}
		//for intermediate elements check for either of
		//the current number is lesser than the previous number
		//0r
		//the current number is greater than the next number
		//if either of the condition is true->return true -> the element is out of order

		 return num > arr[idx+1] | num < arr[idx-1];
	}
}
