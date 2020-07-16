/*Given an array of integers, return  the two numbers such that 
they add up to a specific target.

You may assume that each input would have exactly one solution,
 and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [2, 7].*/

//USING LEFT RIGHT POINTERS
//Time Compexity O(n log n)
//Space complexity O(1)
import java.util.*;
class A
{
	public static int[] arr = new int[]{2, 7, 11, 15};
	public static int target = 9;
	public static void main(String[] args) 
	{

		
		int[] brr = twosum_way2(arr,target);  //bruteforce way
		System.out.println("the numbers that make "+target+" are ");
		System.out.println(Arrays.toString(brr));
	}
	public static int[]  twosum_way2(int[] nums , int target)
	{
	
		Arrays.sort(nums);
		int result[] = new int[2]; 
		int first = 0;
		int last =  nums.length-1 ;
		int sum = 0;
        while(sum != target)
        {
		    sum = nums[first]+nums[last];
		     if(sum > target)
		      {
			    last --;
		      }
		     else if (sum < target)
		      {
			    first++;
		      }
		      else
		      {
			  result[0] = nums[first];
			  result[1] = nums[last]; 
			
		      }
		
	    }
	    return  result;
	}
}
