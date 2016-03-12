package statements.functions.file;

import java.io.IOException;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.BinaryFunction;
import statements.literals.FileHandle;

public class Fput extends BinaryFunction<FileHandle, AbstractStatement> {

	@Override
	protected void eval(NoBracesStack stackState, FileHandle s, AbstractStatement x) throws EvaluationException {
		stackState.push(s);
		try {
			s.getFile().fput(x);
		} catch (IOException e) {
			throw new FileIOError(this.toString(), s.toString());
		}
	}

	@Override
	public String name() {
		return "fput";
	}

}
