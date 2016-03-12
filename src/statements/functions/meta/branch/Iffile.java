package statements.functions.meta.branch;

import statements.literals.FileHandle;

public class Iffile extends TypeBranch {

	@Override
	protected Class<?> typeChecked() {
		return FileHandle.class;
	}

	@Override
	public String name() {
		return "iffile";
	}

}
