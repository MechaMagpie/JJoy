package statements.functions;

import javax.print.attribute.IntegerSyntax;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.PushInteger;
import statements.PushString;

public class Strtol extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		PushInteger i = (PushInteger) stackState.pop();
		PushString s = (PushString) stackState.pop();
		int radix;
		String tempStr = s.extractValue(); 
		if(i.extractValue() == 0) radix = 10;
		if(tempStr.startsWith("0x")) {
			radix = 16;
			tempStr = tempStr.substring(2);
		}
		else if(tempStr.startsWith("0")) {
			radix = 8;
			tempStr = tempStr.substring(1);
		}
		else {
			radix = i.extractValue().intValue();
		}
		stackState.push(new PushInteger(Long.parseLong(tempStr, radix)));
	}

	@Override
	public String toString() {
		return "strtol";
	}
}
