package webtest;

import java.lang.reflect.Method;

public class AbstractPage {
	public Object initOnDemand() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

		String methName = stackTrace[2].getMethodName();
		System.out.println(getClass().getSimpleName());

		Method[] declaredMethods = getClass().getDeclaredMethods();

		Method method = null;
		for (Method meth : declaredMethods) {
			if (meth.getName().equals(methName)) {
				method = meth;
				break;
			}
		}

		Class<?> returnType = method.getReturnType();
		try {
			return returnType.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
