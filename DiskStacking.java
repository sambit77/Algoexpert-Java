//Time Complexity O(n^2) | Space Complexity O(n)
// 2 for loops           | for heights & sequenceindices array
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		//it is a list of disks to be stacked
		ArrayList<int[]> disks = new ArrayList<int[]>();

		//adding disk to the disks list
		//disk has 3 dimension & dimensions are stored in 1D array
		//width of disk is 0th index of array
		//depth of disk is 1st index of array
		//height of disk is 3rd index of array
		disks.add(new int[]{2,1,2});
		disks.add(new int[]{3,2,3});
		disks.add(new int[]{2,2,1}); 
		disks.add(new int[]{4,4,5});
		disks.add(new int[]{2,3,4});
		

        //get the ordering of Disks , satsifying following condition
        //dimensions of disk above should be stricly greater than dimensions of disk below
		ArrayList<int[]> getDiskStack = stackDisk(disks);

		//print the diskStack
		System.out.println("width-depth-height");
		for(int[] disk : getDiskStack)
		{
			System.out.println(Arrays.toString(disk));
		}

		
	}
	public static ArrayList<int[]> stackDisk(ArrayList<int[]> disks)
	{
		//first sort the given disks list on the basis of any one dimension
		//lets sort this on the basis of height of disks first
		sortDiskOnBasisOfHeight(disks);
		//now the disks list are sorted on the basis of height

		//declare a heights array ,which stire the height of diskStack with current indexed disk at bottom most
		int[] heights = new int[disks.size()];

		//at min height of disk stack with all the given diks as bottom (1 layer stack)
		//the minimum height is height of the disk
		//so initialize the height array with this value
		for(int i = 0 ; i < heights.length ; i++)
		{
			//get all disks 
			int[] disk = disks.get(i);
			//the get their height & store it in height array
			heights[i]= disk[2];
		}
		//System.out.println(Arrays.toString(heights));

		//sequenceIndices[i] denotes the index of disk which is just above the disk indexed at i
		//index i disk at bottom -> sequenceIndices[i] is at top of index i disk
		int[] sequenceIndices = new int[disks.size()];

		//initialize it with all 1
		for(int i = 0 ; i < sequenceIndices.length ; i++)
		{
			sequenceIndices[i] = -1;
		}
        
        //to keep track of the largest element in heights array
        //i.e the maximu diskSatck height
		int maxHeightIdx = 0;

		//iterate all the disk from disks list
		for(int i = 1 ; i < disks.size() ; i++)
		{
			//get the current disk 
           int[] currentDisk = disks.get(i);
           //check for all the disk falling previous to it from 0 to i 
           for(int j = 0 ; j < i ; j++)
           {
           	//get the otherDisks(falling previous to currentDisk)
           	int[] otherDisk = disks.get(j);
           	//check the condition
           	//are both the disks compatible?
           	//i.e can we place otherDisk in the immediate top of current disk
           	//check otherDisks dimensions

           	if(dimensionsAreCompatible(otherDisk,currentDisk))
           	{
           		//if compatible
           		
           		//check if placing the disk above current disk produes greater height or it already had greater height
                //currentDisk[2] denotes height of currentDisk
                if(currentDisk[2]+heights[j] > heights[i])
                {
                	//update the height accordingly
                	heights[i] = currentDisk[2]+heights[j];
                	//so we can place disk index at j above disk indexed at i
                	//so update the sequenceIndices array

                	sequenceIndices[i] = j;
                }

           	}
           }
           //meanwhile checking heogt array from index 0 to last index 
           //to get the index of maximum height(largest number in heights array)
           //if height at current index is greater than height at previously assumed maxHeightIndex
           if(heights[i]>heights[maxHeightIdx])
           {
           	//accordingly uodate the index of max HEight
           	maxHeightIdx=i;
           }
		}


        //form diskList From sequenceIndices array
		return buildSequenceFromIndex(sequenceIndices,disks,maxHeightIdx);

	}

	//To sort the disks list on the basis of their height
	public static void sortDiskOnBasisOfHeight(ArrayList<int[]> disks)
	{
		//bubble sort of the ArrayList 
		//by comparing the height i.e the index 2
		for(int i = 0 ; i < disks.size() ; i++)
		{
           for(int j = i+1;  j < disks.size() ; j++)
           {
           	if(disks.get(i)[2]>disks.get(j)[2])
           	{
           		Collections.swap(disks,i,j);
           	}
           }
		}

	}

	public static ArrayList<int[]> buildSequenceFromIndex(int[] sequenceIndices,ArrayList<int[]> disks,int current)
	{
		//heree we will apeend the disks from bottom to top
		ArrayList<int[]> diskStack = new ArrayList<int[]>();
		//start from maxHeight disk
		int i =  current;
		//untill we reach -1 (stopping criteria for sequenceIndidces array)
		while( i != -1)
		{
			//add the corresponding disk index at i in disks list
			diskStack.add(disks.get(i));
			//update the i value to sequenceIndices of i
			//as the disk index at i is at bottom to the disk index at sequenceIndices of i
			i = sequenceIndices[i];

		}
		//as we have back tarcked the stack will be in reversed order ... i.e bottom to top

		//so reverse it before returning it
		Collections.reverse(diskStack);
		//return the diskStack

		return diskStack;
	}
	//chacks if 2 disks are compatiable to form pyramid
	public static boolean dimensionsAreCompatible(int[] otherDisk,int[] currentDisk)
	{
		//width , depth , height of other disk should be < width , depth , height of cuurent disk
		return otherDisk[0]<currentDisk[0] && otherDisk[1]<currentDisk[1] && otherDisk[2]<currentDisk[2];
	}
}