//Time Complexity O(n*c) | Space Complexity O(n*c)
//n = n0 of items
//c = capacity of knapsack
import java.util.*;
class A
{
	public static int maxProfit = 0;
	public static void main(String[] args) 
	{
		int[] weights = new int[]{2,3,6,7};
		int[] profits = new int[]{1,4,5,6};
		int capacity = 10;
        
        //returns indices of thos items whoose profit adds up to give the maximum profit
		ArrayList<Integer> indexOfItems = getMaxProfit(weights,profits,capacity);
		System.out.println("Indices of items that are to be taken for maximizing profit ");
		System.out.println(indexOfItems.toString());
		System.out.println("getting maxProfit from public shared variable ");
		System.out.println("Maximum Profit is "+maxProfit);
		System.out.println("we can also find maxProfit by taking summations of numbers present at the index (in indexOfItems ArrayList)");
		
	}

	public static ArrayList<Integer> getMaxProfit(int[] weights,int[] profits,int capacity)
	{
		//knapsack array stores the profit value

		int[][] knapsack = new int[weights.length+1][capacity+1];
        //starts from 1 beacause at index 0 we have null items
        //itrating 1 to n , where n = no of items provides
        //at index 1 means considering only forst item
        //at index 2 means considering first 2 items from given items
        //at index n means considering all the n  items

		for(int i = 1 ; i < knapsack.length ; i++)
		{
			//we have uses indices i-1 because loop begins from 1
			//get the current weight from weight array
			int weight = weights[i-1];
			//get the profit against current weight from profit array
			//we have uses indices i-1 because loop begins from 1
			int profit = profits[i-1];
            
            //j is the current capacity of knapscan which runs from 0 to the cpaacity of Knapsack
			for(int j = 0; j < knapsack[i].length ; j++ )
			{
				//if current item weight is less than or equal to current knapsack capacity
				//then we have to decide whether to put it in bag or not
				//we have to compare the previous profit of not putting in bag
				//to getting the profit of putting it in bag
				//to get the profit of putting in bag we add the profit of current item with the profit of the knapsack 
				//at a point where it weighs current item's weight less than its present capacity

                if(weight<=j)
                {
                	//take the maximum profit
                	//maximum of (discaring current item,making space for current item in knapsack+putting current item profit)
                	knapsack[i][j] = Math.max(knapsack[i-1][j],knapsack[i-1][j-weight]+profit);
                }
                //if the weight of current item is greater than current knapsack capacity
                //we can never put it in knapsack
                else
                {

                    //so current profit remains same as previous value
                    //i.e the top grid above the current grid
                    //(not considering current item is going to top grid)
                	knapsack[i][j] = knapsack[i-1][j];
                }
			}
		}

		//maxProfit is stored at very last grid of knapsack array
		//uodate the value of public variable maxProfit
		maxProfit = knapsack[knapsack.length-1][knapsack[0].length-1];

		//generate the indices of items that are taken that are used in profit maximization
		return generateIndexOfItemsConsidered(knapsack,weights);
	}
	public static ArrayList<Integer> generateIndexOfItemsConsidered(int[][] knapsack,int[] weights)
	{
		//append the indices of items that constitute to maximum profit
		ArrayList<Integer> indices = new ArrayList<Integer>();
		//start back tarcking from lasy grid of knapsack array

		//i & j are initialized to last grid index
		int i = knapsack.length-1;
		int j = knapsack[0].length-1;

		//iterate untill i becomes zero
		//i denotes items ,, so continue untill we do not look up all items
		while(i > 0)
		{
			//if current profit is equal to its top grid
			//i.e the items is not in bag
			//so only the profit remains same in top grid as well as current grid
			if(knapsack[i][j] == knapsack[i-1][j])
			{
				//so decrement the value of i by 1 , move to upper row
				//move to upper row as we have already considered this item(looked for this item & decided to put it in bag)
				i=i-1;
			}
			//else if current profit of knapsack is greater than its top grid value
			//that means profit has increased when we considered this item
			//i.e we have added this item in bag to maximize profit
			else
			{
				//add this item index to the ArrayList
				//remember to traverse the weight/profits array we use 1 value less than
				// the index that we use to tarverse knapsack
				indices.add(i-1);
				//go back to that point in knapsack array by decreasing knapsack capacity by current items weight
				//as we r putting current item in knapsack , capacity of knapsack decreases by current item weight
				j=j-weights[i-1];
				//move to upper row as we have already considered this item(looked for this item & decided to put it in bag)
				i=i-1;
			}
			//if at any point j becomes zer0
			//i.e capcity of knapsack becomes zero
			//break from the loop
			if(j==0)
				break;
		}
		//as we have back tracked so indices are adde to arraylist in reversed order than its actual order
		//so reverse the arraylist
		Collections.reverse(indices);
		//return the arraylist
		return indices;
	}
}
