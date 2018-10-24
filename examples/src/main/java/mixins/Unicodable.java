package mixins;

import java.nio.charset.Charset;

public interface Unicodable {
	String getText();

	default byte[] utf8() {
		return getText().getBytes(Charset.forName("UTF-8"));
	}
}
