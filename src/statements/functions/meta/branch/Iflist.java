package statements.functions.meta.branch;

import statements.literals.ListStatement;

public class Iflist extends TypeBranch {

	@Override
	protected Class<?> typeChecked() {
		return ListStatement.class;
	}

	@Override
	public String name() {
		return "iflist";
	}

}
