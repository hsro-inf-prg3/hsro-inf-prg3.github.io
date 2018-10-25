package mixins;

import java.util.HashMap;
import java.util.WeakHashMap;

public class StatefulObject implements Stateful {
	private WeakHashMap<Object, HashMap<Class, Object>> states
			= new WeakHashMap<>();

	@Override
	@SuppressWarnings("unchecked")  // shhh... :-)
	public final <T> T getState(Class clazz, T initial) {
		if (!states.containsKey(this))
			states.put(this, new HashMap<>());

		// cast necessary, since internally we store Object!
		return (T) states.get(this).getOrDefault(clazz, initial);
	}

	@Override
	public final <T> void setState(Class clazz, T s) {
		if (!states.containsKey(this))
			states.put(this, new HashMap<>());

		states.get(this).put(clazz, s);
	}
}
