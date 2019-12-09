/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {// has a while loop and will print the produce Answer.

		Scanner userInput = new Scanner(System.in);
		String stringInput = userInput.nextLine(); // this is for the second number stuff
		while (!(stringInput == "quit")) {
			System.out.println(produceAnswer(stringInput));
			stringInput = userInput.nextLine();
		}
		userInput.close();

	}

//	===========================================================================================================
	public static String produceAnswer(String input) {
		String exitProgram = "quit";
		if(input.equals(exitProgram)){
			System.exit(0);
		}

		int posOne = input.indexOf(" ");// index of the first space
		String firstPart = input.substring(0, posOne);
		String secondPart = input.substring(posOne + 3);
		String operator = input.substring(posOne + 1, posOne + 2);
//		^^This stuff above helps divide the equation into 3 parts,^^
//		First Number, Second Number, and Operator.

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
		int finalWhole = 0;
//		^^setting up defaults
//  ==========================================================================================================		
		intNum1 = intNum1 + Math.abs(intWhole1) * intDenom1; // makes an improper fraction for first number
		intNum2 = intNum2 + Math.abs(intWhole2) * intDenom2; // makes an improper fraction for second number

		if (intWhole1 < 0) { // tests if the first number was a negative
			intNum1 *= -1;
		}
		if (intWhole2 < 0) { // tests if the second number as a negative
			intNum2 *= -1;
		}
//		++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		if (operator.equals("+")) {// if operator is '+'
			if (intDenom1 == intDenom2) {
				newNum = intNum1 + intNum2;
				newDenom = intDenom1;
			} else {
				newNum = intNum1 * intDenom2 + intNum2 * intDenom1;
				newDenom = intDenom1 * intDenom2;
			}
		}
//		--------------------------------------------------------------------------------------------------------
		else if (operator.equals("-")) {// if operator is '-'
			newNum = intNum1 * intDenom2 - intNum2 * intDenom1;
			newDenom = intDenom1 * intDenom2;
			for (int i = newNum; i > 0; i--) {
				if ((newNum % i == 0) && (newDenom % i == 0)) { // simplifying the simplified fraction
					newNum = newNum / i;
					newDenom = newDenom / i;

				}
			}

		}
//		*********************************************************************************************************
		else if (operator.equals("*")) {// if operator is '*'
			newNum = intNum1 * intNum2;
			newDenom = intDenom1 * intDenom2;
		}
//		////////////////////////////////////////////////////////////////////////////////////////////////////////
		else if (operator.equals("/")) {// if operator is '/'
			if (intWhole1 < 0 && intWhole2 < 0) {
				newNum = Math.abs(intNum1) * intDenom2;
				newDenom = intDenom1 * Math.abs(intNum2);

			} else if (intNum1 > 0 && intNum2 < 0) {
				newNum = Math.abs(intNum1) * (Math.abs(intDenom2) * -1);
				newDenom = Math.abs(intDenom1) * Math.abs(intNum2);
			} else if (intNum1 < 0 && intNum2 > 0) {
				newNum = Math.abs(intNum1) * (Math.abs(intDenom2) * -1);
				newDenom = Math.abs(intDenom1) * Math.abs(intNum2);
			} else {
				newNum = intNum1 * intDenom2;
				newDenom = intDenom1 * intNum2;
			}

		}

//		---------------------------------------- if we have a zero
		if (newNum == (0) || newNum == (-0)) {
			return "0";
		}
//		---------------------------------------- if only divide by one
//		if (newNum == intNum1) {
//			return Integer.toString(intNum1);
//		}
//		---------------------------------------- 

//		-----------------------------------------------------------------------------------------------------
//		if the improper fraction is less than 1
		if ((newNum / newDenom) == 0 && newNum > 0) {
			for (int i = newNum; i > 0; i--) {
				if ((newNum % i == 0) && (newDenom % i == 0)) { // simplifying the simplified fraction
					newNum = newNum / i;
					newDenom = newDenom / i;

				}

				else {

					return newNum + "/" + newDenom;
				}
			}

			return newNum + "/" + newDenom;
		}
		if ((newNum / newDenom) == 0 && newNum < 0) {
			for (int i = Math.abs(newNum); i > 0; i--) { // for negatives that are smaller than 1
				if ((newNum % i == 0) && (newDenom % i == 0)) { // simplifying the simplified fraction
					newNum = newNum / i;
					newDenom = newDenom / i;

				}

			}

			return newNum + "/" + newDenom;
		}

//		-----------------------------------------------------------------------------------------------------
//		if the improper faction is bigger than 1
		else {
			finalWhole = newNum / newDenom;
			newNum = Math.abs(newNum) % newDenom;

//			---------------------------------------- if we have a zero as a numerator

			if (newNum == 0 && newDenom != 0) {
				return Integer.toString(finalWhole);
			}
//			---------------------------------------- when we have a number
			else {
				if (newNum != 0 && newDenom != 0) {
					for (int i = newNum; i > 0; i--) {
						if ((newNum % i == 0) && newDenom % i == 0) {
							newNum = newNum / i;
							newDenom = newDenom / i;
						}

					}
					return finalWhole + "_" + newNum + "/" + newDenom;
				} else {

					return finalWhole + "_" + newNum + "/" + newDenom;
				}
			}
		}

	}

//	===========================================================================================================
//	-------------start of Whole Parsing
	public static String Whole(String number) {// Parsing out a whole number from the input
		if (number.indexOf("_") != -1) {
			return number.substring(0, number.indexOf("_"));
		} else if (number.indexOf("/") != -1 && number.length() != 0) {
			return "0";
		} else {
			return number;
		}
	}

//	-------------end of Whole Parsing
//	-------------start of Numerator Parsing
	public static String Num(String number) {// Parsing out a Numerator number from the input
		if (number.indexOf("_") != -1) {
			return number.substring(number.indexOf("_") + 1, number.indexOf("/"));
		} else if (number.indexOf("/") != -1) {
			return number.substring(0, number.indexOf("/"));
		} else {
			return "0";
		}
	}

//	-------------end of Numerator Parsing
//	-------------start of Denominator Parsing
	public static String Dem(String number) {// Parsing out a Denominator number from the input
		if (number.indexOf("/") != -1) {
			return number.substring(number.indexOf("/") + 1);
		} else {
			return "1";
		}
	}
//	-------------end of Denominator Parsing
//  ==========================================================================================================	

}