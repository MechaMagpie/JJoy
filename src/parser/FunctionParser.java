package parser;

import java.util.HashMap;
import java.util.Map;

import statements.AbstractStatement;
import statements.PushTruth;
import statements.UnknownStatement;

@SuppressWarnings("unchecked")
public class FunctionParser {
	private static Map<String, AbstractStatement> functions;
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
	}
	
	public FunctionParser() {
		userDefs = new HashMap<String, UserDef>();
	}

	public AbstractStatement getFunction(String string)  {
		if(functions.containsKey(string)) return functions.get(string);
		else if(userDefs.containsKey(string)) return userDefs.get(string);
		else return new UnknownStatement(string);
	}
	
	public void declareFunction(String name) {
		userDefs.put(name, new UserDef(null, name));
	}
	
	public void defineFunction(String name, Program body) {
		userDefs.get(name).update(body);
	}
}
