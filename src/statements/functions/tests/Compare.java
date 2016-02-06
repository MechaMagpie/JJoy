package statements.functions.tests;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.BinaryFunction;
import statements.functions.MismatchedArgumentsException;
import statements.literals.NumericValue;
import statements.literals.PushInteger;

@SuppressWarnings("rawtypes")
public class Compare extends BinaryFunction<Comparable, Comparable> {


	@SuppressWarnings("unchecked")
	@Override
	protected void eval(NoBracesStack stackState, Comparable a, Comparable b) throws EvaluationException {
		if(a instanceof NumericValue != b instanceof NumericValue)
			throw new MismatchedArgumentsException(a.getClass(), b.getClass());
		stackState.push(new PushInteger(a.compareTo(b)));

	}

	@Override
	public String name() {
		return "compare";
	}

}
