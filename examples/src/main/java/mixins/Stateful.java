package mixins;

public interface Stateful {
	Object getState(Object ref, Class clazz, Object initial);
	void setState(Object ref, Class clazz, Object state);
}
