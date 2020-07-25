//Time Complexity O(n) for single for loop
//Space Complexity O(1) , as we are not storing anything like array etc
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		//arr[i] denotes upto which index ew can jump to from index i
		int[] arr = new int[]{3,4,2,1,2,3,7,1,1,1,3};
		//minimum jumps to reach ened of array starting from i
		int minJumps = getMinJumps(arr);
		System.out.println("Minimun number of jumps to reach the end "+minJumps);
		
	}
	public static int getMinJumps(int[] arr)
	{
		//if the array length is 1 , min number of jumps to reach from start to end is zero
		//as both first and last index is same
		if(arr.length == 1)
		{
			return 0;
		}
		//it defines the maximum index up to which we can reach from current index
		int maxReach = arr[0];
		//it defines the number of steps available that we can take from current index(jumping 1 index from current is 1 step)
		int steps = arr[0];
		//it counts the total jumps to reach to the end 
		int jumps = 0;

        //for loop begins fron 1 because we know the 0th index jump value i.e 0 jumps 
        //for llop ends at arr.length-2, because we do not really need to do anything with last index
        //because whatever jumps comes we can increement it by 1 and return 
		for(int i = 1 ; i < arr.length-1 ; i++)
		{
			//maximumu index upto that we can reach is maximum of previous maxReach & arr[i]+i
			//arr[i] denotes the no of indeixes that we can jump at once from index i 
			//if we are at index 5 & arr[5] = 6 , then we can have a maxReach upto index 11 from 5 (i.e 6+5)
			maxReach = Math.max(maxReach,arr[i]+i);
			//decrement the step by 1
			steps--;
			//if at any time we run outta steps
			if(steps==0)
			{
				//increment the jump by 1 as we need to take one jump
				jumps++;
				//update the steps to maxReaxh -m index we are currently at
				steps=maxReach-i;
			}
		}
		//we are returning 1 incremented value of jumps because remember in the loop we havent considered the last element
		return jumps+1;
	}
}
