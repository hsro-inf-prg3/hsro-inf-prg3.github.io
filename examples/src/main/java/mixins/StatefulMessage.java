package mixins;


public class StatefulMessage extends StatefulObject implements StatefulEscalate2 {
	private String m;

	public StatefulMessage(String m) {
		this.m = m;
	}

	@Override
	public String getText() {
		return m;
	}

	public static void main(String[] args) {
		StatefulMessage m1 = new StatefulMessage("Hans");
		StatefulMessage m2 = new StatefulMessage("Dampf");

		System.out.println(m1.escalated());
		System.out.println(m1.escalated());
		System.out.println(m1.escalated());
		System.out.println(m2.escalated());
		System.out.println(m2.escalated());
		System.out.println(m2.escalated());
	}
}
