package statements.functions.tests;

import statements.AbstractStatement;
import statements.literals.PushString;

public class TestString extends TypeTest {

	@Override
	protected boolean typeTest(AbstractStatement a) {
		return a instanceof PushString;
	}

	@Override
	public String name() {
		return "string";
	}

}
