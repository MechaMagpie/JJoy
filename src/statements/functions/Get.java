package statements.functions;

import java.io.InputStreamReader;

import interpreter.NoBracesStack;
import parser.Parser;
import statements.EvaluationException;

public class Get extends AbstractFunction {
	Parser parser;
	
	public Get(Parser parser) {
		this.parser = parser;
	}
	
	@Override
	public void eval(NoBracesStack stackState) throws EvaluationException {
		stackState.push(parser.parseSingle(new InputStreamReader(System.in)));
	}

	@Override
	public String name() {
		return "intern";
	}
}
