package statements.functions.list;

import java.util.List;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.MutableList;
import statements.PushBits;
import statements.PushChar;
import statements.PushInteger;
import statements.PushString;

public class Uncons extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		AbstractStatement a = stackState.pop();
		if(a instanceof PushString) {
			stackState.push(new PushChar(((PushString)a).extractValue().charAt(0)));
			stackState.push(new PushString(((PushString)a).extractValue().substring(1)));
		} else if (a instanceof PushBits) {
			stackState.push(new PushInteger(((PushBits)a).extractValue().first()));
			stackState.push(new PushBits(((PushBits)a).extractValue().rest()));
		} else {
			if(stackState.canPop()) {
				// Optimized cdr
				stackState.push(((MutableList)a).extractBody().remove(0));
				stackState.push(a);
			} else {
				List<AbstractStatement> list = ((MutableList)a).extractBody();
				stackState.push(list.get(0));
				stackState.push(new MutableList(list.subList(1, list.size())));
			}
		}
	}

	@Override
	public String toString() {
		return "uncons";
	}
}
