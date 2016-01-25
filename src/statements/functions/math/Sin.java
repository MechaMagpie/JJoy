package statements.functions.math;

public class Sin extends FloatMath {

	@Override
	protected double mathOp(double arg) {
		return Math.sin(arg);
	}

	@Override
	public String name() {
		return "sin";
	}
}
