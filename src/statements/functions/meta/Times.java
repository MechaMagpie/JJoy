package statements.functions.meta;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.BinaryFunction;
import statements.literals.ListStatement;
import statements.literals.PushInteger;

public class Times extends BinaryFunction<PushInteger, ListStatement> {

	@Override
	protected void eval(NoBracesStack stackState, PushInteger a, ListStatement b) throws EvaluationException {
		for(long i = 0; i < a.longValue(); i++)
			b.dequote(stackState);
	}

	@Override
	public String name() {
		return "times";
	}
}
