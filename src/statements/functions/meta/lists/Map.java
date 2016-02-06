package statements.functions.meta.lists;

import java.util.LinkedList;
import interpreter.LimitedRemoveStack;
import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.BinaryFunction;
import statements.functions.meta.WrongYieldException;
import statements.literals.AggregateStatement;
import statements.literals.ListStatement;
import statements.literals.MutableList;
import statements.literals.PushBits;
import statements.literals.PushChar;
import statements.literals.PushInteger;
import statements.literals.PushString;
import util.ModuloBitset;

public class Map extends BinaryFunction<AggregateStatement, ListStatement> {

	@Override
	protected void eval(NoBracesStack stackState, AggregateStatement a, ListStatement b) throws EvaluationException {
		LinkedList<AbstractStatement> results = new LinkedList<AbstractStatement>();
		for(AbstractStatement m : a) {
			LimitedRemoveStack tempStk = new LimitedRemoveStack(stackState, 0);
			tempStk.push(m);
			b.dequote(tempStk);
			tempStk.close();
			AbstractStatement r0 = stackState.pop();
			if(!a.matchingType(r0))
				throw new WrongYieldException(name(), r0.getClass());
		}
		if(a instanceof PushString) {
			StringBuilder sb = new StringBuilder();
			for (AbstractStatement chr : results) {
				sb.append(((PushChar)chr).charValue());
			}
			stackState.push(new PushString(sb.toString()));
		} else if(a instanceof PushBits) {
			ModuloBitset tempSet = new ModuloBitset();
			for(AbstractStatement num : results) {
				tempSet.add(((PushInteger)num).longValue());
			}
			stackState.push(new PushBits(tempSet));
		}
		else {
			stackState.push(new MutableList(results));
		}
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return null;
	}

}
