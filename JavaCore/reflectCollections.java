package JavaCore;

import java.lang.reflect.Method;

public class reflectCollections {
	public static void main(String args[]) throws ClassNotFoundException {
		Class collectionClass = Class.forName("java.util.Collections");
		Method[] methods = collectionClass.getMethods();
		for (Method x : methods) {
			String ReturnType = x.getReturnType().getName();
			String MethodName = x.getName();
			Class<?>[] ParameterTypes = x.getParameterTypes();
			String parameterTypeString = "";
			for (int i = 0; i < ParameterTypes.length; i++) {
				parameterTypeString += ParameterTypes[i].getName();
				if (i < ParameterTypes.length - 1) {
					parameterTypeString += " , ";
				}
			}
			System.out.println("<" + ReturnType + ">" + MethodName + "<" + parameterTypeString + ">");
		}
	}
}
