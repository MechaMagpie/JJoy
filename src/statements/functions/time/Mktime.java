package statements.functions.time;

import java.util.Calendar;
import java.util.ListIterator;
import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.functions.MalformedListException;
import statements.functions.UnaryFunction;
import statements.literals.MutableList;
import statements.literals.PushInteger;

public class Mktime extends UnaryFunction<MutableList> {

	@Override
	public void eval(NoBracesStack stackState, MutableList t) throws MalformedListException {
		ListIterator<AbstractStatement> iter = t.listIterator();
		Calendar cal = Calendar.getInstance();
		try {
		cal.set((int)((PushInteger)iter.next()).longValue(), 
				(int)((PushInteger)iter.next()).longValue() - 1,
				(int)((PushInteger)iter.next()).longValue(), 
				(int)((PushInteger)iter.next()).longValue(), 
				(int)((PushInteger)iter.next()).longValue(), 
				(int)((PushInteger)iter.next()).longValue());
		} catch (ClassCastException e) {
			throw new MalformedListException(name(), t.toString());
		}
		stackState.push(new PushInteger(cal.getTimeInMillis() / 1000));
		
	}

	@Override
	public String name() {
		return "mktime";
	}
}
