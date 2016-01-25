package statements.functions.logic;

import util.ModuloBitset;

public class And extends LogicFunction {

	@Override
	protected boolean boolCase(boolean a, boolean b) {
		return a && b;
	}

	@Override
	protected ModuloBitset setCase(ModuloBitset a, ModuloBitset b) {
		return a.and(b);
	}

	@Override
	public String name() {
		return "and";
	}
}
