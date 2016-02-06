package statements.literals;

import statements.AbstractStatement;

public abstract class AggregateStatement extends DataType implements Iterable<AbstractStatement> {
	protected static final long number = Long.MAX_VALUE - 1;

	public abstract boolean matchingType(AbstractStatement b);
	public abstract long size();
}
