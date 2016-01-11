package statements.functions.list;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.MutableList;
import statements.PushBits;
import statements.PushChar;
import statements.PushInteger;
import statements.PushString;

public class At extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		PushInteger i = (PushInteger) stackState.pop();
		AbstractStatement a = stackState.pop();
		if(a instanceof PushString) {
			stackState.push(new PushChar(((PushString)a).extractValue().charAt(i.extractValue().intValue())));
		} else if (a instanceof PushBits) {
			stackState.push(new PushInteger(((PushBits)a).extractValue().get(i.extractValue())));
		} else {
			stackState.push(((MutableList)a).extractBody().get(i.extractValue().intValue()));
		}
	}

	@Override
	public String toString() {
		return "at";
	}
}