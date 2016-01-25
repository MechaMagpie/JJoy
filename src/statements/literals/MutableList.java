package statements.literals;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import interpreter.NoBracesStack;
import statements.AbstractStatement;

public class MutableList extends ListStatement {

	public MutableList(List<AbstractStatement> list) {
		super(list);
	}

	private MutableList() {}

	@Override
	public void eval(NoBracesStack stackState) {
		stackState.push(this);
	}
	
	public ListIterator<AbstractStatement> listIterator() {
		return body.listIterator();
	}
	
	public LinkedList<AbstractStatement> body() {
		return super.body;
	}
	
	public void replaceBody(LinkedList<AbstractStatement> newBody) {
		super.body = newBody;
	}
	
	@Override
	public AbstractStatement dup() {
		LinkedList<AbstractStatement> tempLst = new LinkedList<AbstractStatement>();
		for(AbstractStatement a : body) {
			tempLst.add(a.dup());
		}
		MutableList m = new MutableList();
		m.body = tempLst;
		return m;
	}
}