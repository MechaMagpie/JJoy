package statements.functions;

import java.io.IOException;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.literals.PushString;

public class SystemCall extends UnaryFunction<PushString> {

	@Override
	protected void eval(NoBracesStack stackState, PushString a) throws EvaluationException {
		try {
			Process run = Runtime.getRuntime().exec(a.stringValue());
			run.waitFor();
		} catch (IOException e) {
			// I have no idea what to do here
			e.printStackTrace();
		} catch (InterruptedException e) {
			// This should be unreachable
			e.printStackTrace();
		}
		
	}

	@Override
	public String name() {
		return "system";
	}

}
