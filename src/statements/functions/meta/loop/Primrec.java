package statements.functions.meta.loop;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.ArgumentTypeException;
import statements.functions.MismatchedArgumentsException;
import statements.functions.TernaryFunction;
import statements.literals.AggregateStatement;
import statements.literals.ListStatement;
import statements.literals.PushInteger;

public class Primrec extends TernaryFunction<AbstractStatement, ListStatement, ListStatement> {

	@Override
	protected void eval(NoBracesStack stackState, AbstractStatement a, ListStatement b, ListStatement c)
			throws MismatchedArgumentsException, EvaluationException {
		if(!(a instanceof PushInteger || a instanceof AggregateStatement))
			throw new ArgumentTypeException(name(), PushInteger.class, 0);
		long count = 0;
		if(a instanceof AggregateStatement) {
			count = ((AggregateStatement) a).size();
			for(AbstractStatement m : (AggregateStatement) a)
				stackState.push(m);
		} else {
			count = ((PushInteger)a).longValue();
			for(long n = ((PushInteger)a).longValue(); n > 0; n--)
				stackState.push(new PushInteger(n));
		}
		b.dequote(stackState);
		for(;count > 0; count--) {
			c.dequote(stackState);
		}
	}

	@Override
	public String name() {
		return "primrec";
	}

}
