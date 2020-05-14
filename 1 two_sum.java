/*Given an array of integers, return  the two numbers such that 
they add up to a specific target.

You may assume that each input would have exactly one solution,
 and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [2, 7].*/

// Time Complexity O(n*n)
//Space Complexity O(1)
import java.util.*;
class A
{
	public static int[] arr = new int[]{2, 7, 11, 15};
	public static int target = 9;
	public static void main(String[] args) 
	{

		
		int[] brr = twosum_way1(arr,target);  //bruteforce way
		System.out.println("the numbers that make" +target +" are ");
		System.out.println(Arrays.toString(brr));
	}
	
	public static int[] twosum_way1(int[] nums , int target)
	{
		int[] result = new int[2];
      for(int i = 0 ; i < nums.length ; i++)
      {
      	for(int j = 0 ; j < nums.length ; j++)
      	{
      		if( i != j && nums[i]+nums[j] == target)
      		{
      			if(i>j)
      			{
               result[0] = nums[j];
               result[1] = nums[i];
                }
                else
                {
                	result[0] = nums[i];
                    result[1] = nums[j];
                }
      		}
      	}
      }
      return result;
	}
}
