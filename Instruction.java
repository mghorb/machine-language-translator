
public class Instruction {
	
	//declare the three instance variables common to all commands
	public String label;
	public String operator;
	public int r;
	
	//default constructor
	Instruction(){
		label = null;
		operator = null;
		r = 0;
	}

	//excecutes the respective operation of the instruction
	public void excecute() {

	}
	
	//toString implementation of the instruction
	public String toString() {
		return null;
	}
}
