package statements.functions;

import java.lang.reflect.ParameterizedType;
import java.util.NoSuchElementException;

import interpreter.NoBracesStack;
import statements.EvaluationException;

public abstract class UnaryFunction<T> extends AbstractFunction {

	@SuppressWarnings("unchecked")
	@Override
	public void eval(NoBracesStack stackState) throws EvaluationException {
		T a;
		try{
			a = (T) stackState.pop();
		} catch (NoSuchElementException e) {
			throw new NoArgumentException(toString(), 2);
		} catch (ClassCastException e) {
			throw new ArgumentTypeException(
					toString(),
					((Class<T>)(((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0])), 
					0);
		}
		eval(stackState, a);
	}

	protected abstract void eval(NoBracesStack stackState, T a) throws EvaluationException;
}
