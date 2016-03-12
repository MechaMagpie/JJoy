package statements.functions.file;

import java.io.File;
import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.functions.BinaryFunction;
import statements.literals.PushString;
import statements.literals.PushTruth;

public class Frename extends BinaryFunction<PushString, PushString> {

	@Override
	protected void eval(NoBracesStack stackState, PushString p1, PushString p2) throws EvaluationException {
		File oldPath = new File(p1.stringValue());
		stackState.push(new PushTruth(oldPath.renameTo(new File(p2.stringValue()))));
	}

	@Override
	public String name() {
		return "frename";
	}

}
