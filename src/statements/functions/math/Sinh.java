package statements.functions.math;

public class Sinh extends FloatMath {

	@Override
	protected double mathOp(double arg) {
		return Math.sinh(arg);
	}

	@Override
	public String name() {
		return "sinh";
	}
}
