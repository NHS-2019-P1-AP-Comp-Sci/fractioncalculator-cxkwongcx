/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args){//has a while loop and will print the produce Answer. 
    
    	Scanner userInput = new Scanner (System.in);
    	String stringInput = userInput.nextLine();
    	boolean quitTest = stringInput.equals("quit");
    	while(quitTest == false){
//    	System.out.print("What is your equation? : ");
    	System.out.println(produceAnswer(stringInput));     
    	stringInput= userInput.nextLine();
    	if (stringInput == "quit") {
    		quitTest = true;
    	}
    	
        // TODO: Read the input from the user and call produceAnswer with an equation
    	}
    	
    	userInput.close();
    }	

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input){
    	String whole = "0";
    	String numerator = "0";
    	String denominator = "0";

    if (input.equals("quit"));{
    	
    	//move back here
//    	System.out.println("Length of string = " + input.length());
    	int posTwo = input.indexOf(" ") + 3;                  //gives the position of the beginning of the part after _+_(second number)
    	String testOne = input.substring(posTwo);             //prints out the second number from the position it was told it started
    	if (testOne.indexOf("_") != -1) {
    		int positionEndOne = testOne.indexOf("_");
    		whole = testOne.substring(0,positionEndOne);
    		
    	}
    	
    	
    	if (testOne.indexOf("/") != -1) {
    		int positionEndTwo = testOne.indexOf("/");
    		denominator =  testOne.substring(positionEndTwo + 1);
    		if (testOne.indexOf("_") != -1) {
    			int positionOfUnderscorePlusOne = testOne.indexOf("_") + 1;
//    			String stuffAfterUnderscore = testOne.substring(positionOfUnderscore+1);
    			numerator =  testOne.substring(positionOfUnderscorePlusOne,positionEndTwo);
    		}
    		
    		if(testOne.indexOf("_") == -1) {
       			String testTwo = input.substring(posTwo - 1);
       			int positionEndTwoNew = testTwo.indexOf("/");
    			numerator = testTwo.substring(0,positionEndTwoNew);
    		}
    	}
    		
    	else if(testOne.indexOf("_") == -1 && testOne.indexOf("/") == -1){
//    		String three = input.substring(posTwo -1);
    		String onlyDenom = testOne;
    		 whole = onlyDenom.substring(0);
    		
    	}   	
    	
        // TODO: Implement this function to produce the solution to the input

        return ("whole:" + whole + " numerator:" + numerator + " denominator:" + denominator);//returns what you want to output into the console
        
        
    	}
    }
}
    // TODO: Fill in the space below with any helper methods that you think you will need


