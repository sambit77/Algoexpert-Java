class A
{
	public static void main(String[] args) 
	{
	  int[] denoms = new int[]{1,5,10,25};
	  int target = 10;

	  int answer = calculateNoOfWays(target,denoms);	
	  System.out.println("Number of ways to make change "+answer);
	}

	//Time Complexity O(nd)  n = target d = no of denoms
	//Space Complexity O(n) n = target
	public static int calculateNoOfWays(int target,int[] denoms)
	{
		int[] ways = new int[target+1];
		ways[0] = 1; // No of ways to make an amount 0 is 1 .. i.e by discarding all denoms

		for(int i = 0;i < denoms.length ; i++)
		{
			for(int amt = 1 ; amt  < ways.length ; amt++)
			{
				if(denoms[i] <= amt)
				{
					ways[amt] = ways[amt]+ways[amt-denoms[i]];
				}
			}
		}
		return ways[target];
	}
}