package statements.functions;

import interpreter.NoBracesStack;
import statements.literals.LiteralStatement;
import statements.literals.PushInteger;

public class Ord extends UnaryFunction<LiteralStatement> {

	@Override
	public void eval(NoBracesStack stackState, LiteralStatement a) {
		stackState.push(new PushInteger(a.longValue()));
	}
	
	@Override
	public String name() {
		return "ord";
	}
}
