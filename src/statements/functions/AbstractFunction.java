package statements.functions;

import statements.AbstractStatement;

public abstract class AbstractFunction extends AbstractStatement {

	@Override
	public final String toString() {
		return name();
	}
}
