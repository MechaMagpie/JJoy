package statements.functions.math;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.NumberStatement;
import statements.PushFloat;
import statements.PushInteger;

public class Frexp extends AbstractStatement {

	//TODO: make this work again
	@Override
	public void eval(NoBracesStack stackState) {
		double n1 = ((NumberStatement) stackState.pop()).extractValue().doubleValue();
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
	public String toString() {
		return "frexp";
	}
}
