package lab02;
import java.util.Scanner;

public class RangeFinder {

	int[]intArray;
	
	public RangeFinder(){
		Scanner scr = new Scanner(System.in);
		String line = scr.nextLine();
		scr.close();
		String[] StringArray = line.split(" ");
		int[] listOfNum = new int[StringArray.length];	
	
		for (int i=0; i<StringArray.length; i++) {
			listOfNum[i]= Integer.parseInt(StringArray[i]);
		}
		
		intArray = listOfNum;
	}
	
	public int findMin() {
		int var = intArray[0];
		for (int i=1; i<intArray.length; i++) {
			var = Math.min(var, intArray[i]);
		}
		return var;
	}
	
	public int findMax() {
		int var = intArray[0];
		for (int i=1; i<intArray.length; i++) {
			var = Math.max(var, intArray[i]);
		}
		return var;
	}
	
	
	public int rangeFinder() {
		
		int range = findMax() - findMin();
		return range;
	}
	
	
	public static void main(String[] args) {
		RangeFinder r1 = new RangeFinder();
		System.out.println("The range is "+r1.rangeFinder()+".");

	}
}
