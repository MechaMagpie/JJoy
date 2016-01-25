package statements.functions.tests;

public class Lt extends Comparison {

	@Override
	protected boolean test(int a) {
		return a < 0;
	}

	@Override
	public String name() {
		return "<";
	}

}
