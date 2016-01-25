package statements.functions;

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
		stackState.push(parser.parseSingle(a.stringValue()));
	}

	@Override
	public String name() {
		return "intern";
	}

}
