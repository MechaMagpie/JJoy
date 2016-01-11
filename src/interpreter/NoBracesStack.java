package interpreter;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Stack;

import statements.AbstractStatement;

@SuppressWarnings("serial")
public class NoBracesStack extends LinkedList<AbstractStatement> {
	private Random rand;

	public NoBracesStack() {
		super();
		rand = new Random();
	}
	
	public AbstractStatement pop() {
		return super.poll();
	}
	
	public long random() {
		return rand.nextLong();
	}

	public boolean canPop() {
		return true;
	}
}
