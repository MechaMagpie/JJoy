package statements.functions.file;

import java.io.IOException;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.ArgumentSizeException;
import statements.functions.MismatchedArgumentsException;
import statements.functions.TernaryFunction;
import statements.literals.FileHandle;
import statements.literals.PushInteger;

public class Fseek extends TernaryFunction<FileHandle, PushInteger, PushInteger> {

	@Override
	protected void eval(NoBracesStack stackState, FileHandle s, PushInteger p, PushInteger w)
			throws MismatchedArgumentsException, EvaluationException {
		stackState.push(s);
		if(w.longValue() < 0 || w.longValue() > 2)
			throw new ArgumentSizeException(name(), w.longValue());
		try {
			s.getFile().fseek(p.longValue(), w.longValue());
		} catch (IOException e) {
			throw new FileIOError(name(), s.toString());
		}
			
	}

	@Override
	public String name() {
		return "fseek";
	}

}
