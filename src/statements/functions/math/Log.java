package statements.functions.math;

public class Log extends FloatMath {

	@Override
	protected double mathOp(double arg) {
		return Math.log(arg);
	}

	@Override
	public String name() {
		return "log";
	}
}
