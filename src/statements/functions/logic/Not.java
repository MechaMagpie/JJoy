package statements.functions.logic;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.UnaryFunction;
import statements.literals.Logical;
import statements.literals.PushBits;
import statements.literals.PushTruth;

public class Not extends UnaryFunction<Logical> {

	@Override
	protected void eval(NoBracesStack stackState, Logical a) throws EvaluationException {
		if(a instanceof PushBits)
			stackState.push(new PushBits(((PushBits)a).setValue().comp()));
		else
			stackState.push(new PushTruth(!((PushTruth) a).boolValue()));
	}

	@Override
	public String name() {
		return "not";
	}
}
