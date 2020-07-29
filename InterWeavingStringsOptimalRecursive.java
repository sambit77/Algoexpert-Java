//Time Complexity O(nm) | Space Complexity O(nm)


import java.util.*;
class A
{
	public static void main(String[] args) 
	{

		String one = "aaa";
		String two = "aaaf";
		String three = "aaafaaa";
		//check id String one & two can be interwoven to form third String
		boolean result = checkForInterWeaving(one,two,three);
		System.out.println("is thirs String is inter woven string of one & two ?"+result);
	}
	public static boolean checkForInterWeaving(String one ,String two,String three)
	{
		//if length of third String i sgreater than the sum of length of first two Strings 
		//they can never be interwoven to fm third String
		if(three.length()>one.length()+two.length())
		{
			return false;
		}

		//to be used in memoization technique

		//we have not used boolean[][] beacuse it can only store true false
		//Boolean[][] can store null,true,false

		//bydefault boolean[][] is initialized to false,but Boolean[][] initialized to null

		//so we nedd a cache in whic i,j grids initialized to null

		Boolean[][] cache = new Boolean[one.length()+1][two.length()+1];
		
		return isInterWoven(one,two,three,0,0,cache);
	}

	public static boolean isInterWoven(String one ,String two , String three,int i ,int j,Boolean[][] cache)
	{
		//i pointer is used to traverse String 1
		//j pointer is used to traverse String 2

		//k is used to tarverse String 3
		int k = i+j;

		//if the value is already computed for this i,j then just return the value dont go for unnecessary recursion

		if(cache[i][j] != null)
		{
			return cache[i][j];
		}
		//System.out.print(".");

 		//if with recursion we able to reach end of last String then yest ,it can be interwiven
		if(k==three.length())
		{
			return true;
		}

		//if i is within the limit & char at i in String one is equal to char at k in String 3

		if(i < one.length() && one.charAt(i)== three.charAt(k))
		{
			//then recursively exploe by incrementing i and return true only if the recursion returns true
			//as because we have to also consider the case of starting with second String

			//compute and also store the value in cache
			cache[i][j] = isInterWoven(one,two,three,i+1,j,cache);
			if(cache[i][j])
			{
				return true;
			}
		}

		//if j is within the limit & char at j in String two is equal two char at k in String 3

		if(j < two.length() && two.charAt(j) == three.charAt(k))
		{
			//then recursively explore for all the values of String two by incrementing j
			//compute and store the value im cache
			cache[i][j] = isInterWoven(one,two,three,i,j+1,cache);
			return cache[i][j];
		}
		//compute and store the value im cache
		cache[i][j] = false;
		return false;
	}
}