package statements.functions.math;

public class Abs extends FloatMath {

	@Override
	public String name() {
		return "abs";
	}

	@Override
	protected double mathOp(double arg) {
		return Math.abs(arg);
	}
}
