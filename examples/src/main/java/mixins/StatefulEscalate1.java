package mixins;

import java.util.WeakHashMap;
import java.util.stream.Stream;

public interface StatefulEscalate1 {
	String getText();

	// static member!
	WeakHashMap<StatefulEscalate1, Integer> state = new WeakHashMap<>();

	default String escalated() {
		int n = state.getOrDefault(this, 0);

		state.put(this, n+1);

		return getText().toUpperCase() +
				Stream.generate(() -> "!").limit(n).reduce("", (a, b) -> a + b);
	}
}
