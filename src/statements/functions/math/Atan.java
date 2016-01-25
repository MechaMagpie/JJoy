package statements.functions.math;

public class Atan extends FloatMath {
	
	@Override
	public String name() {
		return "atan";
	}

	@Override
	protected double mathOp(double arg) {
		return Math.atan(arg);
	}
}
