//Bubble  Sort
//Time Complexity O(n^2) | Space Complexity O(1)
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		int[] arr = new int[]{9,8,7,6,5,4,3,2,1};
		System.out.println("Given Array"+Arrays.toString(arr));
		int[] brr = bubbleSort(arr);
		System.out.println("arr is also sorted as it is inplace sorting algo"+Arrays.toString(arr));
		System.out.println("brr : Sorted Array"+Arrays.toString(brr));
	}
	public static int[] bubbleSort(int[] arr)
	{
		//Basic Loop , where the number of loopings is n * n , no matter the input
		//array is already sorted or not
	/*	for(int i = 0; i < arr.length ; i++)
		{
			for(int j = 0 ; j < arr.length -1 ; j++)
			{
				//Sort the Consecutive elements like a bubble (relative to each other)
				if(arr[j] > arr[j+1])
				{
					swap(j,j+1,arr);
				}
			}
		}
     */
        //This works fine but we could reuce the number of time the second for loop runs as 
		//after one iteration of whole array the biggest element will come to the end so on and
		//so forth one by one so we can write j < arr.length-1-i
		//but the order of complexity remians same n^2
      /*for(int i = 0; i < arr.length ; i++)
		{
			for(int j = 0 ; j < arr.length -1 ; j++)
			{
				if(arr[j] > arr[j+1])
				{
					swap(j,j+1,arr);
				}
			}
		}*/

		//This is the Optimal Way not in terms of order of time complexity.. time complexity will 
		//remain O(n^2) only 
		//here we use a flag called swapped ..i.e if the previous iteration has any swapped involved 
		//then only go for next iteration , if previous iteration involves no swapping that means 
		//the array is already sorted ,,so now if the input is already sorted array then inner for 
		//loop run as usual for comapring every pair of element ..whether they are in relatively 
		//in their appropriate poition or not ..but the outer for loop will run only once as the
		//previous iteration will not have any swapping involved 

		int swapped = 0;

	    for(int i = 0; i < arr.length ; i++)
		{
			for(int j = 0 ; j < arr.length -1 ; j++)
			{
				if(arr[j] > arr[j+1])
				{
					swapped = 1;
					swap(j,j+1,arr);
				}
			}
			if(swapped == 0 )
			{
				break;
			}
		}
		return arr;
	}
	public static void swap(int a , int b , int[] arr)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
