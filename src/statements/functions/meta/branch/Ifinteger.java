package statements.functions.meta.branch;

import statements.literals.PushInteger;

public class Ifinteger extends TypeBranch {

	@Override
	protected Class<?> typeChecked() {
		return PushInteger.class;
	}

	@Override
	public String name() {
		return "ifinteger";
	}

}
