/****************************************************************
 * Name: Manel Ghorbal 											*
 *																*
 * ID: 002235600 												*
 * 																*
 * CS321 - Assignment 2											*
 * 																*
 * The TML Interpreter											*
 ***************************************************************/

import java.io.File;


public class Main {

	public static void main(String[] args) {
		
		System.out.println("----- Tiny Machine Language Interpreter -----\n");
		System.out.println("DISCLAIMER: please have a \" \" at the end of each line\n so that the instructions are ensured to be read correctly.\n\n");
		
		//pass the path to the file as a parameter 
		File file = new File("/Users/manelghorbal/eclipse/cs321/GHORMAN_Assign2/src/A2TEST.rtf"); 	    
		Scan sc = new Scan (file); 
	    
		//An object of type Instructions<Instruction> is created & filled using Scan.readfile
	    Instructions<Instruction> instructions = new Instructions<Instruction>();
	    instructions = Scan.readFile();
		
	    //Prints out the machine language which was scanned 
		System.out.println("The Machine Language scanned from the file:");
		System.out.println(instructions.toString());
		
		//Excecutes & Prints out the output of this TML while excecuting
		System.out.println("The output from this TML is:");
		instructions.excecuteAll();
		
		//prints the final values of the registers
		System.out.println("\nThe final values of the registers:");
		instructions.printRegs();
	
	}

}
