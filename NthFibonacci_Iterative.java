//Time Complexity O(n) | Space Complexity O(1)

import java.util.*;
class A
{
	public static void main(String[] args) 
	{
	   Scanner sc = new Scanner(System.in);
	   System.out.println("enter the value of n");	
	   int n = sc.nextInt();

	   int result = getNthFib(n);
	   System.out.println(result);
	}

    //to compute
	public static int getNthFib(int n)
	{
		//ARRAY to store last two values
		int[] lastTwo = new int[2];
		//base condition that is for first position value = 0 ,second position value = 1
		lastTwo[0] = 0;
		lastTwo[1] = 1;
        //to keep track of current postion in fibonacci series
		int counter = 3;
        //iterate till we reach the desired postion of fibonacci series
		while(counter <=n)
		{
			//compute the value of a position by adding previous two values which are
			//stored in array
			int value = lastTwo[0]+lastTwo[1];
			//move the value at last index of array to first index
			lastTwo[0] = lastTwo[1];
			//store the newly computed value in last index
			lastTwo[1] = value;
            
            //increment the counter
			counter = counter + 1;
 		}

 		return ((n>1)?lastTwo[1]:lastTwo[0]);
	}
}