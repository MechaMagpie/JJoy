package parser;

import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import statements.keywords.*;
import statements.literals.*;
import statements.*;

public class Parser {
	private FunctionParser fparser;
	
	private Reader reader;
	private char lastRead;
	private ProgramEvaluator evalResult;

	public Parser(Reader reader, ProgramEvaluator evalResult) {
		fparser = new FunctionParser(this);
		this.reader = reader;
		this.evalResult = evalResult;
	}

	public void parseIndefinitely() throws IOException {
		while(!evalResult.stopped()) {
			feed();
			parse();
		}
	}
	
	public void parse() throws IOException {
		eatSpace();
		if(lastRead == '.') evalResult.eval(new Program(new LinkedList<AbstractStatement>()));
		else {
			AbstractStatement first = parseStatement();
			if(first instanceof DEFINE || first instanceof LIBRA) {
				eatSpace();
				parseDefine();
			} else if(first instanceof HIDE) {
				eatSpace();
				parseModule();
			} else {
				LinkedList<AbstractStatement> body = new LinkedList<AbstractStatement>();
				body.add(first);
				eatSpace();
				while(lastRead != '.') {
					body.add(parseStatement());
					eatSpace();
				}
				evalResult.eval(new Program(body));
			}
		}
	}
	
	public AbstractStatement parseSingle(Reader newReader) {
		Reader temp = reader;
		char tempC = lastRead;
		reader = newReader;
		AbstractStatement a = null;
		try {
			feed();
			a = parseStatement();
		} catch (IOException e) {
			// This should be unreachable
			e.printStackTrace();
		}
		reader = temp;
		lastRead = tempC;
		return a;
	}

	public void parseFully(Reader newReader) {
		Reader temp = reader;
		char tempC = lastRead;
		reader = newReader;
		try {
			while(testFeed()) {
				parse();
			}
		} catch (IOException e) {
			// Hopefully unreachable
			e.printStackTrace();
		}
		reader = temp;
		lastRead = tempC;
	}

	private void parseDefine() throws IOException {
		while(true) {
			LinkedList<AbstractStatement> body = new LinkedList<AbstractStatement>();
			UnknownStatement name = (UnknownStatement) parseStatement();
			fparser.declareFunction(name.getName());
			eatSpace();
			parseStatement();
			eatSpace();
			while(!(lastRead == '.' || lastRead == ';')) {
				body.add(parseStatement());
				eatSpace();
			}
			fparser.defineFunction(name.getName(), new Program(body));
			if(lastRead == '.') return;
			else {
				feed();
				eatSpace();
			}
		}
	}
	
	private void parseModule() throws IOException {
		LinkedList<String> hidden = new LinkedList<String>();
		hide: while(true) {
			LinkedList<AbstractStatement> body = new LinkedList<AbstractStatement>();
			UnknownStatement name = (UnknownStatement) parseStatement();
			fparser.declareFunction(name.getName());
			hidden.add(name.getName());
			eatSpace();
			parseStatement();
			eatSpace();
			while(!(lastRead == '.' || lastRead == ';')) {
				body.add(parseStatement());
				eatSpace();
				if(body.getLast() instanceof IN) {
					body.removeLast();
					fparser.defineFunction(name.getName(), new Program(body));
					break hide;
				}
			}
			fparser.defineFunction(name.getName(), new Program(body));
			feed();
			eatSpace();
		}
		while(true) {
			LinkedList<AbstractStatement> body = new LinkedList<AbstractStatement>();
			UnknownStatement name = (UnknownStatement) parseStatement();
			fparser.declareFunction(name.getName());
			eatSpace();
			parseStatement();
			eatSpace();
			while(!(lastRead == '.' || lastRead == ';')) {
				body.add(parseStatement());
				eatSpace();
			}
			fparser.defineFunction(name.getName(), new Program(body));
			if(lastRead == '.') break;
			else {
				feed();
				eatSpace();
			}
		}
		for(String hiddenName : hidden) {
			fparser.hide(hiddenName);
		}
	}

