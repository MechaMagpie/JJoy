package statements.functions.time;

public class Localtime extends WriteTime {

	@Override
	public String name() {
		return "localtime";
	}

	@Override
	protected boolean gmt() {
		return false;
	}
}
