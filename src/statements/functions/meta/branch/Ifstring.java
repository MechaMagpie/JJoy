package statements.functions.meta.branch;

import statements.literals.PushString;

public class Ifstring extends TypeBranch {

	@Override
	protected Class<?> typeChecked() {
		return PushString.class;
	}

	@Override
	public String name() {
		return "ifstring";
	}

}
