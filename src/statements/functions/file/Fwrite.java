package statements.functions.file;

import java.io.IOException;

import interpreter.NoBracesStack;
import statements.AbstractStatement;
import statements.EvaluationException;
import statements.functions.BinaryFunction;
import statements.functions.MalformedListException;
import statements.literals.FileHandle;
import statements.literals.ListStatement;
import statements.literals.PushInteger;

public class Fwrite extends BinaryFunction<FileHandle, ListStatement> {

	@Override
	protected void eval(NoBracesStack stackState, FileHandle s, ListStatement l) throws EvaluationException {
		byte[] byteList = new byte[(int) l.size()];
		try {
			int i = 0;
			for(AbstractStatement a : l) {
				byteList[i++] = (byte) ((PushInteger)a).longValue();
			}
			s.getFile().fwrite(byteList);
		} catch (ClassCastException e) {
			throw new MalformedListException(this.toString(), l.toString());
		} catch (IOException e) {
			throw new FileIOError(this.toString(), s.toString());
		}
	}

	@Override
	public String name() {
		return "fwrite";
	}

}
