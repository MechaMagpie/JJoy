package parser;

public interface ProgramEvaluator {
	public void eval(Program program);

	public boolean stopped();
}
