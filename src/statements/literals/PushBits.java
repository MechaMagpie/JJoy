package statements.literals;

import java.util.Iterator;
import java.util.Set;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import util.ModuloBitset;

public class PushBits extends AggregateStatement implements Logical {
	//Hardcoded to 64 members, should be easy to extend to arbitrary size
	private ModuloBitset value;

	public PushBits(ModuloBitset value) {
		this.value = value;
	}
	public PushBits(Set<Long> numbers) {
		value = new ModuloBitset(numbers);
	}

	@Override
	public String toString() {
		return value.toString();
	}
	@Override
	public void eval(NoBracesStack stackState) throws EvaluationException {
		stackState.push(this);
	}
	@Override
	public String name() {
		return " set type";
	}
	public ModuloBitset setValue() {
		return value;
	}
	@Override
	public boolean matchingType(AbstractStatement m) {
		return m instanceof PushInteger;
	}
	@Override
	public long size() {
		return value.size();
	}
	
	@Override
	public Iterator<AbstractStatement> iterator() {
		return value.iterator();
	}
}
