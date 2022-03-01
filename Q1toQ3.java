import java.util.LinkedList;
import java.util.Random;

public class Q1toQ3 
{
	public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
		
		linkedList.add(1);
		linkedList.add(3);
		linkedList.add(5);
		linkedList.add(7);
		linkedList.add(9);
		linkedList.add(11);
		
		System.out.println("Q1 before: " + linkedList);
		addAndSort(linkedList, 8);
		System.out.println("Q1 after: " + linkedList);
		// remove 8 for Q2 to proceed
		linkedList.remove(4);
		System.out.println("Q2 before: " + linkedList);
		swapValues(linkedList, 1, 5);
		System.out.println("Q2 after: " + linkedList);
		System.out.println("Q3: " + findValue());
	}

    // Q1
	public static void addAndSort(LinkedList linkedList, int value)
    {
		int i = 0;
		while((int)linkedList.get(i) < value)
        {
			i++;
		}
		linkedList.add(i, value);
	}
	
    // Q2
	public static void swapValues(LinkedList linkedList, int indexOne, int indexTwo) 
    {
		int temp1 = (int)linkedList.get(indexOne);
		int temp2 = (int)linkedList.get(indexTwo);
		
		linkedList.remove(indexOne);
		linkedList.add(indexOne, temp2);
		linkedList.remove(indexTwo);
		linkedList.add(indexTwo, temp1);
	}
	
	public static int findValue() 
    {
		Random rand = new Random();
		LinkedList linkedList = new LinkedList();
		int index = -1;

		int min = 1000;
		int max = 9999;

		for (int i = 0; i < 500; i++) 
        {
			linkedList.add(rand.nextInt((max-min) + 1) + min);
		}
		
		for (int i = 0; i < 500; i++) 
        {
			if ((int)linkedList.get(i) == rand.nextInt((max-min) + 1) + min) 
            {
				index = i;
			}
		}	
		return index;
	}
}
