package interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import parser.Parser;
import parser.Program;
import statements.AbstractStatement;

public class REPL {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Parser parser = new Parser(new BufferedReader(new InputStreamReader(System.in)), new EP());
		try {
			parser.parse();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
