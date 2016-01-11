package statements.functions.meta;

import java.util.ListIterator;

import javax.swing.plaf.nimbus.AbstractRegionPainter;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.ListStatement;
import statements.MutableList;

/*
 * Official documentation:
 * 
 * case : X [..[X Y]..] -> Y i
 * Indexing on the value of X, execute the matching Y
 *   
 * This is somewhat misleading, should be read
 * 
 * case : X [[X Y] .. [Z]] - Y i
 * Tests each sublist, if first member equals X executes rest of sublist 
 * and exits, else pushes X back onto the stack and executes Z
 */

public class Case extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		MutableList lst = (MutableList) stackState.pop();
		ListIterator<AbstractStatement> iter = lst.listIterator();
		AbstractStatement x = stackState.pop();
		while(iter.nextIndex() < lst.extractBody().size() - 1) {
			MutableList l = (MutableList) iter.next();
			if(l.extractBody().get(0).equals(x)) {
				l.extractBody().remove(0);
				l.dequote(stackState);
				return;
			}
		}
		stackState.push(x);
		((MutableList) iter.next()).dequote(stackState);
	}

	@Override
	public String toString() {
		return "case";
	}
}
