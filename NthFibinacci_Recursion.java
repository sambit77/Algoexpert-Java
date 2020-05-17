//Time Complexity O(2^n) | Space Complexity O(n)

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


	public static int getNthFib(int n)
	{
		if(n == 1)  //first number in fibonacci series
		{
           return 0;
		}
		else if(n==2) //second number in fibnacci series
		{
            return 1;
		}
		else  //nth number in fibonacci series
		{
            return getNthFib(n-1)+getNthFib(n-2);
		}
	}
}