package statements.functions.meta.loop;

import java.util.LinkedList;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.MismatchedArgumentsException;
import statements.functions.TernaryFunction;
import statements.literals.ListStatement;
import statements.literals.MutableList;

public class Treerec extends TernaryFunction<AbstractStatement, ListStatement, ListStatement> {

	@Override
	protected void eval(NoBracesStack stackState, AbstractStatement t, ListStatement o, ListStatement c)
			throws MismatchedArgumentsException, EvaluationException {
		stackState.push(t);
		if(!(t instanceof MutableList)) {
			o.dequote(stackState);
		} else {
			LinkedList<AbstractStatement> tempLst = new LinkedList<AbstractStatement>();
			tempLst.add(o); tempLst.add(c); tempLst.add(this);
			MutableList recur = new MutableList(tempLst);
			stackState.push(recur);
			c.dequote(stackState);
		}
			
			
	}

	@Override
	public String name() {
		return "treerec";
	}

}
