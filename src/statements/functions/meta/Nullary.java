package statements.functions.meta;

import interpreter.LimitedRemoveStack;
import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.ListStatement;

public class Nullary extends AbstractStatement{

	@Override
	public void eval(NoBracesStack stackState) {
		ListStatement p = (ListStatement) stackState.pop();
		LimitedRemoveStack stackWrap = new LimitedRemoveStack(stackState, 0);
		p.dequote(stackWrap);
		stackWrap.close();
	}

	@Override
	public String toString() {
		return "nullary";
	}
}
