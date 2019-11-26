import java.util.ArrayList;

public class Instructions<Instruction> {
	
	//instance variable - holds a list of all the instructions that are scanned
	ArrayList<Instruction> instructions;
	
	//static variable - can be accessed from other classes
	static int [] register;
	
	//default construction
	Instructions (){
		//create a new arraylist of type Instruction
		ArrayList<Instruction> a = new ArrayList<Instruction>();
		instructions = a;
		
		//create a new array of size 32 (32 registers)
		int [] b = new int[32];
		register = b;
	}
	
	//loads the value into appropriate register
	public static void loadRegister(int r, int x) {
		
		register[r] = x;
		
	}
	
	//adds instruction into list
	public void addInstruct(Instruction i) {
		
		instructions.add(i);
		
	}
	
	//excecute all commands in the instructions list
	public void excecuteAll() {
		
		//declare the index value -- used to iterate
		int index = 0;
		
		//use a while loop to traverse list  
		//a while loop allows easier index change (ex. jumping to a previous instruction)
		while (index < instructions.size()) {
			//get the instruction from the arraylist at specified index 
			Instruction i = instructions.get(index);
			
			//since the class Instruction has subclasses, we cannot instantize it 
			//so, i is seperated into the possible instances it could be
			if (i instanceof Operand) {
				//create a new object of type Operand b/c excecute() is not static
				Operand j = new Operand();
				j = (Operand) i;
				
				//now we can call the excecute method to excecute operation
				j.excecute();
				
				//after performing operation, increment the index
				index++;
			}
			
			if (i instanceof Store) {
				//create a new object of type Store b/c excecute() is not static
				Store j = new Store();
				j = (Store) i;
				
				//now we can call the excecute method to excecute operation
				j.excecute();
				
				//after excecuting operation, increment the index
				index++;
			}
			
			if (i instanceof Print) {
				//create a new object of type Print b/c excecute() is not static
				Print j = new Print();
				j = (Print) i;
				
				//now we can call the excecute method to excecute operation
				j.excecute();
				
				//after excecuting operation, increment the index
				index++;
			}
			
			if (i instanceof Branch) {
				//create a new object of type Print b/c excecute() is not static
				Branch j = new Branch();
				j = (Branch) i;
				
				//call excecute(), which decides whether to branch to another instruction
				j.excecute();
				
				//if we need to branch
				if (j.branch()) {
					//get the index of the next instuction from the branchTo method
					//l2 is the label of the insturction to branch to
					index = branchTo(j.l2);
				}
				else {
					//if we dont need to branch, increment the index to the next instruction
					index++;
				}
			}

		}//closes while loop
		
	}
	
	//this method finds the index of the instruction to branch to (l2 is the label to branch to)
	public int branchTo(String l2){
		//initialize index at 0
		int index = 0;
		
		//for loop of the Arraylist instructions 
		//to search instruction  with the paramatized label (to branch to)
		for (Instruction i : instructions) {
			//because the label of an instruction is an instance variable
			//a new object is needed to be able to get the label of the instance
			//in each case, create a new object of the subtype, equate it to current 
			//iterated instruction, and compare its label to the label we are searching for
			
			if (i instanceof Operand) {
				//create new object of type Operand
				Operand k = new Operand();
				k = (Operand) i;
				
				//if the instruction's label equals the label we are searching for
				if (k.label.equals(l2)) {
					//return the index of that instruction
					return index;
				}
			}	
			if (i instanceof Store) {
				//create new object of type Store
				Store k = new Store();
				k = (Store) i;
				
				//if the instruction's label equals the label we are searching for
				if (k.label.equals(l2)) {
					//return the index of that instruction
					return index;
				}
			}
			if (i instanceof Print) {
				//create new object of type Print
				Print k = new Print();
				k = (Print) i;
				
				//if the instruction's label equals the label we are searching for
				if (k.label.equals(l2)) {
					//return the index of that instruction
					return index;
				}
			}
			if (i instanceof Branch) {
				//create new object of type Branch
				Branch k = new Branch();
				k = (Branch) i;
				
				//if the instruction's label equals the label we are searching for
				if (k.label.equals(l2)) {
					//return the index of that instruction
					return index;
				}
			}
			//increment the index with each iteration
			index++;
			
		}//closes for loop
		
		return index;
		
	}
	
	//the toString implementation of the ArrayLIST of instructions
	public String toString() {
	
		//declare a string to gather the instructions 
		String ins = "";
		
		//for each instruction in the list, call the instruction's respective subclass toString()
		//and add it to the string
		for (Instruction i : instructions) {
			ins = ins + i.toString() + "\n";
		}
		
		return ins;
		
	}
	
	//method that prints a table of the current stored values in the register
	public void printRegs() {
		
		//prints index row name
		System.out.printf("%6s", "index|");
		
		//prints index of each register (0-31), fromatted
		for (int i=0; i<register.length; i++) {
			System.out.printf( "%4s", i + "|");
		}
		
		//format table (to seperate the two rows with appropriate number of dashes)
		System.out.printf("\n%6s", "-----+");
		for (int i=0; i<register.length; i++) {
			System.out.printf( "%4s", "---+");
		}
		
		//prints value row name
		System.out.printf("\n%6s", "value|");
		
		//prints the stored value in the respective register
		for (int i : register) {
			System.out.printf( "%4s", i + "|");
		}
		
	}
	
}//closes class
