package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Target;
import java.util.Arrays;

public class JoyStdin extends FileDuplexStream {
	private BufferedReader reader;
	private InputStream in;
	private String name;
	
	public JoyStdin(InputStream in, String name) {
		reader = new BufferedReader(new InputStreamReader(in));
		this.in = in;
		this.name = name;
	}
	
	@Override
	public void fclose() throws IOException {
		reader.close();
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
		// Intentionally unimplemented
	}

	@Override
	public char fgetch() throws IOException {
		int read = reader.read();
		return read < 0 ? null : (char) read;
	}

	@Override
	public String fgets() throws IOException {
		return reader.readLine();
	}

	@Override
	public byte[] fread(int length) throws IOException {
		byte[] target = new byte[length];
		int len = in.read(target);
		if(len == -1) return new byte[0];
		else return Arrays.copyOf(target, len);
	}

	@Override
	public void fwrite(byte[] list) {
		// Intentionally unimplemented
	}

	@Override
	public void fput(Object data) {
		// Intentionally unimplemented

	}

	@Override
	public void fputch(char arg) {
		// Intentionally unimplemented

	}

	@Override
	public void fputchars(String arg) {
		// Intentionally unimplemented

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
