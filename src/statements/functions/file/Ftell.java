package statements.functions.file;

import java.io.IOException;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.UnaryFunction;
import statements.literals.FileHandle;
import statements.literals.PushInteger;

public class Ftell extends UnaryFunction<FileHandle> {

	@Override
	protected void eval(NoBracesStack stackState, FileHandle s) throws EvaluationException {
		stackState.push(s);
		try {
			stackState.push(new PushInteger(s.getFile().ftell()));
		} catch (IOException e) {
			throw new FileIOError(name(), s.toString());
		}
	}

	@Override
	public String name() {
		return "ftell";
	}

}
