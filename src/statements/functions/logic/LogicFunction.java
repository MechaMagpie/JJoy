package statements.functions.logic;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.BinaryFunction;
import statements.functions.MismatchedArgumentsException;
import statements.literals.Logical;
import statements.literals.PushBits;
import statements.literals.PushTruth;
import util.ModuloBitset;

public abstract class LogicFunction extends BinaryFunction<Logical, Logical> {

	@Override
	protected void eval(NoBracesStack stackState, Logical a, Logical b) throws EvaluationException {
		if(a instanceof PushBits && b instanceof PushBits)
			stackState.push(new PushBits(setCase(((PushBits)a).setValue(), ((PushBits)b).setValue())));
		else if(a instanceof PushTruth && b instanceof PushTruth)
			stackState.push(new PushTruth(boolCase(((PushTruth)a).boolValue(), ((PushTruth)b).boolValue())));
		else throw new MismatchedArgumentsException(a.getClass(), b.getClass());
	}

	protected abstract boolean boolCase(boolean a, boolean b);

	protected abstract ModuloBitset setCase(ModuloBitset a, ModuloBitset b);
}
