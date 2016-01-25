package statements.functions;

import statements.AbstractStatement;

public abstract class AbstractFunction extends AbstractStatement {

	@Override
	public String toString() {
		return name();
	}
}
