/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.Scanner;


public class FracCalc {

	public static void main(String[] args) {// has a while loop and will print the produce Answer.

		Scanner userInput = new Scanner(System.in);
		String stringInput = userInput.nextLine(); // this is for the second number stuff
		while(!(stringInput == "quit")) {
			System.out.println(produceAnswer(stringInput));
			stringInput = userInput.nextLine();
		}
		userInput.close();
		
	}
	
	
	
	
	
	
	public static String produceAnswer(String input) {
		
		int posOne = input.indexOf(" ");// index of the first space
		String firstPart = input.substring(0, posOne);
		String operator = input.substring(posOne+1 , posOne+2);
		String secondPart = input.substring(posOne+3);
//		^^This stuff above helps divide the equation into 3 parts,^^
//		First Number, Operator, and Second Number.
//  ==========================================================================================================		
//		String wString1 = Whole(firstPart);
//		String nString1 = Num(firstPart);
//		String dString1 = Dem(firstPart);
////		^^getting strings for the first number^^
//		String wString2 = Whole(secondPart);
//		String nString2 = Num(secondPart);
//		String dString2 = Dem(secondPart);
////		^^getting strings for the second number^^
		change
//  ==========================================================================================================
		int intWhole1 = Integer.parseInt(Whole(firstPart));
		int intWhole2 = Integer.parseInt(Whole(secondPart));
		int intNum1 = Integer.parseInt(Num(firstPart));
		int intNum2 = Integer.parseInt(Num(secondPart));
		int intDenom1 = Integer.parseInt(Dem(firstPart));
		int intDenom2 = Integer.parseInt(Dem(secondPart));
//		changing my Strings of whole, numerators, and denominators into integers from strings
//  ==========================================================================================================
		int newNum = 0;
		int newDenom = 0;
//		^^setting up defaults
//  ==========================================================================================================		
		intNum1 = intNum1 + Math.abs(intWhole1) * intDenom1; //makes an improper fraction for first number
		intNum2 = intNum2 + Math.abs(intWhole2) * intDenom2; //makes an improper fraction for second number
		
		if (intWhole1 <0) { //tests if the first number was a negative
			intNum1 *= -1;
		}
		if (intWhole2 <0) { //tests if the second number as a negative
			intNum2 *= -1;
		}
		
		if (operator == "+") {// if operator is '+'
			newNum = intNum1 * intDenom2 + intNum2 * intDenom1;
			newDenom = intDenom1 * intDenom2;
		}
		if (operator == "-") {// if operator is '-'
			newNum = intNum1 * intDenom2 - intNum2 * intDenom1;
			newDenom = intDenom1 * intDenom2;
		}
		if (operator == "*") {// if operator is '*'
			newNum = intNum1 * intNum2;
			newDenom = intDenom1 * intDenom2;
		}
		if (operator == "/") {// if operator is '/'
			newNum = intNum1 * intDenom2;
			newDenom = intDenom1 * intNum2;
			
		}
		return newNum + "/" + newDenom;
////		-----------------------------------------------------------------------------------------------------
////		if the improper fraction is less than 1
//		if ((newNum / newDenom) == 0) {
//			return newNum + "/" + newDenom;
//		}
//		
////		-----------------------------------------------------------------------------------------------------
////		if the improper faction is bigger than 1
//		else {
//			finalWhole = newNum / newDenom;
//			newNum = Math.abs(newNum) % newDenom;
//			return finalWhole + "_" + newNum + "/" + newDenom;
//		}

	}
	
	
	
	
	
	
	
//	===========================================================================================================
//	-------------start of Whole Parsing
	public static String Whole(String number) {//Parsing out a whole number from the input
		if (number.indexOf("_") != -1) {
			return number.substring(0,number.indexOf("_"));
		}
		else if(number.indexOf("_") != -1 && number.indexOf("/") != -1 && number.length() != 0){
			return "0";
		}
		else {
			return number;
		}
	}
//	-------------end of Whole Parsing
//	-------------start of Numerator Parsing
	public static String Num(String number) {//Parsing out a Numerator number from the input
		if (number.indexOf("_") != -1) {
			return number.substring(number.indexOf("_") + 1, number.indexOf("/")); 
		}
		else if(number.indexOf("/") != -1) {
			return number.substring(0, number.indexOf("/"));
		}
		else {
			return "0";
		}
		
		
		
	}
//	-------------end of Numerator Parsing
//	-------------start of Denominator Parsing
	public static String Dem(String number) {//Parsing out a Denominator number from the input
		if (number.indexOf("/") != -1) {
			return number.substring(number.indexOf("/") + 1);
		}
		else {
			return "1";
		}
		
	}
//	-------------end of Denominator Parsing
//  ==========================================================================================================	


}

//not working

		