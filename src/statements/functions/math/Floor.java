package statements.functions.math;

public class Floor extends FloatMath {

	@Override
	protected double mathOp(double arg) {
		return Math.floor(arg);
	}

	@Override
	public String name() {
		return "floor";
	}
}
