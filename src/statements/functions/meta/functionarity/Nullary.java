package statements.functions.meta.functionarity;

public class Nullary extends AryFunction{

	@Override
	protected int getArity() {
		return 0;
	}

	@Override
	public String name() {
		return "nullary";
	}
}
