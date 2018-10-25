package mixins;

import java.util.HashMap;
import java.util.WeakHashMap;

public class StatefulObject implements Stateful {
	private WeakHashMap<Object, HashMap<Class, Object>> states
			= new WeakHashMap<>();

	@Override
	public final Object getState(Class clazz, Object initial) {
		if (!states.containsKey(this))
			states.put(this, new HashMap<>());

		return states.get(this).getOrDefault(clazz, initial);
	}

	@Override
	public final void setState(Class clazz, Object s) {
		if (!states.containsKey(this))
			states.put(this, new HashMap<>());

		states.get(this).put(clazz, s);
	}
}
