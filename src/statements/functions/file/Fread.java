package statements.functions.file;

import java.io.IOException;
import java.util.LinkedList;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.BinaryFunction;
import statements.literals.FileHandle;
import statements.literals.MutableList;
import statements.literals.PushInteger;

public class Fread extends BinaryFunction<FileHandle, PushInteger> {

	@Override
	protected void eval(NoBracesStack stackState, FileHandle s, PushInteger i) throws EvaluationException {
		stackState.push(s);
		try {
			byte[] result = s.getFile().fread((int) i.longValue());
			LinkedList<AbstractStatement> tempLst = new LinkedList<AbstractStatement>();
			for(byte b : result) {
				tempLst.add(new PushInteger(b));
			}
			stackState.push(new MutableList(tempLst));
		} catch (IOException e) {
			throw new FileIOError(this.toString(), s.toString());
		}
	}

	@Override
	public String name() {
		return "fread";
	}

}
