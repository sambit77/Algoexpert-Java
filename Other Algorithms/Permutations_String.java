//Program to find all the permutations of a String
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the String");
		String str = sc.nextLine();
		calculate(str,0,str.length()-1);
	}
	public static String swap(String str,int a , int b)
	{
		//swap characters at index  a and index b in a String
		char temp;
		char[] crr = str.toCharArray();
		temp = crr[a];
		crr[a] = crr[b];
		crr[b] = temp;

		return String.valueOf(crr);
	}
	public static void calculate(String str , int start , int end)
	{
		if(start==end)
		{
			System.out.println(str);
		}
		else
		{
			for(int i = start ; i <= end ; i++)
			{
				//swap the first character of the received string with every other charactre
				String swapped = swap(str,start,i);
				//recursively do it for all other charcters in the String
				calculate(swapped,start+1,end);
			}
		}
	}
}