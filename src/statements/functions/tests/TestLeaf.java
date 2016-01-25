package statements.functions.tests;

import statements.AbstractStatement;
import statements.literals.ListStatement;

public class TestLeaf extends TypeTest {

	@Override
	protected boolean typeTest(AbstractStatement a) {
		return !(a instanceof ListStatement);
	}

	@Override
	public String name() {
		return "leaf";
	}

}
