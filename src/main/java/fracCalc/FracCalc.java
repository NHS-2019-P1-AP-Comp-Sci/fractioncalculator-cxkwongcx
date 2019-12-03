/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {// has a while loop and will print the produce Answer.

		Scanner userInput = new Scanner(System.in);
		String stringInput = userInput.nextLine(); // this is for the second number stuff
		String firstInput = stringInput; // this is for the first number stuff
		boolean quitTest = stringInput.equals("quit");
		while (quitTest == false) {
//    	System.out.print("What is your equation? : ");
			System.out.println(inputs(stringInput, firstInput)); // (input for second, input for first to use)
			stringInput = userInput.nextLine();
			if (stringInput == "quit") {
				quitTest = true;
			}

		}

		userInput.close();
	}

	public static void AllNumbers() {

	}

	public static String inputs(String input, String input1) {
		String whole1 = "0";
		String num1 = "0";
		String denom1 = "0";
		
		int posOne = input.indexOf(" ");
		
		
		String beginning = input1.substring(0,posOne); //this is the string of stuff that comes before the first space
		int firstUnderscore = beginning.indexOf("_");
		int firstSlash = beginning.indexOf("/");
//		int firstSpace = beginning.indexOf(" ");
		if (beginning.indexOf("_") != -1) {
			whole1 = beginning.substring(0, firstUnderscore);
		}
		
		if (beginning.indexOf("/") != -1) {
			denom1 = beginning.substring(firstSlash +1);
			if (beginning.indexOf("_") != -1) {
				num1 = beginning.substring(firstUnderscore+1, firstSlash);
			}
			if (beginning.indexOf("_") == -1) {
				num1 = beginning.substring(0, firstSlash);
			}
			
		}
		else if (beginning.indexOf("_") == -1 && beginning.indexOf("/") == -1) {
			whole1 = beginning.substring(0, posOne ); 
			denom1 = "1";
		}
		//___________________________Below is for the second number
		String whole2 = "0";
		String num2 = "0";
		String denom2 = "0";
		// move back here
//    	System.out.println("Length of string = " + input.length());
		int posTwo = input.indexOf(" ") + 3; // gives the position of the beginning of the part after _+_(second number)
		String testOne = input.substring(posTwo); // prints out the second number from the position it was told it
													// started
		if (testOne.indexOf("_") != -1) {
			int positionEndOne = testOne.indexOf("_");
			whole2 = testOne.substring(0, positionEndOne);
		}

		if (testOne.indexOf("/") != -1) {// finds if there is a fraction in the second number
			int positionEndTwo = testOne.indexOf("/");
			denom2 = testOne.substring(positionEndTwo + 1);
			if (testOne.indexOf("_") != -1) {
				int positionOfUnderscorePlusOne = testOne.indexOf("_") + 1;
				num2 = testOne.substring(positionOfUnderscorePlusOne, positionEndTwo);
			}

			if (testOne.indexOf("_") == -1) {
				String testTwo = input.substring(posTwo - 1);
				int positionEndTwoNew = testTwo.indexOf("/");
				num2 = testTwo.substring(0 + 1, positionEndTwoNew);
			}
		}

		else if (testOne.indexOf("_") == -1 && testOne.indexOf("/") == -1) {
			String onlyDenom = testOne;
			whole2 = onlyDenom.substring(0);
			denom2 = "1";

		}
		String operator = input.substring(posOne, posTwo);
		
		if (operator == "+") {
			if (whole1.indexOf("-") == -1) {
				return (add(whole1, whole2, num1, denom1, num2, denom2));
			}
		}

		// TODO: Implement this function to produce the solution to the input

		return ("second int stuff=:" + "      whole2:" + whole2 + "      numerator2:" + num2 + "      denominator2:" + denom2
				 + "     first in stuff=" + "    whole1:" + whole1 + "      numerator1:" + num1 + "      denominator1:" + denom1);// returns what you want
																								// to output into the
																								// console

		
	}

//-----------------------------------------------------------------------------------------------------------------------------
	public static String add(int whole1, int whole2, int num1, int denom1, int num2, int denom2) {
		int num1fix = (whole1 * denom1) + num1;

		int num2fix = (whole2 * denom2) + num2;

		int newnum1 = num1fix * denom2;
		int newnum2 = num2fix * denom1;
		int newdenom = denom2 * denom1;

		int completenum = newnum1 + newnum2;

		return completenum + "/" + newdenom;

	}

//-----------------------------------------------------------------------------------------------------------------------------
	public static String substract(int whole1, int whole2, int num1, int denom1, int num2, int denom2) {
		int newnum1 = num1 * denom2;
		int newnum2 = num2 * denom1;
		int newdenom = denom2 * denom1;

		int completenum = newnum1 - newnum2;

		return completenum + "/" + newdenom;

	}

//-----------------------------------------------------------------------------------------------------------------------------
	public static String multiply(int whole1, int whole2, int num1, int denom1, int num2, int denom2) {
		int newnum = num1 * num2;
		int newdenom = denom1 * denom2;

		return newnum + "/" + newdenom;

	}

//-----------------------------------------------------------------------------------------------------------------------------
	public static String devide(int whole1, int whole2, int num1, int denom1, int num2, int denom2) {
		int newnum = num1 * denom2;
		int newdenom = denom1 * num2;

		return newnum + "/" + newdenom;
	}

}
// TODO: Fill in the space below with any helper methods that you think you will
// need
