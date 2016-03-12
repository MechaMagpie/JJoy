package statements.functions.file;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.UnaryFunction;
import statements.literals.FileHandle;
import statements.literals.PushTruth;

public class Ferror extends UnaryFunction<FileHandle> {

	@Override
	protected void eval(NoBracesStack stackState, FileHandle a) throws EvaluationException {
		stackState.push(a);
		stackState.push(new PushTruth(a.getFile().ferror()));
	}

	@Override
	public String name() {
		return "ferror";
	}

}
