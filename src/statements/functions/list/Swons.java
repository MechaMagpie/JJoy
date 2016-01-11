package statements.functions.list;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.MutableList;
import statements.PushChar;
import statements.PushInteger;
import statements.PushBits;
import statements.PushString;

public class Swons extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		AbstractStatement a = stackState.pop();
		AbstractStatement x = stackState.pop();
		if(a instanceof PushBits) {
			stackState.push(new PushBits(((PushBits)a).extractValue().add(((PushInteger)x).extractValue().longValue())));
		} else if (a instanceof PushString) {
			stackState.push(new PushString(((PushChar)x).extractValue() + ((PushString)a).extractValue()));
		} else {
			((MutableList)a).extractBody().add(0, x);
			stackState.push(a); 
		}
	}

	@Override
	public String toString() {
		return "cons";
	}
}
