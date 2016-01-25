package statements.functions.tests;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.UnaryFunction;
import statements.literals.AggregateStatement;
import statements.literals.DataType;
import statements.literals.LiteralStatement;
import statements.literals.PushTruth;

public class Nulltest extends UnaryFunction<DataType> {

	@Override
	protected void eval(NoBracesStack stackState, DataType a) throws EvaluationException {
		if(a instanceof AggregateStatement) {
			stackState.push(new PushTruth(((AggregateStatement) a).size() == 0));
		} else {
			stackState.push(new PushTruth(((LiteralStatement)a).longValue() == 0));
		}
	}

	@Override
	public String name() {
		return "null";
	}

}
