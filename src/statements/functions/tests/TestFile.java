package statements.functions.tests;

import statements.AbstractStatement;
import statements.literals.FileHandle;

public class TestFile extends TypeTest {

	@Override
	protected boolean typeTest(AbstractStatement a) {
		return a instanceof FileHandle;
	}

	@Override
	public String name() {
		return "file";
	}

}
