package statements.functions;

import java.io.StringReader;

import interpreter.NoBracesStack;
import parser.Parser;
import statements.EvaluationException;
import statements.literals.PushString;

public class Intern extends UnaryFunction<PushString> {
	Parser parser;
	
	public Intern(Parser parser) {
		this.parser = parser;
	}
	
	@Override
	protected void eval(NoBracesStack stackState, PushString a) throws EvaluationException {
		stackState.push(parser.parseSingle(new StringReader(a.stringValue())));
	}

	@Override
	public String name() {
		return "intern";
	}

}
