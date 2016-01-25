package statements.functions.math;

public class Rem extends BinaryMath {

	@Override
	protected double floatMath(double a, double b) {
		return a % b;
	}

	@Override
	protected long intMath(long a, long b) {
		return a % b;
	}

	@Override
	public String name() {
		return "rem";
	}
}
