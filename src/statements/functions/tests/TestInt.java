package statements.functions.tests;

import statements.AbstractStatement;
import statements.literals.PushInteger;

public class TestInt extends TypeTest {

	@Override
	protected boolean typeTest(AbstractStatement a) {
		return a instanceof PushInteger;
	}

	@Override
	public String name() {
		return "integer";
	}

}
