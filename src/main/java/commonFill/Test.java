package commonFill;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.Radio;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class Test {

	public static void main(String[] args) {
		Map<String, String> meta = new HashMap<>();
		meta.put("e1", "value1");
		meta.put("e2", "value2");
		meta.put("e3", "value3");
		
		
		Map<String, String> sorted = sortMeta(meta, getDependencies());
		System.out.println("Done");

	}

	public static void setValues(Map<String, String> meta, Object page) {
		Field[] fields = page.getClass().getDeclaredFields();

		try {
			for (Map.Entry<String, String> entry : meta.entrySet()) {

				String key = entry.getKey();
				if (entry.getValue().equals("DNF"))
					continue;

				for (Field field : fields) {
					if (field.getName().equals(key)) {

						if (Radio.class.isAssignableFrom(field.getType())) {
							Radio elem = (Radio) field.get(page);
							elem.selectByValue(entry.getValue());

						} else if (Select.class.isAssignableFrom(field.getType())) {
							Select elem = (Select) field.get(page);
							elem.selectByValue(entry.getValue());

						} else if (CheckBox.class.isAssignableFrom(field.getType())) {
							CheckBox elem = (CheckBox) field.get(page);
							elem.set(Boolean.valueOf(entry.getValue()));

						} else if (TextInput.class.isAssignableFrom(field.getType())) {
							TextInput elem = (TextInput) field.get(page);
							elem.sendKeys(entry.getValue());
						}
					}
				}
			}
		} catch (IllegalAccessException e) {
		}
	}


	public static Map<String, List<String>> getDependencies(){
		Map<String, List<String>> depend = new HashMap<>();
		depend.put("e2", Arrays.asList("e3", "e1"));
		return depend;
	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortMeta(Map<K, V> map,
			Map<String, List<String>> depend) {
		List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {

				if (depend.get(o1.getKey()) != null && depend.get(o1.getKey()).contains(o2.getKey()))
					return -1;
				else if (depend.get(o2.getKey()) != null && depend.get(o2.getKey()).contains(o1.getKey()))
					return 1;
				else
					return 0;
			}
		});

		Collections.reverse(list);
		Map<K, V> result = new LinkedHashMap<>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
}
