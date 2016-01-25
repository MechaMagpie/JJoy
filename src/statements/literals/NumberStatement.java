package statements.literals;

public abstract class NumberStatement extends LiteralStatement {

	public abstract NumberStatement negate();
	
	public abstract double doubleValue();
}
