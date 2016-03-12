package statements.functions;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.literals.PushString;

public final class Putchars extends UnaryFunction<PushString> {

	@Override
	protected void eval(NoBracesStack stackState, PushString a) throws EvaluationException {
		System.out.println(a.stringValue());
	}

	@Override
	public String name() {
		return "putchars";
	}

}
