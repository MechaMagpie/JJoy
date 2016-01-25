package statements.functions;

import java.lang.reflect.ParameterizedType;
import java.util.NoSuchElementException;

import interpreter.NoBracesStack;
import statements.EvaluationException;

public abstract class QuinaryFunction<T, U, V, W, X>
		extends AbstractFunction {

	@SuppressWarnings("unchecked")
	@Override
	public void eval(NoBracesStack stackState) throws EvaluationException {
		X e;
		W d;
		V c;
		U b;
		T a;
		try{
			e = (X) stackState.pop();
		} catch (NoSuchElementException ex) {
			throw new NoArgumentException(toString(), 2);
		} catch (ClassCastException ex) {
			throw new ArgumentTypeException(
					toString(),
					((Class<X>)(((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1])),
					0
					);
		}
		try{
			d = (W) stackState.pop();
		} catch (NoSuchElementException ex) {
			throw new NoArgumentException(toString(), 2);
		} catch (ClassCastException ex) {
			throw new ArgumentTypeException(
					toString(),
					((Class<W>)(((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1])),
					0
					);
		}
		try{
			c = (V) stackState.pop();
		} catch (NoSuchElementException ex) {
			throw new NoArgumentException(toString(), 2);
		} catch (ClassCastException ex) {
			throw new ArgumentTypeException(
					toString(),
					((Class<V>)(((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1])),
					0
					);
		}
		try{
			b = (U) stackState.pop();
		} catch (NoSuchElementException ex) {
			throw new NoArgumentException(toString(), 2);
		} catch (ClassCastException ex) {
			throw new ArgumentTypeException(
					toString(),
					((Class<U>)(((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1])),
					0
					);
		}
		try{
			a = (T) stackState.pop();
		} catch (NoSuchElementException ex) {
			throw new NoArgumentException(toString(), 2);
		} catch (ClassCastException ex) {
			throw new ArgumentTypeException(
					toString(),
					((Class<T>)(((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1])),
					0
					);
		}
		eval(stackState, a, b, c, d, e);
	}

	protected abstract void eval(NoBracesStack stackState, T a, U b, V c, W d, X e);
}
