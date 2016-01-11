package statements.functions.list;

import java.util.List;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.MutableList;
import statements.PushBits;
import statements.PushChar;
import statements.PushInteger;
import statements.PushString;

public class Unswons extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		AbstractStatement a = stackState.pop();
		if(a instanceof PushString) {
			stackState.push(new PushString(((PushString)a).extractValue().substring(1)));
			stackState.push(new PushChar(((PushString)a).extractValue().charAt(0)));
		} else if (a instanceof PushBits) {
			stackState.push(new PushBits(((PushBits)a).extractValue().rest()));
			stackState.push(new PushInteger(((PushBits)a).extractValue().first()));
		} else {
			if(stackState.canPop()) {
				// Optimized cdr
				AbstractStatement temp = ((MutableList)a).extractBody().remove(0);
				stackState.push(a);
				stackState.push(temp);
			} else {
				List<AbstractStatement> list = ((MutableList)a).extractBody();
				stackState.push(new MutableList(list.subList(1, list.size())));
				stackState.push(list.get(0));
			}
		}
	}

	@Override
	public String toString() {
		return "unswons";
	}
}
