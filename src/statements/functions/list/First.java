package statements.functions.list;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.ListStatement;
import statements.MutableList;
import statements.PushBits;
import statements.PushChar;
import statements.PushInteger;
import statements.PushString;

public class First extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		AbstractStatement a = stackState.pop();
		if(a instanceof PushString) {
			stackState.push(new PushChar(((PushString)a).extractValue().charAt(0)));
		} else if (a instanceof PushBits) {
			stackState.push(new PushInteger(((PushBits)a).extractValue().first()));
		} else {
			stackState.push(((MutableList)a).extractBody().get(0));
		}
	}

	@Override
	public String toString() {
		return "first";
	}
}
