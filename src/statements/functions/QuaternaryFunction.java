package statements.functions;

import java.lang.reflect.ParameterizedType;
import java.util.NoSuchElementException;

import interpreter.NoBracesStack;
import statements.EvaluationException;

public abstract class QuaternaryFunction<T, U, V, W>
		extends AbstractFunction {

	@SuppressWarnings("unchecked")
	@Override
	public void eval(NoBracesStack stackState) throws EvaluationException {
		W d;
		V c;
		U b;
		T a;
		try{
			d = (W) stackState.pop();
		} catch (NoSuchElementException e) {
			throw new NoArgumentException(toString(), 2);
		} catch (ClassCastException e) {
			throw new ArgumentTypeException(
					toString(),
					((Class<W>)(((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1])),
					0
					);
		}
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
					((Class<T>)(((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1])),
					0
					);
		}
		eval(stackState, a, b, c, d);
	}

	protected abstract void eval(NoBracesStack stackState, T a, U b, V c, W d);

}
