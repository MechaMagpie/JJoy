package statements.functions.math;

import interpreter.NoBracesStack;
import statements.functions.UnaryFunction;
import statements.literals.NumberStatement;
import statements.literals.PushFloat;
import statements.literals.PushInteger;

public class Frexp extends UnaryFunction<NumberStatement> {

	@Override
	protected void eval(NoBracesStack stackState, NumberStatement a) {
		double n1 = a.doubleValue();
		long bits = Double.doubleToLongBits(n1);
		long mantissa = (bits & ~0x7FF0000000000000L) | 1023L << 52;
		long exponent = ((bits & 0x7FF0000000000000L) >> 52);
		System.out.println(Long.toHexString(mantissa));
		System.out.println(Long.toHexString(exponent));
		if(exponent == 0x000L && (mantissa & 0x000FFFFFFFFFFFFFL) == 0x0000000000000L) {
			mantissa = 0;
		} else if(exponent == 0x7FF) {
			mantissa = mantissa | exponent << 52;
		} else {
			mantissa = mantissa ^ 1 << 52;
			exponent = exponent - 1022L;
		}
		stackState.push(new PushFloat(Double.longBitsToDouble(mantissa)));
		stackState.push(new PushInteger(exponent));
	}


	@Override
	public String name() {
		return "frexp";
	}
}
