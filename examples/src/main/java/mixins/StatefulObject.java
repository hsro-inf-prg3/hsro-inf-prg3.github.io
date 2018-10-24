package mixins;

import java.util.HashMap;
import java.util.WeakHashMap;

public class StatefulObject implements Stateful {
	private WeakHashMap<Object, HashMap<Class, Object>> state = new WeakHashMap<>();

	@Override
	public final Object getState(Object ref, Class clazz, Object initial) {
		if (!state.containsKey(ref))
			state.put(ref, new HashMap<>());

		return state.get(this).getOrDefault(clazz, initial);
	}

	@Override
	public final void setState(Object ref, Class clazz, Object o) {
		if (!state.containsKey(ref))
			state.put(ref, new HashMap<>());

		state.get(this).put(clazz, o);
	}
}
