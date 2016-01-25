package statements.functions.tests;

import statements.AbstractStatement;
import statements.literals.ListStatement;

public class TestList extends TypeTest {

	@Override
	protected boolean typeTest(AbstractStatement a) {
		return a instanceof ListStatement;
	}

	@Override
	public String name() {
		return "list";
	}

}
