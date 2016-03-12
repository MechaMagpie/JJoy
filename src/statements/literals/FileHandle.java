package statements.literals;

import interpreter.NoBracesStack;
import statements.EvaluationException;
import util.FileDuplexStream;

public class FileHandle extends DataType {
	private FileDuplexStream file;
	
	public FileHandle(FileDuplexStream file) {
		this.file = file;
	}
	
	public FileDuplexStream getFile() {
		return file;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "file:" + file.toString();
	}

	@Override
	public void eval(NoBracesStack stackState) throws EvaluationException {
		stackState.push(this);
	}

	@Override
	public String name() {
		return " file type";
	}
}
