package statements.functions.math;

public class Tan extends FloatMath {

	@Override
	protected double mathOp(double arg) {
		return Math.tan(arg);
	}

	@Override
	public String name() {
		return "tan";
	}
}
