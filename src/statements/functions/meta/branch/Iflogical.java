package statements.functions.meta.branch;

import statements.literals.PushTruth;

public class Iflogical extends TypeBranch {

	@Override
	protected Class<?> typeChecked() {
		return PushTruth.class;
	}

	@Override
	public String name() {
		return "iflogical";
	}

}
