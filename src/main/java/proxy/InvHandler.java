package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class InvHandler implements InvocationHandler {
	public InvHandler(List<String> obj) {
		this.proxiedObj = obj;
	}

	private List<String> proxiedObj;

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		if (method.getName().contains("toString")) {
			return "ABC";
		}

		try {
			return method.invoke(proxiedObj, args);

		} catch (InvocationTargetException e) {
			throw e.getCause();
		}
	}

	public static void main(String[] args) {
		List<String> myList = new ArrayList<>();

		List<String> newProxyInstance = (List<String>) Proxy.newProxyInstance(myList.getClass().getClassLoader(),
				new Class[] { List.class }, new InvHandler(myList));

		System.out.println(newProxyInstance.get(0));

	}

}
