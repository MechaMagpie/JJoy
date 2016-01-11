package statements.functions.list;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.MutableList;
import statements.PushBits;
import statements.PushChar;
import statements.PushInteger;
import statements.PushString;

public class Size extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		AbstractStatement a = stackState.pop();
		PushInteger i = (PushInteger) stackState.pop();
		if(a instanceof PushString) {
			stackState.push(new PushInteger(((PushString)a).extractValue().length()));
		} else if (a instanceof PushBits) {
			stackState.push(new PushInteger(((PushBits)a).extractValue().size()));
		} else {
			stackState.push(new PushInteger(((MutableList)a).extractBody().size()));
		}
	}

}
