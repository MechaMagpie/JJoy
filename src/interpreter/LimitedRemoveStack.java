package interpreter;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;

import statements.AbstractStatement;
import statements.literals.ListStatement;

@SuppressWarnings("serial")
public class LimitedRemoveStack extends NoBracesStack {
	private NoBracesStack stack;
	private int arity;
	private LinkedList<AbstractStatement> topStack;
	private LinkedList<AbstractStatement> poppedStack;
	private boolean modFlag;
	
	public LimitedRemoveStack(NoBracesStack stack, int arity) {
		this.stack = stack;
		this.arity = arity;
		topStack = new LinkedList<AbstractStatement>();
		poppedStack = new LinkedList<AbstractStatement>();
	}
	
	@Override
	public AbstractStatement pop() {
		modFlag = true;
		if(!topStack.isEmpty()) {
			return topStack.pop();
		} else {
			poppedStack.push(stack.pop());
			if(poppedStack.peek() instanceof ListStatement)
				return poppedStack.peek().dup();
			else
				return poppedStack.peek();
		}
	}
	
	@Override
	public void push(AbstractStatement stat) {
		modFlag = true;
		topStack.push(stat);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(Collection<? extends AbstractStatement> c) {
		LinkedList<AbstractStatement> tempStk = new LinkedList<AbstractStatement>();
		while(!isEmpty()) tempStk.push(pop());
		Iterator<AbstractStatement> iter;
		if(c instanceof LinkedList) {		
			iter = ((LinkedList<AbstractStatement>)c).descendingIterator();
		} else {
			iter = (new LinkedList<AbstractStatement>(c)).descendingIterator();
		}
		while (iter.hasNext())
			push(iter.next());
		while(!tempStk.isEmpty())
			push(tempStk.pop());
		return true;
	}

	public void close() {
		int correct = arity - poppedStack.size();
		if(correct > 0)
			while(correct-- > 0)
				stack.pop();
		else
			while(correct++ < 0)
				stack.push(poppedStack.pop());
		stack.push(topStack.pop());
	}
	
	@Override
	public boolean isEmpty() {
		return topStack.isEmpty() && stack.isEmpty();
	}
	
	@Override
	public void clear() {
		while(!super.isEmpty()) pop();
	}
	
	@Override
	public Iterator<AbstractStatement> iterator() {
		return new DoubleIterator();
	}
	
	private class DoubleIterator implements Iterator<AbstractStatement> {
		private Iterator<AbstractStatement> topIter, mainIter;
		
		public DoubleIterator() {
			topIter = topStack.iterator();
			mainIter = iterator();
		}
		
		@Override
		public boolean hasNext() {
			if(modFlag) throw new ConcurrentModificationException();
			return topIter.hasNext() || mainIter.hasNext();
		}

		@Override
		public AbstractStatement next() {
			if(modFlag) throw new ConcurrentModificationException();
			if(topIter.hasNext()) return topIter.next();
			else return mainIter.next();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}