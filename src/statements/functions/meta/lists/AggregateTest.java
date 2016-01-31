package statements.functions.meta.lists;

import java.util.Iterator;
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
import statements.literals.PushTruth;
import util.ModuloBitset;

public abstract class AggregateTest extends BinaryFunction<AggregateStatement, ListStatement> {

	@Override
	protected void eval(NoBracesStack stackState, AggregateStatement a, ListStatement b) throws EvaluationException {
		if(a instanceof PushString) {
			StringBuilder pass = new StringBuilder(), fail = new StringBuilder();
			for(int i = 0; i < a.size(); i++) {
				char chr = ((PushString)a).stringValue().charAt(i);
				stackState.push(new PushChar(chr));
				if(runTest(stackState, b))
					pass.append(chr);
				else
					fail.append(chr);
			}
			decide(stackState, new PushString(pass.toString()), new PushString(fail.toString()));
		} else if (a instanceof PushBits) {
			ModuloBitset pass = new ModuloBitset(), fail = new ModuloBitset();
			for(long i = 0; i < a.size(); i++) {
				long num = ((PushBits)a).setValue().get(i);
				stackState.push(new PushInteger(num));
				if(runTest(stackState, b))
					pass.add(i);
				else
					fail.add(i);
			}
			decide(stackState, new PushBits(pass), new PushBits(fail));
		} else {
			LinkedList<AbstractStatement> pass = new LinkedList<AbstractStatement>(), fail = new LinkedList<AbstractStatement>();
			Iterator<AbstractStatement> iter = ((MutableList)a).listIterator();
			while(iter.hasNext()) {
				AbstractStatement member = iter.next();
				stackState.push(member.dup());
				if(runTest(stackState, b))
					pass.addLast(member);
				else
					fail.addLast(member);
			}
			decide(stackState, new MutableList(pass), new MutableList(fail));
		}
	}
	
	private boolean runTest(NoBracesStack stackState, ListStatement b) throws WrongYieldException {
		LimitedRemoveStack tempStk = new LimitedRemoveStack(stackState, 1);
		b.dequote(tempStk);
		tempStk.close();
		AbstractStatement yield = stackState.pop();
		if(!(yield instanceof PushTruth))
			throw new WrongYieldException(name(), PushTruth.class, yield.getClass());
		return ((PushTruth)yield).boolValue();
	}
	
	protected abstract void decide(NoBracesStack stackState, AggregateStatement pass, AggregateStatement fail);
}
