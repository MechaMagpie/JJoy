package parser;

import java.util.ArrayList;
import java.util.List;
import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import util.ListDeprinter;

public class Program {
	private List<AbstractStatement> body;
	
	public Program(List<AbstractStatement> body) {
		this.body = body;
	}
	
	public Program(Program p) {
		this.body = p.extractBody();
	}
	
	public void eval(NoBracesStack stack) {
		for(AbstractStatement a : body) {
			try {
				a.eval(stack);
			} catch (EvaluationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public List<AbstractStatement> extractBody() {
		return new ArrayList<AbstractStatement>(body);					//Program is intended to be immutable
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ListDeprinter.dePrint(body));
		if(sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}
