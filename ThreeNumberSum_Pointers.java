//Time Complexity O(n) | Space Complexity O(n)
import java.util.*;
class A
{
	//object of this class stores one triplet
	static class Result
	{
		int a;
		int b;
		int c;
		public Result(int a , int b , int c)
		{
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	public static void main(String[] args)
	{
		int[] arr = new int[]{12,3,1,2,-6,5,-8,6};
		int target = 0 ;

		//returns a list of triplets as solution
		ArrayList<Result> result = threeSum(arr,target);

		System.out.println("given array "+Arrays.toString(arr));
		System.out.println("given target "+target);

		//to print the result
		printList(result);
	}
	public static ArrayList<Result> threeSum(int[] arr,int target)
	{
		//first we sort the input array
		Arrays.sort(arr);

		//creating a new list to store triplets as object of result class
		ArrayList<Result> al = new ArrayList<Result>();

		int left = 0;
		int right = 0;
		int currentSum = 0;
        for(int i = 0 ; i < arr.length -2 ; i++)
        {
        	left = i+1;
        	right = arr.length -1;
		while(left < right)
		{ 
			currentSum = arr[i]+arr[left]+arr[right];

			if(currentSum == target)
			{
				al.add(new Result(arr[i],arr[left],arr[right]));
				left = left + 1;
				right = right - 1;
			}
			else if(currentSum < target)
			{
				left = left+1;
			}
			else
			{
				right = right-1;
			}

		}
	    }

	    return al;
	}
	public static void printList(ArrayList<Result> al)
	{
		//traversing arraylist to print the triplets
		for(Result r : al)
		{
			System.out.print("Triplet: "+r.a+" "+r.b+" "+r.c);
			System.out.println("");
		}
	}

}