package statements.functions.math;

public class Cos extends FloatMath {

	@Override
	protected double mathOp(double arg) {
		return Math.cos(arg);
	}

	@Override
	public String name() {
		return "cos";
	}
}
