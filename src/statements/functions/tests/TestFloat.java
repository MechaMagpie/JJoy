package statements.functions.tests;

import statements.AbstractStatement;
import statements.literals.PushFloat;

public class TestFloat extends TypeTest {

	@Override
	protected boolean typeTest(AbstractStatement a) {
		return a instanceof PushFloat;
	}

	@Override
	public String name() {
		return "float";
	}

}
