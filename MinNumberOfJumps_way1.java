//Time Complexity O(n^2) | Space Complexity O(n)
//Time Complexity can be improved by iteraing the array just once
//Space complexity can be improved by not storing the jumps
//see the way 2 for optimisation
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
		//initialize jumps[] array with all infinity (max value of int) as initially we need infinite jumps
		//jumps[i] denotes the no of jumps needed to reach ith index from 0th index
		int[] jumps = new int[arr.length];
        for(int i = 1 ; i < jumps.length ; i++)
        {
        	jumps[i] = Integer.MAX_VALUE;
        }

        //to reach first index from first index we need zero jumps
		jumps[0] = 0;
        //traverse the given input array
		for(int i = 1 ; i < arr.length ; i++)
		{
			//then check backward in jumps array to fill current index
			for(int j = 0 ; j < i ; j++)
			{
				//if given jumps arr[j] + j (index no) is greater than index i 
				//it means there is a reach from index j to i 
                if(arr[j]+j >= i)
                {
                	//update the no of jumps at current index
                	//it is the minimum of what previously stored v/s
                	//1 + no of jumps of to reach its previous position
                	jumps[i] = Math.min(jumps[i],jumps[j]+1);
                }
			}
		}

        //last element of jumps array is answer denoting the minimu number
        //of jumps required to reach last index from first index
		return jumps[jumps.length-1];
	}
}