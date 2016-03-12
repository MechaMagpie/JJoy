package util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class JoyStdout extends FileDuplexStream {
	private PrintWriter writer;
	private String name;
	
	public JoyStdout(OutputStream out, String name) {
		writer = new PrintWriter(out);
		this.name = name;
	}
	
	@Override
	public void fclose() throws IOException {
		writer.close();
	}

	@Override
	public boolean feof() {
		return false;
	}

	@Override
	public boolean ferror() {
		return false;
	}

	@Override
	public void fflush() {
		writer.flush();
	}

	@Override
	public char fgetch() throws IOException {
		return 0;
	}

	@Override
	public String fgets() throws IOException {
		return null;
	}

	@Override
	public byte[] fread(int length) throws IOException {
		return new byte[0];
	}

	@Override
	public void fwrite(byte[] list) {
		for(int i : list) {
			writer.print(i);
		}
	}

	@Override
	public void fput(Object data) {
		writer.print(data);
	}

	@Override
	public void fputch(char arg) {
		writer.print(arg);
	}

	@Override
	public void fputchars(String arg) {
		writer.print(arg);
	}

	@Override
	public void fseek(long P, long W) {
		// Intentionally unimplemented
	}

	@Override
	public long ftell() {
		return -1L;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
