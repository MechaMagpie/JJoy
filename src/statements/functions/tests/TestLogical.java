package statements.functions.tests;

import statements.AbstractStatement;
import statements.literals.PushTruth;

public class TestLogical extends TypeTest {

	@Override
	protected boolean typeTest(AbstractStatement a) {
		return a instanceof PushTruth;
	}

	@Override
	public String name() {
		return "logical";
	}

}
