//import java.util.Collections;
//import java.util.Comparator;
import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.LinkedList;
import java.util.List;
import java.util.Map;
//import java.util.Map.Entry;
import java.util.Random;
// Java program to sort hashmap by values
import java.util.*;
import java.lang.*;

public class Q4toQ6 
{
	public static void main(String[] args) 
    {
		HashMap hashmap = new HashMap();
		hashmap.put(0, 1);
		hashmap.put(1, 3);
		hashmap.put(2, 5);
		hashmap.put(3, 7);
		hashmap.put(4, 9);
		hashmap.put(5, 11);
		
		System.out.println("Q4 before: " + hashmap);
		addAndSort(hashmap, 8);
        // remove index 6 = 0 for Q5 to proceed (non-sorted)
        hashmap.remove(6);
        System.out.println("Q5 before: " + hashmap);
		swapValues(hashmap, 1, 5);
		System.out.println("Q5 after: " + hashmap);
		System.out.println("Q6: " + findValue());
	}
	
	public static void addAndSort(HashMap hashmap, int value) 
    {
		int key = hashmap.size();
		hashmap.put(key, value);
		Map<Integer, Integer> Q1sorted = sortByValue(hashmap);
		
        // Q1 sorted
		System.out.println("Q4 after: " + Q1sorted);
	}
	
	// function to sort hashmap by values
    public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer> > list = new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet());
 
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() 
        {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        
        // put data from sorted list to hashmap
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

	public static void swapValues(HashMap map, int indexOne, int indexTwo) 
    {
		int temp1 = (int)map.get(indexOne);
		int temp2 = (int)map.get(indexTwo);
		
		map.remove(indexOne);
		map.put(indexOne, temp2);
		map.remove(indexTwo);
		map.put(indexTwo, temp1);
	} 
	
	public static int findValue() 
    {
		Random rand = new Random();
		HashMap map = new HashMap();
		int index = -1;

        int min = 1000;
        int max = 9999;
		
		for (int i = 0; i < 500; i++) 
        {
			map.put(i, rand.nextInt((max-min) + 1) + min);
		}
		
		
		for (int i = 0; i < 500; i++) {
			if ((int)map.get(i) == rand.nextInt((max-min) + 1) + min)
            {
				index = i;
			}
		}
		
		return index;
	}
}
	

