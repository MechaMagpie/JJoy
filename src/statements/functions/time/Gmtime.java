package statements.functions.time;

public class Gmtime extends WriteTime {

	@Override
	public String name() {
		return "gmtime";
	}

	@Override
	protected boolean gmt() {
		return true;
	}
}
