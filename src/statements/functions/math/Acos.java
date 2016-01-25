package statements.functions.math;

public class Acos extends FloatMath {
	@Override
	public String name() {
		return "acos";
	}

	@Override
	protected double mathOp(double arg) {
		return Math.acos(arg);
	}
}
