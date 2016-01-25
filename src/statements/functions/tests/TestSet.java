package statements.functions.tests;

import statements.AbstractStatement;
import statements.literals.PushBits;

public class TestSet extends TypeTest {

	@Override
	protected boolean typeTest(AbstractStatement a) {
		return a instanceof PushBits;
	}

	@Override
	public String name() {
		return "set";
	}

}
