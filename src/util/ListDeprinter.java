package util;

import java.util.List;

public class ListDeprinter {
	
	public static String dePrint(List<? extends Object> list) {
		StringBuilder sb = new StringBuilder();
		for(Object o : list) {
			sb.append(o.toString());
			sb.append(' ');
		}
		if(sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}
