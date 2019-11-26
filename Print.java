
public class Print extends Instruction{
	
	//instance variable common to "out" instruction
	//s1 is register whose value is to be printed
	int s1;
	
	//default constructor
	Print(){
		label = null;
		operator = null;
		s1 = 0;
	}
	
	//constructor
	Print(String thisLab, String thisOp, int thisS1){
		label = thisLab;
		operator = thisOp;
		s1 = thisS1;
	}
	
	//excexutes instruction (prints value)
	public void excecute() {
		
		//prints the value in the regiser indexed at s1
		System.out.println(Instructions.register[s1]);
		
	}
	
	//toString implementation of the instruction
	public String toString() {
		
		return (this.label + " " + this.operator + " " + s1);
		
	}
	
}//closes class
