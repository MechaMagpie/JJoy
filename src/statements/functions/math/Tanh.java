package statements.functions.math;

public class Tanh extends FloatMath {

	@Override
	protected double mathOp(double arg) {
		return Math.tanh(arg);
	}

	@Override
	public String name() {
		return "tanh";
	}
}
