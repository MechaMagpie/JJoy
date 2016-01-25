package statements.functions.list;

import statements.literals.MutableList;
import util.ModuloBitset;

public class Take extends SubAggregate {

	@Override
	protected MutableList copyRange(MutableList a, long longValue) {
		return new MutableList(a.body().subList(0, (int) longValue));
	}

	@Override
	protected MutableList breakList(MutableList a, long longValue) {
		for(int i = (int) longValue; i > 0; i--)
			a.body().removeLast();
		return a;
	}

	@Override
	protected ModuloBitset setCase(ModuloBitset setValue, long longValue) {
		return setValue.subSet(0, (int) longValue);
	}

	@Override
	protected String stringCase(String stringValue, long longValue) {
		return stringValue.substring(0, (int) longValue);
	}

	@Override
	public String name() {
		return "take";
	}

}
