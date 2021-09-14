/*
 * Name: Estefan Valencia
 * Program description: This program calculates the values of basic expressions in truth tables				
 * Course: COSC 314, Fall 2021
 * Homework#:  on Page 119, Computer Project #1 
 * Due date: 09/11/21 @ 11:59pm
 */

package hw1;

public class findBasicTruthValues {
	private static int[] arrQ = {0, 1, 0, 1};  //The Q Column which the left-most number would be at the top of the column
	private static int[] arrP = {0, 0, 1, 1};  //The P Column which the left-most number would be at the top of the column
	
	//Prints the P and Q columns
	public static void printPQ() {
		
		//prints the top section of the table
		System.out.printf("%-2s| %-2s|%n", "P", "Q");
		System.out.println("");
		
		// Prints the 1s and 0s in the appropriate columns
		for(int i = 0; i < arrP.length; i++) {
			System.out.printf("%-2d| %-2d|%n", arrP[i], arrQ[i]);
		}
	}
	
	/**
	 * @return the array for the AND values
	 */
	public static int[] getAND() {
		int[] arrAND = new int[4];
		
		// Go through each row and check if p is true and q is true
		for(int i = 0; i < arrAND.length; i++) {
			if(arrP[i] == 1 && arrQ[i] == 1){
				arrAND[i] = 1;
			} else {
				arrAND[i] = 0;
			}
		}

		return arrAND;
	}
	
	/**
	 * @return the array for the OR values
	 */
	public static int[] getOR() {
		int[] arrOR = new int[4];
		
		// Go through each row and check if p is true or if q is true
		for(int i = 0; i < arrOR.length; i++) {
			if(arrP[i] == 1 || arrQ[i] == 1){
				arrOR[i] = 1;
			} else {
				arrOR[i] = 0;
			}
		}
		
		return arrOR;
	}


	/**
	 * @return the array for the XOR values
	 */
	public static int[] getXOR() {
		int[] arrXOR = new int[4];
		
		// Go through each row and check if p is equal to q
		for(int i = 0; i < arrXOR.length; i++) {
			if(arrP[i] != arrQ[i]){
				arrXOR[i] = 1;
			} else {
				arrXOR[i] = 0;
			}
		}
		
		return arrXOR;
	}
	
	/**
	 * @return the array for the conditional
	 */
	public static int[] getConditional() {
		int[] arrCond = new int[4];
		
		// Go through each row and check if p is false or if q is true
		for(int i = 0; i < arrCond.length; i++) {
			if(arrP[i] == 0 || arrQ[i] == 1){
				arrCond[i] = 1;
			} else {
				arrCond[i] = 0;
			}
		}
		
		return arrCond;
	}
	
	/**
	 * 
	 * @return the array for the biconditional
	 */
	public static int[] getBiconditional() {
		int[] arrBi = new int[4];
		
		// Go through each row and check if p is equal to q
		for(int i = 0; i < arrBi.length; i++) {
			if(arrP[i] == arrQ[i]){
				arrBi[i] = 1;
			} else {
				arrBi[i] = 0;
			}
			
		}
		
		return arrBi;
	}
	
	public static void main(String[] args) {
		
		//Make a table where all of the truth values are in it
		System.out.printf("%-2s| %-2s| %-4s| %-3s| %-4s| %-12s| %-14s%n", "P", "Q", "AND", "OR", "XOR", "CONDITIONAL", "BICONDITIONAL");
		System.out.println("");
		
		//display the values under each of the names above
		for(int i = 0; i < arrP.length; i++) {
			System.out.printf("%-2d| %-2d| %-4d| %-3d| %-4d| %-12d| %-2d%n", arrP[i], arrQ[i], getAND()[i], getOR()[i], getXOR()[i], getConditional()[i], getBiconditional()[i]);
		}
		
		
	}

}

/**** Desired Output ****

P | Q | AND | OR | XOR | CONDITIONAL | BICONDITIONAL 

0 | 0 | 0   | 0  | 0   | 1           | 1 
0 | 1 | 0   | 1  | 1   | 1           | 0 
1 | 0 | 0   | 1  | 1   | 0           | 0 
1 | 1 | 1   | 1  | 0   | 1           | 1 

*/
