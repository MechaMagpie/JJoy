package statements.functions.tests;

import statements.AbstractStatement;
import statements.literals.PushChar;

public class TestChar extends TypeTest {

	@Override
	protected boolean typeTest(AbstractStatement a) {
		return a instanceof PushChar;
	}

	@Override
	public String name() {
		return "char";
	}

}
