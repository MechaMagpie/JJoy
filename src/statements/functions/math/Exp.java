package statements.functions.math;

public class Exp extends FloatMath {

	@Override
	protected double mathOp(double arg) {
		return Math.exp(arg);
	}

	@Override
	public String name() {
		return "arg";
	}
}
