//Time Complexity O(2^n * n)
//Space Complexity O(2^n * n)
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);

	    ArrayList<ArrayList<Integer>> powerSet = generatePowerSet(al);
	    for(ArrayList<Integer> subsets : powerSet)
	    {
	    	System.out.print("[");
	    	for(Integer elements : subsets)
	    	{
	    		System.out.print(elements+",");
	    	}
	    	System.out.print("]");
	    	System.out.println();
	    }
		
	}
	public static ArrayList<ArrayList<Integer>> generatePowerSet(ArrayList<Integer> al)
	{
		ArrayList<ArrayList<Integer>> powerSet = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> first = new ArrayList<Integer>();
		powerSet.add(first);
		for(int num : al)
		{
			int size = powerSet.size();
			for(int i = 0 ; i < size ; i++)
			{
				ArrayList<Integer> prev = new ArrayList<Integer>(powerSet.get(i));
				prev.add(num);
				powerSet.add(prev);
			}
		}
		return powerSet;
	}
}