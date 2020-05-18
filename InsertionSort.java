//Insetion Sort
//Time Complexity O(n^2) | Space Complexity O(1)
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		int[] arr = new int[]{9,2,3,56,45,98,12,2,1,10};
		System.out.println("Given Array"+Arrays.toString(arr));
		int[] brr = insertionSort(arr);
		System.out.println("arr is also sorted as it is inplace sorting algo"+Arrays.toString(arr));
		System.out.println("brr : Sorted Array"+Arrays.toString(brr));
	}
	public static int[] insertionSort(int[] arr)
	{
		int j = 0;
		for(int i = 0 ; i < arr.length ; i++)
		{
			//iterate through the array
           j = i;
           while(j > 0)
           {
           	//pick all elements one by one and place in their required postion (insertion)
           	//by comparing with all the values present before that element
           	if(arr[j-1] > arr[j])
           	{
           		swap(j,j-1,arr);
           	}
           	j--;
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
