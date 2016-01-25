package statements.functions;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import statements.literals.PushInteger;
import statements.literals.PushString;

public class Strtol extends BinaryFunction<PushString, PushInteger> {
	
	@Override
	protected void eval(NoBracesStack stackState, PushString a, PushInteger b) throws EvaluationException {
		int radix;
		String tempStr = a.stringValue();
		if(b.longValue() == 0) radix = 10;
		if(tempStr.startsWith("0x")) {
			radix = 16;
			tempStr = tempStr.substring(2);
		}
		else if(tempStr.startsWith("0")) {
			radix = 8;
			tempStr = tempStr.substring(1);
		}
		else {
			radix = (int) b.longValue();
		}
		stackState.push(new PushInteger(Long.parseLong(tempStr, radix)));
	}

	@Override
	public String name() {
		return "strtol";
	}
}
