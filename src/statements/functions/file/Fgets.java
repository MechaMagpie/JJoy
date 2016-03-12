package statements.functions.file;

import java.io.IOException;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.UnaryFunction;
import statements.literals.FileHandle;
import statements.literals.PushString;

public class Fgets extends UnaryFunction<FileHandle> {

	@Override
	protected void eval(NoBracesStack stackState, FileHandle s) throws EvaluationException {
		stackState.push(s);
		try {
			stackState.push(new PushString(s.getFile().fgets()));
		} catch (IOException e) {
			throw new FileIOError(name(), s.toString());
		}
	}

	@Override
	public String name() {
		return "fgets";
	}

}
