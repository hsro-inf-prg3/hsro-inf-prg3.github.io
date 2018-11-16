package reflection.serialization;

public class Transformer {
	private final String name;
	private final String transformsTo;
	private final boolean isLeader;

	public Transformer(String name, String transformsTo, boolean isLeader) {
		this.name = name;
		this.transformsTo = transformsTo;
		this.isLeader = isLeader;
	}

	public String getName() {
		return name;
	}

	public String getTransformsTo() {
		return transformsTo;
	}

	public boolean isLeader() {
		return isLeader;
	}
}
