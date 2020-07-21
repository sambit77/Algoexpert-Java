//Time Complexity O(d) | Space Complexity O(1)
// d = depth of ancestral tree

import java.util.*;
class A
{
	//actual algoruthm to find youngest common ancestor
	public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor,
		AncestralTree descedantOne,
		AncestralTree descedantTwo)
	{
		//get the depth of two descedants
		int depthOne = getDescedantDepth(descedantOne,topAncestor);
		int depthTwo = getDescedantDepth(descedantTwo,topAncestor);

        //do th following accordingly
		if(depthOne>depthTwo)
		{
           return backTraceAncestralTree(descedantOne,descedantTwo,depthOne-depthTwo);
		}
		else
		{
          return backTraceAncestralTree(descedantTwo,descedantOne,depthTwo-depthOne);
		}
	}

	public static int getDescedantDepth(AncestralTree descedant,AncestralTree topAncestor)
	{
		int depth = 0;

		//till descedant does not reach to top parent then go on incrementing depth
		while(descedant != topAncestor)
		{
			depth++;
			descedant = descedant.ancestor;
		}
		return depth;
	}


	public static AncestralTree backTraceAncestralTree(AncestralTree lowerDescedant,
		AncestralTree higherDescedant,int diff)
	{
		//make the 2 descedants to fall to same level first of they are in a different level initially
		while(diff>0)
		{
			lowerDescedant = lowerDescedant.ancestor;
			diff--;
		}

		//then when both the descedants reach to same level increment them waually till you find a common
		//ancestor
		while(lowerDescedant != higherDescedant)
		{
           lowerDescedant = lowerDescedant.ancestor;
           higherDescedant = higherDescedant.ancestor;
		}
		return lowerDescedant;
	}

	//definition of ancestral tree
	static class AncestralTree
	{
		public static char name;
		public static AncestralTree ancestor;

		AncestralTree(char name)
		{
			this.name = name;
			this.ancestor = null;
		}
	}

	//adding ancestor to ancestral tree
	public static void addAsAncestor(AncestralTree[] descedants)
	{
		for(AncestralTree descedant : descedants)
		{
			descedant.ancestor = AncestralTree.ancestor;
		}
	}
	public static void main(String[] args) 
	{
		
		AncestralTree tree = new AncestralTree('a');
		//AncestralTree 1stLevelChild1 = new AncestralTree('b');
		//AncestralTree 1stLevelChild2= new AncestralTree('c');
		//AncestralTree 1stLevelChild3= new AncestralTree('d');
		//AncestralTree 1stLevelChild4= new AncestralTree('e');

		AncestralTree[] arr = new AncestralTree[4];
		for(int i = 0 ; i < arr.length ;i++)
		{
			arr[i] = new AncestralTree((char)i+68); // adding b,c,d,e to the arr
		}
		//addAsAncestor(arr);
	}
}