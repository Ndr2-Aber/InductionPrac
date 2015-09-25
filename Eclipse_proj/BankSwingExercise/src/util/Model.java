package util;

public abstract class Model extends java.util.Observable {

	public void notifyChanged() {
		notifyChanged(null);
	}

	public void notifyChanged(Object arg) {
		setChanged();
		notifyObservers(arg);
	}
}
