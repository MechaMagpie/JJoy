package interpreter;

import parser.Program;
import parser.ProgramEvaluator;
import statements.EvaluationException;

public class EP implements ProgramEvaluator {
	private NoBracesStack stack;
	private boolean stopped = false;
	
	public EP() {
		stack = new NoBracesStack();
	}

	@Override
	public void eval(Program program) {
		try {
			stack.resume();
			program.eval(stack);
		} catch(EvaluationException e) {
			System.err.println(e.helpfulMessage());
		}
		System.out.println(stack);
		if(stack.shouldQuit()) {
			stopped = true;
			return;
		}
	}

	@Override
	public boolean stopped() {
		return stopped;
	}

}
