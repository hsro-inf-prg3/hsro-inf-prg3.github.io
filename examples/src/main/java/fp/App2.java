package fp;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

import static fp.List.list;

public class App2 {

	static <A> A reduce(List<A> xs, BinaryOperator<A> f, A z) {
		if (xs.isEmpty()) return z;
		else return reduce(xs.tail, f, f.apply(xs.head, z));
	}

	static <A, B> B foldLeft(List<A> xs, BiFunction<B, A, B> f, B z) {
		if (xs.isEmpty()) return z;
		else return foldLeft(xs.tail, f, f.apply(z, xs.head));  // tail-recursive
	}

	static <A> A reduceLeft(List<A> xs, BiFunction<A, A, A> f) {
		if (xs.isEmpty()) throw new UnsupportedOperationException();
		else return foldLeft(xs.tail, f, xs.head);  // tail-recursive
	}

	static <A, B> B foldRight(List<A> xs, BiFunction<A, B, B> f, B z) {
		if (xs.isEmpty()) return z;
		else return f.apply(xs.head, foldRight(xs.tail, f, z));
	}

	static <A> A reduceRight(List<A> xs, BiFunction<A, A, A> f) {
		if (xs.isEmpty()) throw new UnsupportedOperationException();
		else if (xs.tail.isEmpty()) return xs.head;
		else return f.apply(xs.head, reduceRight(xs.tail, f));
	}

	public static void main(String[] args) {
		List<Integer> xs = list(7, 3, 1, 3);

		System.out.println(xs);

		// sum, reduced
		System.out.println("sum");
		System.out.println(reduceLeft(xs, (y, ys) -> y + ys));
		System.out.println(reduceRight(xs, (ys, y) -> ys + y));

		// length, folded
		System.out.println("length");
		System.out.println(foldLeft(xs, (n, ys) -> n + 1, 0));
		System.out.println(foldRight(xs, (ys, n) -> n + 1, 0));

		// reverse
		System.out.println("reverse");
		System.out.println(foldLeft(xs, (ys, n) -> list(n, ys), List.<Integer>empty())); // type inference doesn't work

		// append
		System.out.println("append");
		List<Integer> zs = list(0);
		System.out.println(xs);
		System.out.println(zs);
		System.out.println(foldRight(xs, (n, ys) -> list(n, ys), zs));


		// filter
		Predicate<Integer> p = new Predicate<Integer>() {
			@Override
			public boolean test(Integer i) {
				return i < 5;
			}
		};

		System.out.println("filter (lt 5)");
		System.out.println(xs);
		System.out.println(foldLeft(xs, (ys, y) -> p.test(y) ? list(y, ys) : ys, List.<Integer>empty()));


		// map
		Function<Integer, Integer> f = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer i) {
				return i * i;
			}
		};

		System.out.println("squares");
		System.out.println(xs);
		System.out.println(foldRight(xs, (y, ys) -> list(f.apply(y), ys), List.<Integer>empty()));

		System.out.println("sum: " + reduce(xs, (x, y) -> x + y, 0));  // Stream.reduce
	}
}
