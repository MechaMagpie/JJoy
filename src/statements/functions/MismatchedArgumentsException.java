package statements.functions;

import statements.EvaluationException;

@SuppressWarnings("serial")
public class MismatchedArgumentsException extends EvaluationException {
	private Class<?> arg0, arg1;

	public MismatchedArgumentsException(Class<?> arg0, Class<?> arg1) {
		this.arg0 = arg0;
		this.arg1 = arg1;
	}
}
