package statements;

import java.util.Set;

import util.ModuloBitset;

public class PushBits extends LiteralStatement {
	//Hardcoded to 64 members, should be easy to extend to arbitrary size
	private ModuloBitset value;

	public PushBits(ModuloBitset value) {
		this.value = value;
	}
	public PushBits(Set<Long> numbers) {
		value = new ModuloBitset(numbers);
	}

	@Override
	public ModuloBitset extractValue() {
		return value;
	}

	@Override
	public String toString() {
		return value.toString();
	}
}
