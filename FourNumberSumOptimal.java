//Time Compelxity O(n^2) avg | Space Compelxity O(n^2)
//in worst case time complexity can be of O(n^3)
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		int[] arr = new int[]{7,6,4,-1,1,2};
		int target = 16;
		System.out.println("following quadrapules from the array form target "+target);
		ArrayList<int[]> quadrapules = findQuadrapule(arr,target);
		printquadrapules(quadrapules);
		
	}
	public static ArrayList<int[]> findQuadrapule(int[] arr , int target)
	{
		//to store the list quadrapules
		ArrayList<int[]> quadrapules = new ArrayList<int[]>(); // quadrpules are list of arrays {arr[0],arr[1],arr[2],arr[3]}
        
        //eg let the target be 10
        //quadrpules can be list of arrays {1,2,3,4},{5,2,1,2}....


        //this map takes sum of two numbers as key 
        //and corresponding values is list of pairs(arr[0]+arr[1]) that add to give sum
        //example {15,{new int[]{7,8}}}
		HashMap<Integer,ArrayList<int[]>> map = new HashMap<Integer,ArrayList<int[]>>();

		int currentSum = 0;
		int difference = 0;
		
        
        //first and last element is not included beacuse.
        //for first element there is nothing in the hashmap
        //for last element we almost put all the pairs possible with last element to map
		for(int i = 1 ; i < arr.length - 1 ; i++)
		{
			//at a given index form pairs by iterating towards right
			//while itearting towards right do not put the sum in hashmap to avoid duplicates
			//only check for target-sum present in hashmap 
			for(int j = i+1 ; j < arr.length ; j++)
			{
				//current sum for using current index & all indics towards right of it one by one
				currentSum = arr[j]+arr[i];
				//find the difference
				difference = target-currentSum;

				//search if the diffrence is present in hashmap
				//if present then the get all the pairs that form the difference (from hashmap get() method)
				//form a quadrapule using pairs that from currentSum & all pairs from map
				if(map.containsKey(difference))
				{
					//get all pairs
					ArrayList<int[]> pairs = map.get(difference);

					//for each pair froming the diffrence append with them the current pair
					//form a quadrapule and add it to quadrapule list
					for(int[] pair : pairs)
					{
						//forming a quadrapule and adding it to list
					  quadrapules.add(new int[]{arr[i],arr[j],pair[0],pair[1]});
					}
                    
				}
			}

			//now iterate towards left of current index and form pairs using current index num with elements
		    //towards its left one by one and find their sum
			for(int k = 0 ; k < i ; k++)
			{
				//find there sum and add it to hashmap
				currentSum = arr[k]+arr[i];

				//if the sum is already present in hashmap then just append this pair to existing pairs list
				if(map.containsKey(currentSum))
				{

                    //get the existing pairs list for currentsum
					ArrayList<int[]> pairs = map.get(currentSum);
					//append current pair to the pair list
					pairs.add(new int[]{arr[i],arr[k]});
					//put the key value pair which will update the hashmap
					map.put(currentSum,pairs);
				}

				//if currentSum is not present in hashmap , create a new key value pair
				else
				{
					//create a new pairs list
					ArrayList<int[]> pairs = new ArrayList<int[]>();
					//to the list add new pair
					pairs.add(new int[]{arr[i],arr[k]});
					//put this pairs list into the map
					map.put(currentSum,pairs);
				}
			}
		}

		//return the list of quadrapules
		return quadrapules;


	}
	public static void printquadrapules(ArrayList<int[]> q)
	{
		int i = 1;
		//for ecery array(quadrapule) in quadrapules list
		for(int[] arr : q)
		{
           System.out.println("quadrapule "+i);
           //print each element of a quadrapule
           System.out.print("["+arr[0]+","+arr[1]+","+arr[2]+","+arr[3]+"]");
           System.out.println();
           i++;
		}
	}
}