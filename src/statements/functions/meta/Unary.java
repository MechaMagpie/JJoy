package statements.functions.meta;

public class Unary extends AryFunction {

	@Override
	protected int getArity() {
		return 1;
	}
	
	@Override
	public String name() {
		return "unary";
	}
}
