package statements.functions;

import java.io.FileNotFoundException;
import java.io.FileReader;

import interpreter.NoBracesStack;
import parser.Parser;
import statements.EvaluationException;
import statements.functions.file.FileIOError;
import statements.literals.PushString;

public class Include extends UnaryFunction<PushString> {
	private Parser parser;
	
	public Include(Parser parser) {
		this.parser = parser;
	}

	@Override
	protected void eval(NoBracesStack stackState, PushString a) throws EvaluationException {
		try {
			FileReader fr = new FileReader(a.stringValue());
			parser.parseFully(fr);
		} catch (FileNotFoundException e) {
			throw new FileIOError(name(), a.stringValue());
		}
		
	}

	@Override
	public String name() {
		return "include";
	}

}
