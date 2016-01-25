package statements.functions.math;

public class Ceil extends FloatMath {

	@Override
	protected double mathOp(double arg) {
		return Math.ceil(arg);
	}

	@Override
	public String name() {
		return "ceil";
	}

}
