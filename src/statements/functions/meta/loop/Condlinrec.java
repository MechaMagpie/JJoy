package statements.functions.meta.loop;

import java.util.LinkedList;

import interpreter.LimitedRemoveStack;
import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.MalformedListException;
import statements.functions.UnaryFunction;
import statements.functions.meta.WrongYieldException;
import statements.literals.MutableList;
import statements.literals.PushTruth;

public class Condlinrec extends UnaryFunction<MutableList> {

	@Override
	protected void eval(NoBracesStack stackState, MutableList a) throws EvaluationException {
		LinkedList<MutableList> r2s;
		try {
			MutableList end = (MutableList) a.body().removeLast();
			r2s = new LinkedList<MutableList>();
			recursion : for(;;) {
				for(AbstractStatement stmt : a.body()) {
					MutableList ci = (MutableList) stmt;
					LimitedRemoveStack tempStk = new LimitedRemoveStack(stackState, 0);
					((MutableList)ci.body().get(0)).dequote(tempStk);
					tempStk.close();
					AbstractStatement yield = stackState.pop();
					if(!(yield instanceof PushTruth))
						throw new WrongYieldException(name(), PushTruth.class, yield.getClass());
					if(((PushTruth)yield).boolValue()) {
						if(ci.size() == 2) {
							((MutableList) ci.body().get(1)).dequote(stackState);
							break recursion;
						} else if(ci.size() == 3){
							((MutableList)ci.body().get(1)).dequote(stackState);
							r2s.addLast(((MutableList)ci.body().get(2)));
							continue recursion;
						} else
							throw new MalformedListException(name(), a.body().toString());
					}
				}
				end.dequote(stackState);
				break recursion;
			}
		} catch (ClassCastException e) {
			throw new MalformedListException(name(), a.body().toString());
		} catch (IndexOutOfBoundsException e) {
			throw new MalformedListException(name(), a.body().toString());
		}
		for(MutableList r2 : r2s) {
			r2.dequote(stackState);
		}
	}

	@Override
	public String name() {
		return "condlinrec";
	}

}
