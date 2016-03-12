package statements.functions.file;

import java.io.IOException;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.BinaryFunction;
import statements.literals.FileHandle;
import statements.literals.PushString;

public class Fputchars extends BinaryFunction<FileHandle, PushString> {

	@Override
	protected void eval(NoBracesStack stackState, FileHandle s, PushString str) throws EvaluationException {
		stackState.push(s);
		try {
			s.getFile().fputchars(str.stringValue());
		} catch (IOException e) {
			throw new FileIOError(this.toString(), s.toString());
		}
	}

	@Override
	public String name() {
		return "fputchars";
	}

}
