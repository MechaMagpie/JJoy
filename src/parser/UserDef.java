package parser;

import java.util.Stack;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.ListStatement;

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
	
	public UserDef invoke () {
		return new UserDef(body, name);
	}
	
	@Override
	public void eval(NoBracesStack stackState) {
		body.eval(stackState);
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
