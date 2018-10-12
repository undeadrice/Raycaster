package bruc.brayk.entity;

public interface Observable {

	public void notifyObservers();
	public void addObserver(Listener l);
	public void removeObserver(Listener l);
}
