//Time Complexity O(n) (for computing n unique sub problems) 
//| Space Complexity O(n) (for hashmap & recursion stack)
//Memoixe technique | Top-Down approach | Dynamic Programming

import java.util.*;
class A
{
	public static void main(String[] args) 
	{
	   Scanner sc = new Scanner(System.in);
	   System.out.println("enter the value of n");	
	   int n = sc.nextInt();

       //hashmap use to store previously compute value for a position ,and when a particular 
       //position is referred more dan once den we can access it from hashmap in constant time O(1)
       //thus avoiding function call for computing that postion value again
	   HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	   //first field is the postion , second field is the value for dat position

	   //base case tha is in fibi series first number is 0 and second number is 1
	   map.put(1,0);
	   map.put(2,1);
        
        //pass the postion and hashmap for computation
	   int result = getNthFib(n,map);
	   System.out.println(result);
	}

    ///function to compute
	public static int getNthFib(int n,HashMap map)
	{
		//if the value of n is already present in hashmap dont go for function call
		//just access it from hashmap in constant time O(1)
		if(map.containsKey(n))
		{

            return (int)map.get(n);
		}
		//if n is not pressent in hashmap ,go for function call store it in stack
		else
		{
			map.put(n,getNthFib(n-1,map)+getNthFib(n-2,map));
		 return (int) map.get(n);
		}

    }
	
}