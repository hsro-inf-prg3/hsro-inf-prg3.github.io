package reflection.serialization;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public abstract class XmlSerializer {

	private static final Class<?>[] Primitives = new Class[]{
			char.class,
			Character.class,
			String.class,
			boolean.class,
			Boolean.class,
			short.class,
			Short.class,
			int.class,
			Integer.class,
			long.class,
			Long.class,
			float.class,
			Float.class,
			double.class,
			Double.class
	};

	private XmlSerializer() {
	}

	/**
	 * Serialize an object to XML
	 *
	 * @param writer Writer to use
	 * @param input input to serialize
	 * @param <T> Type of the object to serialize (actually not really required)
	 * @throws IOException
	 */
	public static <T> void serialize(Writer writer, T input) throws IOException {
		/* determine how to handle the passed object */
		Class<?> inputClass = input.getClass();

		if (inputClass.isArray()) {
			serializeArray(writer, (Object[]) input, inputClass, null);
		} else if (Iterable.class.isAssignableFrom(inputClass)) {
			serializeIterable(writer, (Iterable<T>) input, null);
		} else {
			serializeSingleObject(writer, input, inputClass, null);
		}
	}

	/**
	 * Private overload of serialize to preserve naming context
	 * @param writer Writer to use
	 * @param input input to serialize
	 * @param name naming context to preserve variable name if present (e.g. field name for nested lists)
	 * @param <T> Type of the object to serialize (actually not really required)
	 * @throws IOException
	 */
	private static <T> void serializeWithName(Writer writer, T input, String name) throws IOException {
		Class<?> inputClass = input.getClass();

		if (inputClass.isArray()) {
			serializeArray(writer, (Object[]) input, inputClass, name);
		} else if (Iterable.class.isAssignableFrom(inputClass)) {
			serializeIterable(writer, (Iterable<T>) input, null);
		} else {
			serializeSingleObject(writer, input, inputClass, name);
		}
	}

	/**
	 * Serialize a Object that is NEITHER an array NOR an iterable
	 * Respects public fields directly
	 * Tries to find matching getters for private fields based on common naming conventions
	 * @param writer Writer to use
	 * @param input given input object to serialize
	 * @param inputClass type of the object to serialize
	 * @param nameContext naming context to preserve variable name if present (e.g. field name for nested lists)
	 * @throws IOException
	 */
	private static void serializeSingleObject(Writer writer, Object input, Class<?> inputClass, String nameContext) throws IOException {
		/* opening tag */
		writer.write(nameContext == null ? String.format("<%s>", inputClass.getSimpleName()) : String.format("<%s type=\"%s\">", nameContext, inputClass.getSimpleName()));

		/* if input is primitive a simple node is created */
		if (isPrimitive(inputClass)) {
			writer.write(input.toString());
		} else {
			/* input is a plain old Java object (POJO)
			* fields are iterated and individually serialized */
			for (Field f : inputClass.getDeclaredFields()) {
				/* handle public fields */
				if (f.isAccessible()) {
					try {
						serializeWithName(writer, f.get(input), f.getName());
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				} else {
					/* try to resolved getter method to work around accessibility issues */
					try {
						/* generate method name from field name by using common naming conventions */
						String methodName = isBooleanType(f.getType()) ? prefixIfNotPresent("is", f.getName()) : prefixIfNotPresent("get", f.getName());
						Method getter = inputClass.getMethod(methodName);
						serializeWithName(writer, getter.invoke(input), f.getName());
					} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}

		/* closing tag */
		writer.write(nameContext == null ? String.format("</%s>", inputClass.getSimpleName()) : String.format("</%s>", nameContext));
	}

	/**
	 * Serialize a given array by iterating it and calling serialize for each element
	 * @param writer Writer to use
	 * @param input given input array to serialize
	 * @param inputClass type of the array
	 * @param nameContext naming context to preserve variable name if present (e.g. field name for nested lists)
	 * @throws IOException
	 */
	private static void serializeArray(Writer writer, Object[] input, Class<?> inputClass, String nameContext) throws IOException {

		String className = inputClass.getSimpleName().replaceAll("\\[]", "");
		/* opening tag */
		writer.write(nameContext == null ? String.format("<%ss>", className) : String.format("<%s type=\"%s\">", nameContext, className));

		for (Object o : input) {
			serializeWithName(writer, o, null);
		}

		/* closing tag */
		writer.write(nameContext == null ? String.format("</%ss>", className) : String.format("</%s>", nameContext));
	}

	/**
	 * Serialize a given iterable by iterating it and calling serialize for each element
	 * @param writer Writer to use
	 * @param input given iterable input to serialize
	 * @param nameContext naming context to preserve variable name if present (e.g. field name for nested lists)
	 * @param <T> Type of the Iterable (actually not required)
	 * @throws IOException
	 */
	private static <T> void serializeIterable(Writer writer, Iterable<T> input, String nameContext) throws IOException {
		Iterator<T> ito = input.iterator();
		T currentItem;
		if (!ito.hasNext()) return;

		currentItem = ito.next();
		String elementClassName = currentItem.getClass().getSimpleName();

		/* opening tag */
		writer.write(nameContext == null ? String.format("<%ss>", elementClassName) : String.format("<%s type=\"%s\">", nameContext, elementClassName));

		serializeWithName(writer, currentItem, null);
		while (ito.hasNext()) {
			serializeWithName(writer, ito.next(), null);
		}

		/* closing tag */
		writer.write(nameContext == null ? String.format("</%ss>", elementClassName) : String.format("</%s>", nameContext));
	}

	/**
	 * Check if given type is boxed or unboxed boolean type
	 * @param clazz type to check
	 * @return boolean result
	 */
	private static boolean isBooleanType(Class<?> clazz) {
		return Boolean.class.isAssignableFrom(clazz) || boolean.class.isAssignableFrom(clazz);
	}

	/**
	 * Add a prefix if it is not present already
	 * e.g. name -> getName, leader -> isLeader
	 * @param prefix prefix toa dd
	 * @param s original String value
	 * @return prefixed String
	 */
	private static String prefixIfNotPresent(String prefix, String s) {
		if (s.startsWith(prefix)) return s;
		return String.format("%s%s", prefix, s.substring(0, 1).toUpperCase() + s.substring(1));
	}

	/**
	 * Determine if a given type is a primitive type like String or int
	 * @param clazz type to check
	 * @return boolean result
	 */
	private static boolean isPrimitive(Class<?> clazz) {
		return Arrays.stream(Primitives)
				.map(c -> c.isAssignableFrom(clazz))
				.reduce(false, (b1, b2) -> b1 || b2);
	}

	public static void main(String[] args) throws IOException {
		StringWriter stringWriter = new StringWriter();
		serialize(stringWriter, new Transformer("Optimus Prime", "Truck", true));
		System.out.println(stringWriter.toString());

		stringWriter = new StringWriter();
		serialize(stringWriter, new Transformer[]{new Transformer("Optimus Prime", "Truck", true)});
		System.out.println(stringWriter.toString());

		stringWriter = new StringWriter();
		serialize(stringWriter, Collections.singletonList(new Transformer("Optimus Prime", "Truck", true)));
		System.out.println(stringWriter.toString());
	}
}
