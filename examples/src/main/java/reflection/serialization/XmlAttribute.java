package reflection.serialization;

import java.lang.annotation.*;

/**
 * Sample annotation
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface XmlAttribute {

	/**
	 * Overrides the name of the node serialized in the XML
	 *
	 * @return
	 */
	String value();
}
