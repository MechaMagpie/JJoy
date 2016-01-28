package statements.functions.meta.branch;

import statements.literals.PushChar;

public class Ifchar extends TypeBranch {

	@Override
	protected Class<?> typeChecked() {
		return PushChar.class;
	}

	@Override
	public String name() {
		return "ifchar";
	}

}
