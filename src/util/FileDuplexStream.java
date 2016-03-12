package util;

import java.io.IOException;

public abstract class FileDuplexStream {

	public abstract void fclose() throws IOException;
	
	public abstract boolean feof() throws IOException;
	
	public abstract boolean ferror();
	
	public abstract void fflush() throws IOException;
	
	public abstract char fgetch() throws IOException;
	
	public abstract String fgets() throws IOException;
	
	/**
	 * Reads {@code length} bytes from stream. Returns zero-length array if no bytes could be read
	 * @param length - number of bytes to read
	 * @return An array of the bytes that were read
	 * @throws IOException
	 */
	public abstract byte[] fread(int length) throws IOException;
	
	public abstract void fwrite(byte[] list) throws IOException;
	
	public abstract void fput(Object data) throws IOException;
	
	public abstract void fputch(char arg) throws IOException;
	
	public abstract void fputchars(String arg) throws IOException;
	
	public abstract void fseek(long P, long W) throws IOException;
	
	public abstract long ftell() throws IOException;
}
