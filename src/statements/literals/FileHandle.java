package statements.literals;

import java.io.File;

import interpreter.NoBracesStack;
import statements.EvaluationException;

public class FileHandle extends DataType {
	private File file;
	
	public FileHandle(File file) {
		this.file = file;
	}
	
	@Override
	public void eval(NoBracesStack stackState) throws EvaluationException {
		stackState.push(this);
	}

	@Override
	public String name() {
		return " file type";
	}

	public File getFile() {
		return file;
	}
}
