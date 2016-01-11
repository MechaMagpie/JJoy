package statements.functions.math;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.LiteralStatement;

public class Max extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		LiteralStatement n2 = (LiteralStatement) stackState.pop();
		LiteralStatement n1 = (LiteralStatement) stackState.pop();
		Comparable v2 = (Comparable) n2.extractValue();
		Comparable v1 = (Comparable) n1.extractValue();
		try {
		if(v1.compareTo(v2) > 0) 
			stackState.push(n1);
		else
			stackState.push(n2);
		} catch (ClassCastException e) {
			throw new RuntimeException("Can't compare dissimilar types");
			//TODO: better exception
		}
	}

	@Override
	public String toString() {
		return "max";
	}
}
