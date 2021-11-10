package lab04;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Solution of Lab #4: Ferry Boat
 * 
 * @author Billy Lee and Savid Basnyat
 * 
 * @version Dec 4, 2020
 */

public class FerryBoat {
	
	int length;
	int number;
	Queue<Car> leftCars;
	Queue<Car> rightCars;
	
	/*
	* Construct two new linked lists and add cars waiting on the left to one and
	* cars waiting on the right to the other.
	* 
	*/
	public FerryBoat() {
		Scanner scr = new Scanner(System.in);
		String[] numberCars = scr.nextLine().split(" ");
		// Assign total length of ferry to variable length
		length = Integer.parseInt(numberCars[0])*100;
		// Assign total number of cars to variable number
		number = Integer.parseInt(numberCars[1]);
		
		if (number!=0) {
	
			leftCars = new LinkedList<Car>();
			rightCars = new LinkedList<Car>();
			
			while(scr.hasNext()) {
				String[] theCars = scr.nextLine().split(" ");
				
				if (theCars[2].equals("left")) {
					Car leftCar = new Car(Integer.parseInt(theCars[0]), theCars[1]);
					leftCars.add(leftCar);
				} else {
					Car rightCar = new Car(Integer.parseInt(theCars[0]), theCars[1]);
					rightCars.add(rightCar);
				}
			}
		}
		scr.close();
	}
	

	public static void main(String[] args) {
		
		FerryBoat fb1 = new FerryBoat();
		
		// if no cars, done!
		if (fb1.number==0) {
			System.out.println("Day Off!");
			
		} else {
			//variable location reflects which side the ferry is at.
			//variable line indicates the line number in the output.
			
			int line = 1;
			String location = null;
			
			//Runs until there are no more Car objects in both lists. Checks leftCars then rightCars and repeats.
			while ((fb1.leftCars.size()!=0)||(fb1.rightCars.size()!=0)) {
				
				// if only 1 car in the left, print the cars license and done!
				if (fb1.leftCars.size()==1) {
					Car car1 = fb1.leftCars.remove();
					System.out.println(line+" : "+car1.license);
					line++;
					location = "right";
					
				// if more than one car, remove the first car and store it in car1. Check the length of next car and
				// space left on the ferry.

				} else if (fb1.leftCars.size()>1) {
					Car car1 = fb1.leftCars.remove();
					int lengthOfNext1 = fb1.leftCars.peek().length;
					int lengthLeft1 = fb1.length - car1.length;
					
					//if one car remains upon removal.
					if (fb1.leftCars.size()==1) {
						//remove the next car if there is enough length on ferry and print both cars. else only print car1.
						if (lengthLeft1>=lengthOfNext1) {
							System.out.print(line+" : "+car1.license);
							System.out.println(" "+fb1.leftCars.remove().license);
						} else {
							System.out.println(line+" : "+car1.license);
						}
					//more than one car remains upon removal, so use while loop to remove until no space left in ferry
					} else {
						if (lengthLeft1>=lengthOfNext1) {
							System.out.print(line+" : "+car1.license);
							//removes a car until if there is not enough space on ferry for next car
							while ((fb1.leftCars.size()>1)&&(lengthLeft1>=lengthOfNext1)) {
								System.out.print(" "+fb1.leftCars.remove().license);
								lengthLeft1 = lengthLeft1 - lengthOfNext1;
								lengthOfNext1 = fb1.leftCars.peek().length;
							}
							System.out.println("");
						//no space for another car, print car1 and finish.	
						} else {
							System.out.println(line+" : "+car1.license);
						}
					}
					line++;
					location = "right";
				}	
				//same exact process as above, except for the right side cars.
				if (fb1.rightCars.size()==1) {
					Car car2 = fb1.rightCars.remove();
					System.out.println(line+" : "+car2.license);
					line++;
					location = "left";
					
				} else if (fb1.rightCars.size()>1) {
					Car car2 = fb1.rightCars.remove();
					
					int lengthOfNext2 = fb1.rightCars.peek().length;
					int lengthLeft2 = fb1.length - car2.length;
					
					if (fb1.rightCars.size()==1) {
						if (lengthLeft2>=lengthOfNext2) {
							System.out.print(line+" : "+car2.license);
							System.out.println(" "+fb1.rightCars.remove().license);
						} else {
							System.out.println(line+" : "+car2.license);
						}
					} else {
						if (lengthLeft2>=lengthOfNext2) {
							System.out.print(line+" : "+car2.license);
							while ((fb1.rightCars.size()>1)&&(lengthLeft2>=lengthOfNext2)) {
								System.out.print(" "+fb1.rightCars.remove().license);
								lengthLeft2 = lengthLeft2 - lengthOfNext2;
								lengthOfNext2 = fb1.rightCars.peek().length;
							}
							System.out.println("");
						} else {
							System.out.println(line+" : "+car2.license);
						}
					}
					line++;
					location = "left";
				}
			}
			//if ferry remains at right side, it has to return to the left at the end of the day.
			if (location == "right") {
				System.out.println(line+" : empty");
			}
		}
		
	}
	
	/*
	* Class that represents a car. Each car has a length and license plate number.
	* 
	*/
	private class Car {
		public int length;
		public String license;
		
		public Car(int length, String license) {
			this.length = length;
			this.license = license;
		}
	}
}
