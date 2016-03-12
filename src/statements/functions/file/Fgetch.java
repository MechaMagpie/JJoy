package statements.functions.file;

import java.io.IOException;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.UnaryFunction;
import statements.literals.FileHandle;
import statements.literals.PushChar;

public class Fgetch extends UnaryFunction<FileHandle> {

	@Override
	protected void eval(NoBracesStack stackState, FileHandle a) throws EvaluationException {
		stackState.push(a);
		try {
			stackState.push(new PushChar(a.getFile().fgetch()));
		} catch (IOException e) {
			throw new FileIOError(this.toString(), a.toString());
		}
	}

	@Override
	public String name() {
		return "fgetch";
	}

}
