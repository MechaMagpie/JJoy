package statements.functions.file;

import java.io.File;
import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.UnaryFunction;
import statements.literals.PushString;
import statements.literals.PushTruth;

public class Fremove extends UnaryFunction<PushString> {

	@Override
	protected void eval(NoBracesStack stackState, PushString p) throws EvaluationException {
		File oldPath = new File(p.stringValue());
		stackState.push(new PushTruth(oldPath.delete()));
	}

	@Override
	public String name() {
		return "fremove";
	}

}
