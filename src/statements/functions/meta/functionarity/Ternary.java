package statements.functions.meta.functionarity;

public class Ternary extends AryFunction {

	@Override
	protected int getArity() {
		return 3;
	}

	@Override
	public String name() {
		return "ternary";
	}

}
