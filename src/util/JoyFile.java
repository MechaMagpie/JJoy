package util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class JoyFile extends FileDuplexStream {
	private RandomAccessFile file;
	private boolean appendMode = false;
	long tempPointer;

	public JoyFile(String path, String mode) throws IOException {
		mode = mode.replaceAll("b", "");
		String newMode;
		switch (mode) {
		case "r":
			newMode = "r";
			break;
		case "r+":
			newMode = "rw";
			break;
		case "w":
			newMode = "rw";
			break;
		case "w+":
			newMode = "rw";
			break;
		case "a":
			newMode = "rw";
			appendMode = true;
			break;
		case "a+":
			newMode = "rw";
			appendMode = true;
			break;
		default:
			throw new IllegalArgumentException(mode);
		}
		file = new RandomAccessFile(new File(path), newMode);
		if(mode.contains("w")) {
			file.setLength(0);
		}
	}

	@Override
	public void fclose() throws IOException {
		file.close();
	}

	@Override
	public boolean feof() throws IOException {
		return file.getFilePointer() >= file.length();
	}

	@Override
	public boolean ferror() {
		// I don't think this does anything useful
		return false;
	}

	@Override
	public void fflush() throws IOException {
		// Not applicable
	}

	@Override
	public char fgetch() throws IOException {
		return file.readChar();
	}

	@Override
	public String fgets() throws IOException {
		return file.readLine();
	}
	
	@Override
	public byte[] fread(int length) throws IOException {
		byte[] result = new byte[length];
		int len = file.read(result);
		if(len == -1) return new byte[0];
		else return Arrays.copyOf(result, len);
	}

	@Override
	public void fwrite(byte[] list) throws IOException {
		tryAppend();
		for(byte c : list) {
			file.writeChar(c);
		}
		ifAppended();
	}

	@Override
	public void fput(Object data) throws IOException {
		tryAppend();
		file.write(String.valueOf(data).getBytes());
		ifAppended();
	}

	@Override
	public void fputch(char arg) throws IOException {
		tryAppend();
		file.writeChar(arg);
		ifAppended();
	}

	@Override
	public void fputchars(String arg) throws IOException {
		tryAppend();
		file.write(arg.getBytes());
		ifAppended();
	}

	@Override
	public void fseek(long P, long W) throws IOException {
		switch((int) W) {
		case 0:
			file.seek(P);
			break;
		case 1:
			file.seek(file.getFilePointer() + P);
			break;
		case 2:
			file.seek(file.length() - 1L + P);
		}
	}

	@Override
	public long ftell() throws IOException {
		return file.getFilePointer();
	}
	
	private void tryAppend() throws IOException {
		if(appendMode) {
			tempPointer = file.getFilePointer();
			file.seek(file.length());
		}
	}
	
	private void ifAppended() throws IOException {
		if(appendMode) {
			file.seek(tempPointer);
		}
	}
	
	@Override
	public String toString() {
		String fd;
		try {
			fd = file.getFD().toString();
		} catch (IOException e) {
			fd = "0x00000000";
		}
		return "0x" + fd.substring(fd.length() - 8);
	}
}
