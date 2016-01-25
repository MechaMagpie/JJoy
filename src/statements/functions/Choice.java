package statements.functions;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.literals.PushTruth;

public class Choice extends TernaryFunction<PushTruth, AbstractStatement, AbstractStatement> {

	@Override
	protected void eval(NoBracesStack stackState, PushTruth a, AbstractStatement b, AbstractStatement c) {
		if(a.boolValue())
			stackState.push(b);
		else
			stackState.push(c);
	}

	@Override
	public String name() {
		return "choice";
	}
}
