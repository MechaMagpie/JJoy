package statements.functions.list;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.MutableList;

public class Unstack extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		MutableList list = (MutableList) stackState.pop();
		stackState.clear();
		stackState.addAll(list.extractBody());
	}

	@Override
	public String toString() {
		return "unstack";
	}
}
