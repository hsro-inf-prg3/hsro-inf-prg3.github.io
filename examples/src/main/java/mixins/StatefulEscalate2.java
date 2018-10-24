package mixins;

import java.util.stream.Stream;

public interface StatefulEscalate2 extends Stateful {
	String getText();

	default String escalated() {
		int n = (Integer) getState(this, StatefulEscalate2.class, 0);

		setState(this, StatefulEscalate2.class, n+1);

		return getText().toUpperCase() +
				Stream.generate(() -> "!").limit(n).reduce("", (a, b) -> a + b);
	}
}
