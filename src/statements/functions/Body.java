package statements.functions;

import interpreter.NoBracesStack;
import parser.UserDef;
import statements.EvaluationException;
import statements.literals.MutableList;

public class Body extends UnaryFunction<UserDef> {

	@Override
	protected void eval(NoBracesStack stackState, UserDef a) throws EvaluationException {
		stackState.push(new MutableList(a.getBody()));
	}

	@Override
	public String name() {
		return "body";
	}

}
