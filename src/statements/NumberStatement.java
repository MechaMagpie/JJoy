package statements;

public abstract class NumberStatement extends LiteralStatement {

	@Override
	public abstract Number extractValue();

	public abstract NumberStatement negate();

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof NumberStatement)) return false;
		return extractValue().equals(((NumberStatement)obj).extractValue());
	}
}
