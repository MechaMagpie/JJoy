package parser;

import java.util.HashMap;
import java.util.Map;

import statements.AbstractStatement;
import statements.UnknownStatement;
import statements.functions.Get;
import statements.functions.Include;
import statements.functions.Intern;
import statements.literals.FileHandle;
import statements.literals.PushInteger;
import statements.literals.PushTruth;
import util.JoyStdin;
import util.JoyStdout;
import util.ModuloBitset;

@SuppressWarnings("unchecked")
public class FunctionParser {
	private static Map<String, AbstractStatement> functions;
	private Map<String, AbstractStatement> dynamicFunctions;
	private Map<String, UserDef> userDefs;

	static {
		functions = new HashMap<String, AbstractStatement>();
		for(Object[] tuple : builtins.builtins) {
			try {
				functions.put((String) tuple[0], ((Class<AbstractStatement>) tuple[1]).newInstance());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		functions.put("true", new PushTruth(true));
		functions.put("false", new PushTruth(false));
		functions.put("stdin", new FileHandle(new JoyStdin(System.in, "stdin")));
		functions.put("stdout", new FileHandle(new JoyStdout(System.out, "stdout")));
		functions.put("stderr", new FileHandle(new JoyStdout(System.err, "stderr")));
		functions.put("setsize", new PushInteger(ModuloBitset.setSize));
		
	}
	
	public FunctionParser(Parser parser) {
		userDefs = new HashMap<String, UserDef>();
		dynamicFunctions = new HashMap<String, AbstractStatement>();
		dynamicFunctions.put("intern", new Intern(parser));
		dynamicFunctions.put("get", new Get(parser));
		dynamicFunctions.put("include", new Include(parser));
	}

	public AbstractStatement getFunction(String string)  {
		if(userDefs.containsKey(string)) return userDefs.get(string);
		else if(functions.containsKey(string)) return functions.get(string);
		else if(dynamicFunctions.containsKey(string)) return dynamicFunctions.get(string);
		else return new UnknownStatement(string);
	}
	
	public void declareFunction(String name) {
		userDefs.put(name, new UserDef(null, name));
	}
	
	public void defineFunction(String name, Program body) {
		userDefs.get(name).update(body);
	}

	public void hide(String hiddenName) {
		userDefs.remove(hiddenName);
	}
}
