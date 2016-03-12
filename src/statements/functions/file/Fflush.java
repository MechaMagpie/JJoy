package statements.functions.file;

import java.io.IOException;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.UnaryFunction;
import statements.literals.FileHandle;

public class Fflush extends UnaryFunction<FileHandle> {

	@Override
	protected void eval(NoBracesStack stackState, FileHandle a) throws EvaluationException {
		stackState.push(a);
		try {
			a.getFile().fflush();
		} catch (IOException e) {
			throw new FileIOError(this.toString(), a.toString());
		}
	}

	@Override
	public String name() {
		return "fflush";
	}

}
