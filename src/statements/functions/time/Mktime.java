package statements.functions.time;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TimeZone;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.ListStatement;
import statements.MutableList;
import statements.PushInteger;
import statements.PushTruth;

public class Mktime extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		MutableList t = (MutableList) stackState.pop();
		ListIterator<AbstractStatement> iter = t.listIterator();
		Calendar cal = Calendar.getInstance();
		cal.set(((PushInteger)iter.next()).extractValue().intValue(), 
				((PushInteger)iter.next()).extractValue().intValue() - 1,
				((PushInteger)iter.next()).extractValue().intValue(), 
				((PushInteger)iter.next()).extractValue().intValue(), 
				((PushInteger)iter.next()).extractValue().intValue(), 
				((PushInteger)iter.next()).extractValue().intValue());
		stackState.push(new PushInteger(cal.getTimeInMillis() / 1000));
		
	}

	@Override
	public String toString() {
		return "mktime";
	}
}
