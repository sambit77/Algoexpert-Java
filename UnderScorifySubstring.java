//Time Complexity O(n+m) <- Amortized Analysis max bound
//Time Complexity O(n^2+m) <- max bound in general but not specific
//Space Complexity O(n)
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		//given the input string and match put under score at left & right of where match appears
		//collapse when substrings overlaps or appears together
		//i.e for test  ->  _test_
		//for testest   -> _testtest_
		//for testestest  ->  _testestest_
		String input = "testthis is a testtest to see if  testestest it works";
		String match = "test";

		String result = underScorifySubstring(input,match);
		System.out.println("under scorified string is "+result);
		
	}
	public static String underScorifySubstring(String str,String match)
	{
		//first get all locations whwre substring appears 
		//store the  starting and ending index od the substring (wrt to given string str)

		//then call collapse method to take care of overlapping & joined substrings 

		ArrayList<int[]> locations = collapse(getLocations(str,match));

		//put underscorify at given locations
		return underScorifySubstringHelper(str,locations);
	}
	public static String underScorifySubstringHelper(String str,ArrayList<int[]> locations)
	{
		//to tarverse locations
		int locationsIdx = 0;
		//to traverse String str
		int startIdx = 0;

		//if we are in between underscire then we accept value at first index of array stored in locations arraylist
		//else we access value stored in 0 index of array stored in locationc arraylist
		boolean inbetweenUnderScores = false;

		//final generated string to be returned
		StringBuffer finalString = new StringBuffer();
		//it will switch value between o & 1 to access values stored in array stored in locations arraylist

		//if inbetweenunderscore is true then i is 1 & vice versa
		int i = 0;

		while(startIdx<str.length() && locationsIdx < locations.size())
		{
			//if we are at a point in string where we should insert underscore
			if(startIdx == locations.get(locationsIdx)[i])
			{
				//insert underscore
				finalString.append("_");
				//flip the inbetweenunderscores value
				inbetweenUnderScores = (!inbetweenUnderScores);

				//go to next location of substring if we are not inbwetween substring
				//i.e if we are inbetween substring we must access value at 1 index in array stored in ArrayList
				//then we will move to next array in ArrayList
				if(!inbetweenUnderScores)
				{
					locationsIdx++;
				}
				//flip the value of i 
				i = (i==1?0:1);		

			}
			//append other characters in the input string to final string to be returned
			finalString.append(str.charAt(startIdx));
			//increment the pointer of string str
			startIdx++;
		}
		//if we break from while loop due to startIdx > str.length()
		//if there are more locations where underscore to be added (i.e last underscore of a string if any)
		if(locationsIdx < locations.size())
		{
			//add that underscore
			finalString.append("_");
		}
		//if we break from while loop due to locationIdx > locations
		else if(startIdx < str.length())
		{
			//append the remaining charcaters of the string to the finalstring to be returned
			finalString.append(str.substring(startIdx,str.length()));
		}

		//conver the StringBuffer to String and return it
		return finalString.toString();

	}
	public static ArrayList<int[]> collapse(ArrayList<int[]> locations)
	{ 
		//collapse method collapse the overlapping ranges
		//i.e [0,4] [1,5] is collapsed to [0,5]
		if(locations.size()==0)
		{
			return locations;
		}
		ArrayList<int[]> newLocation = new ArrayList<int[]>();
		
		newLocation.add(locations.get(0));
		int[] previous = newLocation.get(0);
		
		
		for(int i =1 ; i < locations.size() ; i++)
		{
			
			int[] current = locations.get(i);
			

			if(current[0]<= previous[1])
			{
				
				
				previous[1]=current[1];
			}
			else
			{
				newLocation.add(current);
			
				previous = current;
				
			}
		}
		
		
		return newLocation;

	}
	//get Locations of all occurances of String match in given String str
	public static ArrayList<int[]> getLocations(String str,String match)
	{
		//to store locations of all the occuraces
		//first inedx of int[] stores the starting index of substring
		//second ondex stores the ending index of substring (excluded)

		//ArrayList is a coolection of locations of all substrings
		ArrayList<int[]> locations = new ArrayList<int[]>();

		int startIdx = 0;

		//uterate the given string str
		while(startIdx< str.length())
		{
			//nextIdx to iterate is the occurance of first substring in given string

			//indexOf returns -1 if no substring found
			//returns starting index of first encountered substring in given string
			int nextIdx = str.indexOf(match,startIdx);
			if(nextIdx != -1)
			{
				//if substring found then add its coordinate to array list
				// startIdx will be known endIdx will be startIdx + its length (susbstring length)
				locations.add(new int[]{nextIdx,nextIdx+match.length()});

				//increment startIdx to the letter next to first letter of appeared  substring in given string
				startIdx = nextIdx+1;
			}
			//break if no substring found
			else
			{
				break;
			}
		}
		//return the location
		return locations;
	}
}