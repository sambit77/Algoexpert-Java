//wap to find minimum number of edit operations required to make 2 strings similar for 2 given strings
//edit opertaion can be insertion ,deletion , replacement
import java.util.*;
class A
{
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "yabd";

		int res = levesteinDistance(str1,str2);
		System.out.println("minimum operations is "+res);
		int res2 = levesteinDistanceSpaceOptimised(str1,str2);
		System.out.println("minimum operations is (using Space Optimised)"+res2);

	}



	//Time Complexity O(mn) | Space Complexity O(mn)

	// m and n are length of both Strings
	public static int levesteinDistance(String a , String b)
	{
		int[][] E = new int[a.length()+1][b.length()+1];

		for(int i = 0 ; i < b.length()+1 ;i++ )
		{
			E[0][i] = i;
		}
		for(int j = 0 ; j < a.length()+1 ; j++)
		{
			E[j][0] = j;
		}

		//fiiling the 2D array

		for(int i = 1; i < a.length()+1 ; i++)
		{
			for(int j = 1; j < b.length()+1 ; j++)
			{
				if(a.charAt(i-1) == b.charAt(j-1))
				{
					E[i][j] = E[i-1][j-1];
				}
				else
				{
					E[i][j] = 1+Math.min(Math.min(E[i-1][j],E[i][j-1]),E[i-1][j-1]);
				}
			}
		}


        //Printing th 2D array
		for(int i = 0 ; i < a.length()+1 ; i++ )
		{
			for(int j = 0 ; j < b.length()+1 ; j++)
			{
				System.out.print(E[i][j]+",");
			}
			System.out.println();
		}
		return E[a.length()][b.length()]; //return the very last element
	}
	//Time Complexity O(mn) m and n are String lengths
	//Space Complexity O(minimum(mn))  we use 2 arrays evnEdits & oddEdits of length = small string length 

	public static int levesteinDistanceSpaceOptimised(String str1,String str2)
	{
       String small = str1.length() < str2.length() ? str1 : str2;
       String big = str1.length() > str2.length() ? str1 : str2;
       

       //small String should be the column length 
       int[] evenEdits = new int[small.length()+1];
       int[] oddEdits = new int[small.length()+1];


       int[] currentEdits = new int[small.length()+1];
       int[] previousEdits = new int[small.length()+1];

       //populate the first row of first array as 0 1  2 

       for(int i = 0 ; i < evenEdits.length ; i++)
       {
       	evenEdits[i]=i;
       }

       for(int i = 1 ; i < big.length()+1 ; i++ )
       {
       	if(i%2 == 1)
       	{
       		currentEdits = oddEdits;
       		previousEdits = evenEdits;
       	}
       	else
       	{
       		currentEdits = evenEdits;
       		previousEdits = oddEdits;
       	}
       	currentEdits[0] = i;

       	for(int j = 1 ; j < small.length()+1 ; j++)
       	{
       		if(big.charAt(i-1)==small.charAt(j-1))
       		{
       			currentEdits[j] = previousEdits[j-1];
       		}
       		else
       		{
       			currentEdits[j] = 1 + Math.min(previousEdits[j-1],Math.min(previousEdits[j],currentEdits[j-1])); 
       		}
       	}
       }

       //return the last element of array 
       //if the number of iteration is even that is length of big string is even then return the last element of
       //evenedits array else if the number of iterations id odd that is length of big string is odd then return
       //the last element of oddEditd array

       return big.length() % 2 == 0 ?  evenEdits[small.length()] : oddEdits[small.length()];

	}
}
