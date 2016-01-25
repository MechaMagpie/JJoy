package statements.functions.meta;

import java.util.ListIterator;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.BinaryFunction;
import statements.functions.MalformedListException;
import statements.literals.MutableList;

public class Opcase extends BinaryFunction<AbstractStatement, MutableList> {

	@Override
	protected void eval(NoBracesStack stackState, AbstractStatement a, MutableList b) throws EvaluationException {
		ListIterator<AbstractStatement> iter = b.listIterator();
		try{
			while(iter.nextIndex() < b.body().size() - 1) {
				MutableList l = (MutableList) iter.next();
				if(l.body().get(0).getClass().isInstance(a)) {
					l.body().remove(0);
					l.dequote(stackState);
					return;
				}
			}
			stackState.push(a);
			((MutableList) iter.next()).dequote(stackState);
		} catch (ClassCastException e) {
			throw new MalformedListException(name(), b.toString());
		}
	}

	@Override
	public String name() {
		return "case";
	}
}
