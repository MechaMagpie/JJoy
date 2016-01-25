package statements.functions.logic;

import util.ModuloBitset;

public class Or extends LogicFunction {

	@Override
	protected boolean boolCase(boolean a, boolean b) {
		return a || b;
	}

	@Override
	protected ModuloBitset setCase(ModuloBitset a, ModuloBitset b) {
		return a.or(b);
	}

	@Override
	public String name() {
		return "or";
	}
}
