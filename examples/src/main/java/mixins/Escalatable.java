package mixins;

import java.util.WeakHashMap;
import java.util.stream.Stream;

public interface Escalatable {
	String getText();

	default String escalated() {
		return getText().toUpperCase();
	}
}
