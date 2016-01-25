package statements.functions.list;

import statements.literals.MutableList;
import util.ModuloBitset;

public class Drop extends SubAggregate {

	@Override
	protected MutableList copyRange(MutableList a, long longValue) {
		return new MutableList(a.body().subList((int) longValue, a.body().size()));
	}

	@Override
	protected MutableList breakList(MutableList a, long longValue) {
		for(int i = (int) longValue; i > 0; i--)
			a.body().removeFirst();
		return a;
	}

	@Override
	protected ModuloBitset setCase(ModuloBitset setValue, long longValue) {
		return setValue.subSet(longValue, setValue.size());
	}

	@Override
	protected String stringCase(String stringValue, long longValue) {
		return stringValue.substring((int)longValue);
	}

	@Override
	public String name() {
		return "drop";
	}

}
