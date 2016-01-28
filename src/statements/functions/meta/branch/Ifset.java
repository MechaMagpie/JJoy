package statements.functions.meta.branch;

import statements.literals.PushBits;

public class Ifset extends TypeBranch {

	@Override
	protected Class<?> typeChecked() {
		return PushBits.class;
	}

	@Override
	public String name() {
		return "ifset";
	}

}
