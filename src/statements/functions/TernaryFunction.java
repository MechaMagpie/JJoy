package statements.functions;

import java.lang.reflect.ParameterizedType;
import java.util.NoSuchElementException;

import interpreter.NoBracesStack;
import statements.EvaluationException;

public abstract class TernaryFunction<T, U, V>
		extends AbstractFunction {

	@SuppressWarnings("unchecked")
	@Override
	public void eval(NoBracesStack stackState) throws EvaluationException {
		V c;
		U b;
		T a;
		try{
			c = (V) stackState.pop();
		} catch (NoSuchElementException e) {
			throw new NoArgumentException(toString(), 2);
		} catch (ClassCastException e) {
			throw new ArgumentTypeException(
					toString(),
					((Class<V>)(((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1])),
					0
					);
		}
		try{
			b = (U) stackState.pop();
		} catch (NoSuchElementException e) {
			throw new NoArgumentException(toString(), 2);
		} catch (ClassCastException e) {
			throw new ArgumentTypeException(
					toString(),
					((Class<U>)(((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1])),
					0
					);
		}
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
		eval(stackState, a, b, c);
	}

	protected abstract void eval(NoBracesStack stackState, T a, U b, V c) throws MismatchedArgumentsException;

}
