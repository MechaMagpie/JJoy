package statements.functions.math;

public class Sqrt extends FloatMath {

	@Override
	protected double mathOp(double arg) {
		return Math.sqrt(arg);
	}

	@Override
	public String name() {
		return "sqrt";
	}
}
