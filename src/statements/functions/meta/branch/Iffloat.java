package statements.functions.meta.branch;

import statements.literals.PushFloat;

public class Iffloat extends TypeBranch {

	@Override
	protected Class<?> typeChecked() {
		return PushFloat.class;
	}

	@Override
	public String name() {
		return "iffloat";
	}

}
