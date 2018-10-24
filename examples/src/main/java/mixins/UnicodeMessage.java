package mixins;

import java.nio.charset.Charset;

public class UnicodeMessage extends Message {
	public byte[] utf8() {
		return getText().getBytes(Charset.forName("UTF-8"));
	}
}
