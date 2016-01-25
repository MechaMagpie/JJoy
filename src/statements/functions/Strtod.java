package statements.functions;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.literals.PushFloat;
import statements.literals.PushString;

public class Strtod extends UnaryFunction<PushString> {
	
	@Override
	protected void eval(NoBracesStack stackState, PushString a) throws EvaluationException {
		stackState.push(new PushFloat(Double.parseDouble(a.stringValue())));
	}

	@Override
	public String name() {
		return "strtod";
	}
}
