package statements.functions.meta;

import statements.EvaluationException;

@SuppressWarnings("serial")
public class WrongYieldException extends EvaluationException {

	private String name;
	private Class<?> expected, actual;

	public WrongYieldException(String name, Class<?> expected, Class<?> actual) {
		this.name = name;
		this.expected = expected;
		this.actual = actual;
	}
	
	public WrongYieldException(String name, Class<?> actual) {
		this.name = name;
		this.actual = actual;
		this.expected = null;
	}
}
