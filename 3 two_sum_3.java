/*Given an array of integers, return  the two numbers such that 
they add up to a specific target.

You may assume that each input would have exactly one solution,
 and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [2, 71].*/
//using hashmap
//Time Complexity O(n)
//Space Complsexity O(n)
import java.util.*;
class A
{
	public static int[] arr = new int[]{2, 7, 11, 15};
	public static int target = 9;
	public static void main(String[] args) 
	{

		
		int[] brr = twosum_way3(arr,target);  //bruteforce way
		System.out.println("the numbers that make "+target+" are ");
		System.out.println(Arrays.toString(brr));
	}
	public static int[]  twosum_way3(int[] array , int target)
	{
	
		
		HashMap<Integer,Boolean> map = new HashMap<>();
		for(int num : array)
		{
			int potentialAns = target - num;
			if(map.containsKey(potentialAns))
			{
				return num > potentialAns ? new int[]{potentialAns,num}:new int[]{num,potentialAns};
			}
			else
			{
				map.put(num,true);
			}
		}
		return new int[0];
	}
}
