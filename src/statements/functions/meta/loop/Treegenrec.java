package statements.functions.meta.loop;

import java.util.LinkedList;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.QuaternaryFunction;
import statements.literals.ListStatement;
import statements.literals.MutableList;

public class Treegenrec extends QuaternaryFunction<AbstractStatement, ListStatement, ListStatement, ListStatement> {

	@Override
	protected void eval(NoBracesStack stackState, AbstractStatement t, ListStatement o1, ListStatement o2,
			ListStatement c) throws EvaluationException {
		stackState.push(t);
		if(!(t instanceof MutableList)) {
			o1.dequote(stackState);
		} else {
			o2.dequote(stackState);
			LinkedList<AbstractStatement> tempLst = new LinkedList<AbstractStatement>();
			tempLst.add(o1); tempLst.add(o2); tempLst.add(c); tempLst.add(this);
			MutableList recur = new MutableList(tempLst);
			stackState.push(recur);
			c.dequote(stackState);
		}
			
	}

	@Override
	public String name() {
		return "treegenrec";
	}

}
