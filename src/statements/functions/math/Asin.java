package statements.functions.math;

public class Asin extends FloatMath {

	@Override
	public String name() {
		return "asin";
	}

	@Override
	protected double mathOp(double arg) {
		return Math.asin(arg);
	}

}
