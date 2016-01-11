package statements;

public class PushString extends LiteralStatement {
	private String content;
	
	public PushString(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "\"" + content + "\"";
	}

	@Override
	public String extractValue() {
		return content;
	}
}
