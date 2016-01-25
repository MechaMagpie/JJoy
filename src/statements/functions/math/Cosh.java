package statements.functions.math;

public class Cosh extends FloatMath {

	@Override
	protected double mathOp(double arg) {
		return Math.cosh(arg);
	}

	@Override
	public String name() {
		return "cosh";
	}
}
