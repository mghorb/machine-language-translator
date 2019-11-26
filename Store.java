
public class Store extends Instruction {
	
	//instance variable common to "sto" isntruction
	//x is the value to be stored in the register r
	int x;
	
	//default constructor
	Store(){
		label = null;
		operator = null;
		r = 0;
		x = 0;
	}
	
	//constructor
	Store(String thisLabel, String thisOp, int thisR, int thisX){
		label = thisLabel;
		operator = thisOp;
		r = thisR;
		x = thisX;
	}

	//executes instruction (store value)
	public void excecute() {
		
		//loads the value x into the register r
		Instructions.loadRegister(r, x);
		
	}
	
	//toString implementation of the instruction
	public String toString() {
		
		return (this.label + " " + this.operator + " " + r + " " + x);
		
	}

}//closes class
