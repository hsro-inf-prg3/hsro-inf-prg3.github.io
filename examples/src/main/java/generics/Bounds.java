package generics;

import diamond.Klass;

import java.util.List;

public class Bounds {

	void augment(List<? super Number> list) {
		for (int i = 1; i <= 10; i++) {
			list.add(i);  // this works
			list.add(new Object());
		}

		Number k = list.iterator().next();  // compile time error: can't resolve type
		Number k = (Klass) list.iterator().next();  // runtime hazard: ClassCastException
	}
}
