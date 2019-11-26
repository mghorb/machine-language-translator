import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Scan {
	
	//static variable holds the file
	static File file;
	
	//default constructor
	Scan (){
		file = null;
	}
	
	//constructor
	Scan (File f){
		file = f;
	}
	
	//this method scans/reads each line from the file
	public static Instructions<Instruction> readFile(){
		
		//scans file ... try/catch File not found exception
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("This file does not exist. ");
			e.printStackTrace();
		} 
    
		//create an object of instructions - used to fill with instructions scanned
		Instructions<Instruction> instructions = new Instructions<Instruction>();
		
		//while there exists a next line, grep that next line
		while (sc.hasNextLine()) {
			
			String s = sc.nextLine();
			
			//if the nect line starts with f, it means its part of the label and an instruction
			if (s.startsWith("f")) {
				
				//create a new instructon object
				Instruction instruct = new Instruction();
				
				//"decipher" the string into an instruction
				instruct = decipher(s);
				//add the instruction to the instructions list
				instructions.addInstruct(instruct);
				
			}//closes if
			
		}//closes while loop
		
		//return the array of instructions scanned from the file
		return instructions;
		
	}
	
	//scans the string into its different elements
	public static Instruction decipher(String s) {
		//disclaimer of the scanner: when scanning a .rtf document, the scanner reads an "enter" as "\".
		//this is problematic because when reading the last token, the scanner will read the backslash
		//as a part of the String and inputs the values in wrong. I have only tried this with a .rtf file.
		//the only solution I have found so far is to add a " " after each last token in each line.
		
		//create Scanner object of string s
		Scanner sc = new Scanner(s);
		String label = null; 
		String operand = null;
		
		//if next begins with "f", then it is a label 
		String next = sc.next();
		if (next.startsWith("f")) {
			label = next;
		}
		
		//get the next string
		next = sc.next();
		
		//if the next is an operand instruction
		if (next.equals("add") || next.equals("sub") || next.equals("mul") || next.equals("div")) {
			//next token is operand 
			operand = next;
			//next integer is the register
			int r = sc.nextInt();
			//next intergers are the registers of the operands
			int s1 = sc.nextInt();
			int s2 = sc.nextInt();
			//create & return new Insruction with these parameters
			Instruction op = new Operand(label, operand, r, s1, s2);
			return op;
		}
		
		//if the next is a store instruction
		if (next.equals("sto")) {
			//next token is operand 
			operand = next;
			//next integer is the register
			int r = sc.nextInt();
			//next integer is the value to be stored
			int x = sc.nextInt();
			//create & return new Insruction with these parameters
			Instruction sto = new Store(label, operand, r, x);
			return sto;
		}
		
		//if the next is a print istruction
		if (next.equals("out")) {
			//next token is operand 
			operand = next;
			//next integer is the register whose value to output
			int s1 = sc.nextInt();
			//create & return new Insruction with these parameters
			Instruction out = new Print(label, operand, s1);
			return out;
		}
		
		//if the next is a branch isntruction
		if (next.equals("bnz")) {
			//next token is operand 
			operand = next;
			//next integer is register whose value to check 
			int s1 = sc.nextInt();
			//next token is label whose instruction to jump to  
			String l2 = sc.next();
			//create & return new Insruction with these parameters
			Instruction bnz = new Branch(label, operand, s1, l2);
			return bnz;
		}
		
		return new Instruction();
		
	}

}//closes class
