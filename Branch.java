
public class Branch extends Instruction{
	
	//instance variable common to branch instructions
	//l2 is the label of the instruction to branch to
	String l2;
	
	//boolean branchs will hold true if we need to branch to another instruction
	boolean branches;
	
	//default constructor
	Branch (){
		label = null;
		operator = null;
		r = 0;
		l2 = null;
		branches = false;
	}
	
	//constructor
	Branch (String thisLab, String thisOp, int thisR, String thisL2){
		label = thisLab;
		operator = thisOp;
		r = thisR;
		l2 = thisL2;
		branches = false; 
	}
	
	//excecute the instruction (decide whether to branch to another instruction or not)
	public void excecute() {
		//the reason the excecute defines whether branchs is true or false
		//is so that when we add other branch instructions such as beq, bgz, etc.
		//it easier to implement them 

		//if the operator is "bnz" - register not equal to 0
		if (operator.equals("bnz")) {
			//if register not equal to 0, then branchs is true
			if (Instructions.register[r] != 0)
				branches = true;
			//otherwise, branch is false
			else 
				branches = false;
		}
		
	}
	
	//returns whether to branch to another instruction or not
	public boolean branch() {
		return branches;
	}
	
	//String implementation of the instruction
	public String toString() {
		
		return (this.label + " " + this.operator + " " + r + " " + l2);
		
	}
	
}//end class
