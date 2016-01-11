package statements;

import java.util.LinkedList;
import java.util.ListIterator;

import interpreter.NoBracesStack;
import statements.functions.math.Abs;

public class ListedList extends ListStatement {

	public ListedList(LinkedList<AbstractStatement> list) {
		super(list);
	}

	@Override
	public void eval(NoBracesStack stackState) {
		stackState.push(this.instantiate());
	}

	private AbstractStatement instantiate() {
		ListIterator<AbstractStatement> iter = body.listIterator();
		while(iter.hasNext()) {
			AbstractStatement a = iter.next();
			if(a instanceof ListedList) {
				iter.set(((ListedList) a).instantiate());
			}
		}
		return new MutableList(body);
	}

}
