package lab02;

import java.util.Scanner;

public class MeanMeans {
	double[][]setsOfInt;
	static int count;
	
	public MeanMeans() {
		Scanner scr = new Scanner(System.in);
		
		double[][]doubleArray = new double[1000][50];
		String[] line = scr.nextLine().split(",");
		if (line[0]=="-1") {
			System.out.println("No lines.");
		}
		count = 0;
		while(!(line[0].equals("-1"))) {
			for (int i=0; i<line.length; i++) {
				doubleArray[count][i]=Double.parseDouble(line[i]);
			}
			line=scr.nextLine().split(",");
			count++;
		}	
		scr.close();
		setsOfInt= doubleArray;
	}
	
	
	public double meanFinder() {
		double setSum=0;
		double setSumAve=0;
		for (int i=0; i<count; i++) {
			for (int j=0; j<setsOfInt[i].length; j++) {
				setSum=setSum+setsOfInt[i][j];
			}
			double setAve = setSum/setsOfInt[i].length;
			setSumAve = setSumAve+setAve;
		}
		double totalAve = setSumAve/count;
		return totalAve;
	}
	
	public static void main(String[] args) {
		MeanMeans mm1 = new MeanMeans();
		System.out.println(mm1.meanFinder());
	}
}