	private AbstractStatement parseStatement() throws IOException {
		if (lastRead == '\'')
			return parseChar();
		else if (lastRead == '\"')
			return parseString();
		else if (lastRead == '[')
			return parseList();
		else if (lastRead == '{')
			return parseSet();
		else if (Character.isDigit(lastRead))
			return parseNumber();
		else
			return parseFunction();
	}

	private PushBits parseSet() throws IOException {
		Set<Long>  bits = new HashSet<Long>();
		feed();
		eatSpace();
		while(lastRead != '}') {
			bits.add(parseRawNumber().longValue());
			eatSpace();
		}
		feed();
		return new PushBits(bits);
	}

	private AbstractStatement parseFunction() throws IOException {
		StringBuilder name = new StringBuilder();
		name.append(lastRead);
		feed();
		// Negative numbers and functions share the first character '-'
		if(name.charAt(0) == '-' && Character.isDigit(lastRead)) {
			return ((NumberStatement)parseNumber()).negate();
		}
		while(Character.isLetterOrDigit(lastRead) || lastRead == '=' || lastRead == '_' || lastRead == '-') {
			name.append(lastRead);
			feed();
		} 
		return fparser.getFunction(name.toString());
	}

	private NumberStatement parseNumber() throws IOException {
		Number n = parseRawNumber();
		if(n instanceof Long)
			return new PushInteger(n.longValue());
		else
			return new PushFloat(n.doubleValue());
	}
	
	private Number parseRawNumber() throws IOException {
		StringBuffer fullNumber = new StringBuffer();
		do {
			fullNumber.append(lastRead);
			feed();
		} while(Character.isDigit(lastRead));
		if (lastRead == '.') {
			fullNumber.append(lastRead);
			feed();
			do {
				fullNumber.append(lastRead);
				feed();
			} while(Character.isDigit(lastRead));
			return Double.parseDouble(fullNumber.toString());
		} else
			return Long.parseLong(fullNumber.toString());
	}

	private ListStatement parseList() throws IOException {
		LinkedList<AbstractStatement> list = new LinkedList<AbstractStatement>();
		feed();
		eatSpace();
		while(lastRead != ']') {
			list.add(parseStatement());
			eatSpace();
		} 
		feed();
		return new ListedList(list);
	}

	private void eatSpace() throws IOException {
		if (Character.isWhitespace(lastRead)) {
			while (Character.isWhitespace(lastRead = (char)reader.read()));
		}
	}
	
	private char feed() throws IOException {
		return lastRead = (char) reader.read();
	}
	
	private char feedLater() throws IOException {
		char temp = lastRead;
		lastRead = (char) reader.read();
		return temp;
	}
	
	private boolean testFeed() throws IOException {
		int temp = reader.read();
		if (temp == -1) return false;
		else {
			lastRead = (char) temp;
			return true;
		}
	}
	
	

	private PushChar parseChar() throws IOException {
		feed();
		if (lastRead != '\\') {
			return new PushChar(feedLater());
		} else {
			feed();
			return new PushChar(escapeGoat(feedLater()));
		}
	}

	private PushString parseString() throws IOException {
		StringBuilder sb = new StringBuilder();
		feed();
		if (lastRead == '"') {
			feed();
			return new PushString("");
		} else {
			do {
				if (lastRead == '\\') {
					feed();
					sb.append(escapeGoat(lastRead));
				} else sb.append(lastRead);
				feed();
			} while (lastRead != '\"');
		}
		feed();
		return new PushString(sb.toString());
	}

	private static char escapeGoat(char escapee) {
		switch (escapee) {
		case 't':
			return '\t';
		case 'b':
			return '\b';
		case 'n':
			return '\n';
		case 'f':
			return '\f';
		case '\'':
			return '\'';
		case '\"':
			return '\"';
		case '\\':
			return '\\';
		}
		throw new IllegalArgumentException("Not an escape"); // TODO better exception
	}
}
