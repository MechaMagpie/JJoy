package statements.functions;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.literals.PushChar;

public class Putch extends UnaryFunction<PushChar> {

	@Override
	protected void eval(NoBracesStack stackState, PushChar a) throws EvaluationException {
		System.out.println(a.charValue());
	}

	@Override
	public String name() {
		return "putch";
	}

}
