package interpreter;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import statements.AbstractStatement;

@SuppressWarnings("serial")
public class NoBracesStack extends LinkedList<AbstractStatement> {
	private Random rand;
	private boolean stopping = false, quitting = false;

	public NoBracesStack() {
		super();
		rand = new Random();
	}
	
	public NoBracesStack(LinkedList<AbstractStatement> body) {
		super(body);
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
	
	@Override
	public String toString() {
		Iterator<AbstractStatement> iter = super.descendingIterator();
		StringBuilder sb = new StringBuilder();
		while(iter.hasNext()) {
			sb.append(iter.next());
			sb.append(" ");
		}
		if(sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public boolean shouldStop() {
		return stopping;
	}

	public boolean shouldQuit() {
		return quitting;
	}
	
	public void stop() {
		stopping = true;
	}
	
	public void resume() {
		stopping = false;
	}
	
	public void quit() {
		quitting = true;
	}
}
