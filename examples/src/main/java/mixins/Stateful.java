package mixins;

public interface Stateful {
	Object getState(Class clazz, Object initial);
	void setState(Class clazz, Object state);
}
