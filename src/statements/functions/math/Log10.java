package statements.functions.math;

public class Log10 extends FloatMath {

	@Override
	protected double mathOp(double arg) {
		return Math.log10(arg);
	}

	@Override
	public String name() {
		return "log10";
	}
}
