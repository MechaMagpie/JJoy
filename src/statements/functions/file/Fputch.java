package statements.functions.file;

import java.io.IOException;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.BinaryFunction;
import statements.literals.FileHandle;
import statements.literals.PushChar;

public class Fputch extends BinaryFunction<FileHandle, PushChar> {

	@Override
	protected void eval(NoBracesStack stackState, FileHandle s, PushChar c) throws EvaluationException {
		stackState.push(s);
		try {
			s.getFile().fputch(c.charValue());
		} catch (IOException e) {
			throw new FileIOError(this.toString(), s.toString());
		}
	}

	@Override
	public String name() {
		return "fputch";
	}

}
