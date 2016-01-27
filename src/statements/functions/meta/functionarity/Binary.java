package statements.functions.meta.functionarity;

public class Binary extends AryFunction {

	@Override
	protected int getArity() {
		return 2;
	}

	@Override
	public String name() {
		return "binary";
	}

}
