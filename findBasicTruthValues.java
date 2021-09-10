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
	
	//finds each AND value and prints them
	public static int[] getAND() {
		int[] arrAND = new int[4]; // Make an array so we can insert values later
		
		//Go through each row and add P and Q values to see what AND will be
		//in order for a row to be 1 in AND, both values have to be 1
		//otherwise, the row will be 0
		for(int i = 0; i < arrAND.length; i++) {
			
			//if P + Q = 0, then not a single value is 1 and therefore, AND has to be 0
			if(arrP[i] + arrQ[i] == 0) 
				arrAND[i] = 0;
			
			//if P + Q = 1, then one value is 1 and therefore, AND has to be 0
			else if(arrP[i] + arrQ[i] == 1)
				arrAND[i] = 0;
			
			//if P + Q = 2, then both values have to be 1 and therefore, AND has to be 1
			else if(arrP[i] + arrQ[i] == 2)
				arrAND[i] = 1;
		}
		
		return arrAND;
	}
	
	/**
	 * @return the array for the OR values
	 */
	public static int[] getOR() {
		int[] arrOR = new int[4]; // Make an array so we can insert values later
		
		// Similar to what we did in getAND() except,
		// in order for a row to be 1 in OR, only ONE P/Q value has to be 1
		// the only way OR equals 0 is if NEITHER value in P and Q are 1
		for(int i = 0; i < arrOR.length; i++) {
			
			//if P + Q = 0, then not a single value is 1 and therefore, OR has to be 0
			if(arrP[i] + arrQ[i] == 0) 
				arrOR[i] = 0;
			
			//if P + Q >= 1, then at least one value is 1 and therefore, OR has to be 1
			else if(arrP[i] + arrQ[i] >= 1)
				arrOR[i] = 1;
			
		}
		
		return arrOR;
	}


	/**
	 * @return the array for the XOR values
	 */
	public static int[] getXOR() {
		int[] arrXOR = new int[4]; // Make an array so we can insert values later
		
		// in XOR there can only be a "1" in either P or Q if we want XOR to be 1
		// if either BOTH values are 1 or NO values are 1, then XOR will be 0
		for(int i = 0; i < arrXOR.length; i++) {
			
			//if P + Q = 0 or P + Q > 1, then more than one value is 1 and therefore, XOR has to be 0
			if(arrP[i] + arrQ[i] == 0 || arrP[i] + arrQ[i] > 1) 
				arrXOR[i] = 0;
			
			//if P + Q = 1, then only one value is 1 and therefore, XOR has to be 1
			else if(arrP[i] + arrQ[i] == 1)
				arrXOR[i] = 1;
			
		}
		
		return arrXOR;
	}
	
	/**
	 * @return the array for the conditional
	 */
	public static int[] getConditional() {
		int[] arrCond = new int[4]; // Make an array so we can insert values later
		
		// Conditional is 1 if BOTH P and Q are 1 || if P is 0(it doesn't matter what Q is in this case)
		//
		// Conditional is 0 if Q == 0 && P == 1
		for(int i = 0; i < arrCond.length; i++) {
			
			//if both P and Q are 1, the conditional is 1
			if(arrP[i] + arrQ[i] > 1) 
				arrCond[i] = 1;
			
			//if only one value of P or Q is 1 &&  P is 0, then the conditional is 1
			else if(arrP[i] + arrQ[i] <= 1 && arrP[i] == 0)
				arrCond[i] = 1;
			
			//if P is 1(the only option left) && Q is 0(also the only option left), then the conditional has to be 0
			else
				arrCond[i] = 0;
			
		}
		
		return arrCond;
	}
	
	/**
	 * 
	 * @return the array for the biconditional
	 */
	public static int[] getBiconditional() {
		int[] arrBi = new int[4]; // Make an array so we can insert values later
		
		// Biconditional is 1 if P == Q
		//
		// Biconditional is 0 if P and Q aren't the same
		for(int i = 0; i < arrBi.length; i++) {
			
			//if P and Q are the same, the biconditional is 1
			if(arrP[i] + arrQ[i] != 1)
				arrBi[i] = 1;
			
			//if P and Q aren't the same(the only option left), the biconditional is 0
			else
				arrBi[i] = 0;
			
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
