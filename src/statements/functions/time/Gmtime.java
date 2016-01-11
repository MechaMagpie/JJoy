package statements.functions.time;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.TimeZone;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.MutableList;
import statements.PushInteger;
import statements.PushTruth;

public class Gmtime extends AbstractStatement {

	@Override
	public void eval(NoBracesStack stackState) {
		PushInteger i = (PushInteger) stackState.pop();
		Calendar cal = Calendar.getInstance();
		Date date = new Date(i.extractValue() * 1000);
		cal.setTime(date);
		cal.setTimeZone(TimeZone.getTimeZone("GMT"));
		LinkedList<AbstractStatement> list = new LinkedList<AbstractStatement>();
		list.add(new PushInteger(cal.get(Calendar.YEAR)));
		list.add(new PushInteger(cal.get(Calendar.MONTH) + 1));
		list.add(new PushInteger(cal.get(Calendar.DAY_OF_MONTH)));
		list.add(new PushInteger(cal.get(Calendar.HOUR_OF_DAY)));
		list.add(new PushInteger(cal.get(Calendar.MINUTE)));
		list.add(new PushInteger(cal.get(Calendar.SECOND)));
		list.add(new PushTruth(TimeZone.getDefault().inDaylightTime(date)));
		list.add(new PushInteger(cal.get(Calendar.DAY_OF_YEAR) - 1));
		list.add(new PushInteger((cal.get(Calendar.DAY_OF_WEEK) - 1) == 0 ? 7 : cal.get(Calendar.DAY_OF_WEEK) - 1));
		stackState.push(new MutableList(list));
	}

	@Override
	public String toString() {
		return "gmtime";
	}
}
