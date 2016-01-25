package statements.functions.meta;

import java.util.ListIterator;
import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.BinaryFunction;
import statements.functions.MalformedListException;
import statements.literals.MutableList;

/*
 * Official documentation:
 * 
 * case : X [..[X Y]..] -> Y i
 * Indexing on the value of X, execute the matching Y
 *   
 * This is somewhat misleading, should be read
 * 
 * case : X [[X Y] .. [Z]] -> Y i
 * Tests each sublist, if first member equals X executes rest of sublist 
 * and exits, else pushes X back onto the stack and executes Z
 */

public class Case extends BinaryFunction<AbstractStatement, MutableList> {

	@Override
	protected void eval(NoBracesStack stackState, AbstractStatement a, MutableList b) throws EvaluationException {
		ListIterator<AbstractStatement> iter = b.listIterator();
		try{
			while(iter.nextIndex() < b.body().size() - 1) {
				MutableList l = (MutableList) iter.next();
				if(l.body().get(0).equals(a)) {
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
