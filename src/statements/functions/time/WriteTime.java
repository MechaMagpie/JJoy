package statements.functions.time;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.TimeZone;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.UnaryFunction;
import statements.literals.MutableList;
import statements.literals.PushInteger;
import statements.literals.PushTruth;

public abstract class WriteTime extends UnaryFunction<PushInteger> {

	@Override
	protected void eval(NoBracesStack stackState, PushInteger a) throws EvaluationException {
		Calendar cal = Calendar.getInstance();
		Date date = new Date(a.longValue() * 1000);
		cal.setTime(date);
		if(gmt())
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

	protected abstract boolean gmt();
}
