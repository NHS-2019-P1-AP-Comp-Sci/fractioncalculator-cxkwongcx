/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args)//has a while loop and will print the produce Answer. 
    
    	
    {
    	
    	Scanner userInput = new Scanner (System.in);
    	
//    	System.out.print("What is your equation? : ");
    	String stringInput =userInput.nextLine();
    	
    	System.out.println(produceAnswer(stringInput));                        
    	
    	userInput.close();
        // TODO: Read the input from the user and call produceAnswer with an equation

    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    {
    	
//    	System.out.println("Length of string = " + input.length());
    	int postwo = input.indexOf(" ") + 3;
//    	System.out.println("Position of second fraction = " + postwo);
//    	System.out.println("");
    	
    	
        // TODO: Implement this function to produce the solution to the input

        return input.substring(postwo);//returns what you want to output into the console
    }

    // TODO: Fill in the space below with any helper methods that you think you will need

}
