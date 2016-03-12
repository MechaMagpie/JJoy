package statements.functions.file;

import java.io.IOException;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.BinaryFunction;
import statements.literals.FileHandle;
import statements.literals.PushString;
import util.JoyFile;

public class Fopen extends BinaryFunction<PushString, PushString> {

	@Override
	protected void eval(NoBracesStack stackState, PushString p, PushString m) throws EvaluationException {
		try {
			stackState.push(new FileHandle(new JoyFile(p.stringValue(), m.stringValue())));
		} catch (IOException e) {
			throw new FileIOError(this.toString(), p.toString());
		}
	}

	@Override
	public String name() {
		return "fopen";
	}

}
