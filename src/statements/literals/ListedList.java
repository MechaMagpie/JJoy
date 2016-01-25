package statements.literals;

import java.util.LinkedList;
import interpreter.NoBracesStack;
import statements.AbstractStatement;

public class ListedList extends ListStatement {

	public ListedList(LinkedList<AbstractStatement> list) {
		super(list);
	}

	@Override
	public void eval(NoBracesStack stackState) {
		stackState.push(this.instantiate());
	}

	private AbstractStatement instantiate() {
		LinkedList<AbstractStatement> tempLst = new LinkedList<AbstractStatement>();
		for(AbstractStatement a : body) {
			if(a instanceof ListedList) 
				tempLst.add(((ListedList) a).instantiate());
			else 
				tempLst.add(a);
		}

		return new MutableList(tempLst);
	}
}
