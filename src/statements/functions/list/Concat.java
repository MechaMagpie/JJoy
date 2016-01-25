package statements.functions.list;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.BinaryFunction;
import statements.functions.MismatchedArgumentsException;
import statements.literals.AggregateStatement;
import statements.literals.MutableList;
import statements.literals.PushBits;
import statements.literals.PushString;

public class Concat extends BinaryFunction<AggregateStatement, AggregateStatement> {

	@Override
	protected void eval(NoBracesStack stackState, AggregateStatement a, AggregateStatement b)
			throws EvaluationException {
		if(!a.getClass().isInstance(b))
			throw new MismatchedArgumentsException(a.getClass(), b.getClass());
		if(a instanceof PushString)
			stackState.push(new PushString(((PushString) a).stringValue() + ((PushString)b).stringValue()));
		else if(a instanceof PushBits)
			stackState.push(new PushBits(((PushBits)a).setValue().or(((PushBits)b).setValue())));
		else {
			if(stackState.canPop()) {
				((MutableList)a).body().addAll(((MutableList)b).body());
				stackState.push(a);
			} else {
				MutableList lst = (MutableList) a.dup();
				lst.body().addAll(((MutableList)b).body());
				stackState.push(lst);
			}
		}
	}

	@Override
	public String name() {
		return "concat";
	}

}
