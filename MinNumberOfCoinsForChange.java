import java.util.*;
class A
{
	public static void main(String[] args) {
		int target = 6;
		int[] denoms = new int[]{1,2,4};
		int minways = calcMinCoins(target,denoms);
         
         if(minways == Integer.MAX_VALUE)
         {
         	System.out.println("Not possible using given denominations");
         	return;
         }
		System.out.println("Minimum coins req to form target "+target+" using denoms "
			+Arrays.toString(denoms)+" is "+minways);
	}

	//Time Complexity O(nd)   n = target d = denominations
	//Space Complexity O(n)   n = target 
	public static int calcMinCoins(int target,int[] denoms)
	{
       int[] minCoins = new int[target+1];
       for(int j = 0 ; j < minCoins.length ; j++)
       {
       	minCoins[j]=Integer.MAX_VALUE;
       }
       minCoins[0]=0;

       for(int denom : denoms)
       {
       	for(int amt = 1 ; amt < minCoins.length ; amt++)
       	{
       		if(denom <= amt)
       		{
       			 minCoins[amt] = Math.min(minCoins[amt],1+minCoins[amt-denom]);
       		}
       	}
       }
      


       return minCoins[target];
	}
}
