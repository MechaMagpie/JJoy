package interpreter;

import parser.Program;
import parser.ProgramEvaluator;

public class EP implements ProgramEvaluator {
	private NoBracesStack stack;
	
	public EP() {
		stack = new NoBracesStack();
	}

	@Override
	public void eval(Program program) {
		try {
		program.eval(stack);
		} catch(Exception e) {
			e.printStackTrace();
		}
		if(!stack.isEmpty()) System.out.println(stack.pop());
	}

}
