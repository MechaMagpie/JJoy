package util;

import java.util.NoSuchElementException;
import java.util.Set;

public class ModuloBitset {
	private long value;
	public static final long size = 64;
	
	private ModuloBitset(long value) {
		this.value = value;
	}
	
	public ModuloBitset(Set<Long> numbers) {
		value = 0;
		for(long l : numbers) {
			value |= 1L << (l % size + size) % size;
		}
	}

	public ModuloBitset add(long index) {
		return new ModuloBitset(value | 1L << (index % size + size) % size);
	}

	public long first() {
		for(long i = 0; i < size; i++) {
			if((value & 1L << i) != 0) {
				return i;
			}
		}
		//TODO: better exception
		throw new NoSuchElementException("Empty set");
	}

	public ModuloBitset rest() {
		if(value == 0) throw new NoSuchElementException("Empty set");
		for(long i = 0; i < size; i++) {
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
		for(long i = 0; i < size; i++) {
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

	public long get(long index) {
		for(long i = 0, j = 0; i < size; i++) {
			if((value & 1L << i) != 0) {
				if(j == index)
					return i;
				j++;
			}
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	
	public long size() {
		long n = 0;
		for(long i = 0; i < size; i++) 
			if((value & 1L << i) != 0)
				n++;
		return n;
	}
}
