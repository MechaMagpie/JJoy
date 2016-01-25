package statements.functions.tests;

import parser.UserDef;
import statements.AbstractStatement;

public class TestUser extends TypeTest {

	@Override
	protected boolean typeTest(AbstractStatement a) {
		return a instanceof UserDef;
	}

	@Override
	public String name() {
		return "user";
	}

}
