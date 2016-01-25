package statements.functions;

import interpreter.NoBracesStack;
import statements.literals.LiteralStatement;
import statements.literals.PushChar;
import statements.literals.PushInteger;
import statements.literals.PushTruth;

public class Chr extends UnaryFunction<LiteralStatement> {

	@Override
	public void eval(NoBracesStack stackState, LiteralStatement a) {
		if(a instanceof PushChar)
			stackState.push(a);
		else if (a instanceof PushTruth)
			stackState.push(new PushChar((char) (((PushTruth) a).boolValue() ? 1 : 0)));
		else
			stackState.push(new PushChar((char) ((PushInteger)a).longValue()));
	}

	@Override
	public String name() {
		return "chr";
	}
}
