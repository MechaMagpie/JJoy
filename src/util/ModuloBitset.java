package util;

import java.util.NoSuchElementException;
import java.util.Set;

public class ModuloBitset {
	private long value;
	public static final long setSize = 64;
	
	private ModuloBitset(long value) {
		this.value = value;
	}
	
	public ModuloBitset(Set<Long> numbers) {
		value = 0;
		for(long l : numbers) {
			value |= 1L << (l % setSize + setSize) % setSize;
		}
	}

	public ModuloBitset add(long index) {
		return new ModuloBitset(value | 1L << (index % setSize + setSize) % setSize);
	}

	public long first() {
		for(long i = 0; i < setSize; i++) {
			if((value & 1L << i) != 0) {
				return i;
			}
		}
		//TODO: better exception
		throw new NoSuchElementException("Empty set");
	}

	public ModuloBitset rest() {
		if(value == 0) throw new NoSuchElementException("Empty set");
		for(long i = 0; i < setSize; i++) {
			if((value & 1L << i) != 0) {
				return new ModuloBitset(value ^ 1L << i);
			}
		}
		//TODO: better exception
		throw new NoSuchElementException("Empty set");
	}
	
	@Override
	public String toString() {
		if(value == 0) return "{}";
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for(long i = 0; i < setSize; i++) {
			if((value & 1L << i) != 0) {
				sb.append(i);
				sb.append(" ");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("}");
		return sb.toString();
	}

	public ModuloBitset xor(ModuloBitset arg1) {
		return new ModuloBitset(this.value ^ arg1.value);
	}

	public ModuloBitset or(ModuloBitset arg1) {
		return new ModuloBitset(this.value | arg1.value);
	}

	public ModuloBitset comp() {
		return new ModuloBitset(~this.value);
	}

	public ModuloBitset and(ModuloBitset arg1) {
		return new ModuloBitset(this.value & arg1.value);
	}
	
	public ModuloBitset subSet(long start, long end) {
		if(start > size() || end > size() || end < start)
			//TODO: better exception
			throw new ArrayIndexOutOfBoundsException();
		long newVal = value;
		for(long i = start, j = 0; i > 0;j++) {
			if((1L << j & newVal) != 0) {
				newVal ^= 1L << j;
				i--;
			}
		}
		for(long i = size() - end, j = setSize; i > 0; j--) {
			if((1L << j & newVal) != 0) {
				newVal ^= 1L << j;
				i--;
			}
		}
		return new ModuloBitset(newVal);
	}

	public long get(long index) {
		for(long i = 0, j = 0; i < setSize; i++) {
			if((value & 1L << i) != 0) {
				if(j == index)
					return i;
				j++;
			}
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	
	public boolean contains(long index) {
		return (index | value) != 0;
	}
	
	public long size() {
		long n = 0;
		for(long i = 0; i < setSize; i++) 
			if((value & 1L << i) != 0)
				n++;
		return n;
	}
}
