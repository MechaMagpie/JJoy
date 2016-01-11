package interpreter;

import java.util.LinkedList;

import statements.AbstractStatement;

@SuppressWarnings("serial")
public class LimitedRemoveStack extends NoBracesStack {
	private NoBracesStack stack;
	private int arity;
	private LinkedList<AbstractStatement> topStack;
	private LinkedList<AbstractStatement> poppedStack;
	
	public LimitedRemoveStack(NoBracesStack stack, int arity) {
		this.stack = stack;
		this.arity = arity;
		topStack = new LinkedList<AbstractStatement>();
		poppedStack = new LinkedList<AbstractStatement>();
	}
	
	@Override
	public AbstractStatement pop() {
		if(!topStack.isEmpty()) {
			return topStack.pop();
		} else {
			poppedStack.push(stack.pop());
			return poppedStack.peek();
		}
	}
	
	@Override
	public void push(AbstractStatement stat) {
		topStack.push(stat);
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
	public boolean canPop() {
		return arity - poppedStack.size() > 0;
	}
}
