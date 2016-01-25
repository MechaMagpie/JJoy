package parser;

import java.util.List;

import interpreter.NoBracesStack;
import statements.AbstractStatement;

public class UserDef extends AbstractStatement {
	private Program body;
	private String name;

	public UserDef(Program body, String name) {
		this.body = body;
		this.name = name;
	}
	
	public void update(Program newBody) {
		this.body = newBody;
	}
	
	public List<AbstractStatement> getBody() {
		return body.extractBody();
	}
	
	@Override
	public void eval(NoBracesStack stackState) {
		body.eval(stackState);
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public String name() {
		return name;
	}
}
