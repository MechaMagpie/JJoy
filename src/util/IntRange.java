package util;

import java.util.Iterator;

public class IntRange implements Iterable<Integer> {
	private int from, to, step;
	
	public IntRange(int to) {
		this.from = 0; this.to = to; this.step = 1;
	}
	
	public IntRange(int from, int to) {
		this.from = from; this.to = to; this.step = 1;
	}
	
	public IntRange(int from, int to, int step) {
		this.from = from; this.to = to; this.step = step;
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return new intIterator();
	}
	
	private class intIterator implements Iterator<Integer> {
		private int counter = from;
		
		@Override
		public boolean hasNext() {
			return counter + step <= to;
		}

		@Override
		public Integer next() {
			return (counter = counter + step) - step;
		}

		@Override
		public void remove() {
			//This does nothing
		}
		
	}

}
