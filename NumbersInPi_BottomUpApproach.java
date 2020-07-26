//Time Complexity O(n^3+m)*   | Space Compelxity O(n+m) |* = citation needed
//n = length of String pi
//m = size of num list

//Space compelxity O(n+m) is due to m is for we are puttinh m nums from list to a HashMap
//and n is due to no of digits in pi(String pi)

//Time Complexity O(n^3 + m) is due to
//n^3 is due to we are taraversing the String once from 0 to i and again at each index we are traversing towards end
//it forms for loop inside a for loop kinda situation
//and inside that we are generating subStrings which is agagin a O(n) opertaion
//so total it becomes O(n^3)

//O(m) is due to the fact that we are adding m nums in HashMap(Citation needed)

//arent o(m) is coevered under O(n^3) complexity ?? Doubt

//question find minimu number of sapces to be put in the String pi such that
//all the subStrings formed by the String will be contained in our list

//eg if the num is 3145 , and list is [3145] ... then answer is 0 space
//eg if num is 3145 , and list is [3,145] ... then answer is 1 space
//eg if the num is 3145 list is [457,75] .. then return -1 , as it is not possible
import java.util.*;
class A
{
	public static void main(String[] args) 
	{

		String pi = "3141592";
		ArrayList<String>  nums = new ArrayList<String>();
		nums.add("3141");
		nums.add("5");
		nums.add("31");
		nums.add("2");
		nums.add("4159");
		nums.add("9");
		nums.add("42");

		int minSpaces = getMinSpaces(pi,nums);
		System.out.println("Minimu spaces required so that all the generated string will belong to given list "+minSpaces);
	
	}
	public static int getMinSpaces(String pi , ArrayList<String> nums)
	{
		//first dump the num in nums list to a HashMap so that we can easily access numbers
		HashMap<String,Boolean> numsMap = new HashMap<String,Boolean>();
		for(String num : nums)
		{
			numsMap.put(num,true);
		} 
		//cahce memory to store already computed values to avoid unnecessary recursion for duplicate subproblem
		HashMap<Integer,Integer> cache = new HashMap<Integer,Integer>();

		//go in reversed order bottom up approacj

		for(int i = pi.length() ; i >= 0 ; i-- )
		{
			getMinSpacesHelper(pi,numsMap,cache,i);
		}
        
        //we have started in reversed order that is from length of string i.e the smallest sub problem
        //so our original problems solution will be in 0 index of our table/map 

        //if no solution exist 0 index will be containing Integer,MAX_VALUE
        //we have been asked to return -1 for such conditions

        //accordingly return the value
		return cache.get(0)==Integer.MAX_VALUE ? -1:cache.get(0);
	}
	//it is the actual recaursive function
	public static int getMinSpacesHelper(String pi, HashMap<String,Boolean> numsMap,HashMap<Integer,Integer> cache,int idx)
	{
		if(idx == pi.length())
		{
			return -1;
		}

		//if we have already computed the value for that index just return value dont go for function call
		if(cache.containsKey(idx))
		{
         return cache.get(idx);
		}

		//to store min Space required
        int minSpaces = Integer.MAX_VALUE;

        //iterate the String from given idx to end of String
        //intially in forst function call idx will be zero
		for(int i = idx ; i < pi.length() ; i++)
		{
			//get the first prefix ,then next prefix and so on for a given index
			//fr eg if idx - 0 , String i 3145
			//prefix will be generated as 3  ,  31   , 314   , 3145
			String prefix = pi.substring(idx,i+1);
			//System.out.println(prefix);

			//if the prefix is in nums List (i,e in numsMap )
			if(numsMap.containsKey(prefix))
			{
				//then calcualte the minSpaces int the  corresponding suffix using recursion 
				int minSpacesinSuffix = getMinSpacesHelper(pi,numsMap,cache,i+1);
				//take the minimum of current minSpace value & minSpaces in suffix+1
				//+1 is added to minSapcesinSuffix because to part prefix & suffix we need another space
				minSpaces = Math.min(minSpaces,minSpacesinSuffix+1);
			}
		}

		//pi=ut the computed value for corresponding idx .. so that in next time when subproblem repeats we dont go for recusrion call
		cache.put(idx,minSpaces);
		//System.out.println(idx);

        //return the current minSpace value .. same as the value we just put in cahce memory corresponding to current index
		return cache.get(idx);

	}

}