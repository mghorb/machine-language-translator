
public class Operand extends Instruction {
	
	//two operands s1 & s2 - common only to Operation instructions
	int s1;
	int s2;
	
	//default constructor
	Operand(){
		label = null;
		operator = null;
		r = 0;
		s1 = 0;
		s2 = 0;
	}
	
	//constructor
	Operand(String thisLab, String thisOp, int thisR, int thisS1, int thisS2){
		label = thisLab;
		operator = thisOp;
		r = thisR;
		s1 = thisS1;
		s2 = thisS2;
	}
	
	//excecutes instruction (operation)
	public void excecute() {
		
		//initialize value to go into register  to 0
		int x = 0;
		
		//if add, add two values in operand registers
		if (operator.equals("add")) {
			x = Instructions.register[s1] + Instructions.register[s2];
		}
		
		//if sub, subtract two values in operand registers
		if (operator.equals("sub")) {
			x = Instructions.register[s1] - Instructions.register[s2];
		}
		
		//if mul, multiply two values in operand registers
		if (operator.equals("mul")) {
			x = Instructions.register[s1] * Instructions.register[s2];
		}
		
		//if div, divide two values in operand registers
		if (operator.equals("div")) {
			//try/catch exception, if s2 equals 0 (cant divide by 0)
			try {
				x = (int) (Instructions.register[s1] / Instructions.register[s2]);
			} catch (ArithmeticException e) {
				System.out.println ("Cannot divide a number by 0.");
			}
		}
		
		//load value x into register[r]
		Instructions.loadRegister(r, x);
		
	}
	
	//toString implementation of the instruction
	public String toString() {
		
		return (this.label + " " + this.operator + " " + r + " " + s1 + " " + s2);
		
	}
	
}//closes class
